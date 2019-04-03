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
		Hotel hotel= new Hotel(null,null,1,null,null,1);
		
		try{
			hotel = g.fromJson(jb.toString(), Hotel.class);
		}
		catch(JsonSyntaxException e) { 
			e.printStackTrace();
		}
 
        boolean hasError = false;
        String errorString = null;
 
        if (hotel.getHotel_address() == null|| hotel.getHotel_address().length() == 0) {
            hasError = true;
            errorString = "City required!";
        } else {
            Connection conn = MyUtils.getStoredConnection(request);
            try {
                // Find the hotels in the DB.
            		hotel = DBUtils.findHotel(conn, hotel.getHotel_address());
            		if (hotel == null ) {
                        hasError = true;
                        errorString = "Address invalid";
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
        	

        	loginResponse = new LoginResponse(JWTResponse.createJWT("EHotel", "EHotel", hotel.getHotel_id(), 1000000), true); // 1000 sec log in
        
            
            
            response.setContentType("application/json");
            String json = new Gson().toJson(loginResponse);
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }
    }
 
}