package modelo;

import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Almacen {

	protected ArrayList<Libro> arrayList;

	protected boolean actualizar() {
		return false;
	}

	protected boolean almacenar(Object obj) {
		return false;
	}

	protected Object getAlmacenado() {
		return null;
	}

	protected boolean almacenarMapa(Object objeto) {
		return false;
	}

	protected boolean almacenarLibro(Libro libro) {
		return false;
	}

	protected void almacenarAll() {
	}

	protected boolean borrarPorISBN(String isbn) {
		return false;

	}

	protected boolean insertarLibro(Libro libro) throws SQLException {
		return false;
	}

	protected boolean modificarLibro() {
		return false;
	}

	protected boolean comprobarModificado() {
		return false;
	}

	protected ArrayList<Libro> getArrayList() {
		return arrayList;
	}

	protected void setArrayList(ArrayList<Libro> arrayList) {
		this.arrayList = arrayList;
	}
}
