package hotelchain.servlet;
 
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hotelchain.beans.UserAccount;
import hotelchain.utils.DBUtils;
import hotelchain.utils.MyUtils;
import hotelchain.response.mod.LoginResponse;

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
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String rememberMeStr = request.getParameter("rememberMe");
        boolean remember = "Y".equals(rememberMeStr);
 
        UserAccount user = null;
        boolean hasError = false;
        String errorString = null;
 
        if (userName == null || password == null || userName.length() == 0 || password.length() == 0) {
            hasError = true;
            errorString = "Required username and password!";
        } else {
            Connection conn = MyUtils.getStoredConnection(request);
            try {
                // Find the user in the DB.
                user = DBUtils.findUser(conn, userName, password);
 
                if (user == null) {
                    hasError = true;
                    errorString = "User Name or password invalid";
                }
            } catch (SQLException e) {
                e.printStackTrace();
                hasError = true;
                errorString = e.getMessage();
            }
        }
        
        if (hasError) {
            user = new UserAccount();
            user.setUserName(userName);
            user.setPassword(password);
 
            LoginResponse loginResponse = new LoginResponse(userName, password, false, errorString);
            
            response.setContentType("application/json");
            String json = new Gson().toJson(loginResponse);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }
        // If no error
        // Store user information in Session
        // And redirect to userInfo page.
        else {
            HttpSession session = request.getSession();
            MyUtils.storeLoginedUser(session, user);
 
            // If user checked "Remember me".
            if (remember) {
                MyUtils.storeUserCookie(response, user);
            }
            // Else delete cookie.
            else {
                MyUtils.deleteUserCookie(response);
            }
 
            LoginResponse loginResponse = new LoginResponse(userName, password, true, errorString);
            
            response.setContentType("application/json");
            String json = new Gson().toJson(loginResponse);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }
    }
 
}