package modelo;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LibreriaPorArray extends Libreria {
	private final byte NUM_FILAS = 8;

	public LibreriaPorArray() {
		super();
		this.almacen = new Almacen("data.librosArray");
		iniciar();
	}
	
	@Override
	public void rellenarTabla(JTable tablaLibros) {
		
		String[] nombresColumnas = { "ISBN", "TÍTULO", "EDITORIAL", "AUTOR", "PRECIO", "FORMATO", "ESTADO",
		"CANTIDAD" };
		String[][] filasTabla = new String[arrayLibro.size()][NUM_FILAS];
		for (int i = 0; i < arrayLibro.size(); i++) {
			filasTabla[i][0] = arrayLibro.get(i).getISBN();
			filasTabla[i][1] = arrayLibro.get(i).getTitulo();
			filasTabla[i][2] = arrayLibro.get(i).getEditorial();
			filasTabla[i][3] = arrayLibro.get(i).getAutor();
			filasTabla[i][4] = arrayLibro.get(i).getPrecio();
			filasTabla[i][5] = arrayLibro.get(i).getFormato();
			filasTabla[i][6] = arrayLibro.get(i).getEstado();
			filasTabla[i][7] = arrayLibro.get(i).getCantidad();
		}
		tablaCompleta = new DefaultTableModel(filasTabla, nombresColumnas);
		tablaLibros.setModel(tablaCompleta);
	}

	@Override
	public void anadirLibro(Libro libro) {

		arrayLibro.add(libro);
		contadorLibros = arrayLibro.size();
		guardar();

	}

	@Override
	public void guardar() {
		almacen.almacenar(arrayLibro);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void leer() {
		this.arrayLibro = (ArrayList<Libro>) almacen.getAlmacenado();

	}

	@Override
	public void borrar(int indice) {
		borrarLibro(indice);
	}
	
}
