package hotelchain.beans;

public class Room {

	private int room_number;
	private String hotel_id;
	private String chain_name;
	private float price;
	private int capacity;
	private String view_type;
	private boolean is_extendable;
	private String check_in;
	private String check_out;

	public Room(int room_number, String hotel_id, String chain_name, float price, int capacity, String view_type,
			boolean is_extendable) {
		this.setRoom_number(room_number);
		this.setHotel_id(hotel_id);
		this.setChain_name(chain_name);
		this.setPrice(price);
		this.setCapacity(capacity);
		this.setView_type(view_type);
		this.setIs_extendable(is_extendable);
	}

	public int getRoom_number() {
		return room_number;
	}

	public void setRoom_number(int room_number) {
		this.room_number = room_number;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getView_type() {
		return view_type;
	}

	public void setView_type(String view_type) {
		this.view_type = view_type;
	}

	public boolean isIs_extendable() {
		return is_extendable;
	}

	public void setIs_extendable(boolean is_extendable) {
		this.is_extendable = is_extendable;
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
