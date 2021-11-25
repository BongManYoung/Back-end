package com.hackathon.MYD.util;

import com.hackathon.MYD.exception.ExceptionMessage;
import com.hackathon.MYD.exception.BasicException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtUtil {
    public final static long TOKEN_VALIDATION_SECOND = 1000L*60*24*2;

    String accessToken = "access";

    @Value("${auth.jwt.secret}")
    private String SECRET_KEY;

    public String createToken(String nickname){
        return generateToken(nickname);
    }

    public String generateToken(String nickname){
        return doGenerateToken(nickname, TOKEN_VALIDATION_SECOND, accessToken);
    }

    private String doGenerateToken(String nickname, long expireTime, String type){
        Claims claims = Jwts.claims();
        claims.put("user", nickname);
        claims.put("type", type);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+expireTime))
                .signWith(getSigningKey(SECRET_KEY), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getSigningKey(String secretKey){
        byte[] keyBytes = secretKey.getBytes();
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // 토큰 검증시 시용하면 됩니다
    public void validateToken(String token){
        try{
            Jwts.parserBuilder().setSigningKey(getSigningKey(SECRET_KEY)).build().parseClaimsJws(token);
        } catch (SecurityException | MalformedJwtException e){
            throw new BasicException(ExceptionMessage.INVALID_SIGNATURE);
        } catch (ExpiredJwtException e){
            throw new BasicException(ExceptionMessage.TOKEN_EXPIRED);
        } catch (UnsupportedJwtException e){
            throw new BasicException(ExceptionMessage.UNSUPPORTED_TOKEN);
        } catch (Exception e){
            throw new BasicException(ExceptionMessage.INVALID_TOKEN);
        }
    }


    // 토큰에서 닉네임 얻어올 때 사용하면 됩니다
    public String getUserNicknameFromJwtToken(String accessToken){
        return (String) getBodyFromToken(accessToken)
                .get("user");
    }

    private Claims getBodyFromToken(String token){
        return Jwts.parserBuilder().setSigningKey(getSigningKey(SECRET_KEY))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
