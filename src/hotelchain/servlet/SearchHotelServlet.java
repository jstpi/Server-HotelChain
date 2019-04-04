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
import hotelchain.response.mod.JWTResponse;

import com.google.gson.*;

@WebServlet(urlPatterns = { "/searchHotel" })
public class SearchHotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchHotelServlet() {
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
		Hotel hotel = new Hotel(null, null, 1, null, null, 1);

		try {
			hotel = g.fromJson(jb.toString(), Hotel.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}

		boolean hasError = false;
		String errorString = null;
		Hotel[] hotelArray = null;

		if (hotel.getHotel_address() == null || hotel.getHotel_address().length() == 0) {
			hasError = true;
			errorString = "City required!";
		} else {
			Connection conn = MyUtils.getStoredConnection(request);
			try {
				// Find the hotels in the DB.
				hotelArray = DBUtils.findHotel(conn, hotel.getHotel_address());
				float minPrice;
				Integer[] capacities;
				for (int i=0;i<hotelArray.length;i++) {
					minPrice=DBUtils.findMinPrice(conn, hotelArray[i].getHotel_id());
					System.out.println(minPrice);
					hotelArray[i].setMinPrice(minPrice);
					capacities=DBUtils.findHotelCapacities(conn, hotelArray[i].getHotel_id());
					hotelArray[i].setCapacities(capacities);
				}

			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		

		response.setContentType("application/json");
		String json = new Gson().toJson(hotelArray);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);

	}

}