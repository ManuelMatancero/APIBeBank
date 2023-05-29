package com.manuelsarante.ApiBeBank.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtils {

    private final static String ACCSESS_TOKEN_SECRET="2134h12h34h123h42b4hb24hv12g4c53k16v5";
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS= 120L;

    //This methods send a unique token to the client
    public static String createToken(String nombre, String user){
        //This variables calculate the expiration time of the token
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1_000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        Map<String, Object> extra = new HashMap<>();
        extra.put("nombre", nombre);

        return Jwts.builder()
                .setSubject(user)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(ACCSESS_TOKEN_SECRET.getBytes()))
                .compact();

    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token){
      try{
          Claims claims = Jwts.parserBuilder()
                  .setSigningKey(ACCSESS_TOKEN_SECRET.getBytes())
                  .build()
                  .parseClaimsJws(token)
                  .getBody();

          String user = claims.getSubject();

          return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
      }catch (JwtException e){
          return null;
      }
    }


}
