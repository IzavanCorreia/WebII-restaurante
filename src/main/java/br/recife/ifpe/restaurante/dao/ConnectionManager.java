/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.recife.ifpe.restaurante.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManager {
    
    private static final String URL = "jdbc:mysql://localhost:3306/restaurante";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    private static Connection currentConnection = null;
    
    public static Connection getCurrentConnection() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        
        if(currentConnection == null){
            currentConnection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return currentConnection;
    }
    
    public static Connection getConnection() throws SQLException{
        
        return DriverManager.getConnection(URL, USER, PASSWORD);
       
    }
    
}
