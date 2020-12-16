package controlador.acceso;

import java.sql.Connection;
import java.sql.DriverManager;


public class AccesoBBDD {
	
	public static String usuario ="root";
	public static String password ="";
	public static String nombreBD ="jdbc:mysql://localhost:3306/libreria";
	public static Connection miConexion=null;
	
	public static Connection getConnection(){
		if (miConexion==null) {
			try {
				miConexion = DriverManager.getConnection(nombreBD, usuario, password);
				return miConexion;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return miConexion;
	}
	
	public static void closeConnection() {
		try {
			miConexion.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
