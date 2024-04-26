package com.proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


class UserDao {

	private static final Logger logger = Logger.getLogger(UserDao.class.getName());


	public boolean userExists(String username) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		List<User> users = new ArrayList<>();

		
		TextField idUser = new TextField("Email");;
		
		PasswordField idPass = new PasswordField();
		
		TextField idNombre = new TextField("Nombre");
		
		TextField idApellido = new TextField("Apellido");  

		try {
			con = Database.getDBConnection();
			con.setAutoCommit(false);
			String query = "SELECT id, email, apellido, nombre, password FROM usuario WHERE email = ?";
			st = con.prepareStatement(query);
			int counter = 1;
			st.setString(counter++, username);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.usr.set(idUser.getText());
				user.pas.set(idPass.getText());
				user.nom.set(idNombre.getText());
				user.apell.set(idApellido.getText());
				users.add(user);
				users.add(user);
			}

			return users.isEmpty() ? false : true;
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

		return users.isEmpty() ? false : true;
	}

	public int saveUser(User user) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			con = Database.getDBConnection();
			con.setAutoCommit(false);
			String query = "INSERT INTO usuarios(email, apellido, nombre, password) VALUES(?, ?, ?, ?)";
			st = con.prepareStatement(query, st.RETURN_GENERATED_KEYS);
			int counter = 1;
			st.setString(counter++, user.getUser());
			st.setString(counter++, user.getApellido());
			st.setString(counter++, user.getApellido());
			st.setString(counter++, user.getPass());
			st.executeUpdate();
			con.commit();
			rs = st.getGeneratedKeys();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage());
			if (null != con) {
				con.rollback();
			}
		} finally {
			if (null != rs) {
				rs.close();
			}

			if (null != st) {
				st.close();
			}

			if (null != con) {
				con.close();
			}
		}

		return 0;
	}

}