package com.ismac.servicios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ismac.entidades.Catalogo;
import com.ismac.util.ConexionBdd;

public class CatalogoService {

	// GET TARJETA
	public static List<Catalogo> listar() throws Exception {
		List<Catalogo> catalogos = new ArrayList<Catalogo>();
		ResultSet resultSet = null;
		// SENTENCIA SQL
		String sentenceSql = "select * from Catalogo";
		try {
			// Creo la conexion
			Connection conexion;
			conexion = ConexionBdd.getConexion();
			// Ejecuto la sentencia SQL
			Statement sentenciaInsert = conexion.createStatement();
			resultSet = sentenciaInsert.executeQuery(sentenceSql);
			// Obtengo resultados
			while (resultSet.next()) {
				Catalogo catalogo = new Catalogo();
				catalogo.setIdcatalogo(resultSet.getInt("IdCatalogo"));
				catalogo.setNombre(resultSet.getString("Nombre"));
				catalogo.setTipo(resultSet.getInt("tipo"));
				catalogos.add(catalogo);
			}
		} catch (Exception e) {
			System.out.println("Ocurrió un error al momento de obtener la tarjeta");
			throw new Exception(e.getMessage());
		}

		return catalogos;
	}

	// GET TARJETA
	public static List<Catalogo> obtenerPorIdentificador(int id) throws Exception {
		List<Catalogo> catalogos = new ArrayList<Catalogo>();
		ResultSet resultSet = null;
		// SENTENCIA SQL
		String sentenceSql = "select * from Catalogo where idCatalogo= " + id;
		try {
			// Creo la conexion
			Connection conexion;
			conexion = ConexionBdd.getConexion();
			// Ejecuto la sentencia SQL
			Statement sentenciaInsert = conexion.createStatement();
			resultSet = sentenciaInsert.executeQuery(sentenceSql);
			// Obtengo resultados
			while (resultSet.next()) {
				Catalogo catalogo = new Catalogo();
				catalogo.setIdcatalogo(resultSet.getInt("IdCatalogo"));
				catalogo.setNombre(resultSet.getString("Nombre"));
				catalogo.setTipo(resultSet.getInt("tipo"));
				catalogos.add(catalogo);
			}
		} catch (Exception e) {
			System.out.println("Ocurrió un error al momento de obtener la tarjeta");
			throw new Exception(e.getMessage());
		}

		return catalogos;
	}

}
