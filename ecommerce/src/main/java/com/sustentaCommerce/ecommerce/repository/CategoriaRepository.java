package com.sustentaCommerce.ecommerce.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sustentaCommerce.ecommerce.model.Categorias;

@Repository
public interface CategoriaRepository extends JpaRepository<Categorias, Long>  {
	
public List<Categorias> findAllByDepartamentoProdutoContainingIgnoreCase (String depatarmentoProduto);
public List<Categorias> findAllByTipoProdutoContainingIgnoreCase (String tipoProduto);
public List<Categorias> findAllByMateriaPrimaProdutoContainingIgnoreCase (String materiaPrimaProduto);
}
