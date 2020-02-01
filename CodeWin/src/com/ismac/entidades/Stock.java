package com.ismac.entidades;

public class Stock {
	private int IdStock;
	private int IdProducto;
	private int CantidadInicial;
	private int CantidadActual;
	public int getIdStock() {
		return IdStock;
	}
	public void setIdStock(int idStock) {
		IdStock = idStock;
	}
	public int getIdProducto() {
		return IdProducto;
	}
	public void setIdProducto(int idProducto) {
		IdProducto = idProducto;
	}
	public int getCantidadInicial() {
		return CantidadInicial;
	}
	public void setCantidadInicial(int cantidadInicial) {
		CantidadInicial = cantidadInicial;
	}
	public int getCantidadActual() {
		return CantidadActual;
	}
	public void setCantidadActual(int cantidadActual) {
		CantidadActual = cantidadActual;
	}
}
