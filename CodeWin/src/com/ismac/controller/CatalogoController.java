package com.ismac.controller;

import java.util.ArrayList;
import java.util.List;

import com.ismac.entidades.Catalogo;
import com.ismac.entidades.Producto;
import com.ismac.servicios.CatalogoService;
import com.ismac.servicios.ProductoService;

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
	

	public static void obtenerNombre(Catalogo Catalogo) {
		try {
			CatalogoService.obtenerNombre(Catalogo.getNombre());
		} catch (Exception e) {
			System.out.println("Ocurrió un error al odtener nombre " + e.getMessage());
			e.printStackTrace();
		}
	
}	
}	
