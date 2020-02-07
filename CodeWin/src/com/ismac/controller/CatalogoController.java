package com.ismac.controller;

import java.util.ArrayList;
import java.util.List;

import com.ismac.entidades.Catalogo;
import com.ismac.servicios.CatalogoService;

public class CatalogoController {

	public List<Catalogo> getCatalogos() {
		List<Catalogo> catalogos = new ArrayList<Catalogo>();
		try {
			catalogos = CatalogoService.listar();
		} catch (Exception e) {
			System.out.println("Ocurrió un error al consultar el catalogo " + e.getMessage());
			e.printStackTrace();
		}
		return catalogos;
	}
}
