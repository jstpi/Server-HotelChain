package hotelchain.beans;

public class Amenity {
	
	private String amenity;
	private int room_number;
	private String hotel_id;
	private String chain_name;
	
	public Amenity(String amenity, int room_number, String hotel_id, String chain_name) {
		
		this.amenity=amenity;
		this.room_number=room_number;
		this.hotel_id=hotel_id;
		this.chain_name=chain_name;
	}

	public String getAmenity() {
		return amenity;
	}

	public void setAmenity(String amenity) {
		this.amenity = amenity;
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
