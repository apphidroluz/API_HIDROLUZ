package br.com.hidroluz.api.security.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class JwtAuthenticationDto {
	
	private String login;
	private String senha;

	public JwtAuthenticationDto() {
	}

	@NotEmpty(message = "Login não pode ser vazio.")
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@NotEmpty(message = "Senha não pode ser vazia.")
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "JwtAuthenticationRequestDto [Login=" + login + ", senha=" + senha + "]";
	}

}
