package hotelchain.beans;

public class Room_book {

	private String book_date;
	private String sin;
	private int room_number;
	private String hotel_id;
	private String chain_name;
	
	public Room_book(String book_date, String sin, int room_number, String hotel_id, String chain_name) {
		
		this.setBook_date(book_date);
		this.setSin(sin);
		this.setRoom_number(room_number);
		this.setHotel_id(hotel_id);
		this.setChain_name(chain_name);
	}

	public String getBook_date() {
		return book_date;
	}

	public void setBook_date(String book_date) {
		this.book_date = book_date;
	}

	public String getSin() {
		return sin;
	}

	public void setSin(String sin) {
		this.sin = sin;
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
}
