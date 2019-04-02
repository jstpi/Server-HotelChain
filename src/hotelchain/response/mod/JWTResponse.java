package hotelchain.response.mod;

import java.util.Date;
// import javax.crypto.spec.SecretKeySpec;
// import javax.xml.bind.DatatypeConverter;

import hotelchain.beans.UserAccount;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.impl.crypto.MacProvider;

public class JWTResponse {	
	public static String createJWT(String id, String issuer, String subject, long ttlMillis) {

	    long nowMillis = System.currentTimeMillis();
	    Date now = new Date(nowMillis);

	    //Let's set the JWT Claims
	    JwtBuilder builder = Jwts.builder().setId(id)
	    		.setIssuer(issuer)
	            .setSubject(subject)
	            .setIssuedAt(now);
	  
	    //if it has been specified, let's add the expiration
	    if (ttlMillis > 0) {
	        long expMillis = nowMillis + ttlMillis;
	        Date exp = new Date(expMillis);
	        builder.setExpiration(exp);
	    }  
	  
	    //Builds the JWT and serializes it to a compact, URL-safe string
	    return builder.compact();
	}
}
