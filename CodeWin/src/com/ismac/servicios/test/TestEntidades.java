package com.ismac.servicios.test;

import java.io.IOException;

import com.ismac.controller.LectorController;
import com.ismac.entidades.ManejoSql;
import com.ismac.entidades.Producto;

public class TestEntidades {

	public static void main(String[] args) {
		try {
			LectorController.obtenerPuntosFromCodigo();
		} catch (IOException e) {
			System.out.println("Ocurrio un error");
			e.printStackTrace();
		}

	}

}
