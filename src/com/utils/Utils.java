package com.utils;

import static java.lang.String.valueOf;

public class Utils {
	
	/**
	 * Verifica si el String ingresado es un entero.
	 *
	 * @param entrada String a procesar
	 * @return boolean indicando si el String ingresado es un entero
	 * longs
	 * @throws NumberFormatException {@inheritDoc}
	 */
	public static boolean esInt(String entrada) {
		Integer aux;
		try {
			aux = Integer.parseInt(entrada);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * Genera un identificador basado en un String ingresado
	 *
	 * @param stringIngresado String bajo el cual se creara el identificador
	 * @return String identificador compuesto de una letra y dos numeros
	 */
	public static String generarSku(String stringIngresado) {
		int numeroMaximo = 100;
		int numeroMinimo = 999;
		return "" + Character.toUpperCase(stringIngresado.charAt(0)) + valueOf((int) (Math.random() * (numeroMaximo - numeroMinimo + 1) + numeroMinimo));
	}
}
