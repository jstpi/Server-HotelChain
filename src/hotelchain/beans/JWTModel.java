package hotelchain.beans;

public class JWTModel {
	private String jti;
	private String iss;
	private String sub;
	private String iat;
	private String exp;
	public JWTModel(String jti, String iss, String sub, String iat, String exp) {
		this.jti = jti;
		this.iss = iss;
		this.sub = sub;
		this.iat = iat;
		this.exp = exp;
	}
	public String getJti() {
		return jti;
	}
	public void setJti(String jti) {
		this.jti = jti;
	}
	public String getIss() {
		return iss;
	}
	public void setIss(String iss) {
		this.iss = iss;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public String getIat() {
		return iat;
	}
	public void setIat(String iat) {
		this.iat = iat;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}

}
