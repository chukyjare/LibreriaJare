package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import controlador.acceso.AccesoBBDD;

public class LibreriaSQL extends Libreria{
	
	private Connection miConexion=null;

	

	public LibreriaSQL() {
		super();
		miConexion = AccesoBBDD.getConnection();
	}
	
	@Override
	public void guardar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leer() {
		// TODO Auto-generated method stub
	}

	@Override
	public void borrar(int i) {
		// TODO Auto-generated method stub
		
	}
	
	public Connection getMiConexion() {
		return miConexion;
	}

}
