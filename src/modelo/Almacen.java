package modelo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public abstract class Almacen {
	
	public boolean actualizar() {
		return false;}
	public boolean almacenar(Object obj) {
		return false;}
	public Object getAlmacenado() {
		return null;}
}
