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
import com.sustentaCommerce.ecommerce.model.Produtos;
import com.sustentaCommerce.ecommerce.repository.ProdutosRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutosRepository repositoryP;

	@GetMapping // retorna todos Produtos
	ResponseEntity<List<Produtos>> findAllProduto() { // end point
		return ResponseEntity.ok(repositoryP.findAll());
	}

	@GetMapping("/id/{idProduto}") // retorna um produto por id
	ResponseEntity<Produtos> findByIdProduto(@PathVariable Long idProduto) { // end point
		return repositoryP.findById(idProduto).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/precoUnitario/{precoUnitarioProduto}") // retorna todos os produtos por um preço unitario
	ResponseEntity<List<Produtos>> findByprecoUnitarioProdutos(@PathVariable Float precoUnitarioProduto) { // end point
		return ResponseEntity.ok(repositoryP.findAllByPrecoUnitarioProduto(precoUnitarioProduto));
	}

	@PostMapping // criar um novo produto
	ResponseEntity<Produtos> postProduto(@Valid @RequestBody Produtos produtoNovo) { // end point
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoryP.save(produtoNovo));
	}

	@PutMapping // atualizar informações de um produto
	ResponseEntity<Produtos> putProduto(@Valid @RequestBody Produtos produtoAtualizado) { // end point
		Optional<Produtos> produtoExistente = repositoryP.findById(produtoAtualizado.getIdProduto());
		if (produtoExistente.isPresent()) {
			produtoExistente.get().setNomeProduto(produtoAtualizado.getNomeProduto());
			produtoExistente.get().setDescricaoProduto(produtoAtualizado.getDescricaoProduto());
			produtoExistente.get().setPrecoUnitarioProduto(produtoAtualizado.getPrecoUnitarioProduto());
			produtoExistente.get().setQuantidadeProduto(produtoAtualizado.getQuantidadeProduto());
			return ResponseEntity.status(HttpStatus.CREATED).body(repositoryP.save(produtoExistente.get()));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/id/{idProduto}") // deletar um produto criado
	void deleteProduto(@PathVariable Long idProduto) { // end point
		repositoryP.deleteById(idProduto);
	}
}
