package hotelchain.beans;

public class Chain_email {
	
	private String chain_name;
	private String email;
	
	public Chain_email(String chain_name, String email) {
		
		this.chain_name=chain_name;
		this.email=email;
	}
	
	public String getChain_name() {
		return chain_name;
	}

	public void setChain_name(String chain_name) {
		this.chain_name=chain_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
