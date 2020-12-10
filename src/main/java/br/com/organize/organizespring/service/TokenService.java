package br.com.organize.organizespring.service;

import br.com.organize.organizespring.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${jwt.expiration}")
    private String expiration;

    @Value("${jwt.secret}")
    private String secret;

    public  String gerarToken(Authentication authentication){
        Usuario logado = (Usuario) authentication.getPrincipal();
        Date dataHoje = new Date();
        Date dataExp = new Date(dataHoje.getTime() + Long.parseLong(expiration));

        return Jwts.builder()
                .setIssuer("API Organize")
                .setSubject(logado.getIdUsuario().toString())
                .setIssuedAt(dataHoje)
                .setExpiration(dataExp)
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }

    public boolean tokenValido(String token){
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getIdUsuario(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }
}
