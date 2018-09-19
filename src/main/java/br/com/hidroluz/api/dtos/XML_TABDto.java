package br.com.hidroluz.api.dtos;

import java.sql.Date;

public class XML_TABDto {

	private Integer idXML_TAB;
	private String Concentrador;
	private Date Data_Hora_leitura;
	private String Num_Hidrometro;

	public XML_TABDto() {
	}

	public XML_TABDto(Integer idXML_TAB, String concentrador, Date data_Hora_leitura, String num_Hidrometro) {
		super();
		this.idXML_TAB = idXML_TAB;
		Concentrador = concentrador;
		Data_Hora_leitura = data_Hora_leitura;
		Num_Hidrometro = num_Hidrometro;
	}

	@Override
	public String toString() {
		return "XML_TABDto [idXML_TAB=" + idXML_TAB + ", Concentrador=" + Concentrador + ", Data_Hora_leitura="
				+ Data_Hora_leitura + ", Num_Hidrometro=" + Num_Hidrometro + "]";
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

	public Date getData_Hora_leitura() {
		return Data_Hora_leitura;
	}

	public void setData_Hora_leitura(Date data_Hora_leitura) {
		Data_Hora_leitura = data_Hora_leitura;
	}

	public String getNum_Hidrometro() {
		return Num_Hidrometro;
	}

	public void setNum_Hidrometro(String num_Hidrometro) {
		Num_Hidrometro = num_Hidrometro;
	}

}
