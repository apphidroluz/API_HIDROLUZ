package br.com.hidroluz.api.dtos;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class JwtAuthenticationDto {
	
	@NotEmpty(message = "Login não pode ficar vazio")
	@Length(min = 3, max = 200, message = "Login deve possuir no mínimo 3 caracteres")
	private String login;
	
	@NotEmpty(message = "Senha não pode ficar vazia")
	@Length(min = 3, max = 200, message = "Senha deve conter no mínimo 3 caracteres")
	private String senha;

	public JwtAuthenticationDto() {
	}

	public JwtAuthenticationDto(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "ClienteDTO [login=" + login + ", Senha=" + senha + "]";
	}

	
	public String getLogin() {
		return login;
	}

	
	public void setLogin(String login) {
		this.login = login;
	}

	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
