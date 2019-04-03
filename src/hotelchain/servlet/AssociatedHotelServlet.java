package hotelchain.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import hotelchain.beans.Chain;
import hotelchain.beans.Chain_admin;
import hotelchain.beans.Employee;
import hotelchain.beans.Hotel;
import hotelchain.beans.UserAccount;
import hotelchain.response.mod.LoginResponse;
import hotelchain.utils.DBUtils;
import hotelchain.utils.MyUtils;
import hotelchain.utils.ValidateJWTUtils;

//web servlet to find the associated hotel for an employee or to find the associated chain for an admin

@WebServlet(urlPatterns = { "/associatedHotel" })
public class AssociatedHotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AssociatedHotelServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String role = ValidateJWTUtils.role(request);
		String sin = ValidateJWTUtils.validate(request, role);
		
		System.out.println(sin);
		System.out.println(role);

		UserAccount user = new UserAccount(null, null, null, null, null, null);
		Employee employee = new Employee(null, null, null, null, null, null, null, null);
		Chain_admin admin = new Chain_admin(null, null, null, null, null, null);
		
		Hotel hotel;
		Chain chain;
		
		if (sin == null || role == null) {
			response.setContentType("application/json");
			String json = new Gson().toJson(user);
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		}
		else {
			Connection conn = MyUtils.getStoredConnection(request);
			try {
				// Find the user in the DB.
				if (role.contains("Employee")) {
					hotel = DBUtils.findEmployeeHotel(conn, sin);
					
					response.setContentType("application/json");
					String json = new Gson().toJson(hotel);
					response.setCharacterEncoding("UTF-8");
					response.getWriter().write(json);
				}
				else if (role.contains("Admin")){
					chain = DBUtils.findAdminChain(conn, sin);
					
					response.setContentType("application/json");
					String json = new Gson().toJson(chain);
					response.setCharacterEncoding("UTF-8");
					response.getWriter().write(json);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}