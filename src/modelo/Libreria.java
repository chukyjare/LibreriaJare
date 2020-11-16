package modelo;


import java.util.HashMap;
import java.util.Set;

import javax.swing.table.DefaultTableModel;

public class Libreria {
	private HashMap<String, Libro> mapaLibro;
	private int contadorLibros = 0;
	private DefaultTableModel tablaCompleta;
	private Almacen almacen;


	public Libreria() {
		super();
		this.almacen= new Almacen("data.libros");
		iniciarFichero();
	}

	private void iniciarFichero() {
		try {
			leerAlmacen();
		} catch (Exception e) {
		}
		if (this.mapaLibro==null) {
			this.mapaLibro=new HashMap<String, Libro>();
			guardarEnAlmacen();
		}
	}

	@SuppressWarnings("unchecked")
	private void leerAlmacen() {
		this.mapaLibro=(HashMap<String, Libro>) almacen.getAlmacenado();
	}

	public void anadirLibro(Libro libro) {
		leerAlmacen();
		this.mapaLibro.put(libro.getISBN(), libro);
		guardarEnAlmacen();
		actualizarContador();
	}

	

	public void guardarEnAlmacen() {
		almacen.almacenar(this.mapaLibro);
		
	}

	public int actualizarContador() {
		return contadorLibros= mapaLibro.size();
	}

	public Libro obtenerLibro(String ISBN) {
		return this.mapaLibro.get(ISBN);
	}
	public void borrarLibro(int indice) {
		leerAlmacen();
		String ISBN = obtenerISBNconcreto(indice);
		mapaLibro.remove(ISBN);
		guardarEnAlmacen();
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
