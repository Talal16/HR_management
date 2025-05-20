package com.hrmanagement.hr_management.security;

import com.hrmanagement.hr_management.models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration-ms}")
    private long expirationMs;

    public String generateToken(User user){
            return Jwts.builder()
                    .setSubject(Long.toString(user.getId()))
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                    .signWith(SignatureAlgorithm.HS256,secret)
                    .compact();
    }

    public boolean isTokenValid(String token, User user){
        final String userId = extractUserId(token);
        return userId.equals(user.getId()) && !isTokenExpired(token);
    }

    public String extractUserId(String token){
        return extractClaim(token, Claims::getSubject);
    }


    //-------------------------------------------helpers------//
    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secret)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

}
