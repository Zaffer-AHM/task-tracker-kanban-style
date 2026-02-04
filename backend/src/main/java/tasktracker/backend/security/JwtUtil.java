package tasktracker.backend.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;
import lombok.NonNull;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Component
public class JwtUtil {

    private final Algorithm algorithm;
    private final JWTVerifier jwtVerifier;

    private static final String SECRET = "secret_H256";
    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1hr

    private static final String ISSUER = "task-tracker";
    private static final String ROLES_CLAIM = "roles";

    public JwtUtil() {
        this.algorithm = Algorithm.HMAC256(SECRET);
        this.jwtVerifier = JWT.require(algorithm)
                .withIssuer(ISSUER)
                .build();
    }

    // Token generation
    @NonNull
    public String generateToken(@NonNull String username, List<String> roles) throws IllegalArgumentException, JWTCreationException {
        Instant now = Instant.now();
        return JWT.create()
                .withIssuer(ISSUER)
                .withSubject(username)
                .withClaim(ROLES_CLAIM, roles)
                .withIssuedAt(Date.from(now))
                .withExpiresAt(Date.from(now.plusMillis(EXPIRATION_TIME)))
                .sign(algorithm);
    }

    // Token signature validation
    public boolean isTokenValid(@NonNull String token) {
        try {
            jwtVerifier.verify(token);
            return true;
        } catch (JWTVerificationException exception) {
            return false;
        }
    }

    // Token Decoder ???
    private DecodedJWT getDecodedToken(String token) throws JWTVerificationException {
        return jwtVerifier.verify(token);
    }

    // Note: we are extracting the username/role to check if the token is valid or not
    public String extractUsername(String token) throws JWTVerificationException {
        return getDecodedToken(token).getSubject();
    }
    public List<String> extractRoles(String token) throws JWTVerificationException {
        return getDecodedToken(token).getClaim(ROLES_CLAIM).asList(String.class);
    }

}
