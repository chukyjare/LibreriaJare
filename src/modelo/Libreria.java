package modelo;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public abstract class Libreria implements Almacenable {
	protected ArrayList<Libro> arrayLibro;
	protected int contadorLibros = 0;
	protected DefaultTableModel tablaCompleta;
//	protected Almacen almacen;



	public void iniciar() {
		try {
			leer();
		} catch (Exception e) {
		}
		if (this.arrayLibro == null) {
			this.arrayLibro = new ArrayList<Libro>();

		}
		

	}
	
	public void anadirLibro(Libro libro) {}
	
public void rellenarTabla(JTable tablaLibros) {}
	
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
