package es.ua.dlsi.grfia.im3ws.muret.auth.jwt;

import es.ua.dlsi.grfia.im3ws.muret.auth.services.UserPrinciple;
import io.jsonwebtoken.*;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {

    @Value("${muret.jwtSecret}")
    private String jwtSecret;

    @Value("${muret.jwtExpiration}")
    private int jwtExpiration;

    public String generateJwtToken(Authentication authentication) {

        UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();

        return Jwts.builder()
		                .setSubject((userPrincipal.getUsername()))
		                .setIssuedAt(new Date())
		                .setExpiration(new Date((new Date()).getTime() + jwtExpiration*1000))
		                .signWith(SignatureAlgorithm.HS512, jwtSecret)
		                .compact();
    }
    
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            Logger.getLogger(this.getClass()).warn("Invalid JWT signature -> Message: {} ", e);
        } catch (MalformedJwtException e) {
            Logger.getLogger(this.getClass()).warn("Invalid JWT token -> Message: {}", e);
        } catch (ExpiredJwtException e) {
            Logger.getLogger(this.getClass()).warn("Expired JWT token -> Message: {}", e);
        } catch (UnsupportedJwtException e) {
            Logger.getLogger(this.getClass()).warn("Unsupported JWT token -> Message: {}", e);
        } catch (IllegalArgumentException e) {
            Logger.getLogger(this.getClass()).warn("JWT claims string is empty -> Message: {}", e);
        }
        
        return false;
    }
    
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser()
			                .setSigningKey(jwtSecret)
			                .parseClaimsJws(token)
			                .getBody().getSubject();
    }
}
