package hotelchain.beans;

public class Chain_phone_number {
	
	private String phone_number;
	private String chain_name;
	
	public Chain_phone_number(String chain_name, String phone_number) {
		
		this.chain_name=chain_name;
		this.phone_number=phone_number;
	}
	
	public String getChain_name() {
		return chain_name;
	}

	public void setChain_name(String chain_name) {
		this.chain_name=chain_name;
	}

	public String gePphone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

}
