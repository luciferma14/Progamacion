package com.proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
	
		private static String driv = "com.mysql.cj.jdbc.Driver";
		private static String bibl = "jdbc:mysql://33006/Biblioteca";
		private static String usr= "root";
		private static String pass = "dbrootpass";
		
		private Database() {
			
		}

		private void conect(){

			try {

				Connection con = DriverManager.getConnection(bibl,usr,pass);
			
			}catch(SQLException e){

			}
		}

		
		
		public static Connection getDBConnection() throws SQLException {
			Connection connection = null;

			try {
				Class.forName(DB_DRIVER);
			} catch (ClassNotFoundException exception) {
				logger.log(Level.SEVERE, exception.getMessage());
			}

			try {
				connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
				return connection;
			} catch (SQLException exception) {
				logger.log(Level.SEVERE, exception.getMessage());
			}

			return connection;
		}
		
	}