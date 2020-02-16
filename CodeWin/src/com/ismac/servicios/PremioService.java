package com.ismac.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.ismac.util.ConexionBdd;

public class PremioService {

	/**
	 * Permite obtener el nombre del premio que le corresponde al puntaje que recibe
	 * como par�metro.
	 * 
	 * @param puntaje,
	 *            n�mero de puntos con el que se va a consultar en que rango de
	 *            puntos se encuentra y que premio le corresponde @return, nombre
	 *            del producto que se gana como premio
	 * @throws Exception
	 */
	public static String obtenerPremio(int puntaje) throws Exception {
		String nombrePremio = "Golosinas";
		ResultSet resultSet = null;
		// SENTENCIA SQL
		String sentenceSql = "SELECT prod.nombre AS nombre FROM Premio pr JOIN Producto prod on pr.idProducto = prod.idProducto "
				+ " where  " + puntaje + ">= pr.rangoInicial and " + puntaje + "<= pr.rangoFinal";
		try {
			// Creo la conexion
			Connection conexion;
			conexion = ConexionBdd.getConexion();
			// Ejecuto la sentencia SQL
			Statement sentenciaInsert = conexion.createStatement();
			resultSet = sentenciaInsert.executeQuery(sentenceSql);
			// Obtengo resultados
			while (resultSet.next()) {
				nombrePremio = resultSet.getString("nombre");
			}
		} catch (Exception e) {
			System.out.println("Ocurri� un error al momento de obtener la tarjeta");
			throw new Exception(e.getMessage());
		}
		return nombrePremio;
	}

	public static ResultSet crear(int idProducto, int rangoInicial, int rangoFinal) throws Exception {

		ResultSet resultSet = null;
		// SENTENCIA SQL
		String sentenceSql = "INSERT INTO Premio (idProducto, rangoInicial, rangoFinal) VALUES (" + idProducto + ", "
				+ rangoInicial + ", " + rangoFinal + ")";
		try {
			// Creo la conexion
			Connection conexion;
			conexion = ConexionBdd.getConexion();
			// Ejecuto la sentencia SQL
			PreparedStatement sentenciaInsert = conexion.prepareStatement(sentenceSql,
					java.sql.Statement.RETURN_GENERATED_KEYS);
			sentenciaInsert.execute();
			// Obtengo resultados
			resultSet = sentenciaInsert.getGeneratedKeys();
			while (resultSet.next()) {
				System.out.println("Generado: " + resultSet.getString(1));
			}
		} catch (Exception e) {
			System.out.println("Ocurri� un error al momento de guardar la tarjeta");
			throw new Exception(e.getMessage());
		}

		return resultSet;
	}
}
