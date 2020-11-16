package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Almacen {
	
	private File fichero;
	private FileOutputStream flujoEscritura;
	private FileInputStream flujoLectura;
	private ObjectInputStream adaptadorLectura;
	private ObjectOutputStream adaptadorEscritura;

	public Almacen(String nombre) {
		super();
		fichero = new File(nombre);
		comprobarFichero();
	}

	public boolean almacenar(Object objeto) {
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

	public Object getAlmacenado() {
		Object objeto = null;
		try {
			flujoLectura = new FileInputStream(fichero);
			adaptadorLectura = new ObjectInputStream(flujoLectura);
			objeto = adaptadorLectura.readObject();
			adaptadorLectura.close();
			flujoLectura.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return objeto;
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
