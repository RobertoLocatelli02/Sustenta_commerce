package com.sustentaCommerce.ecommerce.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sustentaCommerce.ecommerce.model.Usuario;
import com.sustentaCommerce.ecommerce.repository.UsuarioRepository;

@Service
public class UserDetailsServiceMpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<Usuario> user = userRepository.findByNomeCompletoUsuario(userName);
		user.orElseThrow(() -> new UsernameNotFoundException(userName + "not found."));
		return user.map(UserDetailsMpl::new).get();

	}

}
