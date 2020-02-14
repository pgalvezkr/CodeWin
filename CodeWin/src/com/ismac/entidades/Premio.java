package com.ismac.entidades;

public class Premio {

	private int idPremio;
	private int idProducto;
	private int rangoInicial;
	private int rangoFinal;

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getIdPremio() {
		return idPremio;
	}

	public void setIdPremio(int idPremio) {
		this.idPremio = idPremio;
	}

	public int getRangoInicial() {
		return rangoInicial;
	}

	public void setRangoInicial(int rangoInicial) {
		this.rangoInicial = rangoInicial;
	}

	public int getRangoFinal() {
		return rangoFinal;
	}

	public void setRangoFinal(int rangoFinal) {
		this.rangoFinal = rangoFinal;
	}

}
