package com.ismac.controller;

import java.util.ArrayList;
import java.util.List;

import com.ismac.entidades.Producto;
import com.ismac.servicios.ProductoService;

public class ProductoController {

	public static void crearProducto(Producto producto) {
		try {
			ProductoService.crear(producto.getNombre(), producto.getPrecio());
		} catch (Exception e) {
			System.out.println("Ocurrió un error al guardar las producto " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static List<Producto> getProducto() {
		List<Producto> productos = new ArrayList<>();
		try {
			productos = ProductoService.listar();
		} catch (Exception e) {
			System.out.println("Ocurrió un error al consultar las productos " + e.getMessage());
			e.printStackTrace();
		}
		return productos;
	}

	public static void actualizarProducto(int id, Producto producto) {
		try {
			ProductoService.actualizar(id, producto.getNombre(), producto.getPrecio());
		} catch (Exception e) {
			System.out.println("Ocurrió un error al actualizar el producto " + e.getMessage());
			e.printStackTrace();
		}

	}

	public static void eliminarProducto(int id) {
		try {
			ProductoService.eliminar(id);
		} catch (Exception e) {
			System.out.println("Ocurrió un error al eliminar el producto " + e.getMessage());
			e.printStackTrace();
		}
	}

}
