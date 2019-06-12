/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecomerce.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  Cria uma conexão com o banco de dados.
 * @author Marcelo Vilas Boas Correa Filho
 */
public class ConexaoMySql {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    public static Connection getConecction() throws ClassNotFoundException, SQLException{
            
        
            driver = "com.mysql.jdbc.Driver";
            url = "jdbc:mysql://localhost:3306/ecomerce";
            user = "root";
            password = "";

            try {
                Class.forName(driver);		// Solicita que seja acriada uma instancuia da classe com base no nome da String
            } catch (ClassNotFoundException e) {
		System.out.println("Where is your MySQL JDBC Driver?");
		e.printStackTrace();
            }
            
            System.out.println("MySQL JDBC Driver Registered!");
            
            Connection conexao = null;
            try {
		conexao = DriverManager
		.getConnection(url, user, password);

            } catch (SQLException e) {
		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
            }
            
            if (conexao != null) {
		System.out.println("You made it, take control your database now!");
            } else {
		System.out.println("Failed to make connection!");
            }
            
            //Connection conexao = DriverManager.getConnection(url, user, password);

            return conexao;
    }
}
