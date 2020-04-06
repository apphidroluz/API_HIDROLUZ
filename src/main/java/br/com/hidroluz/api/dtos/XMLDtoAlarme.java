package br.com.hidroluz.api.dtos;

import javax.validation.constraints.NotEmpty;

public class XMLDtoAlarme {
	
	@NotEmpty(message = "Insira uma data")
	private String dataDe;
	private String dataAte;
	
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

	public XMLDtoAlarme(@NotEmpty(message = "Insira uma data") String dataDe, String dataAte) {
		super();
		this.dataDe = dataDe;
		this.dataAte = dataAte;
	}
	
	

}
