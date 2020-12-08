package modelo;

import java.io.Serializable;

public class Libro implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ISBN;
	private String titulo;
	private String autor;
	private String editorial;
	private String precio;
	private String formato;
	private String tematica;
	private String estado;
	public void setTematica(String tematica) {
		this.tematica = tematica;
	}

	private String cantidad;

	public Libro(String iSBN, String titulo, String autor, String editorial, String precio, String formato,
			String tematica, String estado, String cantidad) {
		super();
		ISBN = iSBN;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.precio = precio;
		this.formato = formato;
		this.tematica = tematica;
		this.estado = estado;
		this.cantidad = cantidad;
	}

	public String getTematica() {
		return tematica;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getCantidad() {
		return cantidad;
	}

	public String getFormato() {
		return formato;
	}

	public String getEstado() {
		return estado;
	}

	public String getISBN() {
		return ISBN;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public String getPrecio() {
		return precio;
	}

	@Override
	public String toString() {
		return "LIBRO ENCONTRADO" + "\n \n ISBN: " + this.ISBN + "\n Título: " + this.titulo + "\n Autor: " + this.autor
				+ "\n Editorial: " + this.editorial + "\n Precio: " + this.precio + 
				"\n Formato: " + this.formato+ "\n Tematica: " + this.tematica
				+ "\n Estado: " + this.estado+ "\n Cantidad: " + this.cantidad;
	}

}
