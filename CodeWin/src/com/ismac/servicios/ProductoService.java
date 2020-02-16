package com.ismac.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ismac.entidades.Producto;
import com.ismac.util.ConexionBdd;

public class ProductoService {

	// CREAR TARJETA
	public static ResultSet crear(String nombre, double precio) throws Exception {
		ResultSet resultSet = null;
		// SENTENCIA SQL
		String sentenceSql = "Insert into Producto (Nombre, Precio) values ('" + nombre + "', " + precio + ")";
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
			System.out.println("Ocurrió un error al momento de guardar la producto");
			throw new Exception(e.getMessage());
		}

		return resultSet;
	}

	// ACTUALIZAR TARJETA
	public static ResultSet actualizar(int id, String nombre, double precio) throws Exception {
		ResultSet resultSet = null;
		// SENTENCIA SQL
		String sentenceSql = "UPDATE PRODUCTO SET Nombre = '" + nombre + "', Precio= " + precio + " WHERE IdProducto ="
				+ id;
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
			System.out.println("Ocurrió un error al momento de actualizar la producto");
			throw new Exception(e.getMessage());
		}
		return resultSet;
	}

	// ELIMINAR TARJETA
	public static ResultSet eliminar(int id) throws Exception {
		ResultSet resultSet = null;
		// SENTENCIA SQL
		String sentenceSql = "DELTE FROM Producto WHERE IdProducto = " + id;
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
			System.out.println("Ocurrió un error al momento de eliminar la producto");
			throw new Exception(e.getMessage());
		}

		return resultSet;
	}

	public static int getIdProductoByNombre(String nombre) throws Exception {
		int idProducto = 0;
		ResultSet resultSet = null;
		// SENTENCIA SQL
		String sentenceSql = "SELECT idProducto FROM Producto WHERE nombre ='" + nombre.trim() + "'";
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
			}
		} catch (Exception e) {
			System.out.println("Ocurrió un error al momento de obtener la tarjeta");
			throw new Exception(e.getMessage());
		}

		return idProducto;
	}

	// GET TARJETA
	public static List<Producto> listar() throws Exception {
		List<Producto> productos = new ArrayList<Producto>();
		ResultSet resultSet = null;
		// SENTENCIA SQL
		String sentenceSql = "SELECT * FROM Producto";
		try {
			// Creo la conexion
			Connection conexion;
			conexion = ConexionBdd.getConexion();
			// Ejecuto la sentencia SQL
			Statement sentenciaInsert = conexion.createStatement();
			resultSet = sentenciaInsert.executeQuery(sentenceSql);
			// Obtengo resultados
			while (resultSet.next()) {
				Producto producto = new Producto();
				producto.setIdProducto(resultSet.getInt("IdProducto"));
				producto.setNombre(resultSet.getString("Nombre"));
				producto.setPrecio(resultSet.getDouble("Precio"));
				productos.add(producto);
			}
		} catch (Exception e) {
			System.out.println("Ocurrió un error al momento de obtener la tarjeta");
			throw new Exception(e.getMessage());
		}

		return productos;
	}

}
