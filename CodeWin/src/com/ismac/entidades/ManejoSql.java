package com.ismac.entidades;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManejoSql {

	//private String connectionUrl;
	private String connectionUrl =
            "jdbc:sqlserver://192.168.1.10:1433;"
            + "database=CodeWin;"
            + "user=sa;"
            + "password=Ismacsql.1;"
            //+ "encrypt=true;"
            + "trustServerCertificate=false;"
            + "loginTimeout=30;";
	
	/////////////////////////Insertar Fila//////////////////////////////////////////
	public ResultSet insertSql(String insertSql) {
		ResultSet resultSet = null;
		//String insertSql = "INSERT INTO Producto (Nombre, Precio) VALUES "
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
	/////////////////////////Borra fila//////////////////////////7
	
	public ResultSet borraSql(String borraSql) {
		ResultSet resultSet = null;
		try (Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement prepsBorraProduct = connection.prepareStatement(borraSql, Statement.RETURN_GENERATED_KEYS);) {
        		
            prepsBorraProduct.execute();
            // Retrieve the generated key from the insert.
           

           
           
        }
       
        // Handle any errors that may have occurred.
        catch (Exception e) {
           e.printStackTrace();
        }
		return resultSet;
	}
	////////////////////////////////////////////////777
	///////////////Editar/////////////////////////////77
	public ResultSet editaSql(String editaSql) {
		ResultSet resultSet = null;
		try (Connection connection = DriverManager.getConnection(connectionUrl);
              PreparedStatement prepsUpdateProduct = connection.prepareStatement(editaSql, Statement.RETURN_GENERATED_KEYS);) {
      		prepsUpdateProduct.execute();
      			resultSet = prepsUpdateProduct.executeQuery();

           
       	}
              
       // Handle any errors that may have occurred.
       catch (Exception e) {
             e.printStackTrace();
       }
		return resultSet;
	}
	//////////////////////////////////////////////////77
	///////////////////////Select///////////////////////}
	public ResultSet selectSql(String selectSql) {
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		try (Connection connection = DriverManager.getConnection(connectionUrl);
                Statement statement = connection.createStatement();) {
            // Create and execute a SELECT SQL statement.
         //   String selectSql = "SELECT TOP 10 Nombre, Precio from Productos";
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + "*" + resultSet.getString(2));
                
            	
            	}
        	}
        	
       
        
        catch (SQLException e) {
            e.printStackTrace();
        }
		//resultSet1=resultSet;
	
		return resultSet;
	}
	//////////////////////////////////////////////////////7
	
	
}
