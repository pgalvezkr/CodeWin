package com.ismac.servicios.test;

import java.io.IOException;
import java.util.Scanner;

import com.ismac.controller.LectorController;

public class TestLectorController {

	public static void main(String[] args) {
   
		LectorController lector = new LectorController();
		try {
			System.out.println(lector.obtenerPuntosFromCodigo());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		/*int puntosTotales = 0;
		int puntos = Integer.parseInt(a);
		int puntosTotales = puntos + puntosTotales;*/

	

}
