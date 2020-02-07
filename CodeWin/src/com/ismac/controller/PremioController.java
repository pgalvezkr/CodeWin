package com.ismac.controller;

import java.util.ArrayList;
import java.util.List;

import com.ismac.entidades.Premio;
import com.ismac.servicios.PremioService;

public class PremioController {

	public static List<Premio> getPremio() {
		List<Premio> tarjetas = new ArrayList<>();
		try {
			tarjetas = PremioService.listar();
		} catch (Exception e) {
			System.out.println("Ocurrió un error al consultar las tarjetas " + e.getMessage());
			e.printStackTrace();
		}
		return tarjetas;
	}

	public static void crearTarjeta(Premio tarjeta) {
		try {
			PremioService.crear(tarjeta.getTipoDeTarjeta(), tarjeta.getEstacion(), tarjeta.getValorDeTarjeta());
		} catch (Exception e) {
			System.out.println("Ocurrió un error al guardar las tarjeta " + e.getMessage());
			e.printStackTrace();
		}
	}
}
