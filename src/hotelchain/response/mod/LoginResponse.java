package hotelchain.response.mod;

public class LoginResponse {
	private String token;
	private boolean valid;
	
	public LoginResponse(String token, boolean valid) {
       this.token = token;
       this.valid = valid;
   }
	 
   public String getToken() {
       return token;
   }
 
   public void setToken(String token) {
       this.token = token;
   }
   
   public boolean getValid() {
       return valid;
   }
 
   public void setValid(boolean valid) {
       this.valid = valid;
   }
 
}
