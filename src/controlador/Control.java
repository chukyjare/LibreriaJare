package controlador;


import javax.swing.table.DefaultTableModel;

import modelo.Estrategia;
import modelo.Libreria;
import modelo.LibreriaPorArray;
import modelo.LibreriaPorLibro;
import modelo.LibreriaPorMapa;


public class Control {
	private Libreria libreria;
	private DefaultTableModel tablaCompleta;
	private String miEstrategia = Estrategia.ESTRATEGIA_PORMAPA.getMensaje();

	public Control() {
		super();
		if (miEstrategia.equals(Estrategia.ESTRATEGIA_PORLIBRO.getMensaje())) {
			this.libreria = new LibreriaPorLibro();
		}
		if (miEstrategia.equals(Estrategia.ESTRATEGIA_PORARRAY.getMensaje())) {
			this.libreria = new LibreriaPorArray();
		}
		if (miEstrategia.equals(Estrategia.ESTRATEGIA_PORMAPA.getMensaje())) {
			this.libreria = new LibreriaPorMapa();
		}
		this.tablaCompleta = libreria.getTablaCompleta();
	}

	public Libreria getLibreria() {
		return libreria;
	}

	public DefaultTableModel getTablaCompleta() {
		return tablaCompleta;
	}

}
