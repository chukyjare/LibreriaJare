package modelo;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public abstract class Libreria implements Almacenable {
	protected ArrayList<Libro> arrayLibro;
	protected int contadorLibros = 0;
	protected DefaultTableModel tablaCompleta;
	private final byte NUM_FILAS = 9;

	public void iniciar() {
		try {
			leer();
		} catch (Exception e) {
		}
		if (this.arrayLibro == null) {
			this.arrayLibro = new ArrayList<Libro>();

		}

	}

	public void anadirLibro(Libro libro) {
	}

	protected String obtenerISBNconcreto(int i) {
		return arrayLibro.get(i).getISBN();
	}

	public void rellenarTabla(JTable tablaLibros) {

		String[] nombresColumnas = { "ISBN", "TÍTULO", "EDITORIAL", "AUTOR", "PRECIO", "FORMATO", "ESTADO", "TEMÁTICA",
				"CANTIDAD" };
		String[][] filasTabla = new String[arrayLibro.size()][NUM_FILAS];
		System.out.println(arrayLibro.size());
		for (int i = 0; i < arrayLibro.size(); i++) {
			filasTabla[i][0] = arrayLibro.get(i).getISBN();
			filasTabla[i][1] = arrayLibro.get(i).getTitulo();
			filasTabla[i][2] = arrayLibro.get(i).getEditorial();
			filasTabla[i][3] = arrayLibro.get(i).getAutor();
			filasTabla[i][4] = arrayLibro.get(i).getPrecio();
			filasTabla[i][5] = arrayLibro.get(i).getFormato();
			filasTabla[i][6] = arrayLibro.get(i).getEstado();
			filasTabla[i][7] = arrayLibro.get(i).getTematica();
			filasTabla[i][8] = arrayLibro.get(i).getCantidad();
		}
		tablaCompleta = new DefaultTableModel(filasTabla, nombresColumnas);
		tablaLibros.setModel(tablaCompleta);
	}

	public Libro obtenerLibro(String ISBN) {

		for (int i = 0; i < this.arrayLibro.size(); i++) {
			if (this.arrayLibro.get(i).getISBN().equals(ISBN)) {
				return arrayLibro.get(i);
			}
		}
		return null;
	}

	public boolean existeISBN(String ISBN) {

		for (int i = 0; i < this.arrayLibro.size(); i++) {
			if (this.arrayLibro.get(i).getISBN().equals(ISBN)) {
				return true;
			}
		}
		return false;
	}

	public DefaultTableModel getTablaCompleta() {
		return tablaCompleta;
	}

	public int actualizarContador() {
		return contadorLibros = arrayLibro.size();
	}

	public int getContadorLibros() {
		return contadorLibros;
	}

	public void borrarLibro(int indice) {
		arrayLibro.remove(indice);
	}

	public ArrayList<Libro> getArrayLibro() {
		return arrayLibro;
	}

	public boolean isVacia() {
		if (arrayLibro.isEmpty()) {
			return true;
		}
		return false;
	}

	public Libro getLibro(int i) {
		return arrayLibro.get(i);
	}

}
