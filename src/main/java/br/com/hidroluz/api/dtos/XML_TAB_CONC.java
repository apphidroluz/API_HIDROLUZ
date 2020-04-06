package br.com.hidroluz.api.dtos;

public class XML_TAB_CONC {
	
	private String concentrador;
	private String data;
	
	
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
	public XML_TAB_CONC(String concentrador, String data) {
		super();
		this.concentrador = concentrador;
		this.data = data;
	}
	public XML_TAB_CONC() {
		super();
	}
	
	
	
	

}
