package com.ismac.entidades;

public class PuntoTarjetaProducto {
	private int id;
	private int idTarjeta;
	private int idProducto;
	private int puntosInicio;
	private int puntosFin;
	public int getIdTarjeta() {
		return idTarjeta;
	}
	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getPuntosInicio() {
		return puntosInicio;
	}
	public void setPuntosInicio(int puntosInicio) {
		this.puntosInicio = puntosInicio;
	}
	public int getPuntosFin() {
		return puntosFin;
	}
	public void setPuntosFin(int puntosFin) {
		this.puntosFin = puntosFin;
	}
	
}
