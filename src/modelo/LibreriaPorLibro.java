package modelo;

public class LibreriaPorLibro extends Libreria {

	private Almacen almacen;

	public LibreriaPorLibro() {
		super();
		this.almacen = new AlmacenFicheros("data.libros");
		iniciar();
	}

	public void guardarPorLibro(Libro libro) {
		almacen.almacenarLibro(libro);

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
