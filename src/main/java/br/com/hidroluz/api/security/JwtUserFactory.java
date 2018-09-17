package br.com.hidroluz.api.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.com.hidroluz.api.security.entity.Cliente;
import br.com.hidroluz.api.security.enums.PerfilEnum;

public class JwtUserFactory {
	
	public JwtUserFactory() {
	}
	
	public static JwtUser create(Cliente cliente) {
		return new JwtUser(cliente.getId_Cliente(), cliente.getLogin(), 
						   cliente.getSenha(), mapToGrateAuthorities(cliente.getPerfil()));
		
	
	}
	
	private static List<GrantedAuthority> mapToGrateAuthorities(PerfilEnum perfilEnum){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(perfilEnum.toString()));
		return authorities;
	}

}
