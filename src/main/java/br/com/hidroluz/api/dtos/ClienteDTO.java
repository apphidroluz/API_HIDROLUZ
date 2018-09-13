package br.com.hidroluz.api.dtos;

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
