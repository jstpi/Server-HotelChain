package hotelchain.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hotelchain.beans.Chain_admin;
import hotelchain.beans.Employee;
import hotelchain.beans.Hotel;
import hotelchain.beans.UserAccount;
import hotelchain.utils.DBUtils;
import hotelchain.utils.MyUtils;
import hotelchain.response.mod.LoginResponse;
import hotelchain.response.mod.SignupResponse;
import hotelchain.response.mod.JWTResponse;

import com.google.gson.*;
import java.util.*;
import java.text.SimpleDateFormat;

@WebServlet(urlPatterns = { "/signUp" })
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SignUpServlet() {
		super();
	}

	// When the user enters the area of a hotel in search bad and click Search.
	// This method will be executed.
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

		Gson g = new Gson();
		UserAccount user = new UserAccount(null, null, null, null, null, null);

		try {
			user = g.fromJson(jb.toString(), UserAccount.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}

		//date:year-month-day
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		user.setDate_registration(dateFormat.format(date));
		
		boolean hasError = false;
		String errorString = "";

		if (user.getSin() == null || user.getSin().length() == 0) {
			hasError = true;
			errorString = "Sin required!";
		}
		else {
			Connection conn = MyUtils.getStoredConnection(request);
			UserAccount similarUser = null;
			try {
				similarUser = DBUtils.findInfo(conn, user.getSin());
			} catch (SQLException e) {
				e.printStackTrace();
				hasError = true;
				errorString = "Error occured during the query";
			}
			
			if (similarUser != null) {
				hasError = true;
				errorString = "A user with the same sin is already existing";
			}
			else {
				try {
					// Find the hotels in the DB.
					DBUtils.createCustomer(conn, user.getSin(), user.getEmail(), user.getPassword(), user.getAddress(), user.getFull_name(), user.getDate_registration());
				} catch (SQLException e) {
					e.printStackTrace();
					hasError = true;
					errorString = "Error occured during the insertion of the customer";
				}
			}
		}
		
		if (hasError) {
			SignupResponse signupResponse = new SignupResponse(errorString, false);

			response.setContentType("application/json");
			String json = new Gson().toJson(signupResponse);
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		}
		else {
			SignupResponse signupResponse = new SignupResponse(errorString, true);

			response.setContentType("application/json");
			String json = new Gson().toJson(signupResponse);
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		}
		
		

	}

}
