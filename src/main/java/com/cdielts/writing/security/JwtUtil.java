package com.cdielts.writing.security;


import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int jwtExpirationMs;

    private SecretKey key;
    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }



    // Generate JWT token
    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(new Date())
                //.expiration(new Date(System.currentTimeMillis() + 1000L * 60 * 60 * 24)) -- Removing this line stops an expiration date from being added
                .signWith(getKey())
                .compact();
    }


    // Get username from JWT token
    public String extractUsername(String token) {
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }


//Validate JWT token
public boolean isTokenValid(String token, UserDetails userDetails) {
    return extractUsername(token).equals(userDetails.getUsername())
            && !isTokenExpired(token);
}

    public boolean isTokenExpired(String token) {
//        return Jwts.parser()     this version is used when if the token expiration is used but in my case I omitted the token expiration for development purposes
//                .verifyWith(getKey())
//                .build()
//                .parseSignedClaims(token)
//                .getPayload()
//                .getExpiration()
//                .before(new Date());




        //this version is used for not using an checking token expiration
        Date expiration = Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getExpiration(); // Will return null for tokens without an 'exp' claim

        // If expiration is null, the token never expires, so return false
        if (expiration == null) {
            return false;
        }

        return expiration.before(new Date());
    }

}
