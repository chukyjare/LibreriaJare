package modelo;


import java.util.HashMap;
import java.util.Set;

import javax.swing.table.DefaultTableModel;

public class Libreria {
	private HashMap<String, Libro> mapaLibro;
	private int contadorLibros = 0;
	private DefaultTableModel tablaCompleta;


	public Libreria() {
		super();
		this.mapaLibro = new HashMap<String, Libro>();
	}

	public void anadirLibro(Libro libro) {
		
		this.mapaLibro.put(libro.getISBN(), libro);
		actualizarContador();
	}

	

	public int actualizarContador() {
		return contadorLibros= mapaLibro.size();
	}

	public Libro obtenerLibro(String ISBN) {

		return this.mapaLibro.get(ISBN);
	}

	public boolean existeISBN(String ISBN) {
		return this.mapaLibro.containsKey(ISBN);
	}

	public DefaultTableModel getTablaCompleta() {
		return tablaCompleta;
	}

	public int getContadorLibros() {
		return contadorLibros;
	}

	public void borrarLibro(int indice) {
		String ISBN = obtenerISBNconcreto(indice);
		mapaLibro.remove(ISBN);
	}

	public HashMap<String, Libro> getHashMapLibro() {
		return this.mapaLibro;
	}

	public boolean isVacia() {
		if (mapaLibro.isEmpty()) {
			return true;
		}
		return false;
	}

	public Libro getLibro(int i) {
		String ISBN = obtenerISBNconcreto(i);
		return obtenerLibro(ISBN);
	}

	private String obtenerISBNconcreto(int i) {
		Set <String> conjunto = this.mapaLibro.keySet();
		Object[] array = conjunto.toArray();
		String ISBN = (String) array[i];
		return ISBN;
	}
	

}
