package br.com.hidroluz.api.dtos;

import java.io.Serializable;

public class XML_TAB_RET implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idXML_TAB;
	private String concentrador;
	private String data;
	private String numHidrometro;
	private Double indice_atual;
	private String alarmes;
	private String unit;

	public Integer getIdXML_TAB() {
		return idXML_TAB;
	}

	public void setIdXML_TAB(Integer idXML_TAB) {
		this.idXML_TAB = idXML_TAB;
	}

	public String getConcentrador() {
		return concentrador;
	}

	public void setConcentrador(String concentrador) {
		this.concentrador = concentrador;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getNumHidrometro() {
		return numHidrometro;
	}

	public void setNumHidrometro(String numHidrometro) {
		this.numHidrometro = numHidrometro;
	}

	public Double getIndice_atual() {
		return indice_atual;
	}

	public void setIndice_atual(Double indice_atual) {
		this.indice_atual = indice_atual;
	}

	public String getAlarmes() {
		return alarmes;
	}

	public void setAlarmes(String alarmes) {
		this.alarmes = alarmes;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
