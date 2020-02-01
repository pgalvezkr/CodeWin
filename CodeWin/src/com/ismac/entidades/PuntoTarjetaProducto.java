package com.ismac.entidades;

public class PuntoTarjetaProducto {
	private int Id;
	private int IdTarjeta;
	private int IdProducto;
	private int PuntosInicio;
	private int PuntosFin;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getIdTarjeta() {
		return IdTarjeta;
	}
	public void setIdTarjeta(int idTarjeta) {
		IdTarjeta = idTarjeta;
	}
	public int getIdProducto() {
		return IdProducto;
	}
	public void setIdProducto(int idProducto) {
		IdProducto = idProducto;
	}
	public int getPuntosInicio() {
		return PuntosInicio;
	}
	public void setPuntosInicio(int puntosInicio) {
		PuntosInicio = puntosInicio;
	}
	public int getPuntosFin() {
		return PuntosFin;
	}
	public void setPuntosFin(int puntosFin) {
		PuntosFin = puntosFin;
	}
	
}
