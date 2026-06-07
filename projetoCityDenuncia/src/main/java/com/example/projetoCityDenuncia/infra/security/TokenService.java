package com.example.projetoCityDenuncia.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.projetoCityDenuncia.model.User;
import com.example.projetoCityDenuncia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secretKey;

    @Autowired
    private UserRepository userRepository;

    public String generateToken(User user) throws JWTCreationException {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        return JWT.create()
                .withIssuer("city-denuncia-api")
                .withSubject(user.getEmail())
                .withClaim("type", "access")
                .withExpiresAt(genExpirationDateToken())
                .withIssuedAt(Instant.now())
                .sign(algorithm);
    }

    public String generateRefreshToken(String token) throws JWTCreationException {

        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        String email = validateToken(token);
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));

        return JWT.create()
                .withIssuer("city-denuncia-api")
                .withSubject(user.getEmail())
                .withClaim("type", "refresh")
                .withExpiresAt(genExpirationDateRefreshToken())
                .withIssuedAt(Instant.now())
                .sign(algorithm);
    }

    public String generateAccessTokenFromRefreshToken(String refreshToken) throws JWTCreationException {

        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        String email = validateRefreshToken(refreshToken);
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));

        return JWT.create()
                .withIssuer("city-denuncia-api")
                .withSubject(user.getEmail())
                .withClaim("type", "access")
                .withExpiresAt(genExpirationDateToken())
                .withIssuedAt(Instant.now())
                .sign(algorithm);
    }

    public String validateToken(String token) throws JWTVerificationException {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        return JWT.require(algorithm)
                .withIssuer("city-denuncia-api")
                .withClaim("type", "access")
                .build()
                .verify(token)
                .getSubject();
    }

    public String validateRefreshToken(String refreshToken) throws JWTVerificationException {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        return JWT.require(algorithm)
                .withIssuer("city-denuncia-api")
                .withClaim("type", "refresh")
                .build()
                .verify(refreshToken)
                .getSubject();
    }

    private Instant genExpirationDateToken(){
        return Instant.now().plus(Duration.ofMinutes(2));
    }

    private Instant genExpirationDateRefreshToken(){
        return Instant.now().plus(Duration.ofDays(7));
    }
}
