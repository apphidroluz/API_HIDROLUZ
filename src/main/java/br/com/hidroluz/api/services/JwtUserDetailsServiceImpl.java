package br.com.hidroluz.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.hidroluz.api.entity.Cliente;
import br.com.hidroluz.api.security.JwtUserFactory;

public class JwtUserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private ClienteService clienteService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Cliente> user = clienteService.buscarPorLogin(username);
		
		if(user.isPresent()) {
			return JwtUserFactory.create(user.get());
		}
		
		throw new UsernameNotFoundException("Login Não encontrado.");
		
	}

}
