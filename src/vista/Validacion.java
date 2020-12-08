package vista;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import utiles.Validaciones;

public class Validacion {

	private String nombre;
	private boolean estado = false;

	public Validacion() {
	}

	public Validacion(String nombre) {
		super();
		this.nombre = nombre;
	}

	public void validar(String nombre, JTextField txt) {
		if (nombre.equals("ISBN")) {
			validarISBN(txt);
		}
		if (nombre.equals("Título")) {
			validarLetrasYNumeros(txt);
		}
		if (nombre.equals("Editorial") || nombre.equals("Autor") || nombre.equals("Temática")) {
			validarLetras(txt);
		}
		if (nombre.equals("Precio")) {
			validarFloat(txt);
		}
		if (nombre.equals("Cantidad")) {
			validarNumeros(txt);
		}
	}

	private void validarNumeros(JTextField txt) {
		if (Validaciones.validaNumeros(txt.getText())) {
			txt.setBorder(new LineBorder(Color.GREEN, 3));
			estado = true;
		} else {
			txt.setBorder(new LineBorder(new Color(255, 0, 0), 3));
			estado = false;
		}
		
	}

	public boolean validarCampos(ArrayList<JTextField> listaTexfields, ArrayList<JLabel> listaLabels) {
		int cont = 0;
		for (int i = 0; i < listaTexfields.size(); i++) {
			Validacion validacion = new Validacion(listaLabels.get(i).getText());
			validacion.validar(validacion.getNombre(), listaTexfields.get(i));
			if (validacion.isEstado()) {
				cont++;
			}

		}
		return cont == listaTexfields.size();

	}

	private void validarISBN(JTextField txt) {
		
		if (Validaciones.validaISBN(txt.getText())) {
			txt.setBorder(new LineBorder(Color.GREEN, 3));
			estado = true;
		} else {
			txt.setBorder(new LineBorder(new Color(255, 0, 0), 3));
			estado = false;
		}

	}

	private void validarFloat(JTextField txt) {
		if (Validaciones.validaFloat(txt.getText())) {
			txt.setBorder(new LineBorder(Color.GREEN, 3));
			estado = true;
		} else {
			txt.setBorder(new LineBorder(new Color(255, 0, 0), 3));
			estado = false;
		}

	}

	private void validarLetras(JTextField txt) {
		if (Validaciones.validaLetras(txt.getText())) {
			txt.setBorder(new LineBorder(Color.GREEN, 3));
			estado = true;
		} else {
			txt.setBorder(new LineBorder(new Color(255, 0, 0), 3));
			estado = false;
		}
	}

	private void validarLetrasYNumeros(JTextField txt) {
		if (Validaciones.validaLetrasYNumeros(txt.getText())) {
			txt.setBorder(new LineBorder(Color.GREEN, 3));
			estado = true;
		} else {
			txt.setBorder(new LineBorder(new Color(255, 0, 0), 3));
			estado = false;
		}

	}

	public String getNombre() {
		return nombre;
	}

	public boolean isEstado() {
		return estado;
	}
}
