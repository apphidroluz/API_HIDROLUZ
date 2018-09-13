package br.com.hidroluz.api.dtos;

public class ClienteDTO {

	private Integer Id_Cliente;
	private String login;
	private String Senha;

	public ClienteDTO() {

	}


	@Override
	public String toString() {
		return "ClienteDTO [Id_Cliente=" + Id_Cliente + ", login=" + login + ", Senha=" + Senha + "]";
	}

	public Integer getId_Cliente() {
		return Id_Cliente;
	}

	public void setId_Cliente(Integer id_Cliente) {
		Id_Cliente = id_Cliente;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}

}
