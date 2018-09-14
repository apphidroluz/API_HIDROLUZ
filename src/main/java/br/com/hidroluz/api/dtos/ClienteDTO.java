package br.com.hidroluz.api.dtos;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class ClienteDTO {

	private Integer id_Cliente;
	private String login;
	private String senha;

	public ClienteDTO() {

	}

	@Override
	public String toString() {
		return "ClienteDTO [Id_Cliente=" + id_Cliente + ", login=" + login + ", Senha=" + senha + "]";
	}

	public Integer getId_Cliente() {
		return id_Cliente;
	}

	public void setId_Cliente(Integer id_Cliente) {
		this.id_Cliente = id_Cliente;
	}

	@NotEmpty(message = "Login não pode ficar vazio")
	@Length(min = 3, max = 200, message = "Login deve possuir no mínimo 3 caracteres")
	public String getLogin() {
		return login;
	}

	
	public void setLogin(String login) {
		this.login = login;
	}

	@NotEmpty(message = "Senha não pode ficar vazia")
	@Length(min = 3, max = 200, message = "Senha deve conter no mínimo 4 caracteres")
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
