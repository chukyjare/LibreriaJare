package controlador;



import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Libreria;


public class Control {
	private Libreria libreria;
	private DefaultTableModel tablaCompleta;
	private final byte NUM_FILAS=8;
	

	
	public Control() {
		super();
		this.libreria = new Libreria();
		this.tablaCompleta=libreria.getTablaCompleta();
	}

	
	public Libreria getLibreria() {
		return libreria;
	}
	
	public DefaultTableModel getTablaCompleta() {
		return tablaCompleta;
	}


	public void rellenarTabla(JTable tablaLibros) {
		String[] nombresColumnas = { "ISBN", "TÍTULO", "EDITORIAL", "AUTOR", "PRECIO", "FORMATO", "ESTADO", "CANTIDAD" };
		String[][] filasTabla = new String[libreria.getHashMapLibro().size()][NUM_FILAS];
		for (int i = 0; i < libreria.getHashMapLibro().size(); i++) {
//			Libro libro = libreria.getLibro(i);
			filasTabla[i][0] = libreria.getLibro(i).getISBN();
			filasTabla[i][1] = libreria.getLibro(i).getTitulo();
			filasTabla[i][2] = libreria.getLibro(i).getEditorial();
			filasTabla[i][3] = libreria.getLibro(i).getAutor();
			filasTabla[i][4] = libreria.getLibro(i).getPrecio();
			filasTabla[i][5] = libreria.getLibro(i).getFormato();
			filasTabla[i][6] = libreria.getLibro(i).getEstado();
			filasTabla[i][7] = libreria.getLibro(i).getCantidad();
		}
		tablaCompleta = new DefaultTableModel(filasTabla, nombresColumnas);
		tablaLibros.setModel(tablaCompleta);
	}
}
