package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import controlador.acceso.AccesoBBDD;

public class AlmacenSQL extends Almacen {

	private ResultSet miResulset = null;
	@SuppressWarnings("unused")
	private Connection miConexion = null;
	private Libro libroModificado;

	public AlmacenSQL() {
		super();
		arrayList = new ArrayList<Libro>();
		miConexion = AccesoBBDD.getConnection();
	}

	// Procedure que registra el libro en la base de datos con throw
	@Override
	protected boolean insertarLibro(Libro libro) throws SQLException {
		Connection miConexion = DriverManager.getConnection(AccesoBBDD.nombreBD, AccesoBBDD.usuario,
				AccesoBBDD.password);
		CallableStatement miStatement = (CallableStatement) miConexion
				.prepareCall("{CALL registrarLibro(?,?,?,?,?,?,?,?,?,?)}");
		miStatement.setString(1, libro.getISBN());
		miStatement.setString(2, libro.getAutor());
		miStatement.setString(3, libro.getTitulo());
		miStatement.setString(4, libro.getEditorial());
		miStatement.setInt(5, getId(libro.getTematica(), "tematica"));
		miStatement.setInt(6, getId(libro.getEstado(), "estado"));
		miStatement.setInt(7, getId(libro.getFormato(), "formato"));
		miStatement.setInt(8, Integer.parseInt(libro.getCantidad()));
		miStatement.setFloat(9, Float.parseFloat(libro.getPrecio().substring(0, libro.getPrecio().length() - 1)));
		miStatement.registerOutParameter(10, Types.BOOLEAN);
		miStatement.execute();
		arrayList.add(libro);
		return miStatement.getBoolean(10);

	}

	@Override
	protected boolean comprobarModificado() {
		boolean modificado = true;
		int i = 0;
		try (Connection miConexion = DriverManager.getConnection(AccesoBBDD.nombreBD, AccesoBBDD.usuario,
				AccesoBBDD.password); Statement miStatement = miConexion.createStatement();) {
			miResulset = miStatement.executeQuery("SELECT * FROM LIBRO");
			while (miResulset.next()) {
				Libro libro = arrayList.get(i);
				if (libro.getISBN().equals(miResulset.getString(2)) && libro.getAutor().equals(miResulset.getString(3))
						&& libro.getTitulo().equals(miResulset.getString(4))
						&& libro.getEditorial().equals(miResulset.getString(5))
						&& libro.getTematica().equals(
								String.valueOf(Tematica.values()[Integer.parseInt(miResulset.getString(6)) - 1]))
						&& libro.getEstado()
								.equals(String.valueOf(Estado.values()[Integer.parseInt(miResulset.getString(7)) - 1]))
						&& libro.getFormato()
								.equals(String.valueOf(Formato.values()[Integer.parseInt(miResulset.getString(8)) - 1]))
						&& libro.getCantidad().equals(miResulset.getString(9))
						&& libro.getPrecio().equals(miResulset.getString(10))) {
					modificado = false;
				} else {
					modificado = true;
					libroModificado = libro;
					return modificado;
				}
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// Procedure que modifica un libro de la base de datos con try/catch
	@Override
	protected boolean modificarLibro() {

		try (Connection miConexion = DriverManager.getConnection(AccesoBBDD.nombreBD, AccesoBBDD.usuario,
				AccesoBBDD.password);
				CallableStatement miStatement = (CallableStatement) miConexion
						.prepareCall("{CALL modificarLibro(?,?,?,?,?,?,?,?)}");) {
			miStatement.setString(1, libroModificado.getISBN());
			miStatement.setString(2, libroModificado.getAutor());
			miStatement.setString(3, libroModificado.getTitulo());
			miStatement.setString(4, libroModificado.getEditorial());
			miStatement.setInt(5, Integer.parseInt(libroModificado.getCantidad()));
			miStatement.setFloat(6, Float
					.parseFloat(libroModificado.getPrecio().substring(0, libroModificado.getPrecio().length() - 1)));
			miStatement.setInt(7, getId(libroModificado.getTematica(), "tematica"));
			miStatement.registerOutParameter(8, Types.BOOLEAN);
			miStatement.execute();
			return miStatement.getBoolean(8);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	// Consulta normal con Statement para almacenar los libros de la base de datos,
	@Override
	protected void almacenarAll() {

		try (Connection miConexion = DriverManager.getConnection(AccesoBBDD.nombreBD, AccesoBBDD.usuario,
				AccesoBBDD.password); Statement miStatement = miConexion.createStatement();) {
			miResulset = miStatement.executeQuery("SELECT * FROM LIBRO");
			while (miResulset.next()) {
				Libro libro = new Libro(miResulset.getString(2), miResulset.getString(4), miResulset.getString(3),
						miResulset.getString(5), miResulset.getString(10),
						String.valueOf(Formato.values()[Integer.parseInt(miResulset.getString(8)) - 1]),
						String.valueOf(Estado.values()[Integer.parseInt(miResulset.getString(7)) - 1]),
						String.valueOf(Tematica.values()[Integer.parseInt(miResulset.getString(6)) - 1]),
						miResulset.getString(9));
				this.arrayList.add(libro);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// PreparedStatement para borrar un libro de la base de datos
	@Override
	protected boolean borrarPorISBN(String isbn) {
		try (Connection miConexion = DriverManager.getConnection(AccesoBBDD.nombreBD, AccesoBBDD.usuario,
				AccesoBBDD.password);
				PreparedStatement miStatement = generarParametrizada("DELETE FROM `libro` WHERE `isbn` = ?", isbn,
						miConexion)) {
			miStatement.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private PreparedStatement generarParametrizada(String sql, String nombre, Connection conexion) throws SQLException {
		PreparedStatement consulta = conexion.prepareStatement(sql);
		consulta.setString(1, nombre);
		return consulta;
	}

	// Intentaré refactorizarlo poniendo este método en cada enum para que me de su
	// id
	private int getId(String nombre, String enumTipo) {
		int id = 0;
		if (enumTipo.equals("tematica")) {
			for (int i = 0; i < Tematica.values().length; i++) {
				if (String.valueOf(Tematica.values()[i]).equals(nombre)) {
					id = i + 1;
				}
			}
		}
		if (enumTipo.equals("estado")) {
			for (int i = 0; i < Estado.values().length; i++) {
				if (String.valueOf(Estado.values()[i]).equals(nombre)) {
					id = i + 1;
				}
			}
		}
		if (enumTipo.equals("formato")) {
			for (int i = 0; i < Formato.values().length; i++) {
				if (String.valueOf(Formato.values()[i]).equals(nombre)) {
					id = i + 1;
				}
			}
		}
		return id;
	}
}
