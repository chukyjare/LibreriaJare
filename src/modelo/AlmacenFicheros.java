package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AlmacenFicheros extends Almacen {

	private File fichero;
	private FileOutputStream flujoEscritura;
	private FileInputStream flujoLectura;
	private ObjectInputStream adaptadorLectura;
	private ObjectOutputStream adaptadorEscritura;

	public AlmacenFicheros(String nombre) {
		super();
		arrayList = new ArrayList<Libro>();
		fichero = new File(nombre);
		comprobarFichero();
	}

	@Override
	protected boolean almacenar(Object objeto) {
		try {
			flujoEscritura = new FileOutputStream(fichero);
			adaptadorEscritura = new ObjectOutputStream(flujoEscritura);
			adaptadorEscritura.writeObject(objeto);
			try {
				arrayList.add((Libro) objeto);
			} catch (Exception e) {
				System.out.println("{Libro registrado}");
			} finally {
				adaptadorEscritura.close();
				flujoEscritura.close();
			}
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	@Override
	protected boolean actualizar() {
		try {
			flujoEscritura = new FileOutputStream(fichero);
			adaptadorEscritura = new ObjectOutputStream(flujoEscritura);
			for (int i = 0; i < arrayList.size(); i++) {
				adaptadorEscritura.writeObject(arrayList.get(i));
			}
			adaptadorEscritura.close();
			flujoEscritura.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	@Override
	protected Object getAlmacenado() {
		Object objeto = null;
		try {
			flujoLectura = new FileInputStream(fichero);
			try {
				adaptadorLectura = new ObjectInputStream(flujoLectura);
				objeto = adaptadorLectura.readObject();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				adaptadorLectura.close();
				flujoLectura.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return objeto;
	}

	@Override
	protected boolean almacenarMapa(Object objeto) {
		try {
			flujoEscritura = new FileOutputStream(fichero);
			adaptadorEscritura = new ObjectOutputStream(flujoEscritura);
			adaptadorEscritura.writeObject(objeto);
			adaptadorEscritura.close();
			flujoEscritura.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	@Override
	protected boolean almacenarLibro(Libro libro) {
		try {
			flujoEscritura = new FileOutputStream(fichero);
			adaptadorEscritura = new ObjectOutputStream(flujoEscritura);
			arrayList.add(libro);
			for (int i = 0; i < arrayList.size(); i++) {
				adaptadorEscritura.writeObject(arrayList.get(i));
			}
			adaptadorEscritura.close();
			flujoEscritura.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	@Override
	protected void almacenarAll() {
		try {
			flujoLectura = new FileInputStream(fichero);
			adaptadorLectura = new ObjectInputStream(flujoLectura);
			Libro libro = (Libro) adaptadorLectura.readObject();
			while (libro != null) {
				arrayList.add(libro);
				libro = (Libro) adaptadorLectura.readObject();
			}

		} catch (IOException | ClassNotFoundException e) {

		} finally {
			try {
				this.flujoLectura.close();
				this.adaptadorLectura.close();

			} catch (Exception e) {
			}
		}
	}

	private void comprobarFichero() {
		if (!fichero.exists()) {
			try {
				fichero.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
