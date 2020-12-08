package controlador.acceso;

import java.sql.Connection;
import java.sql.DriverManager;


public class AccesoBBDD {
	
	public final static String usuario ="root";
	public final static String password ="";
	public static String nombreBD ="jdbc:mysql://localhost/libreria";
	private static String driver = "com.mysql.jdbc.Driver";
	public static Connection miConexion = null;
	
	
	public static Connection getConnection(){
		if (miConexion==null) {
			try {
				Class.forName(driver);
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
