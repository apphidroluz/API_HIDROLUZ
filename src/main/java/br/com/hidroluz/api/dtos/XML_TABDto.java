package br.com.hidroluz.api.dtos;

import java.util.Optional;


public class XML_TABDto {

	private Optional<Integer> id = Optional.empty();
	private Integer idXML_TAB;
	private String Concentrador;
	private String data;
	
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

	public String getHidrometro() {
		return Hidrometro;
	}


	public void setHidrometro(String hidrometro) {
		Hidrometro = hidrometro;
	}


	public Optional<Integer> getId() {
		return id;
	}


	public void setId(Optional<Integer> id) {
		this.id = id;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public XML_TABDto(Optional<Integer> id, Integer idXML_TAB, String concentrador, String data, String hidrometro) {
		super();
		this.id = id;
		this.idXML_TAB = idXML_TAB;
		Concentrador = concentrador;
		this.data = data;
		Hidrometro = hidrometro;
	}
	
	
	

}
