package com.ismac.servicios.test;

import java.io.IOException;

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

}
