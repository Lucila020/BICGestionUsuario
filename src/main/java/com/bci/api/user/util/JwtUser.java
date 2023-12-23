package com.bci.api.user.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.UUID;

@Component
public class JwtUser {

    private static final String secretKey = "mi_clave_secreta";

    public String createJwt(String email) {

        final var key = new SecretKeySpec(secretKey.getBytes(), SignatureAlgorithm.HS256.getJcaName());

        return Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(key).compact();

    }


}
