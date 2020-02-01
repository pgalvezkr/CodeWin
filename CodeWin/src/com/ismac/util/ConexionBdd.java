package com.ismac.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBdd {
	private String connectionUrl =
            "jdbc:sqlserver://192.168.1.13:1433;"
            + "database=CodeWin;"
            + "user=sa;"
            + "password=Ismacsql.1;"
            //+ "encrypt=true;"
            + "trustServerCertificate=false;"
            + "loginTimeout=30;";
	
/////////////////////////Insertar Fila//////////////////////////////////////////
public ResultSet insertSql(String insertSql) {
	ResultSet resultSet = null;
	//String insertSql = "INSERT INTO Productos (Nombre, Precio) VALUES "
	//      + "('Manzanas', 5);";
	try (Connection connection = DriverManager.getConnection(connectionUrl);
	PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);) {
	
	prepsInsertProduct.execute();
	// Retrieve the generated key from the insert.
	resultSet = prepsInsertProduct.getGeneratedKeys();
	
	while (resultSet.next()) {
	System.out.println("Generated: " + resultSet.getString(1));
	} 

}

// Handle any errors that may have occurred.
catch (Exception e) {
	e.printStackTrace();
	}
	return resultSet;
}

////////////////////////////////////////////////////////////////7

}
