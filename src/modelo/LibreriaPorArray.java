package modelo;

import java.util.ArrayList;

public class LibreriaPorArray extends Libreria {
	protected Almacen almacen;

	public LibreriaPorArray() {
		super();
		this.almacen = new AlmacenFicheros("data.librosArray");
		iniciar();
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
