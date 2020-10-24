package vista;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import modelo.Libro;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JSpinner;


public class UI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel contentPane;
	protected JPanel panelEstanteria;
	protected JTextField txtISBN;
	protected JTextField txtTitulo;
	protected JTextField txtAutor;
	protected JTextField txtEditorial;
	protected JTextField txtPrecio;
	protected JButton btnSalir;
	protected JButton btnGuardar;
	protected JButton btnBorrar;
	protected JButton btnConsultar;
	protected JLabel lblCantidadLibros;
	private String cadenaVacia = "";
	protected JTablaLibreria tablaLibros;
	protected JRadioButton rbtnReedicion;
	protected JRadioButton rbtnNovedad;
	protected JRadioButton rbtnCartone;
	protected JRadioButton rbtnRustica;
	protected JRadioButton rbtnGrapada;
	protected JRadioButton rbtnEspiral;
	protected ButtonGroup grupoFormato;
	protected ButtonGroup grupoEstado;
	protected JLabel lblUltimoAñadido;
	protected JSpinner spinner;
	protected JLabel lblCorrect;
	protected JLabel lblError;
	protected JButton btnOjoConsulta;
	private JPanel panelBotoneraTabla;
	protected JButton btnBorraUnidad;
	protected JButton btnCompraUnidad;
	protected JButton btnEditar;

	protected JTable getTablaLibros() {
		return tablaLibros;
	}

	/**
	 * Create the frame.
	 */
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1208, 721);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.windowBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panelSuperior = new JPanel();
		panelSuperior.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(204, 0, 255)));
		panelSuperior.setBackground(Color.DARK_GRAY);

		contentPane.add(panelSuperior, BorderLayout.NORTH);
		panelSuperior.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblLibreria = new JLabel("LIBRER\u00CDA JAREMO");
		lblLibreria.setForeground(SystemColor.controlHighlight);
		lblLibreria.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 25));
		panelSuperior.add(lblLibreria);

		JTabbedPane panelCentral = new JTabbedPane(JTabbedPane.TOP);
		panelCentral.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panelCentral, BorderLayout.CENTER);

		JPanel panelInferior = new JPanel();
		panelInferior.setBackground(SystemColor.windowBorder);
		contentPane.add(panelInferior, BorderLayout.SOUTH);
		panelInferior.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblCantidadLibros = new JLabel("");
		panelInferior.add(lblCantidadLibros);

		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setBackground(Color.BLACK);
		panelInferior.add(btnGuardar);

		btnBorrar = new JButton("BORRAR");
		btnBorrar.setForeground(Color.WHITE);
		btnBorrar.setBackground(Color.BLACK);
		panelInferior.add(btnBorrar);

		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setForeground(Color.WHITE);
		btnConsultar.setBackground(Color.BLACK);
		panelInferior.add(btnConsultar);

		btnSalir = new JButton("SALIR");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(Color.BLACK);
		panelInferior.add(btnSalir);

		grupoFormato = new ButtonGroup();

		grupoEstado = new ButtonGroup();

		JPanel panelLibro = new JPanel();
		panelLibro.setBackground(UIManager.getColor("Button.light"));
		panelCentral.addTab("LIBRO", null, panelLibro, null);

		JLabel lblISBN = new JLabel("ISBN");
		lblISBN.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblEditorial = new JLabel("Editorial");
		lblEditorial.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblTitulo = new JLabel("T\u00EDtulo");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 16));

		txtISBN = new JTextField();
		txtISBN.setColumns(10);
		txtISBN.setText("");

		txtTitulo = new JTextField();
		txtTitulo.setColumns(10);
		txtISBN.setText("");

		txtAutor = new JTextField();
		txtAutor.setColumns(10);
		txtISBN.setText("");

		txtEditorial = new JTextField();
		txtEditorial.setColumns(10);
		txtISBN.setText("");

		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);

		JLabel lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon(UI.class.getResource("/img/libreriaIcon2.png")));

		JLabel lblGif = new JLabel("");
		lblGif.setIcon(new ImageIcon(UI.class.getResource("/img/giphy (1).gif")));

		JPanel panelFormato = new JPanel();
		panelFormato.setBackground(UIManager.getColor("Button.light"));
		panelFormato.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, UIManager.getColor("Button.darkShadow"),
				UIManager.getColor("Button.focus"), UIManager.getColor("Button.darkShadow"),
				UIManager.getColor("Button.focus")));

		JLabel lblFormato = new JLabel("Formato:");
		lblFormato.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JPanel panelEstado = new JPanel();
		panelEstado.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, UIManager.getColor("Button.darkShadow"),
				UIManager.getColor("Button.focus"), UIManager.getColor("Button.darkShadow"),
				UIManager.getColor("Button.focus")));
		panelEstado.setBackground(UIManager.getColor("Button.light"));

		lblUltimoAñadido = new JLabel("Ultimo Libro que registr\u00F3");
		lblUltimoAñadido.setEnabled(false);
		lblUltimoAñadido.setForeground(Color.BLACK);
		lblUltimoAñadido.setBackground(Color.WHITE);
		lblUltimoAñadido.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblUltimoAñadido.setVisible(false);

		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 16));

		spinner = new JSpinner();

		lblError = new JLabel("");
		lblError.setIcon(new ImageIcon(UI.class.getResource("/img/error.png")));

		lblCorrect = new JLabel("");
		lblCorrect.setIcon(new ImageIcon(UI.class.getResource("/img/correct.png")));

		GroupLayout gl_panelLibro = new GroupLayout(panelLibro);
		gl_panelLibro.setHorizontalGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING).addGroup(gl_panelLibro
				.createSequentialGroup()
				.addGroup(gl_panelLibro.createParallelGroup(Alignment.TRAILING).addGroup(gl_panelLibro
						.createSequentialGroup().addGap(26)
						.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING).addGroup(gl_panelLibro
								.createSequentialGroup()
								.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING).addComponent(lblTitulo)
										.addComponent(lblISBN))
								.addGap(18)
								.addGroup(gl_panelLibro.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panelLibro.createSequentialGroup()
												.addComponent(txtISBN, GroupLayout.PREFERRED_SIZE, 448,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18).addComponent(lblError).addGap(18).addComponent(lblCorrect)
												.addPreferredGap(ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
												.addComponent(lblFormato).addGap(14))
										.addGroup(gl_panelLibro.createSequentialGroup()
												.addComponent(txtTitulo, GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
												.addGap(308))))
								.addGroup(gl_panelLibro.createSequentialGroup().addGroup(gl_panelLibro
										.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelLibro.createSequentialGroup().addComponent(lblEditorial)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(txtEditorial, GroupLayout.DEFAULT_SIZE, 507,
														Short.MAX_VALUE)
												.addGap(19))
										.addGroup(
												gl_panelLibro.createSequentialGroup().addComponent(lblAutor).addGap(18)
														.addComponent(txtAutor, GroupLayout.DEFAULT_SIZE, 513,
																Short.MAX_VALUE)
														.addGap(18))
										.addGroup(gl_panelLibro.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_panelLibro.createSequentialGroup()
																.addComponent(lblCantidad).addGap(18)
																.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 48,
																		GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_panelLibro.createSequentialGroup()
																.addComponent(lblPrecio).addGap(18)
																.addGroup(gl_panelLibro
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(lblUltimoAñadido,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(txtPrecio,
																				GroupLayout.PREFERRED_SIZE, 45,
																				GroupLayout.PREFERRED_SIZE))
																.addGap(345)))))
										.addGap(291))))
						.addGroup(
								gl_panelLibro.createSequentialGroup().addContainerGap(359, Short.MAX_VALUE)
										.addComponent(lblGif).addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 53,
												GroupLayout.PREFERRED_SIZE)
										.addGap(7)))
				.addGap(18)
				.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelLibro.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_panelLibro.createSequentialGroup().addComponent(lblIcon).addGap(53))
								.addGroup(gl_panelLibro.createSequentialGroup()
										.addComponent(panelFormato, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(5)))
						.addComponent(panelEstado, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
				.addGap(5)));
		gl_panelLibro.setVerticalGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING).addGroup(gl_panelLibro
				.createSequentialGroup()
				.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panelLibro.createSequentialGroup().addGap(18).addComponent(lblFormato)
								.addGroup(gl_panelLibro.createParallelGroup(Alignment.TRAILING).addComponent(lblGif)
										.addGroup(gl_panelLibro.createSequentialGroup().addComponent(lblEstado)
												.addGap(20))))
						.addGroup(gl_panelLibro.createSequentialGroup().addGroup(gl_panelLibro
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelLibro.createSequentialGroup().addGap(92).addComponent(lblIcon))
								.addComponent(panelFormato, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panelLibro.createSequentialGroup().addGap(18).addGroup(gl_panelLibro
										.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panelLibro.createSequentialGroup()
												.addGroup(gl_panelLibro.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblISBN).addComponent(txtISBN,
																GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
												.addGap(24))
										.addGroup(
												gl_panelLibro.createSequentialGroup().addComponent(lblError).addGap(32))
										.addGroup(gl_panelLibro.createSequentialGroup().addComponent(lblCorrect)
												.addGap(26)))
										.addGroup(gl_panelLibro.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblTitulo)
												.addComponent(txtTitulo, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(gl_panelLibro.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblAutor)
												.addComponent(txtAutor, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(gl_panelLibro.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblEditorial)
												.addComponent(txtEditorial, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(gl_panelLibro.createParallelGroup(Alignment.BASELINE)
												.addComponent(txtPrecio, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblPrecio))
										.addGap(33).addComponent(lblUltimoAñadido).addGap(34)
										.addGroup(gl_panelLibro.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblCantidad).addComponent(spinner,
														GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))))
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panelEstado, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(15, Short.MAX_VALUE)));
		panelEstado.setLayout(new BoxLayout(panelEstado, BoxLayout.X_AXIS));

		rbtnReedicion = new JRadioButton("Reedici\u00F3n");
		rbtnReedicion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rbtnReedicion.setBackground(UIManager.getColor("Button.light"));
		panelEstado.add(rbtnReedicion);

		rbtnNovedad = new JRadioButton("Novedad");
		rbtnNovedad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rbtnNovedad.setBackground(UIManager.getColor("Button.light"));
		panelEstado.add(rbtnNovedad);

		rbtnCartone = new JRadioButton("Carton\u00E9");
		rbtnCartone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rbtnCartone.setBackground(UIManager.getColor("Button.light"));

		rbtnRustica = new JRadioButton("R\u00FAstica");
		rbtnRustica.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rbtnRustica.setBackground(UIManager.getColor("Button.light"));

		rbtnGrapada = new JRadioButton("Grapada");
		rbtnGrapada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rbtnGrapada.setBackground(UIManager.getColor("Button.light"));

		rbtnEspiral = new JRadioButton("Espiral");
		rbtnEspiral.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rbtnEspiral.setBackground(UIManager.getColor("Button.light"));
		panelFormato.setLayout(new BoxLayout(panelFormato, BoxLayout.X_AXIS));
		panelFormato.add(rbtnCartone);
		panelFormato.add(rbtnRustica);
		panelFormato.add(rbtnGrapada);
		panelFormato.add(rbtnEspiral);
		panelLibro.setLayout(gl_panelLibro);
		grupoFormato.add(rbtnRustica);
		grupoFormato.add(rbtnCartone);
		grupoFormato.add(rbtnGrapada);
		grupoFormato.add(rbtnEspiral);
		grupoEstado.add(rbtnNovedad);
		grupoEstado.add(rbtnReedicion);
		panelEstanteria = new JPanel();
		panelEstanteria.setBackground(SystemColor.activeCaption);
		panelCentral.addTab("ESTANTER\u00CDA", null, panelEstanteria, null);

		JScrollPane scrollPane = new JScrollPane();
		panelEstanteria.setLayout(new GridLayout(0, 1, 0, 0));
		panelEstanteria.add(scrollPane);

		tablaLibros = new JTablaLibreria();
		scrollPane.setViewportView(tablaLibros);
		
		panelBotoneraTabla = new JPanel();
		scrollPane.setRowHeaderView(panelBotoneraTabla);
		
		btnOjoConsulta = new JButton("");
		btnOjoConsulta.setIcon(new ImageIcon(UI.class.getResource("/img/ojo.png")));
		btnOjoConsulta.setBackground(new Color(51, 153, 204));
		
		btnBorraUnidad = new JButton("");
		btnBorraUnidad.setBackground(new Color(255, 51, 0));
		btnBorraUnidad.setIcon(new ImageIcon(UI.class.getResource("/img/cubo-de-la-basura.png")));
		
		btnCompraUnidad = new JButton("");
		btnCompraUnidad.setBackground(new Color(50, 205, 50));
		btnCompraUnidad.setIcon(new ImageIcon(UI.class.getResource("/img/comprar.png")));
		
		
		panelBotoneraTabla.setLayout(new GridLayout(0, 1, 0, 0));
		panelBotoneraTabla.add(btnOjoConsulta);
		panelBotoneraTabla.add(btnBorraUnidad);
		panelBotoneraTabla.add(btnCompraUnidad);
		
		btnEditar = new JButton("");
		btnEditar.setIcon(new ImageIcon(UI.class.getResource("/img/editar.png")));
		btnEditar.setBackground(new Color(255, 215, 0));
		panelBotoneraTabla.add(btnEditar);
		
		

	}

	protected void borrarCampos() {
		txtISBN.setText(cadenaVacia);
		txtTitulo.setText(cadenaVacia);
		txtAutor.setText(cadenaVacia);
		txtEditorial.setText(cadenaVacia);
		txtPrecio.setText(cadenaVacia);
		spinner.setValue(0);
	}

	protected void mostrarCampos(Libro libro) {
		txtISBN.setText(libro.getISBN());
		txtTitulo.setText(libro.getTitulo());
		txtAutor.setText(libro.getAutor());
		txtEditorial.setText(libro.getEditorial());
		txtPrecio.setText(String.valueOf(libro.getPrecio()));
		spinner.setValue(Integer.parseInt(libro.getCantidad()));
	}
}
