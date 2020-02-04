package com.ismac.servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
						Statement.RETURN_GENERATED_KEYS);) {
			prepsInsertProduct.execute();
			
			resultSet = prepsInsertProduct.getGeneratedKeys();

			while (resultSet.next()) {
				System.out.println("Generado: " + resultSet.getString(1));
			}
		}
		// Handle any errors that may have occurred./
		catch (Exception e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	
	//Update tabla Set campo1='José', campo2='', campo3=12 Where id=1
	//Delete from nombreTabla where id =12
	//Select * from nombreTabla where id = 12
}
