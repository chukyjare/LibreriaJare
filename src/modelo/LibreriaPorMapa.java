package modelo;

import java.util.HashMap;
import java.util.Set;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LibreriaPorMapa extends Libreria {
	private HashMap<String, Libro> mapaLibro;
	private final byte NUM_FILAS = 8;

	public LibreriaPorMapa() {
		super();
		this.almacen = new Almacen("data.librosMapa");
		iniciar();
	}
	@Override
	public void iniciar() {
		try {
			leer();
		} catch (Exception e) {
		}
		if (this.mapaLibro == null) {
			this.mapaLibro = new HashMap<String, Libro>();
			guardar();
		}
	}
	@Override
	public void rellenarTabla(JTable tablaLibros) {
		String[] nombresColumnas = { "ISBN", "TÍTULO", "EDITORIAL", "AUTOR", "PRECIO", "FORMATO", "ESTADO",
				"CANTIDAD" };
		String[][] filasTabla = new String[mapaLibro.size()][NUM_FILAS];
		for (int i = 0; i < mapaLibro.size(); i++) {
			filasTabla[i][0] = getLibro(i).getISBN();
			filasTabla[i][1] = getLibro(i).getTitulo();
			filasTabla[i][2] = getLibro(i).getEditorial();
			filasTabla[i][3] = getLibro(i).getAutor();
			filasTabla[i][4] = getLibro(i).getPrecio();
			filasTabla[i][5] = getLibro(i).getFormato();
			filasTabla[i][6] = getLibro(i).getEstado();
			filasTabla[i][7] = getLibro(i).getCantidad();
		}
		tablaCompleta = new DefaultTableModel(filasTabla, nombresColumnas);
		tablaLibros.setModel(tablaCompleta);
	}

	private String obtenerISBNconcreto(int i) {
		Set<String> conjunto = this.mapaLibro.keySet();
		Object[] array = conjunto.toArray();
		String ISBN = (String) array[i];
		return ISBN;
	}

	@Override
	public Libro obtenerLibro(String ISBN) {
		return this.mapaLibro.get(ISBN);
	}
	
	@Override
	public boolean existeISBN(String ISBN) {
		return this.mapaLibro.containsKey(ISBN);
	}
	
	public HashMap<String, Libro> getHashMapLibro() {
		return this.mapaLibro;
	}
	
	@Override
	public boolean isVacia() {
		if (mapaLibro.isEmpty()) {
			return true;
		}
		return false;
	}
	
	@Override
	public Libro getLibro(int i) {
		String ISBN = obtenerISBNconcreto(i);
		return obtenerLibro(ISBN);
	}
	@Override
	public void anadirLibro(Libro libro) {
		leer();
		this.mapaLibro.put(libro.getISBN(), libro);
		guardar();
		actualizarContador();
	}
	
	@Override
	public void guardar() {
		almacen.almacenarMapa(this.mapaLibro);

	}

	@SuppressWarnings("unchecked")
	@Override
	public void leer() {
		this.mapaLibro = (HashMap<String, Libro>) almacen.getAlmacenado();
	}

	@Override
	public void borrar(int i) {
		leer();
		String ISBN = obtenerISBNconcreto(i);
		mapaLibro.remove(ISBN);
		guardar();

	}



	@Override
	public int actualizarContador() {
		return contadorLibros = mapaLibro.size();
	}

	@Override
	public int getContadorLibros() {
		return contadorLibros;
	}

}
