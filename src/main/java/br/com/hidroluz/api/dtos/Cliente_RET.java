package br.com.hidroluz.api.dtos;

public class Cliente_RET {
	
	private String concentradores;

	public String getConcentradores() {
		return concentradores;
	}

	public void setConcentradores(String concentradores) {
		this.concentradores = concentradores;
	}

	@Override
	public String toString() {
		return "Cliente_RET [concentradores=" + concentradores + "]";
	}

	public Cliente_RET(String concentradores) {
		super();
		this.concentradores = concentradores;
	}

	public Cliente_RET() {
		super();
	}



	
	

}
