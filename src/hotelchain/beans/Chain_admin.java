package hotelchain.beans;

public class Chain_admin {
	
	private String admin_id;
	private String full_name;
	private String chain_name;
	private String password;
	private String email;
	private String sin;
	
	public Chain_admin(String admin_id, String full_name, String chain_name, String pwd, String email, String sin) {
		
		this.admin_id=admin_id;
		this.full_name=full_name;
		this.setChain_name(chain_name);
		this.setPassword(password);
		this.setEmail(email);
		this.setSin(sin);
	}
	
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getChain_name() {
		return chain_name;
	}
	public void setChain_name(String chain_name) {
		this.chain_name = chain_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getSin() {
		return sin;
	}

	public void setSin(String sin) {
		this.sin = sin;
	}

}
