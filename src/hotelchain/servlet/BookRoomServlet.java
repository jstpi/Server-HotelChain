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
import hotelchain.beans.Room_book;
import hotelchain.beans.UserAccount;
import hotelchain.utils.DBUtils;
import hotelchain.utils.MyUtils;
import hotelchain.utils.ValidateJWTUtils;
import hotelchain.response.mod.LoginResponse;
import hotelchain.response.mod.JWTResponse;

import com.google.gson.*;

@WebServlet(urlPatterns = { "/bookRoom" })
public class BookRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookRoomServlet() {
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

		String role = ValidateJWTUtils.role(request);
		String sin = ValidateJWTUtils.validate(request, role);

		Gson g = new Gson();
		Book book = new Book(null, null, null, null, false);
		Room_book room_book = new Room_book(null, null,1,null,null);

		try {
			book = g.fromJson(jb.toString(), Book.class);
			room_book = g.fromJson(jb.toString(), Room_book.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}

		// date:year-month-day
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		book.setBook_date(dateFormat.format(date));
		book.setSin(sin);
		room_book.setBook_date(dateFormat.format(date));
		room_book.setSin(sin);

		boolean hasError = false;
		String errorString = null;


		Connection conn = MyUtils.getStoredConnection(request);
		try {
			// Creates the book in the DB
			DBUtils.createBook(conn, book);
			//create the room_book
			DBUtils.createRoomBook(conn, room_book);

		} catch (SQLException e) {
			e.printStackTrace();

		}

		response.setContentType("application/json");
		String json = new Gson().toJson(book);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);

	}

}
