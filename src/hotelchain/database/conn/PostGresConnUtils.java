package hotelchain.database.conn;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
  
public class PostGresConnUtils {
  
   public static Connection getPostGresConnection()
           throws ClassNotFoundException, SQLException {
  
       // Note: Change the connection parameters accordingly.
       String hostName = "web0.site.uottawa.ca";
       String port = "15432";
       String userName = "jstpi047";
       String password = "Picun103606";
  
       return getPostGresConnection(hostName, port, userName, password);
   }
  
   public static Connection getPostGresConnection(String hostName, String port,
           String userName, String password) throws ClassNotFoundException,
           SQLException {
   
       Class.forName("org.postgresql.Driver");
  
       // URL Connection for Postgresql
       //jdbc:postgresql://web0.site.uottawa.ca:15432/svale054
       String connectionURL = "jdbc:postgresql://" + hostName + ":" + port + "/" + userName;
  
       Connection conn = DriverManager.getConnection(connectionURL, userName,
               password);
       return conn;
   }
}