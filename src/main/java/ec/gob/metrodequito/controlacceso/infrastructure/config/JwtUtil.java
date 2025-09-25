package ec.gob.metrodequito.controlacceso.infrastructure.config;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    private static String SECRET_KEY = "2025_U10_337r0_6u170";
    private static Algorithm ALGORITHM = Algorithm.HMAC256(SECRET_KEY);

    public String create(String username){
        return JWT.create()
                .withSubject(username)
                .withIssuer("metro-quito")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(60))) //TimeUnit.DAYS.toMillis(1)))
                .sign(ALGORITHM);
    }

    public boolean isvalid(String jwt) {
        try{
            JWT.require(ALGORITHM).build()
                    .verify(jwt);
            return true;
        }catch(JWTVerificationException e){
            return false;
        }
    }

    public String getUsername(String jwt){
        return JWT.require(ALGORITHM).build()
                .verify(jwt)
                .getSubject();
    }

}

