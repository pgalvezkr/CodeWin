package com.ismac.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.ismac.util.ConexionBdd;

public class StockService {

	public static void disminuirStock(int idProducto, int cantidad) throws Exception {
		int cantidadFinal = obtenerCantidadActual(idProducto);
		cantidadFinal-= cantidad;
		ResultSet resultSet = null;
		// SENTENCIA SQL
		String sentenceSql = "UPDATE Stock SET CantidadFinal=" + cantidadFinal + " WHERE idProducto=" + idProducto+";";
		try {
			// Creo la conexion
			Connection conexion;
			conexion = ConexionBdd.getConexion();
			
			 PreparedStatement prepsUpdateProduct = conexion.prepareStatement(sentenceSql, Statement.RETURN_GENERATED_KEYS); {
		     prepsUpdateProduct.execute();
		     resultSet = prepsUpdateProduct.executeQuery();
			
			 }
			// Ejecuto la sentencia SQL
//			Statement sentenciaInsert = conexion.createStatement();
			//resultSet = sentenciaInsert.executeQuery(sentenceSql);
//			sentenciaInsert.executeQuery(sentenceSql);
			// Obtengo resultados
//			while (resultSet.next()) {
//				System.out.println("Actualizado: " + resultSet.getString(1));
//			}
		} catch (Exception e) {
			System.out.println("Ocurri� un error al momento de obtener la tarjeta");
			throw new Exception(e.getMessage());
		}
	}

	public static int obtenerCantidadActual(int idProducto) throws Exception {
		int cantidadActual = 0;
		ResultSet resultSet = null;
		// SENTENCIA SQL
		String sentenceSql = "SELECT CantidadFinal FROM Stock where idProducto =" + idProducto;
		try {
			// Creo la conexion
			Connection conexion;
			conexion = ConexionBdd.getConexion();
			// Ejecuto la sentencia SQL
			Statement sentenciaInsert = conexion.createStatement();
			resultSet = sentenciaInsert.executeQuery(sentenceSql);
			// Obtengo resultados
			while (resultSet.next()) {
				cantidadActual = resultSet.getInt("CantidadFinal");
			}
		} catch (Exception e) {
			System.out.println("Ocurri� un error al momento de obtener la tarjeta");
			throw new Exception(e.getMessage());
		}

		return cantidadActual;
	}

}
