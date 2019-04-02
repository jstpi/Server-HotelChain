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

import hotelchain.beans.UserAccount;
import hotelchain.response.mod.LoginResponse;
import hotelchain.utils.DBUtils;
import hotelchain.utils.MyUtils;

@WebServlet(urlPatterns = { "/userInfo" })
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserInfoServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println(request.toString());

		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(jb);
		Gson g = new Gson();
		UserAccount user = new UserAccount(null, null, null, null, null, null);
		try {
			user = g.fromJson(jb.toString(), UserAccount.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}

		Connection conn = MyUtils.getStoredConnection(request);
		try {
			// Find the user in the DB.
			user = DBUtils.findInfo(conn, user.getSin());

		} catch (SQLException e) {
			e.printStackTrace();

		}

		response.setContentType("application/json");
		String json = new Gson().toJson(user);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);

	}

}