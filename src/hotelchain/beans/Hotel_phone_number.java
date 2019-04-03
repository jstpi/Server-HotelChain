package hotelchain.beans;

public class Hotel_phone_number {
	
	private String phone_number;
	private String hotel_id;
	private String chain_name;
	
	public Hotel_phone_number(String phone_number, String hotel_id, String chain_name) {
		
		this.phone_number=phone_number;
		this.hotel_id=hotel_id;
		this.chain_name=chain_name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
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
