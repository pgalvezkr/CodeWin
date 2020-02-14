package com.ismac.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ismac.entidades.Tarjeta;
import com.ismac.util.ConexionBdd;

public class TarjetaService {

	// CREAR TARJETA
	public static ResultSet crear(String tipoTarjeta, String estacion, int valorTarjeta) throws Exception {

		ResultSet resultSet = null;
		// SENTENCIA SQL
		String sentenceSql = "INSERT INTO Tarjeta (TipoDeTarjeta, Estacion, ValorTarjeta) VALUES (" + tipoTarjeta + ", "
				+ estacion + ", " + valorTarjeta + ")";
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
			System.out.println("Ocurrió un error al momento de guardar la tarjeta");
			throw new Exception(e.getMessage());
		}

		return resultSet;
	}

	// ACTUALIZAR TARJETA
	public static ResultSet actualizar(int idTarjeta, int tipoTarjeta, int estacion, int valorTarjeta)
			throws Exception {
		ResultSet resultSet = null;
		// SENTENCIA SQL
		String sentenceSql = "UPDATE Tarjeta SET TipoTarjeta =" + tipoTarjeta + " ,estacion = " + estacion
				+ " ,valorTarjeta= " + valorTarjeta;
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
				System.out.println("Actualizado: " + resultSet.getString(1));
			}
		} catch (Exception e) {
			System.out.println("Ocurrió un error al momento de actualizar la tarjeta");
			throw new Exception(e.getMessage());
		}
		return resultSet;
	}

	// ELIMINAR TARJETA
	public static ResultSet eliminar(int idTarjeta) throws Exception {
		ResultSet resultSet = null;
		// SENTENCIA SQL
		String sentenceSql = "DELETE FROM Tarjeta WHERE IdTarjeta = " + idTarjeta;
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
				System.out.println("Eliminado: " + resultSet.getString(1));
			}
		} catch (Exception e) {
			System.out.println("Ocurrió un error al momento de eliminar la tarjeta");
			throw new Exception(e.getMessage());
		}

		return resultSet;
	}

	// GET TARJETA
	public static List<Tarjeta> listar() throws Exception {
		List<Tarjeta> tarjetas = new ArrayList<Tarjeta>();
		ResultSet resultSet = null;
		// SENTENCIA SQL
		String sentenceSql = "SELECT * FROM Tarjeta";
		try {
			// Creo la conexion
			Connection conexion;
			conexion = ConexionBdd.getConexion();
			// Ejecuto la sentencia SQL
			Statement sentenciaInsert = conexion.createStatement();
			resultSet = sentenciaInsert.executeQuery(sentenceSql);
			// Obtengo resultados
			while (resultSet.next()) {
				Tarjeta tarjeta = new Tarjeta();
				tarjeta.setIdTarjeta(resultSet.getInt("Idtarjeta"));
				tarjeta.setTipoDeTarjeta(resultSet.getString("TipoDeTarjeta"));
				tarjeta.setEstacion(resultSet.getString("Estacion"));
				tarjeta.setValorDeTarjeta(resultSet.getInt("ValorTarjeta"));
				tarjetas.add(tarjeta);
			}
		} catch (Exception e) {
			System.out.println("Ocurrió un error al momento de obtener la tarjeta");
			throw new Exception(e.getMessage());
		}

		return tarjetas;
	}

}
