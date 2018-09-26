package br.com.hidroluz.api.dtos;

import javax.validation.constraints.NotEmpty;

public class NumHidrometroDTO {
	
	@NotEmpty(message = "Numero do Hidrometro deve ser preenchido")
	//@Length(min = 15, max = 15, message = "Numero do hidrometro deve possuir X caracteres")
	private String numHidrometro;

	public NumHidrometroDTO(String numHidrometro) {
		super();
		this.numHidrometro = numHidrometro;
	}

	public String getNumHidrometro() {
		return numHidrometro;
	}

	public void setNumHidrometro(String numHidrometro) {
		this.numHidrometro = numHidrometro;
	}
	
	

}
