package hotelchain.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hotelchain.beans.Book;
import hotelchain.beans.Chain_admin;
import hotelchain.beans.Employee;
import hotelchain.beans.Hotel;
import hotelchain.beans.Rent;
import hotelchain.beans.Room_book;
import hotelchain.beans.Room_rent;
import hotelchain.beans.UserAccount;
import hotelchain.utils.DBUtils;
import hotelchain.utils.MyUtils;
import hotelchain.utils.ValidateJWTUtils;
import hotelchain.response.mod.LoginResponse;
import hotelchain.response.mod.JWTResponse;

import com.google.gson.*;

@WebServlet(urlPatterns = { "/rentRoom" })
public class RentRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RentRoomServlet() {
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
		Rent rent = new Rent(null, null, null, null);
		Room_rent room_rent = new Room_rent(null, null, 1, null, null);

		try {
			rent = g.fromJson(jb.toString(), Rent.class);
			room_rent = g.fromJson(jb.toString(), Room_rent.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}

		// date:year-month-day
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		rent.setRent_date(dateFormat.format(date));
		rent.setCheck_in(dateFormat.format(date));
		// rent.setSin(sin);
		room_rent.setRent_date(dateFormat.format(date));
		// room_rent.setSin(sin);

		UserAccount user = null;

		Connection conn = MyUtils.getStoredConnection(request);
		try {
			// check for user
			user = DBUtils.findUser(conn, rent.getSin());
	

		} catch (SQLException e) {
			e.printStackTrace();

		}
		if (user != null) {
			try {
				// Creates the book in the DB
				DBUtils.createRent(conn, rent);
				// create the room_book
				DBUtils.createRoomRent(conn, room_rent);

			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		response.setContentType("application/json");
		String json = new Gson().toJson(true);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);

	}

}
