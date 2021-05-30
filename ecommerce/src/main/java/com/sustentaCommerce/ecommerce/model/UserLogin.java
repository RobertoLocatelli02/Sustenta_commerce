package com.sustentaCommerce.ecommerce.model;

public class UserLogin {

	private String nome;
	private String usuario;
	private String senha;
	private String token;
	private Boolean usuarioVendedor;
	private Boolean usuarioAdministrador;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Boolean getUsuarioVendedor() {
		return usuarioVendedor;
	}
	public void setUsuarioVendedor(Boolean usuarioVendedor) {
		this.usuarioVendedor = usuarioVendedor;
	}
	public Boolean getUsuarioAdministrador() {
		return usuarioAdministrador;
	}
	public void setUsuarioAdministrador(Boolean usuarioAdministrador) {
		this.usuarioAdministrador = usuarioAdministrador;
	} 
	
}
