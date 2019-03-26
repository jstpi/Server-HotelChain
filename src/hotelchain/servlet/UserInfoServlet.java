package hotelchain.servlet;
 
import java.io.IOException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hotelchain.beans.UserAccount;
import hotelchain.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/userInfo" })
public class UserInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public UserInfoServlet() {
        super();
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	HttpSession session = request.getSession();
    	
    	// Check User has logged on
        UserAccount loginedUser = MyUtils.getLoginedUser(session);
 
        // Not logged in
        if (loginedUser == null) {
            // Redirect to login page.
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        // Store info to the request attribute before forwarding.
        request.setAttribute("user", loginedUser);
        
        // TO DO: continue to a query
    }
 
}