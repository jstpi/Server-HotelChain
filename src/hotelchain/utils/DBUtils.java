package hotelchain.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Deque;

import hotelchain.beans.Book;
import hotelchain.beans.Chain;
import hotelchain.beans.Chain_admin;
import hotelchain.beans.Employee;
import hotelchain.beans.Hotel;
import hotelchain.beans.Product;
import hotelchain.beans.Rent;
import hotelchain.beans.Room;
import hotelchain.beans.Room_book;
import hotelchain.beans.Room_rent;
import hotelchain.beans.UserAccount;
import hotelchain.beans.UserRoomHistory;

import java.sql.Date;

public class DBUtils {

	public static UserAccount findUser(Connection conn, String email, String password) throws SQLException {

		// System.out.println("The account is of type Customer.");

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		// preparing query for the user
		String sql = "Select * from customer where email = ? and password= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, email);
		pstm.setString(2, password);
		// System.out.println(pstm);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			System.out.println("Full Name = " + rs.getString("full_name"));
			UserAccount user = new UserAccount(null, null, null, null, null, null);
			user.setSin(rs.getString("sin"));
			user.setFull_name(rs.getString("full_name"));
			user.setAddress(rs.getString("address"));
			user.setDate_registration(rs.getString("date_registration"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			return user;
		}
		return null;
	}

	public static UserAccount findUser(Connection conn, String sin) throws SQLException {

		// System.out.println("The account is of type Customer.");

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		// preparing query for the user
		String sql = "Select * from customer where sin=?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, sin);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			System.out.println("Full Name = " + rs.getString("full_name"));
			UserAccount user = new UserAccount(null, null, null, null, null, null);
			user.setSin(rs.getString("sin"));
			user.setFull_name(rs.getString("full_name"));
			user.setAddress(rs.getString("address"));
			user.setDate_registration(rs.getString("date_registration"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			return user;
		}
		return null;
	}

	public static Employee findEmployee(Connection conn, String email, String password) throws SQLException {

		// System.out.println("The account is of type Employee.");

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		// preparing query for the employee
		String sql = "Select * from employee where email = ? and password= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, email);
		pstm.setString(2, password);
		// System.out.println(pstm);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			System.out.println("Full Name = " + rs.getString("full_name"));
			Employee employee = new Employee(null, null, null, null, null, null, null, null);
			// missing chain, hotel and employee id
			employee.setChain_name(rs.getString("chain_name"));
			employee.setHotel_id(rs.getString("hotel_id"));
			employee.setEmployee_id(rs.getString("employee_id"));
			employee.setSin(rs.getString("sin"));
			employee.setFull_name(rs.getString("full_name"));
			employee.setAddress(rs.getString("address"));
			employee.setPassword(rs.getString("password"));
			employee.setEmail(rs.getString("email"));
			return employee;
		}
		return null;
	}

	public static Chain_admin findAdmin(Connection conn, String email, String password) throws SQLException {

		// System.out.println("The account is of type Admin.");

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		// preparing query for the employee
		String sql = "Select * from chain_admin where email = ? and password= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, email);
		pstm.setString(2, password);
		// System.out.println(pstm);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			System.out.println("Full Name = " + rs.getString("full_name"));
			Chain_admin admin = new Chain_admin(null, null, null, null, null, null);

			admin.setAdmin_id(rs.getString("admin_id"));
			admin.setChain_name(rs.getString("chain_name"));
			admin.setFull_name(rs.getString("full_name"));
			admin.setPassword(rs.getString("password"));
			admin.setEmail(rs.getString("email"));
			admin.setSin(rs.getString("sin"));
			return admin;
		}
		return null;
	}

	public static UserAccount findInfo(Connection conn, String sin) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		// preparing query for the user
		String sql = "Select * from customer where sin = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, sin);
		// System.out.println(pstm);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			System.out.println("Full Name = " + rs.getString("full_name"));
			UserAccount user = new UserAccount(null, null, null, null, null, null);
			user.setSin(rs.getString("sin"));
			user.setFull_name(rs.getString("full_name"));
			user.setAddress(rs.getString("address"));
			user.setDate_registration(rs.getString("date_registration"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			return user;
		}
		return null;
	}

	public static Employee findEmployeeInfo(Connection conn, String sin) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		// preparing query for the user
		String sql = "Select * from employee where sin = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, sin);
		// System.out.println(pstm);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			System.out.println("Full Name = " + rs.getString("full_name"));
			Employee employee = new Employee(null, null, null, null, null, null, null, null);
			employee.setSin(rs.getString("sin"));
			employee.setFull_name(rs.getString("full_name"));
			employee.setAddress(rs.getString("address"));
			employee.setChain_name(rs.getString("chain_name"));
			employee.setHotel_id(rs.getString("hotel_id"));
			employee.setEmployee_id(rs.getString("employee_id"));
			employee.setChain_name(rs.getString("chain_name"));
			employee.setPassword(rs.getString("password"));
			employee.setEmail(rs.getString("email"));
			return employee;
		}
		return null;
	}

	public static Chain_admin findAdminInfo(Connection conn, String sin) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		// preparing query for the user
		String sql = "Select * from chain_admin where sin = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, sin);
		// System.out.println(pstm);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			System.out.println("Full Name = " + rs.getString("full_name"));
			Chain_admin admin = new Chain_admin(null, null, null, null, null, null);
			admin.setSin(rs.getString("sin"));
			admin.setFull_name(rs.getString("full_name"));
			admin.setPassword(rs.getString("password"));
			admin.setEmail(rs.getString("email"));
			admin.setChain_name(rs.getString("chain_name"));
			admin.setAdmin_id(rs.getString("admin_id"));
			return admin;
		}
		return null;
	}

	// find hotel with part of address
	public static Hotel[] findHotel(Connection conn, String address) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		String sql = "SELECT * FROM hotel WHERE hotel_address ~* '" + address + "';";
		// System.out.println(sql);
		PreparedStatement pstm = conn.prepareStatement(sql);
		// pstm.setString(1, address);
		ResultSet rs = pstm.executeQuery();
		int i = 0;

		Deque<Hotel> hotelStack = new ArrayDeque<Hotel>();
		while (rs.next()) {

			Hotel hotel = new Hotel(null, null, 1, null, null, 1);
			hotel.setChain_name(rs.getString("chain_name"));
			hotel.setHotel_id(rs.getString("hotel_id"));
			hotel.setHotel_address(rs.getString("hotel_address"));
			hotel.setContact_email_address(rs.getString("contact_email_address"));
			hotel.setNumber_of_rooms(rs.getInt("number_of_rooms"));
			hotel.setRating(rs.getFloat("rating"));
			hotelStack.push(hotel);

		}
		if (!hotelStack.isEmpty()) {
			Hotel[] hotel = (Hotel[]) hotelStack.toArray(new Hotel[hotelStack.size()]);
			return hotel;
		}
		return null;
	}

	// find hotel with part of address
	public static Hotel findHotelWithID(Connection conn, String hotel_id) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		String sql = "SELECT * FROM hotel WHERE hotel_id=?;";
		// System.out.println(sql);
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, hotel_id);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {

			Hotel hotel = new Hotel(null, null, 1, null, null, 1);
			hotel.setChain_name(rs.getString("chain_name"));
			hotel.setHotel_id(rs.getString("hotel_id"));
			hotel.setHotel_address(rs.getString("hotel_address"));
			hotel.setContact_email_address(rs.getString("contact_email_address"));
			hotel.setNumber_of_rooms(rs.getInt("number_of_rooms"));
			hotel.setRating(rs.getFloat("rating"));

			return hotel;
		}

		return null;
	}

	// find available rooms with hotel_id
	public static Room[] findRooms(Connection conn, String hotel_id, String check_in) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		Date realDate = Date.valueOf(check_in);

		String sql = "(select * from room where hotel_id=?) Except\r\n"
				+ "(select room_number,hotel_id, chain_name,price,capacity,view_type, is_extendable"
				+ " from room Natural join room_book\r\n" + "Natural join book where check_out>? and hotel_id=?)\r\n"
				+ "Except\r\n" + "(select room_number,hotel_id, chain_name,price,capacity,view_type, is_extendable\r\n"
				+ " from room \r\n" + "Natural join room_rent\r\n" + "Natural join rent where check_out>? \r\n"
				+ "and hotel_id=?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, hotel_id);
		pstm.setDate(2, realDate);
		pstm.setString(3, hotel_id);
		pstm.setDate(4, realDate);
		pstm.setString(5, hotel_id);
		ResultSet rs = pstm.executeQuery();

		int i = 0;

		Deque<Room> roomStack = new ArrayDeque<Room>();
		while (rs.next()) {

			Room room = new Room(1, null, null, 1, 1, null, false);
			room.setRoom_number(rs.getInt("room_number"));
			room.setHotel_id(rs.getString("hotel_id"));
			room.setChain_name(rs.getString("chain_name"));
			room.setPrice(rs.getFloat("price"));
			room.setCapacity(rs.getInt("capacity"));
			room.setView_type(rs.getString("view_type"));
			room.setIs_extendable(rs.getBoolean("is_extendable"));

			roomStack.push(room);

		}
		if (!roomStack.isEmpty()) {
			Room[] room = (Room[]) roomStack.toArray(new Room[roomStack.size()]);
			return room;
		}
		return null;
	}

	// find rooms with hotel_id
	public static Room[] findAllRooms(Connection conn, String hotel_id) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		String sql = "(select * from room where hotel_id=?);";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, hotel_id);
		ResultSet rs = pstm.executeQuery();

		int i = 0;

		Deque<Room> roomStack = new ArrayDeque<Room>();
		while (rs.next()) {

			Room room = new Room(1, null, null, 1, 1, null, false);
			room.setRoom_number(rs.getInt("room_number"));
			room.setHotel_id(rs.getString("hotel_id"));
			room.setChain_name(rs.getString("chain_name"));
			room.setPrice(rs.getFloat("price"));
			room.setCapacity(rs.getInt("capacity"));
			room.setView_type(rs.getString("view_type"));
			room.setIs_extendable(rs.getBoolean("is_extendable"));

			roomStack.push(room);

		}
		if (!roomStack.isEmpty()) {
			Room[] room = (Room[]) roomStack.toArray(new Room[roomStack.size()]);
			return room;
		}
		return null;
	}

	// find hotel with employee sin
	public static Hotel findEmployeeHotel(Connection conn, String sin) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		String sql = "select * from hotel where hotel_id=\r\n" + "(select hotel_id from employee where sin=?);";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, sin);

		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			Hotel hotel = new Hotel(null, null, 1, null, null, 1);
			hotel.setChain_name(rs.getString("chain_name"));
			hotel.setHotel_id(rs.getString("hotel_id"));
			hotel.setHotel_address(rs.getString("hotel_address"));
			hotel.setContact_email_address(rs.getString("contact_email_address"));
			hotel.setNumber_of_rooms(rs.getInt("number_of_rooms"));
			hotel.setRating(rs.getFloat("rating"));

			return hotel;
		}
		return null;
	}

	// find chain with admin sin
	public static Chain findAdminChain(Connection conn, String sin) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		String sql = "select * from chain where chain_name=\r\n" + "(select chain_name from chain_admin where sin='?')";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, sin);

		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			Chain chain = new Chain(null, null, 1);
			chain.setChain_name(rs.getString("chain_name"));
			chain.setCentral_office_address(rs.getString("central_office_address"));
			chain.setNumber_of_hotels(rs.getInt("number_of_hotels"));

			return chain;
		}
		return null;
	}

	// find chain with admin sin
	public static Hotel[] findAdminHotels(Connection conn, String sin) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		String sql = "select * from hotel where chain_name=(select chain_name from chain_admin where sin=?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, sin);

		ResultSet rs = pstm.executeQuery();

		int i = 0;

		Deque<Hotel> hotelStack = new ArrayDeque<Hotel>();
		while (rs.next()) {

			Hotel hotel = new Hotel(null, null, 1, null, null, 1);
			hotel.setChain_name(rs.getString("chain_name"));
			hotel.setHotel_id(rs.getString("hotel_id"));
			hotel.setHotel_address(rs.getString("hotel_address"));
			hotel.setContact_email_address(rs.getString("contact_email_address"));
			hotel.setNumber_of_rooms(rs.getInt("number_of_rooms"));
			hotel.setRating(rs.getFloat("rating"));

			hotelStack.push(hotel);

		}
		if (!hotelStack.isEmpty()) {
			Hotel[] hotel = (Hotel[]) hotelStack.toArray(new Hotel[hotelStack.size()]);
			return hotel;
		}
		return null;
	}

	// create new customer
	public static void createCustomer(Connection conn, String sin, String email, String pwd, String address,
			String name, String date) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		Date realDate = Date.valueOf(date);

		// INSERT INTO cutomer () VALUES(1,'Fred','Lafleche');
		String sql = "INSERT INTO customer (sin,full_name,address,date_registration,password,email) VALUES(?,?,?,?,?,?);";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, sin);
		pstm.setString(2, name);
		pstm.setString(3, address);
		pstm.setDate(4, realDate);
		pstm.setString(5, pwd);
		pstm.setString(6, email);

		pstm.executeUpdate();

	}

	// find Minimum room price in hotel
	public static float findMinPrice(Connection conn, String hotel_id) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		// INSERT INTO cutomer () VALUES(1,'Fred','Lafleche');
		String sql = "select Min(price) from room where hotel_id = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, hotel_id);

		ResultSet rs = pstm.executeQuery();
		rs.next();
		return rs.getFloat("min");

	}

	// find the different room capacities in hotel
	public static Integer[] findHotelCapacities(Connection conn, String hotel_id) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		// INSERT INTO cutomer () VALUES(1,'Fred','Lafleche');
		String sql = "SELECT DISTINCT capacity FROM room where hotel_id= ?;";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, hotel_id);

		ResultSet rs = pstm.executeQuery();

		Deque<Integer> capacityStack = new ArrayDeque<Integer>();
		while (rs.next()) {
			capacityStack.push(rs.getInt("capacity"));
		}

		if (!capacityStack.isEmpty()) {
			Integer[] i = (Integer[]) capacityStack.toArray(new Integer[capacityStack.size()]);
			return i;
		}

		return null;
	}

	// create the book in the DB
	public static void createBook(Connection conn, Book book) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		Date date = Date.valueOf(book.getBook_date());
		Date check_in = Date.valueOf(book.getCheck_in());
		Date check_out = Date.valueOf(book.getCheck_out());
		// INSERT book in the DB
		String sql = "INSERT INTO book (book_date, sin, check_in, check_out, is_cancelled) VALUES(?,?,?,?,?);";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setDate(1, date);
		pstm.setString(2, book.getSin());
		pstm.setDate(3, check_in);
		pstm.setDate(4, check_out);
		pstm.setBoolean(5, book.isIs_cancelled());

		pstm.executeUpdate();

	}

	// create the room_book in the DB
	public static void createRoomBook(Connection conn, Room_book room_book) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		Date date = Date.valueOf(room_book.getBook_date());

		// INSERT room book in the DB
		String sql = "INSERT INTO room_book (Book_date, sin, room_number, hotel_id, chain_name) VALUES(?,?,?,?,?);";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setDate(1, date);
		pstm.setString(2, room_book.getSin());
		pstm.setInt(3, room_book.getRoom_number());
		pstm.setString(4, room_book.getHotel_id());
		pstm.setString(5, room_book.getChain_name());

		pstm.executeUpdate();

	}

	// create the room_book in the DB
	public static void createRoom(Connection conn, Room room) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		// Find room number
		PreparedStatement number = conn.prepareStatement("select max(room_number) from room where hotel_id=?;");
		number.setString(1, room.getHotel_id());
		ResultSet rs = number.executeQuery();
		rs.next();
		int roomNumber = rs.getInt("max");
		roomNumber++;

		// INSERT room in the DB
		String sql = "INSERT INTO room (room_number,hotel_id,chain_name,price,capacity,view_type,is_extendable) \r\n"
				+ "VALUES(?,?,?,?,?,?,?);";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, roomNumber);
		pstm.setString(2, room.getHotel_id());
		pstm.setString(3, room.getChain_name());
		pstm.setFloat(4, room.getPrice());
		pstm.setInt(5, room.getCapacity());
		pstm.setString(6, room.getView_type());
		pstm.setBoolean(7, room.isIs_extendable());

		pstm.executeUpdate();

	}

	// create the room_book in the DB
	public static void createHotel(Connection conn, Hotel hotel) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		// Find room number
		PreparedStatement hotelID = conn.prepareStatement("select max(hotel_id) from hotel;");
		ResultSet rs = hotelID.executeQuery();
		rs.next();
		String ID = rs.getString("max");

		if (ID.charAt(5) == '9') {
			char char1 = ID.charAt(4);
			char1++;
			String var = char1 + "1";
			ID = ID.substring(0, ID.length() - 2) + var;

		} else {
			int i = Character.getNumericValue(ID.charAt(5));
			i++;
			ID = ID.substring(0, ID.length() - 1) + i;
		}

		// INSERT room in the DB
		String sql = "INSERT INTO hotel (hotel_id, chain_name, number_of_rooms, hotel_address,contact_email_address,rating) \r\n"
				+ "VALUES(?,?,?,?,?,?);";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, ID);
		pstm.setString(2, hotel.getChain_name());
		pstm.setInt(3, hotel.getNumber_of_rooms());
		pstm.setString(4, hotel.getHotel_address());
		pstm.setString(5, hotel.getContact_email_address());
		pstm.setFloat(6, hotel.getRating());

		pstm.executeUpdate();

	}

	// delete room from the DB
	public static void deleteRoom(Connection conn, Room room) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		// INSERT room in the DB
		String sql = "delete from room_rent where room_number=? and hotel_id=?; delete from room_book where room_number=? and hotel_id=?;"
				+ "delete from room where room_number=? and hotel_id=?;";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, room.getRoom_number());
		pstm.setString(2, room.getHotel_id());
		pstm.setInt(3, room.getRoom_number());
		pstm.setString(4, room.getHotel_id());
		pstm.setInt(5, room.getRoom_number());
		pstm.setString(6, room.getHotel_id());

		pstm.executeUpdate();

	}

	// delete room from the DB
	public static void deleteHotel(Connection conn, Hotel hotel) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		// INSERT room in the DB
		String sql = "delete from room_rent where hotel_id=?; delete from room_book where hotel_id=?;"
				+ "delete from room where hotel_id=?; delete from employee where hotel_id=?;"
				+ "delete from hotel where hotel_id=?;";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, hotel.getHotel_id());
		pstm.setString(2, hotel.getHotel_id());
		pstm.setString(3, hotel.getHotel_id());
		pstm.setString(4, hotel.getHotel_id());
		pstm.setString(5, hotel.getHotel_id());

		pstm.executeUpdate();

	}

	// find bookings by hotel
	public static Room[] findBookingByHotel(Connection conn, String hotel_id) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		// findind the bookings by hotel_id
		String sql = "select room_number,hotel_id,chain_name,price,capacity,view_type, is_extendable, check_in, check_out from room natural join room_book natural join book \r\n"
				+ "where check_out > current_date and hotel_id=?;";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, hotel_id);

		ResultSet rs = pstm.executeQuery();

		Deque<Room> roomStack = new ArrayDeque<Room>();
		while (rs.next()) {

			Room room = new Room(1, null, null, 1, 1, null, false);
			room.setRoom_number(rs.getInt("room_number"));
			room.setHotel_id(rs.getString("hotel_id"));
			room.setChain_name(rs.getString("chain_name"));
			room.setPrice(rs.getFloat("price"));
			room.setCapacity(rs.getInt("capacity"));
			room.setView_type(rs.getString("view_type"));
			room.setIs_extendable(rs.getBoolean("is_extendable"));
			room.setCheck_in(rs.getDate("check_in").toString());
			room.setCheck_out(rs.getDate("check_out").toString());

			roomStack.push(room);

		}
		if (!roomStack.isEmpty()) {
			Room[] room = (Room[]) roomStack.toArray(new Room[roomStack.size()]);
			return room;
		}

		return null;

	}

	// find rent by hotel
	public static Room[] findRentByHotel(Connection conn, String hotel_id) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		// findind the bookings by hotel_id
		String sql = "select room_number,hotel_id,chain_name,price,capacity,view_type, is_extendable, check_in, check_out from room \r\n"
				+ "natural join room_rent natural join rent \r\n" + "where check_out > current_date and hotel_id=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, hotel_id);

		ResultSet rs = pstm.executeQuery();

		Deque<Room> roomStack = new ArrayDeque<Room>();
		while (rs.next()) {

			Room room = new Room(1, null, null, 1, 1, null, false);
			room.setRoom_number(rs.getInt("room_number"));
			room.setHotel_id(rs.getString("hotel_id"));
			room.setChain_name(rs.getString("chain_name"));
			room.setPrice(rs.getFloat("price"));
			room.setCapacity(rs.getInt("capacity"));
			room.setView_type(rs.getString("view_type"));
			room.setIs_extendable(rs.getBoolean("is_extendable"));
			room.setCheck_in(rs.getDate("check_in").toString());
			room.setCheck_out(rs.getDate("check_out").toString());

			roomStack.push(room);

		}
		if (!roomStack.isEmpty()) {
			Room[] room = (Room[]) roomStack.toArray(new Room[roomStack.size()]);
			return room;
		}

		return null;

	}

	// Update hotel info
	public static void updateHotel(Connection conn, Hotel hotel) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		// findind the bookings by hotel_id
		String sql = "Update hotel \r\n" + "set hotel_address=?, \r\n" + "	contact_email_address=?,\r\n"
				+ "	rating=?\r\n" + "where hotel_id=?;";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, hotel.getHotel_address());
		pstm.setString(2, hotel.getContact_email_address());
		pstm.setFloat(3, hotel.getRating());
		pstm.setString(4, hotel.getHotel_id());

		pstm.executeUpdate();

	}

	public static void updateRoom(Connection conn, Room room) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		// findind the bookings by hotel_id
		String sql = "Update room set price=?,\r\n" + "capacity=?,\r\n" + "view_type=?,\r\n" + "is_extendable=?\r\n"
				+ "where hotel_id=? and room_number=?;";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setFloat(1, room.getPrice());
		pstm.setInt(2, room.getCapacity());
		pstm.setString(3, room.getView_type());
		pstm.setBoolean(4, room.isIs_extendable());
		pstm.setString(5, room.getHotel_id());
		pstm.setInt(6, room.getRoom_number());

		pstm.executeUpdate();

	}

	public static void updateCustomer(Connection conn, UserAccount user) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		// findind the bookings by hotel_id
		String sql = "Update customer set full_name=?, address=?, password=?, email=?" + "where sin=?;";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, user.getFull_name());
		pstm.setString(2, user.getAddress());
		pstm.setString(3, user.getPassword());
		pstm.setString(4, user.getEmail());
		pstm.setString(5, user.getSin());

		pstm.executeUpdate();

	}

	public static void updateEmployee(Connection conn, Employee employee) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		// findind the bookings by hotel_id
		String sql = "Update Employee set full_name=?, address=?, password=?, email=?" + "where sin=?;";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, employee.getFull_name());
		pstm.setString(2, employee.getAddress());
		pstm.setString(3, employee.getPassword());
		pstm.setString(4, employee.getEmail());
		pstm.setString(5, employee.getSin());

		pstm.executeUpdate();

	}

	public static void updateAdmin(Connection conn, Chain_admin admin) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		// findind the bookings by hotel_id
		String sql = "Update chain_admin set full_name=?, password=?, email=?" + "where sin=?;";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, admin.getFull_name());
		pstm.setString(2, admin.getPassword());
		pstm.setString(3, admin.getEmail());
		pstm.setString(4, admin.getSin());

		pstm.executeUpdate();

	}

	// find employee by hotel
	public static Employee[] findEmployeeByHotel(Connection conn, String hotel_id) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		// findind the bookings by hotel_id
		String sql = "select * from employee where hotel_id=?;";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, hotel_id);

		ResultSet rs = pstm.executeQuery();

		Deque<Employee> empStack = new ArrayDeque<Employee>();
		while (rs.next()) {

			Employee emp = new Employee(null, null, null, null, null, null, null, null);
			emp.setEmployee_id(rs.getString("employee_id"));
			emp.setHotel_id(rs.getString("hotel_id"));
			emp.setChain_name(rs.getString("chain_name"));
			emp.setSin(rs.getString("sin"));
			emp.setFull_name(rs.getString("full_name"));
			emp.setAddress(rs.getString("address"));
			emp.setPassword(rs.getString("password"));
			emp.setEmail(rs.getString("email"));

			empStack.push(emp);

		}
		if (!empStack.isEmpty()) {
			Employee[] empArray = (Employee[]) empStack.toArray(new Employee[empStack.size()]);
			return empArray;
		}

		return null;

	}

	// delete employee by hotel
	public static void deleteEmployeeByHotel(Connection conn, String sin) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		// findind the bookings by hotel_id
		String sql = "delete from employee where sin=?;";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, sin);

		pstm.executeUpdate();

	}

	// add employee by hotel
	public static void addEmployeeByHotel(Connection conn, Employee emp) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		// Find employee number
		PreparedStatement number = conn.prepareStatement("select max(employee_id) from Employee where hotel_id=?;");
		number.setString(1, emp.getHotel_id());
		ResultSet rs = number.executeQuery();
		rs.next();
		String roomNumber = rs.getString("max");
		int num = Integer.parseInt(roomNumber);
		num++;
		roomNumber = Integer.toString(num);

		// findind the bookings by hotel_id
		String sql = "insert into employee (employee_id,hotel_id,chain_name,sin,full_name,address,password,email)"
				+ "values(?,?,?,?,?,?,?,?);";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, roomNumber);
		pstm.setString(2, emp.getHotel_id());
		pstm.setString(3, emp.getChain_name());
		pstm.setString(4, emp.getSin());
		pstm.setString(5, emp.getFull_name());
		pstm.setString(6, emp.getAddress());
		pstm.setString(7, emp.getPassword());
		pstm.setString(8, emp.getEmail());

		pstm.executeUpdate();

	}

	// add employee by hotel
	public static void createRent(Connection conn, Rent rent) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		Date check_inDate = Date.valueOf(rent.getCheck_in());
		Date check_outDate = Date.valueOf(rent.getCheck_out());

		// findind the bookings by hotel_id
		String sql = "insert into rent (rent_date, sin, check_in, check_out)" + "values(?,?,?,?);";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setDate(1, check_inDate);
		pstm.setString(2, rent.getSin());
		pstm.setDate(3, check_inDate);
		pstm.setDate(4, check_outDate);

		pstm.executeUpdate();

	}

	// create the room_book in the DB
	public static void createRoomRent(Connection conn, Room_rent room_rent) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		Date date = Date.valueOf(room_rent.getRent_date());

		// INSERT room book in the DB
		String sql = "INSERT INTO room_rent (Rent_date, sin, room_number, hotel_id, chain_name) VALUES(?,?,?,?,?);";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setDate(1, date);
		pstm.setString(2, room_rent.getSin());
		pstm.setInt(3, room_rent.getRoom_number());
		pstm.setString(4, room_rent.getHotel_id());
		pstm.setString(5, room_rent.getChain_name());

		pstm.executeUpdate();

	}

	public static UserRoomHistory[] getUserRoomHistory(Connection conn, String sin) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		String sqlBook = "select address, chain_name, room_number, check_in, check_out, capacity \r\n"
				+ "from hotel natural join room natural join room_book natural join book natural join customer where sin=?;";

		PreparedStatement pstm1 = conn.prepareStatement(sqlBook);
		pstm1.setString(1, sin);
		ResultSet rs = pstm1.executeQuery();

		Deque<UserRoomHistory> userStack = new ArrayDeque<UserRoomHistory>();
		while (rs.next()) {

			UserRoomHistory user = new UserRoomHistory(null, null, 1, null, null, true, 1);
			user.setAddress(rs.getString("address"));
			user.setChain_name(rs.getString("chain_name"));
			user.setRoom_number(rs.getInt("room_number"));
			user.setCheck_in(rs.getDate("check_in").toString());
			user.setCheck_out(rs.getDate("check_out").toString());
			user.setCapacity(rs.getInt("capacity"));

			userStack.push(user);

		}

		String sqlRent = "select address, chain_name, room_number, check_in, check_out, capacity \r\n"
				+ "from hotel natural join room natural join room_rent natural join rent natural join customer where sin=?;";

		PreparedStatement pstm2 = conn.prepareStatement(sqlRent);
		pstm2.setString(1, sin);
		rs = pstm2.executeQuery();

		while (rs.next()) {

			UserRoomHistory user = new UserRoomHistory(null, null, 1, null, null, false, 1);
			user.setAddress(rs.getString("address"));
			user.setChain_name(rs.getString("chain_name"));
			user.setRoom_number(rs.getInt("room_number"));
			user.setCheck_in(rs.getDate("check_in").toString());
			user.setCheck_out(rs.getDate("check_out").toString());
			user.setCapacity(rs.getInt("capacity"));

			userStack.push(user);

		}

		if (!userStack.isEmpty()) {
			UserRoomHistory[] userArray = (UserRoomHistory[]) userStack.toArray(new UserRoomHistory[userStack.size()]);
			return userArray;
		}

		return null;
	}

}
