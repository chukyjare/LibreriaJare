package modelo;

public enum Estrategia {
	ESTRATEGIA_PORLIBRO("libro"),
	ESTRATEGIA_PORARRAY("array"),
	ESTRATEGIA_PORMAPA("mapa"),
	ESTRATEGIA_PORSQL("sql")
	;

	private String mensaje;

	private Estrategia(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}
}
