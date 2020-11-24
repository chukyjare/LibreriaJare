package modelo;



import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LibreriaPorLibro extends Libreria {
	
	private final byte NUM_FILAS = 8;
	
	public LibreriaPorLibro() {
		super();
		this.almacen = new Almacen("data.libros");
		iniciar();
	}
	
	public void guardarPorLibro(Libro libro) {
		almacen.almacenarLibro(libro);
		
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
		
		contadorLibros = arrayLibro.size();
		guardarPorLibro(libro);
		
	}

	@Override
	public void guardar() {
		almacen.actualizar();
	}

	@Override
	public void leer() {
		almacen.almacenarAll();
		this.arrayLibro = almacen.getArrayList();
		
	}


	@Override
	public void borrar(int indice) {
		borrarLibro(indice);
		almacen.setArrayList(arrayLibro);
		guardar();
	}

	
	

}
