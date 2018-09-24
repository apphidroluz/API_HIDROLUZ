package br.com.hidroluz.api.dtos;

import java.util.Optional;

public class XML_TABDto {

	private Optional<Integer> id = Optional.empty();
	private Integer idXML_TAB;
	private String Concentrador;
	private String dataDe;
	private String dataAte;

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

	public XML_TABDto(Optional<Integer> id, Integer idXML_TAB, String concentrador, String hidrometro, 
			String dataDe, String dataAte) {
		super();
		this.id = id;
		this.idXML_TAB = idXML_TAB;
		Concentrador = concentrador;
		this.dataDe = dataDe;
		this.dataAte = dataAte;
		Hidrometro = hidrometro;
	}

}
