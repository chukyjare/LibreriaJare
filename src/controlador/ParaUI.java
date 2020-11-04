package controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import modelo.Error;
import modelo.Info;
import modelo.Libreria;
import modelo.Libro;
import utiles.Validaciones;
import vista.ConsultaDialog;
import vista.UI;

public class ParaUI extends UI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Control control = new Control();
	private String librosAñadidos ="Libros registrados: ";
	private int unidades;
	
	public ParaUI() {
		Libreria libreria = control.getLibreria();
		lblError.setVisible(false);
		lblCorrect.setVisible(false);
		comprobarLibreriaVacia(libreria);

		txtISBN.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				int MAX_CARACTER = 12;
				if (txtISBN.getText().length() == MAX_CARACTER) {
					lblCorrect.setVisible(true);
					lblError.setVisible(false);
				} else {
					lblCorrect.setVisible(false);
					lblError.setVisible(true);
				}
			}
		});
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validarCampos()) {

					if (!libreria.existeISBN(txtISBN.getText())) {

						libreria.anadirLibro(new Libro(txtISBN.getText(), txtTitulo.getText(), txtAutor.getText(),
								txtEditorial.getText(), txtPrecio.getText() + "€", getRadioButtonFormato(),
								getRadioButtonEstado(), String.valueOf(spinner.getValue())));
						actualizarLibrosRegistrados(libreria);
						borrarCampos();
						control.rellenarTabla(tablaLibros);
						comprobarLibreriaVacia(libreria);

					} else {
						JOptionPane.showMessageDialog(null, Error.ERROR_ISBN_EXISTENTE.getMensaje());
					}
				} else {
					JOptionPane.showMessageDialog(null, Error.ERROR_CAMPOSINCORRECTOS.getMensaje());
				}
			}

		});

		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Libreria libreria = control.getLibreria();
				libreria.borrarLibro(tablaLibros.getSelectedRow());
				control.rellenarTabla(tablaLibros);
				JOptionPane.showMessageDialog(null, Info.INFO_BORRADO.getMensaje());
				comprobarLibreriaVacia(libreria);
				actualizarLibrosRegistrados(libreria);
			}
		});
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Libreria libreria = control.getLibreria();
				String ISBNsel = JOptionPane.showInputDialog(Info.INFO_INTRODUCE.getMensaje());		
				try {
//					lblUltimoAñadido.setVisible(true);
//					mostrarCampos(libreria.getLibro(tablaLibros.getRowCount()-1));
					JOptionPane.showMessageDialog(null, libreria.obtenerLibro(ISBNsel).toString());
					borrarCampos();
					lblUltimoAñadido.setVisible(false);
				} catch (Exception ee) {
					JOptionPane.showMessageDialog(null, Error.ERROR_ILOCALIZABLE.getMensaje());
				}
			}

		});
		btnOjoConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Libreria libreria = control.getLibreria();
					JOptionPane.showMessageDialog(null, libreria.getLibro(tablaLibros.getSelectedRow()).toString());
					
				} catch (Exception ee) {
					JOptionPane.showMessageDialog(null, Error.ERROR_NOSELECCIONADO.getMensaje());
				}
			}
		});
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					crearConsulta();
					unidades = Integer.parseInt(libreria.getLibro(tablaLibros.getSelectedRow()).getCantidad());
					if (unidades<=0) {
						borrarLibroSeleccionado(libreria);
					}
					control.rellenarTabla(tablaLibros);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, Error.ERROR_NOSELECCIONADO.getMensaje());
				}

			}


		});
		btnBorraUnidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Libreria libreria = control.getLibreria();	
					unidades = Integer.parseInt(libreria.getLibro(tablaLibros.getSelectedRow()).getCantidad());
					unidades--;
					libreria.getLibro(tablaLibros.getSelectedRow()).setCantidad(String.valueOf(unidades));
					if (unidades==0) {
						borrarLibroSeleccionado(libreria);
					}
					control.rellenarTabla(tablaLibros);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, Error.ERROR_NOSELECCIONADO.getMensaje());
				}

			}

		});
		btnCompraUnidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					unidades = Integer.parseInt(libreria.getLibro(tablaLibros.getSelectedRow()).getCantidad());
					unidades++;
					libreria.getLibro(tablaLibros.getSelectedRow()).setCantidad(String.valueOf(unidades));
					control.rellenarTabla(tablaLibros);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, Error.ERROR_NOSELECCIONADO.getMensaje());
				}

			}

		});
		btnConfiguration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.setVisible(!panelMenu.isVisible());
				if (panelMenu.isVisible()) {
					btnConfiguration.setIcon(new ImageIcon(UI.class.getResource("/img/configure.png")));
				} else {
					btnConfiguration.setIcon(new ImageIcon(UI.class.getResource("/img/settings.png")));
				}
			}
		});
		itemOriginal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pintarBotones(Color.WHITE, Color.BLACK);
				pintarPaneles(Color.DARK_GRAY, SystemColor.windowBorder);
				cambiarCabecera(new Font("Candara", Font.BOLD | Font.ITALIC, 25), SystemColor.controlHighlight);
				lblFondo.setIcon(new ImageIcon(UI.class.getResource("/img/book.png")));
			}
		});
		itemClasico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pintarBotones(Color.BLACK, UIManager.getColor("Button.light"));
				pintarPaneles(SystemColor.controlShadow, SystemColor.activeCaption);
				cambiarCabecera(new Font("Arial Black", Font.BOLD, 25), Color.black);
				lblFondo.setIcon(new ImageIcon(UI.class.getResource("/img/oldBook.png")));
			}
		});
		itemSimpsons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pintarBotones(Color.WHITE, new Color(255, 102, 153));
				pintarPaneles(new Color(77, 166, 255), new Color(255, 255, 77));
				cambiarCabecera(new Font("Ink Free", Font.BOLD, 28), new Color(255, 255, 77));
				lblFondo.setIcon(new ImageIcon(UI.class.getResource("/img/simpsonsSchool.png")));
			}
		});
		itemImgEstatica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblFondo.setIcon(new ImageIcon(UI.class.getResource("/img/book.png")));
			}
		});
		itemVacio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblFondo.setIcon(null);
			}
		});
		itemGIF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblFondo.setIcon(new ImageIcon(UI.class.getResource("/img/giphy (1).gif")));
			}
		});
		itemAmarillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLibro.setBackground(new Color(255, 255, 102));
				pintarLetras(Color.black);
			}
		});
		itemButtonLight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLibro.setBackground(UIManager.getColor("Button.light"));
				pintarLetras(Color.black);
			}
		});
		itemAzul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLibro.setBackground(new Color(102, 163, 255));
				pintarLetras(Color.white);
			}
		});
		itemRojo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLibro.setBackground(new Color(255, 77, 77));
				pintarLetras(Color.white);
			}
		});
		itemOscuro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLibro.setBackground(new Color(51, 51, 51));
				pintarLetras(Color.white);

			}
		});
		itemPequena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBounds(100, 100, 1280, 750);
				cambiarFuente(16);
			}
		});
		itemMediana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBounds(100, 100, 1500, 900);
				cambiarFuente(20);
			}

		});
		itemGrande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBounds(0, 0, 2000, 1000);
				cambiarFuente(28);
			}
		});
	}

	private void borrarLibroSeleccionado(Libreria libreria) {
		libreria.borrarLibro(tablaLibros.getSelectedRow());
		actualizarLibrosRegistrados(libreria);
		JOptionPane.showMessageDialog(null, Info.INFO_BORRADO.getMensaje());
	}
	private void actualizarLibrosRegistrados(Libreria libreria) {
		lblCantidadLibros.setText(librosAñadidos + String.valueOf(libreria.actualizarContador()));
	}
	private JDialog crearConsulta() {
		Libreria libreria = control.getLibreria();
		ConsultaDialog consultaDialog = new ConsultaDialog(this, true, libreria.getLibro(tablaLibros.getSelectedRow()));
		consultaDialog.setVisible(true);
		return consultaDialog;
	}
	
	private boolean comprobarLibreriaVacia(Libreria libreria) {
		if (libreria.isVacia()) {
			btnBorrar.setEnabled(false);
			btnConsultar.setEnabled(false);
			btnOjoConsulta.setVisible(false);
			btnEditar.setVisible(false);
			btnCompraUnidad.setVisible(false);
			btnBorraUnidad.setVisible(false);
			return true;
		} else {
			btnBorrar.setEnabled(true);
			btnConsultar.setEnabled(true);
			btnOjoConsulta.setVisible(true);
			btnEditar.setVisible(true);
			btnCompraUnidad.setVisible(true);
			btnBorraUnidad.setVisible(true);
			return false;
		}
	}

	private boolean validarCampos() {
		return Validaciones.validaISBN(txtISBN.getText()) && Validaciones.validaLetras(txtAutor.getText())
				&& Validaciones.validaLetras(txtEditorial.getText()) && Validaciones.validaFloat(txtPrecio.getText())
				&& grupoRatioButtonIsEmpty(grupoFormato) && grupoRatioButtonIsEmpty(grupoEstado);
	}

	private boolean grupoRatioButtonIsEmpty(ButtonGroup grupo) {
		for (Enumeration<AbstractButton> buttons = grupo.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();
			if (button.isSelected()) {
				return true;
			}
		}
		return false;
	}

	private String getRadioButtonFormato() {
		if (rbtnCartone.isSelected()) {
			return rbtnCartone.getText();
		}
		if (rbtnEspiral.isSelected()) {
			return rbtnEspiral.getText();
		}
		if (rbtnGrapada.isSelected()) {
			return rbtnGrapada.getText();
		}
		if (rbtnRustica.isSelected()) {
			return rbtnRustica.getText();
		}
		return null;
	}

	private String getRadioButtonEstado() {
		if (rbtnNovedad.isSelected()) {
			return rbtnNovedad.getText();
		}
		if (rbtnReedicion.isSelected()) {
			return rbtnReedicion.getText();
		}

		return null;
	}
	
}
