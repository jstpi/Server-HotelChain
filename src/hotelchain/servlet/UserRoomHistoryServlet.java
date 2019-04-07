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

import hotelchain.beans.Chain_admin;
import hotelchain.beans.Employee;
import hotelchain.beans.UserAccount;
import hotelchain.beans.UserRoomHistory;
import hotelchain.response.mod.LoginResponse;
import hotelchain.utils.DBUtils;
import hotelchain.utils.MyUtils;
import hotelchain.utils.ValidateJWTUtils;

@WebServlet(urlPatterns = { "/userHistory" })
public class UserRoomHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserRoomHistoryServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String role = ValidateJWTUtils.role(request);
		String sin = ValidateJWTUtils.validate(request, role);

		UserRoomHistory[] user=null;
		Connection conn = MyUtils.getStoredConnection(request);
		try {
			// Find the user history in the DB.
			user = DBUtils.getUserRoomHistory(conn, sin);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.setContentType("application/json");
		String json = new Gson().toJson(user);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);

	}

}
