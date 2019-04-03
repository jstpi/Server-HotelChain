package hotelchain.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hotelchain.beans.Chain_admin;
import hotelchain.beans.Employee;
import hotelchain.beans.Hotel;
import hotelchain.beans.Product;
import hotelchain.beans.UserAccount;

public class DBUtils {

	public static UserAccount findUser(Connection conn, String email, String password) throws SQLException {

		//System.out.println("The account is of type Customer.");
		
		// Accessing the right search path
		PreparedStatement path = conn.prepareStatement("Set search_path='eHotel';");
		path.execute();

		// preparing query for the user
		String sql = "Select * from customer where email = ? and password= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, email);
		pstm.setString(2, password);
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
	
	public static Employee findEmployee(Connection conn, String email, String password) throws SQLException {
		
		//System.out.println("The account is of type Employee.");
		
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
			//missing chain, hotel and employee id
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

		//System.out.println("The account is of type Admin.");
		
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
			Chain_admin admin = new Chain_admin(null, null, null, null, null,null);

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

	public static Hotel findHotel(Connection conn, String address) throws SQLException {

		String sql = "SELECT * FROM hotel WHERE hotel_address ~* '?'";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, address);

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