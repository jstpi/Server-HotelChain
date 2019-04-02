package hotelchain.beans;

public class Rent {

	private String rent_date;
	private String sin;
	private String check_in;
	private String check_out;
	
	public Rent(String rent_date, String sin, String check_in, String check_out) {
		
		this.setRent_date(rent_date);
		this.setSin(sin);
		this.setCheck_in(check_in);
		this.setCheck_out(check_out);
	}

	public String getRent_date() {
		return rent_date;
	}

	public void setRent_date(String rent_date) {
		this.rent_date = rent_date;
	}

	public String getSin() {
		return sin;
	}

	public void setSin(String sin) {
		this.sin = sin;
	}

	public String getCheck_in() {
		return check_in;
	}

	public void setCheck_in(String check_in) {
		this.check_in = check_in;
	}

	public String getCheck_out() {
		return check_out;
	}

	public void setCheck_out(String check_out) {
		this.check_out = check_out;
	}
	
}
