package br.com.hidroluz.api.dtos;

import javax.validation.constraints.NotEmpty;

public class ConcentradorDataDTO {

	@NotEmpty(message = "Numero do Concentrador deve ser preenchido")
	//@Length(min = 15, max = 15, message = "Numero do concentrador deve possuir X caracteres")
	private String concentrador;
	@NotEmpty(message = "Insira uma data")
	private String dataDe;
	private String dataAte;

	public ConcentradorDataDTO(String concentrador, String dataDe, String dataAte) {
		super();
		this.concentrador = concentrador;
		this.dataDe = dataDe;
		this.dataAte = dataAte;
	}

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

}
