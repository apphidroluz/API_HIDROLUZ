package br.com.hidroluz.api.security.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "concentrador")
public class Concentrador implements Serializable{

	private static final long serialVersionUID = 7716108130834719629L;

	@Id
	@Column(name = "concentrador", nullable = false, unique = true)
	private String numConcentrador;

	@OneToMany(mappedBy = "concentrador", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<XML_TAB> xmls;

	@ManyToOne(fetch = FetchType.EAGER)
	private Cliente cliente;

	public Concentrador() {
		super();
	}

	public Concentrador(String concentrador, List<XML_TAB> xmls, Cliente cliente) {
		super();
		numConcentrador = concentrador;
		this.xmls = xmls;
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Concentrador [Concentrador=" + numConcentrador + ", xmls=" + xmls + ", cliente=" + cliente + "]";
	}

	public String getNumConcentrador() {
		return numConcentrador;
	}

	public void setNumConcentrador(String concentrador) {
		numConcentrador = concentrador;
	}

	public List<XML_TAB> getXmls() {
		return xmls;
	}

	public void setXmls(List<XML_TAB> xmls) {
		this.xmls = xmls;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
