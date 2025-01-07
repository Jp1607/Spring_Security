package com.jp.Spring_Security.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.jp.Spring_Security.Model.Entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class JWTService {

    DateService dateService;

    @Value("${security.jwt.subscriptionKey}")
    private String subscriptionKey;

    public JWTService(DateService dateService) {
        this.dateService = dateService;
    }

    public String generateToken(User user){
        Algorithm algorithm = Algorithm.HMAC256(subscriptionKey);
        LocalDateTime expiration = LocalDateTime.now().plusDays(3);
        return JWT.create()
                .withIssuer("Spring_Security")
                .withSubject(user.getUsername())
                .withExpiresAt(dateService.createExpirationDate())
                .sign(algorithm);
    }
}
