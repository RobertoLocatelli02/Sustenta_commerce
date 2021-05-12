package com.sustentaCommerce.ecommerce.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categoria")
public class Categorias {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategoria;
	
	@NotNull
	private String departamentoProduto;
	
	@NotNull
	private String tipoProduto;
	
	@NotNull
	private String materiaPrimaProduto;
	
	@OneToMany(mappedBy = "categoria_produtos_criados", fetch = FetchType.EAGER)
	@JsonIgnoreProperties("categoria_produtos")
	private List<Produtos> categoria_produtos2 = new ArrayList<>();

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDepartamentoProduto() {
		return departamentoProduto;
	}

	public void setDepartamentoProduto(String departamentoProduto) {
		this.departamentoProduto = departamentoProduto;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public String getMateriaPrimaProduto() {
		return materiaPrimaProduto;
	}

	public void setMateriaPrimaProduto(String materiaPrimaProduto) {
		this.materiaPrimaProduto = materiaPrimaProduto;
	}

	public List<Produtos> getCategoria_produtos2() {
		return categoria_produtos2;
	}

	public void setCategoria_produtos2(List<Produtos> categoria_produtos2) {
		this.categoria_produtos2 = categoria_produtos2;
	}
	
}