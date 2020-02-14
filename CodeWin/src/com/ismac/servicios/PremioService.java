package com.ismac.servicios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.ismac.util.ConexionBdd;

public class PremioService {

	/**
	 * Permite obtener el nombre del premio que le corresponde al puntaje que recibe
	 * como parámetro.
	 * 
	 * @param puntaje,
	 *            número de puntos con el que se va a consultar en que rango de
	 *            puntos se encuentra y que premio le corresponde @return, nombre
	 *            del producto que se gana como premio
	 * @throws Exception
	 */
	public static String obtenerPremio(int puntaje) throws Exception {
		String nombrePremio = "Golosinas";
		int idProducto = 0;
		ResultSet resultSet = null;
		ResultSet resultSetProducto = null;
		// SENTENCIA SQL
		String sentenceSql = "SELECT idProducto FROM Premio where  " + puntaje + ">= rangoInicial and " + puntaje
				+ "<= rangoFinal";
		try {
			// Creo la conexion
			Connection conexion;
			conexion = ConexionBdd.getConexion();
			// Ejecuto la sentencia SQL
			Statement sentenciaInsert = conexion.createStatement();
			resultSet = sentenciaInsert.executeQuery(sentenceSql);
			// Obtengo resultados
			while (resultSet.next()) {
				idProducto = resultSet.getInt("idProducto");
				String setenceProducto = "Select nombre FROM Producto where id =" + idProducto;
				resultSetProducto = sentenciaInsert.executeQuery(setenceProducto);
			}
			while (resultSetProducto.next()) {
				nombrePremio = resultSet.getString("nombre");
			}
		} catch (Exception e) {
			System.out.println("Ocurrió un error al momento de obtener la tarjeta");
			throw new Exception(e.getMessage());
		}
		return nombrePremio;
	}
}
