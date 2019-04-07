package hotelchain.beans;

public class UserRoomHistory {
	
	private String address;
	private String chain_name;
	private int room_number;
	private String check_in;
	private String check_out;
	private int capacity;
	private boolean is_book;
	
	public UserRoomHistory(String a,String b, int c, String d, String e, boolean f, int g) {
		this.setAddress(a);
		this.setChain_name(b);
		this.setRoom_number(c);
		this.setCheck_in(d);
		this.setCheck_out(e);
		this.setIs_book(f);
		this.setCapacity(g);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getChain_name() {
		return chain_name;
	}

	public void setChain_name(String chain_name) {
		this.chain_name = chain_name;
	}

	public int getRoom_number() {
		return room_number;
	}

	public void setRoom_number(int room_number) {
		this.room_number = room_number;
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

	public boolean isIs_book() {
		return is_book;
	}

	public void setIs_book(boolean is_book) {
		this.is_book = is_book;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
