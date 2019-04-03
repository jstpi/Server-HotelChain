package hotelchain.beans;

public class UserAccount {

	private String sin;
	private String full_name;
	private String address;
	private String date_registration;
	private String password;
	private String email;

	public UserAccount(String sin, String full_name, String address, String date_registration, String email,
			String password) {
		this.sin=sin;
		this.full_name=full_name;
		this.address=address;
		this.date_registration=date_registration;
		this.password = password;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getSin() {
		return sin;
	}

	public void setSin(String sin) {
		this.sin = sin;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDate_registration() {
		return date_registration;
	}

	public void setDate_registration(String date_registration) {
		this.date_registration = date_registration;
	}

}