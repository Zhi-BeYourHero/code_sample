package com.zhi.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: luowenzhi
 * @CreateTime: 13/2/2022
 * @desc:
 */
public class JwtUtil {
    private static final String SECRET = "zhi2ZpSecret";
    private static final Long EXPIRATION = 1000 * 60 * 60 * 24L;

    public static String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setHeaderParam("wife", "zp")
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .compact();
    }

    public static Claims getClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

    public static void main(String[] args) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(Claims.SUBJECT, "xiaozhi");
        claims.put("created", new Date());
        Claims claimsFromToken = getClaimsFromToken(generateToken(claims));
        System.out.println(claimsFromToken);
    }
}
