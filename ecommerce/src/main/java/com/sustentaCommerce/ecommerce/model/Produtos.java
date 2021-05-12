package com.sustentaCommerce.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produto")
public class Produtos {
	
	Produtos() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduto;
	
	@NotNull
	private String nomeProduto;
	
	@NotNull
	private String descricaoProduto;
	
	@NotNull
	private Float precoUnitarioProduto;
	
	@NotNull
	private Integer quantidadeProduto;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoria_produtos")
	@JsonIgnoreProperties({"categoria_produtos","idCategoria"})
	private Categorias categoria_produtos_criados;

	@ManyToOne
	@JoinColumn(name = "usuario_produto")
	private Usuario usuario_produtos_criados;

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public Float getPrecoUnitarioProduto() {
		return precoUnitarioProduto;
	}

	public void setPrecoUnitarioProduto(Float precoUnitarioProduto) {
		this.precoUnitarioProduto = precoUnitarioProduto;
	}

	public Integer getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public Categorias getCategoria_produtos_criados() {
		return categoria_produtos_criados;
	}

	public void setCategoria_produtos_criados(Categorias categoria_produtos_criados) {
		this.categoria_produtos_criados = categoria_produtos_criados;
	}
	
	public Usuario getUsuario_produtos_criados() {
		return usuario_produtos_criados;
	}

	public void setUsuario_produtos_criados(Usuario usuario_produtos_criados) {
		this.usuario_produtos_criados = usuario_produtos_criados;
	}
}