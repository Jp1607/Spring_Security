package com.jp.Spring_Security.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.jp.Spring_Security.Model.Entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JWTService {

    DateService dateService;
    JWTVerifier jwtVerifier;

    @Value("${security.jwt.subscriptionKey}")
    private String subscriptionKey;

    public JWTService(DateService dateService) {
        this.dateService = dateService;
    }

    public String generateToken(User user){
        Algorithm algorithm = Algorithm.HMAC256(subscriptionKey);
        return JWT.create()
                .withIssuer("Spring_Security")
                .withSubject(user.getUsername())
                .withExpiresAt(dateService.createExpirationDate())
                .withClaim("id", user.getId())
                .sign(algorithm);
    }

    public Long getId(String token){
        Claim claim = verify(token).getClaim("id");
        return claim.asLong();
    }

    public DecodedJWT verify(String token) {
        try {
            return jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new RuntimeException(e);
        }
    }
}
