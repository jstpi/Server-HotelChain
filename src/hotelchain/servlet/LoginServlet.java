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
import hotelchain.beans.UserAccount;
import hotelchain.utils.DBUtils;
import hotelchain.utils.MyUtils;
import hotelchain.response.mod.LoginResponse;
import hotelchain.response.mod.JWTResponse;

import com.google.gson.*;
 
@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public LoginServlet() {
        super();
    }
 
    // When the user enters userName & password, and click Submit.
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
        
		String userType;
		Gson g = new Gson();
		//json string
		userType = jb.toString();
		
		UserAccount userInfo = new UserAccount(null, null, null, null, null, null);
		try{
			userInfo = g.fromJson(jb.toString(), UserAccount.class);
		}
		catch(JsonSyntaxException e) { 
			e.printStackTrace();
		}
 
        boolean hasError = false;
        String errorString = null;
        Employee employee=null;
        Chain_admin admin=null;
        UserAccount user=null;
 
        if (userInfo.getEmail() == null || userInfo.getPassword() == null || userInfo.getEmail().length() == 0 || userInfo.getPassword().length() == 0) {
            hasError = true;
            errorString = "Required username and password!";
        } else {
            Connection conn = MyUtils.getStoredConnection(request);
            try {
                // Find the user in the DB.
            	if (userType.contains("Customer")) {
            		user = DBUtils.findUser(conn, userInfo.getEmail(), userInfo.getPassword());
            		if (user == null ) {
                        hasError = true;
                        errorString = "User Name or password invalid";
                    }
            	}
            	else if (userType.contains("Employee")) {
            		employee = DBUtils.findEmployee(conn, userInfo.getEmail(), userInfo.getPassword());
            		if (employee == null ) {
                        hasError = true;
                        errorString = "User Name or password invalid";
                    }
            	}
            	else if (userType.contains("Admin")) {
            		admin = DBUtils.findAdmin(conn, userInfo.getEmail(), userInfo.getPassword());
            		if (admin == null ) {
                        hasError = true;
                        errorString = "User Name or password invalid";
                    }
            	}
 
                
            } catch (SQLException e) {
                e.printStackTrace();
                hasError = true;
                errorString = e.getMessage();
            }
        }
        
        if (hasError) {
 
            LoginResponse loginResponse = new LoginResponse(JWTResponse.createJWT("EHotel", "EHotel", errorString, 1000), false); // 1 sec error
            
            response.setContentType("application/json");
            String json = g.toJson(loginResponse);
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }
        // If no error
        // Store user information in Session
        else {
            //HttpSession session = request.getSession();
            //MyUtils.storeLoginedUser(session, user);
        	LoginResponse loginResponse;
        	
        	if (userType.contains("Employee")){
        		loginResponse = new LoginResponse(JWTResponse.createJWT("EHotel", "Employee", employee.getSin(), 1000000), true); // 1000 sec log in
        	}
        	else if (userType.contains("Admin")){
        		loginResponse = new LoginResponse(JWTResponse.createJWT("EHotel", "Admin", admin.getSin(), 1000000), true); // 1000 sec log in
        	}
        	else{
        		loginResponse = new LoginResponse(JWTResponse.createJWT("EHotel", "Customer", user.getSin(), 1000000), true); // 1000 sec log in
        	}
        	response.setContentType("application/json");
            String json = g.toJson(loginResponse);
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
            
        }
    }
 
}