package fr.reference.it.projectref.security.rest.config;

import fr.reference.it.projectref.security.rest.config.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {
    @Value("${secretKey}")
    private String secret;

    public JwtUser validate(String token) {
        JwtUser jwtUser = null;
        try{
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
            jwtUser = new JwtUser();
            jwtUser.setUserName(body.getSubject());
            jwtUser.setRole((String)body.get("role"));
            jwtUser.setId(Long.parseLong((String)body.get("userId")));
            body.getSubject();
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return jwtUser;
    }
}
