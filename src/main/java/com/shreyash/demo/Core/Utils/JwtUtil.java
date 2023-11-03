package com.shreyash.demo.Core.Utils;
import io.jsonwebtoken.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.function.Function;
import java.util.function.Predicate;

public class JwtUtil {
    private static final String SECRET = "87690825e122bfda798af4c28267c2265bc16ea617a587deaf7f83ee69051e74";
    private static final long AUTH_EXPIRATION_TIME = 464_000_000;
    private static final long REFRESH_EXPIRATION_TIME = 964_000_000;
    public static String generateToken(String username,  final long addedExpiry) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + addedExpiry))
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

    public static boolean isTokenValid(String token, UserDetails userDetails){
        final String tokenUsername = extractUsername(token);
        return (tokenUsername.equals(userDetails.getUsername()) && isTokenExpired(token));
    }




    public static <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    public static Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    public static Claims extractAllClaims(String token){
        return   Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }


    private static boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());


    }
}