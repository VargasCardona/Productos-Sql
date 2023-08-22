package com.controladores;

import com.utils.ConexionUtils;
import com.utils.Utils;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ControladorGeneral {

	public ResultSet listarTabla(String sqlQuery) {
		try {
			PreparedStatement preparedStat = null;

			preparedStat = ConexionUtils.realizarConexion().prepareStatement(sqlQuery);
			return preparedStat.executeQuery();
		} catch (SQLException ex) {
			System.err.print(ex);
		}
		return null;
	}

	public void insertarTabla(String nombre, String precio, String distribuidor, String categoria) {
		try {
			PreparedStatement ps = ConexionUtils.realizarConexion().prepareStatement("INSERT INTO productos (sku, nombre, precio, distribuidor, categoria) VALUES (?, ?, ?, ? ,?)");
			ps.setString(1, Utils.generarIdentificador(nombre));
			ps.setString(2, nombre);
			ps.setString(3, precio);
			ps.setString(4, distribuidor);
			ps.setString(5, categoria);
			
			ps.execute();

		} catch (SQLException ex) {
			System.err.print(ex);
		}
	}
}
