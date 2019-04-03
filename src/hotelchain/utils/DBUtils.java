package hotelchain.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Deque;

import hotelchain.beans.Chain;
import hotelchain.beans.Chain_admin;
import hotelchain.beans.Employee;
import hotelchain.beans.Hotel;
import hotelchain.beans.Product;
import hotelchain.beans.UserAccount;

public class DBUtils {

	public static UserAccount findUser(Connection conn, String email, String password) throws SQLException {

		// System.out.println("The account is of type Customer.");

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='eHotel';");
		path.execute();

		// preparing query for the user
		String sql = "Select * from customer where email = ? and password= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, email);
		pstm.setString(2, password);
		//System.out.println(pstm);
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
		PreparedStatement path = conn.prepareStatement("Set search_path='eHotel';");
		path.execute();

		// preparing query for the employee
		String sql = "Select * from employee where email = ? and password= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, email);
		pstm.setString(2, password);
		System.out.println(pstm);
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
		PreparedStatement path = conn.prepareStatement("Set search_path='eHotel';");
		path.execute();

		// preparing query for the employee
		String sql = "Select * from chain_admin where email = ? and password= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, email);
		pstm.setString(2, password);
		System.out.println(pstm);
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
		PreparedStatement path = conn.prepareStatement("Set search_path='eHotel';");
		path.execute();

		// preparing query for the user
		String sql = "Select * from customer where sin = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, sin);
		System.out.println(pstm);
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
		PreparedStatement path = conn.prepareStatement("Set search_path='eHotel';");
		path.execute();

		// preparing query for the user
		String sql = "Select * from employee where sin = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, sin);
		System.out.println(pstm);
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
		PreparedStatement path = conn.prepareStatement("Set search_path='eHotel';");
		path.execute();

		// preparing query for the user
		String sql = "Select * from chain_admin where sin = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, sin);
		System.out.println(pstm);
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

	public static Hotel[] findHotel(Connection conn, String address) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='eHotel';");
		path.execute();

		String sql = "SELECT * FROM hotel WHERE hotel_address ~* '"+address+"';";
		System.out.println(sql);
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

	// find hotel with employee sin
	public static Hotel findEmployeeHotel(Connection conn, String sin) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='eHotel';");
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
			hotel.setRating(rs.getFloat("chain_name"));

			return hotel;
		}
		return null;
	}

	// find chain with admin sin
	public static Chain findAdminChain(Connection conn, String sin) throws SQLException {

		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='eHotel';");
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
	
	// create new customer
		public static void createCustomer(Connection conn, String sin, String email, String pwd, String address, String name, String date) throws SQLException {

			// Accessing the right search path
			PreparedStatement path = conn.prepareStatement("Set search_path='eHotel';");
			path.execute();

			//INSERT INTO cutomer () VALUES(1,'Fred','Lafleche');
			String sql = "INSERT INTO customer (sin,full_name,address,date_registration,password,email) VALUES('?','?','?','?','?','?');";

			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, sin);
			pstm.setString(2, name);
			pstm.setString(3, address);
			pstm.setString(4, date);
			pstm.setString(5, pwd);
			pstm.setString(6, email);

			pstm.executeUpdate();
			
			
		}

	// sample update
	public static void updateProduct(Connection conn, Product product) throws SQLException {
		String sql = "Update Product set Name =?, Price=? where Code=? ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, product.getName());
		pstm.setFloat(2, product.getPrice());
		pstm.setString(3, product.getCode());
		pstm.executeUpdate();
	}

	// sample insert
	public static void insertProduct(Connection conn, Product product) throws SQLException {
		String sql = "Insert into Product(Code, Name,Price) values (?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, product.getCode());
		pstm.setString(2, product.getName());
		pstm.setFloat(3, product.getPrice());

		pstm.executeUpdate();
	}

	// sample delete
	public static void deleteProduct(Connection conn, String code) throws SQLException {
		String sql = "Delete From Product where Code= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, code);

		pstm.executeUpdate();
	}

}