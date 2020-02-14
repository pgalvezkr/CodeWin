package com.ismac.controller;

import com.ismac.entidades.Premio;
import com.ismac.servicios.PremioService;

public class PremioController {

	public static void crearPremio(Premio premio) {
		try {
			PremioService.crear(premio.getIdProducto(), premio.getRangoInicial(), premio.getRangoFinal());
		} catch (Exception e) {
			System.out.println("Ocurrio un error al crear el premio");
			e.printStackTrace();
		}
	}
}
