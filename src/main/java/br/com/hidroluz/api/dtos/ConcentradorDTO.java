package br.com.hidroluz.api.dtos;

import javax.validation.constraints.NotEmpty;

import br.com.hidroluz.api.security.entity.Concentrador;

public class ConcentradorDTO {
	
	@NotEmpty(message = "Numero do Concentrador deve ser preenchido")
	//@Length(min = 15, max = 15, message = "Numero do concentrador deve possuir X caracteres")
	private Concentrador concentrador;
	
	public ConcentradorDTO() {
	}

	public ConcentradorDTO(Concentrador concentrador) {
		this.concentrador = concentrador;
	}

	public Concentrador getConcentrador() {
		return concentrador;
	}

	public void setConcentrador(Concentrador concentrador) {
		this.concentrador = concentrador;
	}
	
	

}
