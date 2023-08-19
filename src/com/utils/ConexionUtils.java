package com.utils;

import com.conexion.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author Nicolas Vargas Cardona
 */
public class ConexionUtils {

	public static ResultSet realizarConsulta(String sqlQuery) {
		try {

			PreparedStatement preparedStat = null;
			ResultSet resultSet = null;

			ConexionDB conexionD = new ConexionDB();
			Connection con = conexionD.getConexion();

			preparedStat = con.prepareStatement(sqlQuery);
			return preparedStat.executeQuery();

		} catch (SQLException ex) {
			System.err.println(ex.toString());
		}

		return null;
	}
}
