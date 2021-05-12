package com.sustentaCommerce.ecommerce.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sustentaCommerce.ecommerce.model.Usuario;
import com.sustentaCommerce.ecommerce.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario cadastrarUsuario (Usuario usuarioNovo) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaCriptografada = encoder.encode(usuarioNovo.getSenhaUsuario());
		usuarioNovo.setSenhaUsuario(senhaCriptografada);
		
		return repository.save(usuarioNovo);
		
	}
	
	public Optional<UserLogin> logarUsuario (Optional<UserLogin> loginUser) {
		BCryptPasswordEncoder enconder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = repository.findByNomeCompletoUsuario(loginUser.get().getSenha());
		
		if (usuario.isPresent()) {
			if(enconder.matches(loginUser.get().getSenha(), usuario.get().getSenhaUsuario() ));{
				String auth = loginUser.get().getUsuario() + ":" + loginUser.get().getSenha();
				byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCCII")));
				String token = "Basic " + new String (encodeAuth);
				
				loginUser.get().setToken(token);
				loginUser.get().setNome (usuario.get().getNomeCompletoUsuario());
				loginUser.get().setSenha(usuario.get().getSenhaUsuario());
				
				return loginUser;
				
			}
		}
		return null;
	}

}
