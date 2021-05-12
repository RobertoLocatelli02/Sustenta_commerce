package com.sustentaCommerce.ecommerce.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sustentaCommerce.ecommerce.model.Produtos;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Long>{

	List<Produtos> findAllByNomeProdutoContainingIgnoreCase (String nomeProduto);
	List<Produtos> findAllByDescricaoProdutoContainingIgnoreCase (String descricaoProduto);
	List<Produtos> findAllByPrecoUnitarioProduto (Float precoUnitarioProduto);
}
