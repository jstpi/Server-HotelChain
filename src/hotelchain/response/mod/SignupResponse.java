package hotelchain.response.mod;

public class SignupResponse {
	private String error;
	private boolean valid;
	
	public SignupResponse(String error, boolean valid) {
       this.setError(error);
       this.valid = valid;
   }
   
   public boolean getValid() {
       return valid;
   }
 
   public void setValid(boolean valid) {
       this.valid = valid;
   }

	public String getError() {
		return error;
	}
	
	public void setError(String error) {
		this.error = error;
	}
 
}
