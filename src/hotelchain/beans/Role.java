package hotelchain.beans;

public class Role {
	
	private String role;
	private String employee_id;
	
	public Role(String role, String employee_id) {
		
		this.role=role;
		this.employee_id=employee_id;		
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	

}
