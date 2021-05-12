package com.sustentaCommerce.ecommerce.model;

public class UserLogin {

	private String nome;
	private String ussuario;
	private String senha;
	private String token;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUssuario() {
		return ussuario;
	}
	public void setUssuario(String ussuario) {
		this.ussuario = ussuario;
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
}
