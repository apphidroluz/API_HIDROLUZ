package br.com.hidroluz.api.dtos;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class XML_TABDto {

	private Integer idXML_TAB;
	private String Concentrador;
	private LocalDateTime data;
	private String Hidrometro;

	public XML_TABDto() {
	}

	
	public Integer getIdXML_TAB() {
		return idXML_TAB;
	}

	public void setIdXML_TAB(Integer idXML_TAB) {
		this.idXML_TAB = idXML_TAB;
	}

	public String getConcentrador() {
		return Concentrador;
	}

	public void setConcentrador(String concentrador) {
		Concentrador = concentrador;
	}



	public XML_TABDto(Integer idXML_TAB, @Length(min = 3, max = 200) String concentrador, LocalDateTime data,
			@Length(min = 3, max = 200) @NotEmpty(message = "Hidrometro não pode ser vazio.") String hidrometro) {
		super();
		this.idXML_TAB = idXML_TAB;
		Concentrador = concentrador;
		this.data = data;
		Hidrometro = hidrometro;
	}


	public LocalDateTime getData() {
		return data;
	}


	public void setData(LocalDateTime data) {
		this.data = data;
	}


	public String getHidrometro() {
		return Hidrometro;
	}

	public void setHidrometro(String hidrometro) {
		Hidrometro = hidrometro;
	}

}
