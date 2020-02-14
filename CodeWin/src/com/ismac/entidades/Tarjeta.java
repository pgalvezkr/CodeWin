package com.ismac.entidades;

public class Tarjeta {
	private int idTarjeta;
	private String tipoDeTarjeta;
	private String estacion;
	private int puntos;

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getIdTarjeta() {
		return idTarjeta;
	}

	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public String getTipoDeTarjeta() {
		return tipoDeTarjeta;
	}

	public void setTipoDeTarjeta(String tipoDeTarjeta) {
		this.tipoDeTarjeta = tipoDeTarjeta;
	}

	public String getEstacion() {
		return estacion;
	}

	public void setEstacion(String estacion) {
		this.estacion = estacion;
	}

	public int getValorDeTarjeta() {
		return valorDeTarjeta;
	}

	public void setValorDeTarjeta(int valorDeTarjeta) {
		this.valorDeTarjeta = valorDeTarjeta;
	}

	private int valorDeTarjeta;

}
