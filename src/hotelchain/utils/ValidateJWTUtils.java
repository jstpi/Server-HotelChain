package hotelchain.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import hotelchain.beans.JWTModel;
import hotelchain.beans.UserAccount;

public class ValidateJWTUtils {
	
	public static String validate(HttpServletRequest request) {
		String header = request.getHeader("authorization");
		Gson g = new Gson();
		JWTModel jwt = new JWTModel(null, null, null, null, null);
		try {
			jwt = g.fromJson(header.split(" ")[1], JWTModel.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
			return null;
		}
		
		//Test expire
		long nowSec = System.currentTimeMillis()/1000;
		long expSec = Long.parseLong(jwt.getExp());
		if (nowSec > expSec) {
			return null;
		}
		
		//Test correct sin
		try {
			Connection conn = MyUtils.getStoredConnection(request);
			UserAccount user = DBUtils.findInfo(conn, jwt.getSub());
			if (user == null) {
				return null;
			}
			else {
				return jwt.getSub();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
