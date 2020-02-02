package com.ismac.servicios;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TarjetaService {


	public String connectionUrl = "";

	// CREAR TARJETA
	public ResultSet crear(int idTarjeta, int tipoTarjeta, int estacion, int valorTarjeta) {

		ResultSet resultSet = null;

		// SENTENCIA SQL
		String sentenceSql = "INSERT INTO Tarjeta (IdTarjeta, TipoTarjeta, Estacion, ValorTarjeta) VALUES (" + idTarjeta
				+ ", " + tipoTarjeta + ", " + estacion + ", " + valorTarjeta + ")";

		try (Connection connection = DriverManager.getConnection(connectionUrl);
				PreparedStatement prepsInsertProduct = connection.prepareStatement(sentenceSql,
						Statement.RETURN_GENERATED_KEYS())); {
			prepsInsertProduct.execute();
			
			resultSet = prepsInsertProduct.getGeneratedKeys();

			while (resultSet.next()) {
				System.out.println("Generado: " + resultSet.getString(1));
			}
		}
		// Handle any errors that may have occurred.////////
		catch (Exception e) {
			e.printStackTrace();
		}
		return resultSet;

	// LEER TARJETA
	public ResultSet leer (int idTarjeta, int tipoTarjeta, int estacion, int valorTarjeta) {

		ResultSet resultSet2 = null;

		// SENTENCIA SQL
		String sentenceSql2 = "INSERT INTO Tarjeta (IdTarjeta, TipoTarjeta, Estacion, ValorTarjeta) VALUES (" + idTarjeta
				+ ", " + tipoTarjeta + ", " + estacion + ", " + valorTarjeta + ")";

		try (Connection connection = DriverManager.getConnection(connectionUrl);
				PreparedStatement prepsInsertProduct = connection.prepareStatement(sentenceSql,
						Statement.RETURN_GENERATED_KEYS())); {
			prepsInsertProduct.execute();
			
			resultSet = prepsInsertProduct.getGeneratedKeys();

			while (resultSet.next()) {
				System.out.println("Generado: " + resultSet.getString(1));
			}
		}
		// Handle any errors that may have occurred.////////
		catch (Exception e) {
			e.printStackTrace();
		}
		return resultSet;
	}

	
	}
	
}
