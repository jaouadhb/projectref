package fr.reference.it.projectref.security.rest.config;

import fr.reference.it.projectref.security.rest.config.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenGenerator {
    @Value("${secretKey}")
    String secretKey;
    public String generate(JwtUser userName) {
        Claims claims = Jwts.claims()
                .setSubject(userName.getSubject());
        claims.put("userId",String.valueOf(userName.getUserId()));
        claims.put("role",userName.getRole());

        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512,secretKey).compact();
    }
}
