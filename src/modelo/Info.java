package modelo;

public enum Info {
	INFO_BORRADO("Libro borrado"),
	INFO_INTRODUCE("Introduce ISBN")
	;
	
	private String mensaje;

	private Info(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}
}
