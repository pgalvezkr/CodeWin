package com.ismac.controller;

import java.util.ArrayList;
import java.util.List;

import com.ismac.entidades.Producto;
import com.ismac.entidades.Tarjeta;
import com.ismac.servicios.ProductoService;
import com.ismac.servicios.TarjetaService;

public class ProductoController {

	public static List<Tarjeta> getProducto() {
		List<Tarjeta> productos = new ArrayList<>();
		try {
			Object tarjetas = ProductoService.listar();
		} catch (Exception e) {
			System.out.println("Ocurrió un error al consultar las tarjetas " + e.getMessage());
			e.printStackTrace();
		}
		return productos;
	}

	public static void crearTarjeta(Tarjeta tarjeta) {
		try {
			TarjetaService.crear(tarjeta.getTipoDeTarjeta(), tarjeta.getEstacion(), tarjeta.getValorDeTarjeta());
		} catch (Exception e) {
			System.out.println("Ocurrió un error al guardar las tarjeta " + e.getMessage());
			e.printStackTrace();
		}
	}
}
