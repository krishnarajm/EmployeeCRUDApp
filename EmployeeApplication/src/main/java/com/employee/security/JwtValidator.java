package com.employee.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.employee.config.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {

	@Value("${jwt.secret}")
	private String secret;

    public JwtUser validate(String token) {

        JwtUser jwtUser = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            jwtUser = new JwtUser();

            jwtUser.setName(body.getSubject());
            jwtUser.setId(Long.parseLong((String) body.get("userId")));
            jwtUser.setDesignation((String) body.get("designation"));
            jwtUser.setClient((String) body.get("client"));
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return jwtUser;
    }
}
