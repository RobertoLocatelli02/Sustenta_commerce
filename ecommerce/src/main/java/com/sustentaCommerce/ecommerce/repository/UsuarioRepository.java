package com.sustentaCommerce.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sustentaCommerce.ecommerce.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	List<Usuario> findAllByNomeCompletoUsuarioContainingIgnoreCase (String nomeCompletoUsuario);
	List<Usuario> findAllByEmailUsuarioContainingIgnoreCase (String emailUsuario);
	List<Usuario> findAllBySenhaUsuarioContainingIgnoreCase (String senhaUsuario);
	Optional<Usuario> findByNomeCompletoUsuario(String userName);
}
