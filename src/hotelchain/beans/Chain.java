package hotelchain.beans;

public class Chain {
	private String chain_name;
	private String central_office_address;
	private int number_of_hotels;

	public Chain(String chain_name, String central_office_address, int number_of_hotels) {
		
		this.setChain_name(chain_name);
		this.setCentral_office_address(central_office_address);
		this.setNumber_of_hotels(number_of_hotels);
	}

	public String getCentral_office_address() {
		return central_office_address;
	}

	public void setCentral_office_address(String central_office_address) {
		this.central_office_address = central_office_address;
	}

	public String getChain_name() {
		return chain_name;
	}

	public void setChain_name(String chain_name) {
		this.chain_name = chain_name;
	}

	public int getNumber_of_hotels() {
		return number_of_hotels;
	}

	public void setNumber_of_hotels(int number_of_hotels) {
		this.number_of_hotels = number_of_hotels;
	}

}
