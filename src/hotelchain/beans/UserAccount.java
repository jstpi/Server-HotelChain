package hotelchain.beans;
 
public class UserAccount {
 
    
   private String email;
   private String password;
    
 
   public UserAccount() {
        
   }
    
   public String getEmail() {
       return email;
   }
 
   public void setUserName(String email) {
       this.email = email;
   }
 
 
   public String getPassword() {
       return password;
   }
 
   public void setPassword(String password) {
       this.password = password;
   }
 
}