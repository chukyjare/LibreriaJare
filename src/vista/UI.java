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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.border.LineBorder;

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
	protected JPanel panelMenu;
	private JMenuBar menuBar;
	private JMenu mnTema;
	private JMenu mnFondo;
	private JMenu mnVentana;
	protected JMenuItem itemOriginal;
	protected JMenuItem itemClasico;
	protected JMenuItem itemSimpsons;
	protected JMenuItem itemImgEstatica;
	protected JMenuItem itemGIF;
	private JMenu mnColor;
	protected JMenuItem itemAmarillo;
	protected JMenuItem itemAzul;
	protected JMenuItem itemRojo;
	protected JMenuItem itemPequena;
	protected JMenuItem itemMediana;
	protected JMenuItem itemGrande;
	protected JMenuItem itemOscuro;
	private JLabel lblISBN;
	private JLabel lblTitulo;
	private JLabel lblAutor;
	private JLabel lblEditorial;
	private JLabel lblPrecio;
	private JLabel lblCantidad;
	private JLabel lblFormato;
	private JLabel lblEstado;
	protected JMenuItem itemVacio;
	private JMenuItem itemMovil;
	protected JMenuItem itemButtonLight;
	private JPanel panelSuperior;
	private JPanel panelInferior;
	private JLabel lblLibreria;
	private JMenu mnOrdenador;
	private JPanel panelFormato;
	private JPanel panelEstado;
	protected JButton btnConfiguration;
	protected JPanel panelLibro;
	protected JLabel lblFondo;

	protected JTable getTablaLibros() {
		return tablaLibros;
	}

	/**
	 * Create the frame.
	 */
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 750);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.windowBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JTabbedPane panelCentral = new JTabbedPane(JTabbedPane.TOP);
		panelCentral.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panelCentral, BorderLayout.CENTER);

		panelInferior = new JPanel();
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

		panelLibro = new JPanel();
		panelLibro.setBackground(UIManager.getColor("Button.light"));
		panelCentral.addTab("LIBRO", null, panelLibro, null);

		lblISBN = new JLabel("ISBN");
		lblISBN.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblAutor = new JLabel("Autor");
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblEditorial = new JLabel("Editorial");
		lblEditorial.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblTitulo = new JLabel("T\u00EDtulo");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblPrecio = new JLabel("Precio");
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
		lblIcon.setIcon(new ImageIcon(UI.class.getResource("/img/libreriaIcono.png")));

		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(UI.class.getResource("/img/giphy (1).gif")));

		panelFormato = new JPanel();
		panelFormato.setBackground(UIManager.getColor("Button.light"));
		panelFormato.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, UIManager.getColor("Button.darkShadow"),
				UIManager.getColor("Button.focus"), UIManager.getColor("Button.darkShadow"),
				UIManager.getColor("Button.focus")));

		lblFormato = new JLabel("Formato:");
		lblFormato.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 16));

		panelEstado = new JPanel();
		panelEstado.setBackground(UIManager.getColor("Button.light"));
		panelEstado.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, UIManager.getColor("Button.darkShadow"),
				UIManager.getColor("Button.focus"), UIManager.getColor("Button.darkShadow"),
				UIManager.getColor("Button.focus")));

		lblUltimoAñadido = new JLabel("Ultimo Libro que registr\u00F3");
		lblUltimoAñadido.setEnabled(false);
		lblUltimoAñadido.setForeground(Color.BLACK);
		lblUltimoAñadido.setBackground(Color.WHITE);
		lblUltimoAñadido.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblUltimoAñadido.setVisible(false);

		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 16));

		spinner = new JSpinner();

		lblError = new JLabel("");
		lblError.setIcon(new ImageIcon(UI.class.getResource("/javax/swing/plaf/metal/icons/ocean/error.png")));

		lblCorrect = new JLabel("");
		lblCorrect.setIcon(new ImageIcon(UI.class.getResource("/img/correct.png")));

		GroupLayout gl_panelLibro = new GroupLayout(panelLibro);
		gl_panelLibro.setHorizontalGroup(
			gl_panelLibro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLibro.createSequentialGroup()
					.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelLibro.createSequentialGroup()
							.addGap(26)
							.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelLibro.createSequentialGroup()
									.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING)
										.addComponent(lblTitulo)
										.addComponent(lblISBN))
									.addGap(18)
									.addGroup(gl_panelLibro.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panelLibro.createSequentialGroup()
											.addComponent(txtISBN, GroupLayout.PREFERRED_SIZE, 448, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblError)
											.addGap(18)
											.addComponent(lblCorrect)
											.addPreferredGap(ComponentPlacement.RELATED, 210, Short.MAX_VALUE)
											.addComponent(lblFormato)
											.addGap(14))
										.addGroup(gl_panelLibro.createSequentialGroup()
											.addComponent(txtTitulo, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
											.addGap(308))))
								.addGroup(gl_panelLibro.createSequentialGroup()
									.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelLibro.createSequentialGroup()
											.addComponent(lblEditorial)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtEditorial, GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
											.addGap(19))
										.addGroup(gl_panelLibro.createSequentialGroup()
											.addComponent(lblAutor)
											.addGap(18)
											.addComponent(txtAutor, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
											.addGap(18))
										.addGroup(gl_panelLibro.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panelLibro.createSequentialGroup()
													.addComponent(lblCantidad)
													.addGap(18)
													.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_panelLibro.createSequentialGroup()
													.addComponent(lblPrecio)
													.addGap(18)
													.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING)
														.addComponent(lblUltimoAñadido, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
														.addComponent(txtPrecio, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
													.addGap(345))
												.addGroup(gl_panelLibro.createSequentialGroup()
													.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(panelEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
									.addGap(291))))
						.addGroup(gl_panelLibro.createSequentialGroup()
							.addGap(359)
							.addComponent(lblFondo)))
					.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelLibro.createSequentialGroup()
							.addGap(18)
							.addComponent(panelFormato, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelLibro.createSequentialGroup()
							.addGap(5)
							.addComponent(lblIcon)))
					.addGap(5))
		);
		gl_panelLibro.setVerticalGroup(
			gl_panelLibro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLibro.createSequentialGroup()
					.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panelLibro.createSequentialGroup()
							.addGap(18)
							.addComponent(lblFormato)
							.addComponent(lblFondo))
						.addGroup(gl_panelLibro.createSequentialGroup()
							.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelLibro.createSequentialGroup()
									.addComponent(panelFormato, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addGap(56)
									.addComponent(lblIcon))
								.addGroup(gl_panelLibro.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_panelLibro.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panelLibro.createSequentialGroup()
											.addGroup(gl_panelLibro.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblISBN)
												.addComponent(txtISBN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGap(24))
										.addGroup(gl_panelLibro.createSequentialGroup()
											.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING)
												.addComponent(lblError)
												.addComponent(lblCorrect))
											.addGap(26)))
									.addGroup(gl_panelLibro.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblTitulo)
										.addComponent(txtTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_panelLibro.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblAutor)
										.addComponent(txtAutor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_panelLibro.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblEditorial)
										.addComponent(txtEditorial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_panelLibro.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPrecio))
									.addGap(33)
									.addComponent(lblUltimoAñadido)
									.addGap(34)
									.addGroup(gl_panelLibro.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblCantidad)
										.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))))
							.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelLibro.createSequentialGroup()
									.addGap(29)
									.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelLibro.createSequentialGroup()
									.addGap(18)
									.addComponent(panelEstado, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(15, Short.MAX_VALUE))
		);
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

		panelSuperior = new JPanel();
		panelSuperior.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(204, 0, 255)));
		panelSuperior.setBackground(Color.DARK_GRAY);
		contentPane.add(panelSuperior, BorderLayout.NORTH);

		lblLibreria = new JLabel("LIBRER\u00CDA JAREMO");
		lblLibreria.setForeground(SystemColor.controlHighlight);
		lblLibreria.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 25));

		btnConfiguration = new JButton("");
		btnConfiguration.setBorder(null);
		btnConfiguration.setBackground(null);
		btnConfiguration.setIcon(new ImageIcon(UI.class.getResource("/img/settings.png")));
		

		panelMenu = new JPanel();
		panelMenu.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMenu.setBackground(Color.LIGHT_GRAY);
		panelMenu.setVisible(false);

		GroupLayout gl_panelSuperior = new GroupLayout(panelSuperior);
		gl_panelSuperior.setHorizontalGroup(gl_panelSuperior.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelSuperior.createSequentialGroup().addGap(413)
						.addComponent(lblLibreria, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE).addGap(297)
						.addComponent(panelMenu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(28).addComponent(btnConfiguration).addContainerGap()));
		gl_panelSuperior.setVerticalGroup(gl_panelSuperior.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSuperior.createSequentialGroup().addContainerGap().addGroup(gl_panelSuperior
						.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLibreria, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
						.addComponent(btnConfiguration)
						.addGroup(gl_panelSuperior.createSequentialGroup()
								.addComponent(panelMenu, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE).addGap(29)))
						.addContainerGap()));
		panelSuperior.setLayout(gl_panelSuperior);
		panelMenu.setLayout(new BorderLayout(0, 0));
		
		menuBar = new JMenuBar();
		panelMenu.add(menuBar);

		mnTema = new JMenu("Tema");
		menuBar.add(mnTema);

		itemOriginal = new JMenuItem("Original");
		
		itemOriginal.setIcon(new ImageIcon(UI.class.getResource("/img/libreriaOriginal.png")));
		mnTema.add(itemOriginal);

		itemClasico = new JMenuItem("Clasico");
		
		itemClasico.setIcon(new ImageIcon(UI.class.getResource("/img/circuloClasico.png")));
		mnTema.add(itemClasico);

		itemSimpsons = new JMenuItem("Simpsons");
		
		itemSimpsons.setIcon(new ImageIcon(UI.class.getResource("/img/rosquilla.png")));
		mnTema.add(itemSimpsons);

		mnFondo = new JMenu("Fondo");
		menuBar.add(mnFondo);

		itemImgEstatica = new JMenuItem("Imagen est\u00E1tica");
		

		itemVacio = new JMenuItem("(Sin Imagen)");
		
		mnFondo.add(itemVacio);
		itemImgEstatica.setIcon(new ImageIcon(UI.class.getResource("/img/picture.png")));
		mnFondo.add(itemImgEstatica);

		itemGIF = new JMenuItem("GIF");
		
		itemGIF.setIcon(new ImageIcon(UI.class.getResource("/img/gif.png")));
		mnFondo.add(itemGIF);

		mnColor = new JMenu("Color");
		mnColor.setIcon(new ImageIcon(UI.class.getResource("/img/color-circle.png")));
		mnFondo.add(mnColor);

		itemAmarillo = new JMenuItem("Amarillo");
		

		itemButtonLight = new JMenuItem("(Por defecto)");
		
		mnColor.add(itemButtonLight);
		itemAmarillo.setIcon(new ImageIcon(UI.class.getResource("/img/circuloAmarillo.png")));
		mnColor.add(itemAmarillo);

		itemAzul = new JMenuItem("Azul");
		
		itemAzul.setIcon(new ImageIcon(UI.class.getResource("/img/circuloAzul.png")));
		mnColor.add(itemAzul);

		itemRojo = new JMenuItem("Rojo");
		
		itemRojo.setIcon(new ImageIcon(UI.class.getResource("/img/circuloRojo.png")));
		mnColor.add(itemRojo);

		itemOscuro = new JMenuItem("Oscuro");
		
		itemOscuro.setIcon(new ImageIcon(UI.class.getResource("/img/circuloNegro.png")));
		mnColor.add(itemOscuro);

		mnVentana = new JMenu("Ventana");
		menuBar.add(mnVentana);

		itemPequena = new JMenuItem("Peque\u00F1a");
		

		itemMediana = new JMenuItem("Mediana");
		

		itemGrande = new JMenuItem("Grande");
		

		itemMovil = new JMenuItem("Versi\u00F3n Movil");
		itemMovil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBounds(100, 100, 659, 953);
				lblIcon.setIcon(null);
				gl_panelSuperior.setHorizontalGroup(gl_panelSuperior.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelSuperior.createSequentialGroup().addGap(61)
								.addComponent(lblLibreria, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE).addGap(18)
								.addComponent(panelMenu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(26).addComponent(btnConfiguration, GroupLayout.PREFERRED_SIZE, 67,
										GroupLayout.PREFERRED_SIZE)
								.addGap(30)));
				gl_panelSuperior.setVerticalGroup(gl_panelSuperior.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelSuperior.createSequentialGroup().addGroup(gl_panelSuperior
								.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_panelSuperior.createSequentialGroup().addContainerGap()
										.addGroup(gl_panelSuperior.createParallelGroup(Alignment.TRAILING)
												.addComponent(btnConfiguration, GroupLayout.DEFAULT_SIZE, 57,
														Short.MAX_VALUE)
												.addComponent(lblLibreria, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														47, Short.MAX_VALUE)))
								.addGroup(gl_panelSuperior.createSequentialGroup().addGap(23).addComponent(panelMenu,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
								.addContainerGap()));
				gl_panelLibro.setHorizontalGroup(
						gl_panelLibro.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelLibro.createSequentialGroup()
								.addGap(26)
								.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panelLibro.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_panelLibro.createSequentialGroup()
												.addGroup(gl_panelLibro.createParallelGroup(Alignment.TRAILING)
													.addGroup(gl_panelLibro.createSequentialGroup()
														.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
														.addGap(30))
													.addGroup(gl_panelLibro.createSequentialGroup()
														.addComponent(lblFormato)
														.addGap(18)))
												.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING)
													.addGroup(gl_panelLibro.createSequentialGroup()
														.addComponent(panelEstado, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(lblFondo, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE))
													.addComponent(panelFormato, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
											.addGroup(gl_panelLibro.createSequentialGroup()
												.addComponent(lblPrecio)
												.addGap(18)
												.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING)
													.addComponent(lblUltimoAñadido, GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
													.addComponent(txtPrecio, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))))
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGroup(gl_panelLibro.createSequentialGroup()
										.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING)
											.addComponent(lblTitulo)
											.addComponent(lblISBN))
										.addGap(18)
										.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING, false)
											.addComponent(txtISBN)
											.addComponent(txtTitulo, GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(lblError, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(lblCorrect, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_panelLibro.createSequentialGroup()
											.addComponent(lblEditorial)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtEditorial))
										.addGroup(gl_panelLibro.createSequentialGroup()
											.addComponent(lblAutor)
											.addGap(18)
											.addComponent(txtAutor, GroupLayout.PREFERRED_SIZE, 443, GroupLayout.PREFERRED_SIZE))))
								.addGap(560))
					);
					gl_panelLibro.setVerticalGroup(
						gl_panelLibro.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelLibro.createSequentialGroup()
								.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panelLibro.createSequentialGroup()
										.addGap(32)
										.addGroup(gl_panelLibro.createParallelGroup(Alignment.BASELINE)
											.addComponent(lblISBN)
											.addComponent(txtISBN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(24)
										.addGroup(gl_panelLibro.createParallelGroup(Alignment.BASELINE)
											.addComponent(lblTitulo)
											.addComponent(txtTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(gl_panelLibro.createParallelGroup(Alignment.BASELINE)
											.addComponent(lblAutor)
											.addComponent(txtAutor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(gl_panelLibro.createParallelGroup(Alignment.BASELINE)
											.addComponent(lblEditorial)
											.addComponent(txtEditorial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(gl_panelLibro.createParallelGroup(Alignment.BASELINE)
											.addComponent(txtPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblPrecio)))
									.addGroup(gl_panelLibro.createSequentialGroup()
										.addGap(26)
										.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING)
											.addComponent(lblCorrect, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblError, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))))
								.addGap(47)
								.addComponent(lblUltimoAñadido)
								.addGap(61)
								.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING)
									.addComponent(lblFormato)
									.addComponent(panelFormato, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panelLibro.createSequentialGroup()
										.addGap(60)
										.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING)
											.addComponent(panelEstado, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblEstado)))
									.addGroup(gl_panelLibro.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblFondo, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE)))
								.addContainerGap())
					);
			}
		});
		itemMovil.setIcon(new ImageIcon(UI.class.getResource("/img/smarthphone.png")));
		mnVentana.add(itemMovil);

		mnOrdenador = new JMenu("Versi\u00F3n Ordenador");
		mnOrdenador.setIcon(new ImageIcon(UI.class.getResource("/img/computer.png")));
		mnOrdenador.add(itemPequena);
		mnOrdenador.add(itemMediana);
		mnOrdenador.add(itemGrande);
		mnVentana.add(mnOrdenador);
		panelSuperior.setLayout(gl_panelSuperior);

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

	protected void cambiarFuente(int i) {
		lblISBN.setFont(new Font("Tahoma", Font.PLAIN, i));
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, i));
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, i));
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, i));
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, i));
		lblEditorial.setFont(new Font("Tahoma", Font.PLAIN, i));
		lblFormato.setFont(new Font("Tahoma", Font.PLAIN, i));
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, i));
	}
	
	protected void pintarLetras(Color color) {
		lblTitulo.setForeground(color);
		lblAutor.setForeground(color);
		lblPrecio.setForeground(color);
		lblISBN.setForeground(color);
		lblCantidad.setForeground(color);
		lblEditorial.setForeground(color);
		lblFormato.setForeground(color);
		lblEstado.setForeground(color);
	}

	protected void pintarBotones(Color foreground, Color background) {
		btnGuardar.setForeground(foreground);
		btnGuardar.setBackground(background);
		btnBorrar.setForeground(foreground);
		btnBorrar.setBackground(background);
		btnConsultar.setForeground(foreground);
		btnConsultar.setBackground(background);
		btnSalir.setForeground(foreground);
		btnSalir.setBackground(background);
	}
	


	protected void pintarPaneles(Color primary, Color secondary) {
		contentPane.setBackground(secondary);
		panelSuperior.setBackground(primary);
		panelInferior.setBackground(secondary);
		panelEstanteria.setBackground(primary);
		panelEstado.setBackground(primary);
		panelFormato.setBackground(primary);
	}

	protected void cambiarCabecera(Font fuente, Color forenground) {
		lblLibreria.setFont(fuente);
		lblLibreria.setForeground(forenground);
	}

}
