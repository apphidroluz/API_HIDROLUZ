package br.com.hidroluz.api.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
	

	private static final long serialVersionUID = 7736833236207254524L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer Id_Cliente;
	
	@Column(name = "login", nullable = false)
	private String login;
	
	@Column(name = "senha", nullable = false)
	private String Senha;
	
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
		return Senha;
	}
	
	public void setSenha(String senha) {
		Senha = senha;
	}
	
	public List<Concentrador> getConcentradores() {
		return concentradores;
	}

	public void setConcentradores(List<Concentrador> concentradores) {
		this.concentradores = concentradores;
	}

	
	
		
	public Cliente(Integer id_Cliente, String login, String senha) {
		super();
		Id_Cliente = id_Cliente;
		this.login = login;
		Senha = senha;
	}

	public Cliente() {
		super();
	}

	@Override
	public String toString() {
		return "Cliente [Id_Cliente=" + Id_Cliente + ", Login=" + login + ", Senha=" + Senha + "]";
	}

	
	
}
