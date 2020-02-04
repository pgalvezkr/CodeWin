package com.ismac.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBdd {

	public static Connection getConexion() throws Exception {
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(Constantes.PATH_BDD);
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		return conexion;
	}

}
