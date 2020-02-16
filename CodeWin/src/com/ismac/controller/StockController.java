package com.ismac.controller;

import com.ismac.servicios.StockService;

public class StockController {

	public static void descontarProductos(int idProducto, int cantidad) {
		int cantidadActual = 0;
		try {
			cantidadActual = StockService.obtenerCantidadActual(idProducto);
			if (cantidadActual >= cantidad) {
				StockService.disminuirStock(idProducto, cantidad);
			} else {
				System.out.println("No existe disponibilidad del producto");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static int getCantidadActual(int idProducto) {
		int cantidadActual = 0;
		try {
			cantidadActual = StockService.obtenerCantidadActual(idProducto);
		} catch (Exception e) {
			System.out.println("Ocurrio un error al momento de consultar la cantidad actual del producto");
			e.printStackTrace();
		}
		return cantidadActual;
	}
}