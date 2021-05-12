package com.sustentaCommerce.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sustentaCommerce.ecommerce.model.Produtos;
import com.sustentaCommerce.ecommerce.model.Usuario;
import com.sustentaCommerce.ecommerce.repository.UsuarioRepository;

@RestController 
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repositoryU;
	
	@GetMapping
	ResponseEntity <List<Usuario>> findAllUsusario(){
		return ResponseEntity.ok(repositoryU.findAll());
	}
	
	@GetMapping("/id/{idUsuario}")
	ResponseEntity <Usuario> findAllByIdUsuario (@PathVariable Long idUsuario){
		return repositoryU.findById(idUsuario).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nomeCompletoUsuario}")
	ResponseEntity <List<Usuario>> findAllByNomeCompletoUsuarioContainingIgnoreCase(@PathVariable String nomeCompletoUsuario){
		return ResponseEntity.ok(repositoryU.findAllByNomeCompletoUsuarioContainingIgnoreCase(nomeCompletoUsuario));
	}
	
	@GetMapping("/email/{emailUsuario}")
	ResponseEntity <List<Usuario>> findAllByEmailUsuarioContainingIgnoreCase(@PathVariable String emailUsuario){
		return ResponseEntity.ok(repositoryU.findAllByNomeCompletoUsuarioContainingIgnoreCase(emailUsuario));
	}
	
	@GetMapping("/senha/{senhaUsuario}")
	ResponseEntity <List<Usuario>> findAllBySenhaUsuarioContainingIgnoreCase(@PathVariable String senhaUsuario){
		return ResponseEntity.ok(repositoryU.findAllByNomeCompletoUsuarioContainingIgnoreCase(senhaUsuario));
	}
	@PostMapping
	ResponseEntity<Usuario> postUsuario(@RequestBody Usuario usuarioNovo){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoryU.save(usuarioNovo));
	}
	
	@PutMapping // atualizar informações de um produto
	ResponseEntity<Usuario> putUsuario(@Valid @RequestBody Usuario usuarioAtualizado) { // end point
		Optional<Usuario> usuarioExistente = repositoryU.findById(usuarioAtualizado.getIdUsuario());
		if (usuarioExistente.isPresent()) {
			usuarioExistente.get().setNomeCompletoUsuario(usuarioAtualizado.getNomeCompletoUsuario());
			usuarioExistente.get().setEmailUsuario(usuarioAtualizado.getEmailUsuario());
			usuarioExistente.get().setSenhaUsuario(usuarioAtualizado.getSenhaUsuario());
			usuarioExistente.get().setTipoPagamento(usuarioAtualizado.getTipoPagamento());
		
			return ResponseEntity.status(HttpStatus.CREATED).body(repositoryU.save(usuarioExistente.get()));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/id/{idUsuario}")
	void deleteUsuario (@PathVariable Long idUsuario){
		repositoryU.deleteById(idUsuario);
	}
}

	
	
	

	
	
	