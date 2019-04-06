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
import hotelchain.beans.UserAccount;
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
				+ " from room Natural join room_book\r\n" + "Natural join book where check_in=? and hotel_id=?)\r\n"
				+ "Except\r\n" + "(select room_number,hotel_id, chain_name,price,capacity,view_type, is_extendable\r\n"
				+ " from room \r\n" + "Natural join room_rent\r\n" + "Natural join rent where check_in=? \r\n"
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

		String sql = "select * from hotel where hotel_id=\r\n" + "(select hotel_id from employee where sin='?');";

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
		+"delete from room where room_number=? and hotel_id=?;";
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
		String sql = "delete from room_rent where hotel_id=?; delete from room_book where hotel_id=?;"+ 
				"delete from room where hotel_id=?;\r\n"+ "delete from hotel where hotel_id=?;";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, hotel.getHotel_id());
		pstm.setString(2, hotel.getHotel_id());
		pstm.setString(3, hotel.getHotel_id());
		pstm.setString(4, hotel.getHotel_id());

		pstm.executeUpdate();

	}

	// find bookings by hotel
	public static Book[] findBookingByHotel(Connection conn, String hotel_id) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		// findind the bookings by hotel_id
		String sql = "select * from book where sin=(select sin from room_book where hotel_id=?);";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, hotel_id);

		ResultSet rs = pstm.executeQuery();

		Deque<Book> bookStack = new ArrayDeque<Book>();
		while (rs.next()) {
			Book book = new Book(null, null, null, null, false);
			book.setBook_date(rs.getDate("book_date").toString());
			book.setSin(rs.getString("sin"));
			book.setCheck_in(rs.getDate("check_in").toString());
			book.setCheck_out(rs.getDate("check_out").toString());
			book.setIs_cancelled(rs.getBoolean("is_cancelled"));
		}

		if (!bookStack.isEmpty()) {
			Book[] bookArray = (Book[]) bookStack.toArray(new Book[bookStack.size()]);
			return bookArray;
		}

		return null;

	}

	// find bookings by hotel
	public static Rent[] findRentByHotel(Connection conn, String hotel_id) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='ehotel';");
		path.execute();

		// findind the bookings by hotel_id
		String sql = "Select * from rent where sin=(select sin from room_rent where hotel_id=?);";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, hotel_id);

		ResultSet rs = pstm.executeQuery();

		Deque<Rent> rentStack = new ArrayDeque<Rent>();
		while (rs.next()) {
			Rent rent = new Rent(null, null, null, null);
			rent.setRent_date(rs.getDate("rent_date").toString());
			rent.setSin(rs.getString("sin"));
			rent.setCheck_in(rs.getDate("check_in").toString());
			rent.setCheck_out(rs.getDate("check_out").toString());

		}

		if (!rentStack.isEmpty()) {
			Rent[] rentArray = (Rent[]) rentStack.toArray(new Rent[rentStack.size()]);
			return rentArray;
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

}