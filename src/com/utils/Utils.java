package com.utils;

import static java.lang.String.valueOf;

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

	/**
	 * Genera un identificador basado en un String ingresado
	 *
	 * @param stringIngresado String bajo el cual se creara el identificador
	 * @return String identificador compuesto de una letra y dos numeros
	 */
	public static String generarIdentificador(String stringIngresado) {
		int numeroMaximo = 100;
		int numeroMinimo = 999;
		return "" + Character.toUpperCase(stringIngresado.charAt(0)) + valueOf((int) (Math.random() * (numeroMaximo - numeroMinimo + 1) + numeroMinimo));
	}
}
