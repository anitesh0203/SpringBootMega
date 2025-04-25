package com.example.securityDemo.service;

import com.example.securityDemo.model.MyUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private String secretKey;

    public JwtService() {
        this.secretKey = getSecretKey();
    }
    public String getToken(MyUser user) throws NoSuchAlgorithmException {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getName())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 3))
                .signWith(getKeyy(), SignatureAlgorithm.HS256).compact();
    }

    private Key getKeyy() throws NoSuchAlgorithmException {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private static String getSecretKey() {
        KeyGenerator keygen = null;
        try {
            keygen = KeyGenerator.getInstance("Hmacsha256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        SecretKey secretKey = keygen.generateKey();
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }

    public String getUsername(String token){
        try {
            return extractClaim(token, Claims::getSubject);

        }catch (NoSuchAlgorithmException ex){
            return null;

        }
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) throws NoSuchAlgorithmException {
        final Claims claims = extracttoken(token);
        return claimsResolver.apply(claims);
    }

    private Claims extracttoken(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(getKeyy())
                    .build().parseClaimsJws(token).getBody();
        } catch (NoSuchAlgorithmException ex) {

        }
        return null;
    }

    public boolean isValidToken(String token, UserDetails userDetails) throws NoSuchAlgorithmException {
        final String usrename = getUsername(token);
        if (!userDetails.getUsername().equalsIgnoreCase(usrename)  || isExpiredToken(token)) {
            return false;
        }
        return true;
    }

    private boolean isExpiredToken(String token) throws NoSuchAlgorithmException {
        Date time = extractClaim(token, Claims::getExpiration);
        return time.before(new Date());
    }


}
