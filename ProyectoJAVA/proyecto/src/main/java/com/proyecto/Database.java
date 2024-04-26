package com.proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database{
    private static String driv = "com.mysql.cj.jdbc.Driver";
    private static String bibl = "jdbc:mysql:33006/Biblioteca";
    private static String usr= "root";
    private static String pass = "dbrootpass";	

    private Database(){

    }

    private void conect(){
        try{
            Connection con = DriverManager.getConnection(bibl,usr,pass);	
        }catch(SQLException e){
        }
    }
    public static Connection getDBConnection() throws SQLException {
        Connection connection = null;

        try {
        	Class.forName(driv);

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
        	connection = DriverManager.getConnection(bibl, usr, pass);
        	return connection;
        } catch (SQLException e) {
    
            return connection;
        
        }
    }
}