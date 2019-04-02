package hotelchain.beans;

public class Hotel {

	private String hotel_id;
	private String chain_name;
	private int number_of_rooms;
	private String hotel_address;
	private String contact_email_address;
	private float rating;

	public Hotel(String hotel_id, String chain_name, int number_of_rooms, String hotel_address,
			String contact_email_address, float rating) {
		this.setHotel_id(hotel_id);
		this.setChain_name(chain_name);
		this.setNumber_of_rooms(number_of_rooms);
		this.setHotel_address(hotel_address);
		this.setContact_email_address(contact_email_address);
		this.setRating(rating);

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

	public int getNumber_of_rooms() {
		return number_of_rooms;
	}

	public void setNumber_of_rooms(int number_of_rooms) {
		this.number_of_rooms = number_of_rooms;
	}

	public String getHotel_address() {
		return hotel_address;
	}

	public void setHotel_address(String hotel_address) {
		this.hotel_address = hotel_address;
	}

	public String getContact_email_address() {
		return contact_email_address;
	}

	public void setContact_email_address(String contact_email_address) {
		this.contact_email_address = contact_email_address;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

}
