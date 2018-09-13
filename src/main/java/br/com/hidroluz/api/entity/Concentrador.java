package br.com.hidroluz.api.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "concentrador")
public class Concentrador {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id_Concentrador;

	@Column(name = "concentrador", nullable = false)
	private String Concentrador;

	@ManyToOne(fetch = FetchType.EAGER)
	private Cliente cliente;

	@OneToMany(mappedBy = "concentrador", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<XML_TAB> xml_TABs;

	public Concentrador() {
		super();
	}

	public Integer getId_Concentrador() {
		return Id_Concentrador;
	}

	public void setId_Concentrador(Integer id_Concentrador) {
		Id_Concentrador = id_Concentrador;
	}

	public String getConcentrador() {
		return Concentrador;
	}

	public void setConcentrador(String concentrador) {
		Concentrador = concentrador;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<XML_TAB> getXml_TABs() {
		return xml_TABs;
	}

	public void setXml_TABs(List<XML_TAB> xml_TABs) {
		this.xml_TABs = xml_TABs;
	}

	@Override
	public String toString() {
		return "Concentrador [Id_Concentrador=" + Id_Concentrador + ", Concentrador=" + Concentrador + ", cliente="
				+ cliente + "]";
	}


}
