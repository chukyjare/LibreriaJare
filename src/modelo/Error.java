package modelo;

public enum Error {
	ERROR_ISBN_EXISTENTE("Ese ISBN ya existe"),
	ERROR_CAMPOSINCORRECTOS("Validación de campos incorrecta"),
	ERROR_ILOCALIZABLE("LIBRO NO ENCONTRADO"),
	ERROR_NOSELECCIONADO("NO HA SELECCIONADO NINGÚN LIBRO")
	;

	private String mensaje;

	private Error(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}
	
	
}
