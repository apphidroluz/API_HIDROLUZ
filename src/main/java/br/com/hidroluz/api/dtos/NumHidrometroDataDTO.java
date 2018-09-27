package br.com.hidroluz.api.dtos;

import javax.validation.constraints.NotEmpty;

public class NumHidrometroDataDTO {

	@NotEmpty(message = "Numero do Hidrometro deve ser preenchido")
	//@Length(min = 15, max = 15, message = "Numero do hidrometro deve possuir X caracteres")
	private String numHidrometro;
	@NotEmpty(message = "Insira uma data")
	private String dataDe;
	private String dataAte;

	public NumHidrometroDataDTO(String numHidrometro, String dataDe, String dataAte) {
		super();
		this.numHidrometro = numHidrometro;
		this.dataDe = dataDe;
		this.dataAte = dataAte;
	}
	
	public NumHidrometroDataDTO() {
	}

	public String getNumHidrometro() {
		return numHidrometro;
	}

	public void setNumHidrometro(String numHidrometro) {
		this.numHidrometro = numHidrometro;
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

}
