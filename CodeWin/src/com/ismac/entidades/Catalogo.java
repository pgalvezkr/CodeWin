package com.ismac.entidades;

public class Catalogo {
	private int Idcatalogo;
	private int nombre;
	private int tipo;

	public int getIdcatalogo() {
		return Idcatalogo;
	}

	public void setIdcatalogo(int idcatalogo) {
		Idcatalogo = idcatalogo;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

}