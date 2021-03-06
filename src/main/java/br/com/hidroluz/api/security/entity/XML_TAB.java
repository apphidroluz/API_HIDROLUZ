package br.com.hidroluz.api.security.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "XML_TAB")
public class XML_TAB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idXML_TAB;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_Hora_leitura", nullable = false)
	private Date data;

	@Column(name = "num_Hidrometro", nullable = false)
	private String numHidrometro;

	@Column(name = "indice_atual", nullable = false)
	private Double indice_atual;

	@Column(name = "alarmes", nullable = false)
	private String alarmes;

	@Column(name = "unit", nullable = false)
	private String unit;
	
	@Column(name = "concentrador", nullable = false)
	private String concentrador;

	public XML_TAB() {
	}
	
	

	public XML_TAB(Integer idXML_TAB, Date data, String numHidrometro, Double indice_atual, String alarmes, String unit,
			String concentrador) {
		super();
		this.idXML_TAB = idXML_TAB;
		this.data = data;
		this.numHidrometro = numHidrometro;
		this.indice_atual = indice_atual;
		this.alarmes = alarmes;
		this.unit = unit;
		this.concentrador = concentrador;
	}



	@Override
	public String toString() {
		return "XML_TAB [idXML_TAB=" + idXML_TAB + ", data=" + data + ", numHidrometro=" + numHidrometro
				+ ", indice_atual=" + indice_atual + ", alarmes=" + alarmes + ", unit=" + unit + ", concentrador="
				+ concentrador + "]";
	}



	public Integer getIdXML_TAB() {
		return idXML_TAB;
	}

	public void setIdXML_TAB(Integer idXML_TAB) {
		this.idXML_TAB = idXML_TAB;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
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

	public String getConcentrador() {
		return concentrador;
	}

	public void setConcentrador(String concentrador) {
		this.concentrador = concentrador;
	}



	public XML_TAB(String concentrador,Date data) {
		super();
		this.data = data;
		this.concentrador = concentrador;
	}
	
	


}
