package hotelchain.beans;

public class Employee {

	private String employee_id;
	private String hotel_id;
	private String chain_name;
	private String sin;
	private String full_name;
	private String address;
	private String password;
	private String email;

	public Employee(String employee_id, String hotel_id, String chain_name, String sin, String full_name,
			String address, String email, String password) {

		this.employee_id = employee_id;
		this.hotel_id = hotel_id;
		this.chain_name = chain_name;
		this.sin = sin;
		this.full_name = full_name;
		this.address = address;
		this.password = password;
		this.email = email;

	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(String hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getChain_name() {
		return chain_name;
	}

	public void setChain_name(String chain_name) {
		this.chain_name = chain_name;
	}

	public String getSin() {
		return sin;
	}

	public void setSin(String sin) {
		this.sin = sin;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

}
