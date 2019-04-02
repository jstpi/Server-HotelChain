package hotelchain.beans;

public class Book {

	private String book_date;
	private String sin;
	private String check_in;
	private String check_out;
	private boolean is_cancelled;
	
	public Book(String book_date, String sin, String check_in, String check_out, boolean is_cancelled) {
		
		this.setBook_date(book_date);
		this.setSin(sin);
		this.setCheck_in(check_in);
		this.setCheck_out(check_out);
		this.setIs_cancelled(is_cancelled);
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



	public String getBook_date() {
		return book_date;
	}



	public void setBook_date(String book_date) {
		this.book_date = book_date;
	}



	public boolean isIs_cancelled() {
		return is_cancelled;
	}



	public void setIs_cancelled(boolean is_cancelled) {
		this.is_cancelled = is_cancelled;
	}
	
}
