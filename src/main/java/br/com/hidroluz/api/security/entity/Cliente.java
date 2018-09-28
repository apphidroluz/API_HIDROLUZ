package br.com.hidroluz.api.security.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.hidroluz.api.security.enums.PerfilEnum;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 7736833236207254524L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id_Cliente;

	@Column(name = "login", nullable = false , unique = true)
	private String login;

	@Column(name = "senha", nullable = false)
	private String senha;

	@Enumerated(EnumType.STRING)
	@Column(name = "perfil", nullable = false)
	private PerfilEnum perfil;

	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Concentrador> concentradores;

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
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Concentrador> getConcentradores() {
		return concentradores;
	}

	public void setConcentradores(List<Concentrador> concentradores) {
		this.concentradores = concentradores;
	}

	public PerfilEnum getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
	}

	public Cliente(Integer id_Cliente, String login, String senha, PerfilEnum perfil) {
		super();
		Id_Cliente = id_Cliente;
		this.login = login;
		this.senha = senha;
		this.perfil = perfil;
	}

	public Cliente() {
		super();
	}

	@Override
	public String toString() {
		return "Cliente [Id_Cliente=" + Id_Cliente + ", Login=" + login + ", Senha=" + senha + "]";
	}

}
