package hotelchain.response.mod;

public class LoginResponse {
	private String userName;
	private String password;
	private boolean valid;
	private String errorString;
	
	public LoginResponse(String userName, String password, boolean valid, String errorString) {
       this.userName = userName;
       this.password = password;
       this.valid = valid;
       this.errorString = errorString;
   }
	 
   public String getUserName() {
       return userName;
   }
 
   public void setUserName(String userName) {
       this.userName = userName;
   }
 
   public String getPassword() {
       return password;
   }
 
   public void setPassword(String password) {
       this.password = password;
   }
 
   public boolean getValid() {
       return valid;
   }
 
   public void setValid(boolean valid) {
       this.valid = valid;
   }
   
   public String getErrorString() {
       return errorString;
   }
 
   public void setErrorString(String errorString) {
       this.errorString = errorString;
   }
}
