package com.proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


class UserDao {

	private static final Logger logger = Logger.getLogger(UserDao.class.getName());


	public void userExists(String username) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;

		
		TextField idUser = new TextField("Email");;
		
		PasswordField idPass = new PasswordField();
		
		TextField idNombre = new TextField("Nombre");
		
		TextField idApellido = new TextField("Apellido");  

		try {
			con = Database.getDBConnection();
			con.setAutoCommit(false);
			String query = "SELECT id, email, apellido, nombre, password FROM usuario WHERE email = ?";
			st = con.prepareStatement(query);
			ResultSet rs = st.executeQuery();

		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage());
		} finally {
			if (null != st) {
				st.close();
			}

			if (null != con) {
				con.close();
			}
		}
	}
}