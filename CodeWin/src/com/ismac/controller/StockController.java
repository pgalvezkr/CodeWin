package com.ismac.controller;

import com.ismac.servicios.StockService;

public class StockController {

	public static void descontarProductos(int idProducto, int cantidad) {
		int cantidadActual = 0;
		try {
			cantidadActual = StockService.obtenerCantidadActual(idProducto);
			if (cantidadActual >= cantidad) {
				StockService.disminuirStock(idProducto, cantidadActual);
			} else {
				System.out.println("No existe disponibilidad del producto");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}