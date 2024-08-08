package com.learning.learning.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    private static final String SECRET_KEY= "AOfuZIs3OuQD+dFzhfZBTYVP6kCnw0+KclWAjB0Jbwav0evMBE8sXapcTD3cqlDanMD+B9xZhdrQGdrDAzxeJtl7wsPzzgLABUa9c62JC3nTtBD6EpPpv+0VG3O7Yi8IM888rUhuUfmNyrU6m5HHMLaQX4UpUwONzQkmWC5LvC15EVXims2feku+pE93+WPebQxYLQvfedQk7c70tAEP8aVEONWPYl1JmwePfECglX93KCKUuBaG9kgwr4R1coAzqvvUt2bU6qB3JP8C40XxP81v4brZte3YIBMBEst1jlxIzM0Ued4DvBO2lQpodW6dW4jI0fgfazE/mCCOKF2j3ayO2Jxj3UHqli9SQHPUsgM=";
    public String extractUsername(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    public  String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails
    ) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSignInkey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public  boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaims(token, Claims::getExpiration);
    }

    public <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInkey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInkey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}

