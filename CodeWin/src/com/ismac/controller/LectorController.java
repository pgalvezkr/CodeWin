package com.ismac.controller;

import java.awt.Image;

import java.util.ArrayList;
import java.util.List;

import com.ismac.entidades.Tarjeta;
import com.ismac.servicios.TarjetaService;

public class LectorController {

	public static List<Tarjeta> getTarjetas() {
		List<Tarjeta> tarjetas = new ArrayList<>();
		try {
			tarjetas = TarjetaService.listar();
		} catch (Exception e) {
			System.out.println("Ocurrió un error al consultar las tarjetas " + e.getMessage());
			e.printStackTrace();
		}
		return tarjetas;
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