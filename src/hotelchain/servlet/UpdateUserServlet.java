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

//web servlet to update the customer, employee or admin info

@WebServlet(urlPatterns = { "/updateUser" })
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateUserServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String role = ValidateJWTUtils.role(request);
		String sin = ValidateJWTUtils.validate(request, role);
		Gson g = new Gson();

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
				if (role.contains("UserAccount")) {	
														
					try {
						user = g.fromJson(jb.toString(), UserAccount.class);
					} catch (JsonSyntaxException e) {
						e.printStackTrace();
					}
					
					DBUtils.updateCustomer(conn, user);
					
					response.setContentType("application/json");
					String json = new Gson().toJson(user);
					response.setCharacterEncoding("UTF-8");
					response.getWriter().write(json);
				}
				else if (role.contains("Employee")) {
					try {
						employee = g.fromJson(jb.toString(), Employee.class);
					} catch (JsonSyntaxException e) {
						e.printStackTrace();
					}
					
					DBUtils.updateEmployee(conn, employee);
					
					response.setContentType("application/json");
					String json = new Gson().toJson(employee);
					response.setCharacterEncoding("UTF-8");
					response.getWriter().write(json);
				}
				else if (role.contains("Admin")){
					try {
						admin = g.fromJson(jb.toString(), Chain_admin.class);
					} catch (JsonSyntaxException e) {
						e.printStackTrace();
					}
					
					DBUtils.updateAdmin(conn, admin);
					
					response.setContentType("application/json");
					String json = new Gson().toJson(admin);
					response.setCharacterEncoding("UTF-8");
					response.getWriter().write(json);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
