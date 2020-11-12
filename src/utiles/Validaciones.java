package utiles;

import java.util.regex.Pattern;

public class Validaciones {

	public static boolean validaLetras(String cadena) {
		return Pattern.matches("[a-zA-Z\\s]+", cadena);
	}
	public static boolean validaNumeros(String cadena) {
		return Pattern.matches("[a-zA-ZñÑáéíóúÜüÁÉÍÓÚ0-9\\s]+", cadena);
	}
	public static boolean validaLetrasYNumeros(String cadena) {
		return Pattern.matches("[a-zA-ZñÑáéíóúÜüÁÉÍÓÚ0-9\\s]+", cadena);
	}
	public static boolean validaISBN(String cadena) {
		return Pattern.matches("[0-9]{13}", cadena);
	}

	public static boolean validaFloat(String cadena) {

		try {
			Float.parseFloat(cadena);
			char charAt = cadena.charAt(cadena.length() - 1);
			if (charAt == 'f' || charAt == 'd') {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
