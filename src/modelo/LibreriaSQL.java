package modelo;

import java.sql.SQLException;

public class LibreriaSQL extends Libreria {

	private Almacen almacen;

	public LibreriaSQL() {
		super();
		almacen = new AlmacenSQL();
		iniciar();
	}

	@Override
	public void anadirLibro(Libro libro) {

		contadorLibros = arrayLibro.size();
		try {
			regitrarLibro(libro);
			guardar();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void regitrarLibro(Libro libro) throws SQLException {
		almacen.insertarLibro(libro);

	}

	@Override
	public void guardar() {
		if (almacen.comprobarModificado()) {
			almacen.modificarLibro();
		}
		this.arrayLibro = almacen.getArrayList();

	}

	@Override
	public void leer() {
		almacen.almacenarAll();
		this.arrayLibro = almacen.getArrayList();
	}

	@Override
	public void borrar(int i) {
		almacen.borrarPorISBN(obtenerISBNconcreto(i));
		borrarLibro(i);
		almacen.setArrayList(arrayLibro);
	}

}
