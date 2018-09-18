package br.com.hidroluz.api.dtos;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.hidroluz.api.security.enums.PerfilEnum;

public class ClienteDTO {

	private Integer id_Cliente;
	
	@NotEmpty(message = "Login não pode ficar vazio")
	@Length(min = 3, max = 200, message = "Login deve possuir no mínimo 3 caracteres")
	private String login;
	
	@NotEmpty(message = "Senha não pode ficar vazia")
	@Length(min = 3, max = 200, message = "Senha deve conter no mínimo 3 caracteres")
	private String senha;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "perfil", nullable = false)
	private PerfilEnum perfil;
	
	public ClienteDTO() {
	}
	
	public ClienteDTO(Integer id_Cliente, String login, String senha, PerfilEnum perfil) {
		this.id_Cliente = id_Cliente;
		this.login = login;
		this.senha = senha;
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "ClienteDTO [Id_Cliente=" + id_Cliente + ", login=" + login + ", Senha=" + senha + "]";
	}

	public PerfilEnum getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
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
