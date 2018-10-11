package br.com.hidroluz.api.dtos;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class ConcentradorDataDTO {

	
	private String concentrador;
	@NotEmpty(message = "Insira uma data")
	private String dataDe;
	private String dataAte;
	
	@NotEmpty(message = "Login não pode ficar vazio")
	@Length(min = 3, max = 200, message = "Login deve possuir no mínimo 3 caracteres")
	private String login;
	
	@NotEmpty(message = "Senha não pode ficar vazia")
	@Length(min = 3, max = 200, message = "Senha deve conter no mínimo 3 caracteres")
	private String senha;

	public String getConcentrador() {
		return concentrador;
	}

	public void setConcentrador(String concentrador) {
		this.concentrador = concentrador;
	}

	public String getDataDe() {
		return dataDe;
	}

	public void setDataDe(String dataDe) {
		this.dataDe = dataDe;
	}

	public String getDataAte() {
		return dataAte;
	}

	public void setDataAte(String dataAte) {
		this.dataAte = dataAte;
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
