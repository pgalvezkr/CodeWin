package com.ismac.servicios.test;

import com.ismac.entidades.ManejoSql;
import com.ismac.entidades.Producto;

public class TestEntidades {

	public static void main(String[] args) {
			Producto producto = new Producto();
			ManejoSql conexion = new ManejoSql();
			producto.setNombre("Peras");
			producto.setPrecio(10);
			String insertSql = "INSERT INTO Products1 (Nombre, Precio) VALUES "
			        + "('"+producto.getNombre()+"',"+ producto.getPrecio()+");";
			conexion.insertSql(insertSql);
			

	}

}
