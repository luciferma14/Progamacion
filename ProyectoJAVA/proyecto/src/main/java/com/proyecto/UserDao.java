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


class UserDao {

	private static final Logger logger = Logger.getLogger(UserDao.class.getName());

	public boolean userExists(String username) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		List<User> users = new ArrayList<>();

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
				user.setId(rs.getInt(1));
				user.setUser(rs.getString(2));
				user.setApellido(rs.getString(3));
				user.setNombre(rs.getString(4));
				user.setPass(rs.getString(5));
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