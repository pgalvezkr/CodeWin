package com.ismac.controller;

import java.util.ArrayList;
import java.util.List;

import com.ismac.entidades.Stock;
import com.ismac.servicios.StockService;

public class StockController {

	public static List<Stock> getStock() {
		List<Stock> stock = new ArrayList<>();
		try {
			stock = StockService.listar();
		} catch (Exception e) {
			System.out.println("Ocurrió un error al consultar las tarjetas " + e.getMessage());
			e.printStackTrace();
		}
		return stock;
	}

	public static void stock(Stock stock) {
		try {
			Service.crear(tarjeta.getTipoDeTarjeta(), tarjeta.getEstacion(), tarjeta.getValorDeTarjeta());
		} catch (Exception e) {
			System.out.println("Ocurrió un error al guardar las tarjeta " + e.getMessage());
			e.printStackTrace();
		}
	}
}