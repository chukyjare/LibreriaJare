package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AlmacenSQL extends Almacen{
	
	private Statement miStatement = null;
	private PreparedStatement miPreparedStatement=null;
	private ResultSet miResulset = null;
	
	@Override
	public boolean actualizar() {
		return false;}
	
	@Override
	public boolean almacenar(Object obj) {
		return false;}
	
	@Override
	public Object getAlmacenado() {
//		try {
//		miConexion = DriverManager.getConnection(AccesoBBDD.nombreBD, AccesoBBDD.usuario, AccesoBBDD.password);
//		miStatement = AccesoBBDD.miConexion.createStatement();
//		miResulset = miStatement.executeQuery("SELECT * FROM LIBRO");
//
//		while (miResulset.next()) {
////			System.out.println("[Cliente]");
////			System.out.println("ID: " + miResulset.getString(1));
////			System.out.println("Nombre: " + miResulset.getString(2));
////			System.out.println("Apellidos: " + miResulset.getString(3));
////			System.out.println("DNI: " + miResulset.getString(4));
////			System.out.println();
//			
//
//		}
//	} catch (Exception e) {
//		e.printStackTrace();
//	} finally {
//		try {
//			if (miConexion != null) {
//				miConexion.close();
//			}
//			if (miStatement != null) {
//				miStatement.close();
//			}
//			if (miResulset != null) {
//				miResulset.close();
//			}
//		} catch (Exception e2) {
//			e2.printStackTrace();
//		}
//	}
		return null;}
	
}
