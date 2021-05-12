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
import com.sustentaCommerce.ecommerce.model.Categorias;
import com.sustentaCommerce.ecommerce.repository.CategoriaRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repositoryC;
	
	@GetMapping
	ResponseEntity<List<Categorias>> findAllCategoria() {
		return ResponseEntity.ok(repositoryC.findAll());
	}
	
	@GetMapping("/id/{idCategoria}")
	ResponseEntity<Categorias> findByIdCategoria(@PathVariable Long idCategoria) {
		return repositoryC.findById(idCategoria).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/departamento/{departamentoProduto}")
	ResponseEntity<List<Categorias>> findByDepartamentoCategoria(@PathVariable String departamentoProduto) {
		return ResponseEntity.ok(repositoryC.findAllByDepartamentoProdutoContainingIgnoreCase(departamentoProduto));
	}
	
	@GetMapping("/tipoProduto/{tipoProduto}")
	ResponseEntity<List<Categorias>> findByTipoProdutoCategoria(@PathVariable String tipoProduto) {
		return ResponseEntity.ok(repositoryC.findAllByTipoProdutoContainingIgnoreCase(tipoProduto));
	}
	
	@GetMapping("/materiaPrima/{materiaPrimaProduto}")
	ResponseEntity<List<Categorias>> findByMateriaPrimaCategoria(@PathVariable String materiaPrimaProduto) {
		return ResponseEntity.ok(repositoryC.findAllByMateriaPrimaProdutoContainingIgnoreCase(materiaPrimaProduto));
	}
	
	@PostMapping
	ResponseEntity<Categorias> postCategoria(@RequestBody Categorias categoriaoNovo) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoryC.save(categoriaoNovo));
	}
	
	@PutMapping
	ResponseEntity<Categorias> putCategoria(@Valid @RequestBody Categorias categoriaAtualizada) {
		
		Optional<Categorias> categoriaExistente = repositoryC.findById(categoriaAtualizada.getIdCategoria());
		
		if (categoriaExistente.isPresent()) {
			categoriaExistente.get().setDepartamentoProduto(categoriaAtualizada.getDepartamentoProduto());
			categoriaExistente.get().setMateriaPrimaProduto(categoriaAtualizada.getMateriaPrimaProduto());
			categoriaExistente.get().setTipoProduto(categoriaAtualizada.getTipoProduto());
			return ResponseEntity.status(HttpStatus.CREATED).body(repositoryC.save(categoriaExistente.get()));
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@DeleteMapping("/id/{idCategoria}")
	void deleteCategoria(@PathVariable Long idCategoria) {
		repositoryC.deleteById(idCategoria);
	}
}
