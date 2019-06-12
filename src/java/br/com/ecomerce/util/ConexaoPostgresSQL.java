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
public class ConexaoPostgresSQL {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    public static Connection getConecction() throws ClassNotFoundException, SQLException{

            driver = "org.postgresql.Driver";
            url = "jdbc:postgresql://localhost:5432/Arquitetura3-Web";
            user = "postgres";
            password = "123";

            Class.forName(driver);		// Solicita que seja acriada uma instancuia da classe com base no nome da String

            Connection conexao = DriverManager.getConnection(url, user, password);

            return conexao;
    }
}
