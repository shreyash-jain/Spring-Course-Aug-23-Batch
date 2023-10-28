package com.shreyash.demo.Core.Utils;
import io.jsonwebtoken.*;

import java.util.Date;

public class JwtUtil {
    private static final String SECRET = "87690825e122bfda798af4c28267c2265bc16ea617a587deaf7f83ee69051e74";
    private static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }
    public static String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}