package br.com.abreutech.sgc.config.security;

import br.com.abreutech.sgc.modelo.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {
	
	@Value("${api.token.expiration}")
	private String expiration;
	
	@Value("${api.token.secret}")
	private String secret;

	public String gerarToken(Authentication authentication) {
		Usuario logado = (Usuario) authentication.getPrincipal();
		Date hoje = new Date();
		Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));

		return Jwts.builder()
				.setClaims(getClaims(logado))
				.setIssuer("br.com.abreutech")
				.setSubject(logado.getUsername())
				.setIssuedAt(hoje)
				.setExpiration(dataExpiracao)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}

	public boolean isTokenValido(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String getUsuario(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return claims.getSubject();
	}

	public Claims getClaims(Usuario usuario) {
		Claims claims = Jwts.claims();
		claims.put("nome", usuario.getNome());
		claims.put("usuario", usuario.getUsuario());
		claims.put("roles", usuario.getPerfilList().get(0).getAuthority());
		return claims;
	}

}
