package com.utils;

public class Utils {

	public boolean esDouble(String entrada) {
		Double aux;
		try {
			aux = Double.parseDouble(entrada);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
