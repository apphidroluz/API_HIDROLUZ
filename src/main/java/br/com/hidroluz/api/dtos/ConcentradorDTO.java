package br.com.hidroluz.api.dtos;

import javax.validation.constraints.NotEmpty;

public class ConcentradorDTO {
	
	@NotEmpty(message = "Numero do Concentrador deve ser preenchido")
	//@Length(min = 15, max = 15, message = "Numero do concentrador deve possuir X caracteres")
	private String concentrador;

	public ConcentradorDTO(String concentrador) {
		super();
		this.concentrador = concentrador;
	}

	public String getConcentrador() {
		return concentrador;
	}

	public void setConcentrador(String concentrador) {
		this.concentrador = concentrador;
	}
	
	

}
