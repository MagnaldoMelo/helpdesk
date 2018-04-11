package br.com.udemy.api.security.jwt;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtTokenUtil implements Serializable{

    private static final long serialVersionUID = 1L;
    
    public static final String CLAIM_KEY_USERNAME = "sub";
    public static final String CLAIN_KEY_CREATED = "created";
    public static final String CLAIN_KEY_EXPIRED = "expired";

    @Value("{jwt.secret}")
    private String secret;

    @Value("{jwt.expiration}")
    private Long expiration;

    private Claims getClaimsFromToken(String token){
        Claims claims;
        try {
            claims = Jwts.parser()
                .setSigningKey("secret")
                .parseClaimsJws(token)
                .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    public String getUsernameFromToken(String token){
        String username;
        try{
            final Claims claims = getClaimsFromToken(token)
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    public Date getExpirationDateFromToken(String token){
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }
}