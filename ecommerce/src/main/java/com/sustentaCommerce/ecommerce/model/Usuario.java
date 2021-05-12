package com.sustentaCommerce.ecommerce.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_usuario", uniqueConstraints=@UniqueConstraint(columnNames={"emailUsuario"}))
public class Usuario {
	
	Usuario() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	
	@NotNull
	@Size(min = 5, max = 100)
	private String nomeCompletoUsuario;
	
	@NotNull
	@Size(min = 5, max = 100)
	private String emailUsuario;
	
	@NotNull
	private String senhaUsuario;
	
	@NotNull
	private String tipoPagamento;
	
	@OneToMany(mappedBy = "usuario_produtos_criados")
	private List<Produtos> usuario_produto = new ArrayList<>();

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeCompletoUsuario() {
		return nomeCompletoUsuario;
	}

	public void setNomeCompletoUsuario(String nomeCompletoUsuario) {
		this.nomeCompletoUsuario = nomeCompletoUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public List<Produtos> getUsuario_produto() {
		return usuario_produto;
	}

	public void setUsuario_produto(List<Produtos> usuario_produto) {
		this.usuario_produto = usuario_produto;
	}
	
}
