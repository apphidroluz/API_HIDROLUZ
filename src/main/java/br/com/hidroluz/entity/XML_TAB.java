package br.com.hidroluz.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "XML_TAB")
public class XML_TAB {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idXML_TAB;

	@ManyToOne(fetch = FetchType.EAGER)
	private Concentrador concentrador;

	@Column(name = "data_Hora_leitura", nullable = false)
	private Date Data_Hora_leitura;

	@Column(name = "num_Hidrometro", nullable = false)
	private String Num_Hidrometro;

	@Column(name = "indice_atual", nullable = false)
	private Double Indice_atual;

	@Column(name = "alarmes", nullable = false)
	private String Alarmes;

	@Column(name = "unit", nullable = false)
	private String Unit;

	public XML_TAB() {
		super();
	}

	public Integer getIdXML_TAB() {
		return idXML_TAB;
	}

	public void setIdXML_TAB(Integer idXML_TAB) {
		this.idXML_TAB = idXML_TAB;
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

	public Double getIndice_atual() {
		return Indice_atual;
	}

	public void setIndice_atual(Double indice_atual) {
		Indice_atual = indice_atual;
	}

	public String getAlarmes() {
		return Alarmes;
	}

	public void setAlarmes(String alarmes) {
		Alarmes = alarmes;
	}

	public String getUnit() {
		return Unit;
	}

	public void setUnit(String unit) {
		Unit = unit;
	}

	@Override
	public String toString() {
		return "XML_TAB [idXML_TAB=" + idXML_TAB + ", Data_Hora_leitura=" + Data_Hora_leitura + ", Num_Hidrometro="
				+ Num_Hidrometro + ", Indice_atual=" + Indice_atual + ", Alarmes=" + Alarmes + ", Unit=" + Unit + "]";
	}

}
