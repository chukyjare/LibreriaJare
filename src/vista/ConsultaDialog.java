package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import modelo.Error;
import modelo.Libro;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import modelo.Tematica;

public class ConsultaDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtEditorial;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JLabel lblTitulo;
	private JLabel lblAutor;
	private JLabel lblEditorial;
	private JLabel lblPrecio;
	private JLabel lblCantidad;
	private ArrayList<JTextField> listaTexfields = new ArrayList<JTextField>();
	private ArrayList<JLabel> listaLabels = new ArrayList<JLabel>();
	private JPanel panelTematica;
	private JComboBox<Tematica> comBoxTematica;

	public ConsultaDialog(JFrame padre, boolean modo, Libro libro) {
		super(padre, modo);
		setTitle("Editar");

		setBounds(600, 300, 352, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);

		lblTitulo = new JLabel("Título");
		lblTitulo.setForeground(Color.ORANGE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));

		lblAutor = new JLabel("Autor");
		lblAutor.setForeground(Color.ORANGE);
		lblAutor.setFont(new Font("Tahoma", Font.BOLD, 13));

		lblEditorial = new JLabel("Editorial");
		lblEditorial.setForeground(Color.ORANGE);
		lblEditorial.setFont(new Font("Tahoma", Font.BOLD, 13));

		lblPrecio = new JLabel("Precio");
		lblPrecio.setForeground(Color.YELLOW);
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 13));

		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setForeground(Color.YELLOW);
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtTitulo = new JTextField();
		txtTitulo.setForeground(Color.BLACK);
		txtTitulo.setBackground(new Color(204, 204, 255));
		txtTitulo.setText(libro.getTitulo());
		txtTitulo.setColumns(10);

		txtAutor = new JTextField();
		txtAutor.setForeground(Color.BLACK);
		txtAutor.setBackground(new Color(204, 204, 255));
		txtAutor.setText(libro.getAutor());
		txtAutor.setColumns(10);

		txtEditorial = new JTextField();
		txtEditorial.setForeground(Color.BLACK);
		txtEditorial.setBackground(new Color(204, 204, 255));
		txtEditorial.setText(libro.getEditorial());
		txtEditorial.setColumns(10);

		txtPrecio = new JTextField();
		txtPrecio.setForeground(Color.BLACK);
		txtPrecio.setBackground(new Color(204, 204, 255));
		txtPrecio.setText(libro.getPrecio().substring(0, libro.getPrecio().length() - 1));
		txtPrecio.setColumns(10);

		txtCantidad = new JTextField();
		txtCantidad.setForeground(Color.BLACK);
		txtCantidad.setBackground(new Color(204, 204, 255));
		txtCantidad.setText(libro.getCantidad());
		txtCantidad.setColumns(10);

		crearListaLabels();
		crearListaTexfields();

		JButton btnOK = new JButton("OK");
		btnOK.setForeground(Color.WHITE);
		btnOK.setBackground(Color.BLACK);
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Validacion validaciones = new Validacion();
				if (validaciones.validarCampos(listaTexfields, listaLabels)) {
					modificarLibro(libro);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, Error.ERROR_CAMPOSINCORRECTOS.getMensaje());
				}
			}

		});

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarCampos();
			}

		});
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setBackground(Color.BLACK);
		
		panelTematica = new JPanel();
		
		JLabel lblTematica_1 = new JLabel("Tem\u00E1tica");
		lblTematica_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelTematica.add(lblTematica_1);
		
		comBoxTematica = new JComboBox<Tematica>();
		comBoxTematica.setModel(new DefaultComboBoxModel<Tematica>(Tematica.values()));
		comBoxTematica.setSelectedItem(null);
		panelTematica.add(comBoxTematica);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(66)
					.addComponent(btnOK, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnLimpiar, GroupLayout.PREFERRED_SIZE, 92, Short.MAX_VALUE)
					.addGap(57))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panelTematica, GroupLayout.PREFERRED_SIZE, 31, Short.MAX_VALUE)
							.addGap(142))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblCantidad)
									.addGap(18)
									.addComponent(txtCantidad, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblPrecio)
									.addGap(18)
									.addComponent(txtPrecio, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblAutor)
									.addGap(18)
									.addComponent(txtAutor, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblTitulo)
									.addGap(18)
									.addComponent(txtTitulo, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblEditorial)
									.addGap(18)
									.addComponent(txtEditorial, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)))
							.addGap(38))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTitulo)
						.addComponent(txtTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAutor)
						.addComponent(txtAutor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEditorial)
						.addComponent(txtEditorial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrecio)
						.addComponent(txtPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCantidad)
						.addComponent(txtCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addComponent(panelTematica, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOK)
						.addComponent(btnLimpiar))
					.addGap(24))
		);
		contentPane.setLayout(gl_contentPane);
	}

	private void crearListaLabels() {
		listaLabels.add(lblTitulo);
		listaLabels.add(lblAutor);
		listaLabels.add(lblEditorial);
		listaLabels.add(lblPrecio);
		listaLabels.add(lblCantidad);
	}

	private void crearListaTexfields() {

		listaTexfields.add(txtTitulo);
		listaTexfields.add(txtAutor);
		listaTexfields.add(txtEditorial);
		listaTexfields.add(txtPrecio);
		listaTexfields.add(txtCantidad);

	}

	private void limpiarCampos() {
		for (int i = 0; i < listaTexfields.size(); i++) {
			listaTexfields.get(i).setText("");
		}

	}

	private void modificarLibro(Libro libro) {
		libro.setTitulo(txtTitulo.getText());
		libro.setAutor(txtAutor.getText());
		libro.setEditorial(txtEditorial.getText());
		libro.setPrecio(txtPrecio.getText() + "€");
		libro.setCantidad(txtCantidad.getText());
		libro.setTematica(String.valueOf(comBoxTematica.getSelectedItem()));

	}
}
