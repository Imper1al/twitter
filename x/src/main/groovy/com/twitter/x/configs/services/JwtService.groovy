//package com.twitter.x.configs.services
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import java.security.Key;
//import java.util.function.Function;
//
//@Service
//class JwtService {
//
//    private static final String SECRET_KEY = "5367566B59703373367639792442264529482B4D6251655468576D5A71347437";
//
//    static String extractUsername(String token) {
//        return extractClaim(token, Claims::getSubject)
//    }
//
//    static <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//        return claimsResolver.apply(extractAllClaims(token))
//    }
//
//    static String generateToken(UserDetails userDetails) {
//        return generateToken(new HashMap<>(), userDetails)
//    }
//
//    static String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
//        return  Jwts.builder()
//                .setClaims(extraClaims)
//                .setSubject(userDetails.getUsername())
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
//                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
//                .compact()
//    }
//
//    static boolean isTokenValid(String token, UserDetails userDetails) {
//        String username = extractUsername(token)
//        return username.equals(userDetails.getUsername()) && !isTokenExpired(token)
//    }
//
//    private static boolean isTokenExpired(String token) {
//        return extractExpiration(token).before(new Date())
//    }
//
//    private static Date extractExpiration(String token) {
//        return extractClaim(token, Claims::getExpiration)
//    }
//
//    private static Claims extractAllClaims(String token) {
//        return  Jwts.parserBuilder()
//                .setSigningKey(getSignInKey())
//                .build()
//                .parseClaimsJws(token)
//                .getBody()
//    }
//
//    private static Key getSignInKey() {
//        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY))
//    }
//}