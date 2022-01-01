import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Ventana extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPane;
	private final JTextField VSalida;
	private final JTextField CapacidadPret;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */

	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/pilas";
	private static final String USUARIO = "root";
	private static final String CLAVE = "Voltmotors2020";
	private final JLabel labelMarca;
	private final JLabel labelModelo;
	private final JLabel labelTension;
	private final JLabel labelCapacidad;
	private final JLabel Cargaelectrica;
	private final JLabel Ccarga;
	private final JLabel Cdescarga;
	private final JRadioButtonMenuItem rdbtnmntmNewRadioItem_1;
	private final JRadioButtonMenuItem rdbtnmntmNewRadioItem;
	private final JRadioButtonMenuItem rdbtnmntmNewRadioItem_2;
	private final JRadioButtonMenuItem rdbtnmntmNewRadioItem_3;
	private final JRadioButtonMenuItem rdbtnmntmNewRadioItem_4;
	private final JRadioButtonMenuItem rdbtnmntmNewRadioItem_5;
	private final JRadioButtonMenuItem rdbtnmntmNewRadioItem_6;
	private final JRadioButtonMenuItem rdbtnmntmNewRadioItem_7;

	Connection cn = null;
	Statement stm = null;
	ResultSet rs = null;

	private final JLabel IPicoDescarga;
	private final JLabel Idescarga;
	private final JLabel Constantecarga;
	private final JLabel Constantedescarga;
	private final JLabel PSerie;
	private final JLabel Pparalelo;
	private final JButton btnNewButton;
	private final JLabel TotalPilas;

	public static void main(final String[] args) {

		final Ventana conexion = new Ventana();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					final Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}
		});

		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM 'pilas'");
		} catch (final SQLException e) {

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stm != null) {
					stm.close();
				}
				if (cn != null) {
					cn.close();
				}
			} catch (final Exception e2) {
				e2.printStackTrace();
			}
		}
	} // fin main

	/**
	 * Create the frame.
	 */
	public Ventana() {
	    setResizable(false);
		setFont(new Font("Consolas", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("src/imagenes/3_bat_full.png"));
		setTitle("CALCULADORA DE BATERÍA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);

		final JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		final JMenu mnNewMenu = new JMenu("PILAS");
		mnNewMenu.setFont(new Font("Conthrax Sb", Font.BOLD, 12));
		menuBar.add(mnNewMenu);

		rdbtnmntmNewRadioItem = new JRadioButtonMenuItem("Generica 26650 LiFePo4");
		rdbtnmntmNewRadioItem.setFont(new Font("Conthrax Sb", Font.BOLD, 8));
		rdbtnmntmNewRadioItem.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				consulta("1");
				Calcular();
			}
		});
		buttonGroup.add(rdbtnmntmNewRadioItem);
		mnNewMenu.add(rdbtnmntmNewRadioItem);

		rdbtnmntmNewRadioItem_1 = new JRadioButtonMenuItem("Panasonic 18650B");
		rdbtnmntmNewRadioItem_1.setFont(new Font("Conthrax Sb", Font.BOLD, 8));
		rdbtnmntmNewRadioItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				consulta("2");
				Calcular();
			}
		});

		buttonGroup.add(rdbtnmntmNewRadioItem_1);
		mnNewMenu.add(rdbtnmntmNewRadioItem_1);

		rdbtnmntmNewRadioItem_2 = new JRadioButtonMenuItem("LG 18650");
		rdbtnmntmNewRadioItem_2.setFont(new Font("Conthrax Sb", Font.BOLD, 8));
		rdbtnmntmNewRadioItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				consulta("3");
				Calcular();
			}
		});
		buttonGroup.add(rdbtnmntmNewRadioItem_2);
		mnNewMenu.add(rdbtnmntmNewRadioItem_2);

		rdbtnmntmNewRadioItem_3 = new JRadioButtonMenuItem("Panasonic 20700");
		rdbtnmntmNewRadioItem_3.setFont(new Font("Conthrax Sb", Font.BOLD, 8));
		rdbtnmntmNewRadioItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				consulta("4");
				Calcular();
			}
		});
		buttonGroup.add(rdbtnmntmNewRadioItem_3);
		mnNewMenu.add(rdbtnmntmNewRadioItem_3);

		rdbtnmntmNewRadioItem_4 = new JRadioButtonMenuItem("Samsung IRF18650");
		rdbtnmntmNewRadioItem_4.setFont(new Font("Conthrax Sb", Font.BOLD, 8));
		rdbtnmntmNewRadioItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				consulta("5");
				Calcular();
			}
		});
		buttonGroup.add(rdbtnmntmNewRadioItem_4);
		mnNewMenu.add(rdbtnmntmNewRadioItem_4);

		rdbtnmntmNewRadioItem_5 = new JRadioButtonMenuItem("Soundon SEPNi11164227P");
		rdbtnmntmNewRadioItem_5.setFont(new Font("Conthrax Sb", Font.BOLD, 8));
		rdbtnmntmNewRadioItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				consulta("6");
				Calcular();
			}
		});
		buttonGroup.add(rdbtnmntmNewRadioItem_5);
		mnNewMenu.add(rdbtnmntmNewRadioItem_5);

		rdbtnmntmNewRadioItem_6 = new JRadioButtonMenuItem("Soundon SEPNi11100302P 3.0 V");
		rdbtnmntmNewRadioItem_6.setFont(new Font("Conthrax Sb", Font.BOLD, 8));
		rdbtnmntmNewRadioItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				consulta("7");
				Calcular();
			}
		});
		buttonGroup.add(rdbtnmntmNewRadioItem_6);
		mnNewMenu.add(rdbtnmntmNewRadioItem_6);

		rdbtnmntmNewRadioItem_7 = new JRadioButtonMenuItem("Soundon SEPNi11100302P 4.4 V");
		rdbtnmntmNewRadioItem_7.setFont(new Font("Conthrax Sb", Font.BOLD, 8));
		rdbtnmntmNewRadioItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				consulta("8");
				Calcular();
			}
		});
		buttonGroup.add(rdbtnmntmNewRadioItem_7);
		mnNewMenu.add(rdbtnmntmNewRadioItem_7);

		final JMenu mnNewMenu_1 = new JMenu("ABOUT");
		mnNewMenu_1.setFont(new Font("Conthrax Sb", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_1);

		final JMenuItem mntmNewMenuItem = new JMenuItem("Version");
		mntmNewMenuItem.setFont(new Font("Conthrax Sb", Font.BOLD, 8));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Ver.: 1.0" + (char) 10 +
								" Dev: Camaño Nicolas E.,  Abraham Yamil",
						"Information", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JLabel lblNewLabel = new JLabel("DATOS DE PILA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Conthrax Sb", Font.BOLD, 21));
		lblNewLabel.setBounds(206, 50, 228, 24);
		contentPane.add(lblNewLabel);

		final JLabel lblNewLabel_1 = new JLabel("Marca");
		lblNewLabel_1.setFont(new Font("Conthrax Sb", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(183, 100, 228, 24);
		contentPane.add(lblNewLabel_1);

		final JLabel lblNewLabel_2 = new JLabel("Modelo");
		lblNewLabel_2.setFont(new Font("Conthrax Sb", Font.PLAIN, 14));
		lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2.setBounds(183, 150, 228, 24);
		contentPane.add(lblNewLabel_2);

		final JLabel lblNewLabel_3 = new JLabel("Tensión");
		lblNewLabel_3.setFont(new Font("Conthrax Sb", Font.PLAIN, 14));
		lblNewLabel_3.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_3.setBounds(183, 200, 228, 24);
		contentPane.add(lblNewLabel_3);

		final JLabel lblNewLabel_4 = new JLabel("Capacidad");
		lblNewLabel_4.setFont(new Font("Conthrax Sb", Font.PLAIN, 14));
		lblNewLabel_4.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_4.setBounds(183, 250, 228, 24);
		contentPane.add(lblNewLabel_4);

		final JLabel lblNewLabel_5 = new JLabel("Corriente nominal de descarga");
		lblNewLabel_5.setFont(new Font("Conthrax Sb", Font.PLAIN, 14));
		lblNewLabel_5.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_5.setBounds(183, 300, 340, 24);
		contentPane.add(lblNewLabel_5);

		final JLabel lblNewLabel_6 = new JLabel("Corriente pico de descarga");
		lblNewLabel_6.setFont(new Font("Conthrax Sb", Font.PLAIN, 14));
		lblNewLabel_6.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_6.setBounds(183, 350, 320, 24);
		contentPane.add(lblNewLabel_6);

		final JLabel lblNewLabel_7 = new JLabel("Carga eléctrica");
		lblNewLabel_7.setFont(new Font("Conthrax Sb", Font.PLAIN, 14));
		lblNewLabel_7.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_7.setBounds(183, 400, 228, 24);
		contentPane.add(lblNewLabel_7);

		Ccarga = new JLabel("Constante de carga");
		Ccarga.setFont(new Font("Conthrax Sb", Font.PLAIN, 14));
		Ccarga.setForeground(Color.LIGHT_GRAY);
		Ccarga.setHorizontalAlignment(SwingConstants.LEFT);
		Ccarga.setBounds(183, 450, 228, 24);
		contentPane.add(Ccarga);

		Cdescarga = new JLabel("Constante de descarga");
		Cdescarga.setFont(new Font("Conthrax Sb", Font.PLAIN, 14));
		Cdescarga.setForeground(Color.LIGHT_GRAY);
		Cdescarga.setHorizontalAlignment(SwingConstants.LEFT);
		Cdescarga.setBounds(183, 500, 228, 24);
		contentPane.add(Cdescarga);

		labelMarca = new JLabel("--------------");
		labelMarca.setForeground(Color.LIGHT_GRAY);
		labelMarca.setHorizontalAlignment(SwingConstants.LEFT);
		labelMarca.setBounds(305, 100, 228, 24);
		contentPane.add(labelMarca);

		labelModelo = new JLabel("--------------");
		labelModelo.setForeground(Color.LIGHT_GRAY);
		labelModelo.setHorizontalAlignment(SwingConstants.LEFT);
		labelModelo.setBounds(305, 150, 300, 24);
		contentPane.add(labelModelo);

		labelTension = new JLabel("--------------");
		labelTension.setForeground(Color.LIGHT_GRAY);
		labelTension.setHorizontalAlignment(SwingConstants.LEFT);
		labelTension.setBounds(305, 200, 228, 24);
		contentPane.add(labelTension);

		final JLabel lblNewLabel_21 = new JLabel("V");
		lblNewLabel_21.setFont(new Font("Conthrax Sb", Font.BOLD, 14));
		lblNewLabel_21.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_21.setBounds(385, 200, 50, 24);
		contentPane.add(lblNewLabel_21);

		labelCapacidad = new JLabel("--------------");
		labelCapacidad.setForeground(Color.LIGHT_GRAY);
		labelCapacidad.setHorizontalAlignment(SwingConstants.LEFT);
		labelCapacidad.setBounds(305, 250, 228, 24);
		contentPane.add(labelCapacidad);

		final JLabel lblNewLabel_22 = new JLabel("mAh");
		lblNewLabel_22.setFont(new Font("Conthrax Sb", Font.BOLD, 14));
		lblNewLabel_22.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_22.setBounds(385, 250, 50, 24);
		contentPane.add(lblNewLabel_22);

		Idescarga = new JLabel("--------------");
		Idescarga.setForeground(Color.LIGHT_GRAY);
		Idescarga.setHorizontalAlignment(SwingConstants.LEFT);
		Idescarga.setBounds(305, 325, 228, 24);
		contentPane.add(Idescarga);

		final JLabel lblNewLabel_23 = new JLabel("mAh");
		lblNewLabel_23.setFont(new Font("Conthrax Sb", Font.BOLD, 14));
		lblNewLabel_23.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_23.setBounds(385, 325, 50, 24);
		contentPane.add(lblNewLabel_23);

		IPicoDescarga = new JLabel("--------------");
		IPicoDescarga.setForeground(Color.LIGHT_GRAY);
		IPicoDescarga.setHorizontalAlignment(SwingConstants.LEFT);
		IPicoDescarga.setBounds(305, 375, 228, 24);
		contentPane.add(IPicoDescarga);

		final JLabel lblNewLabel_24 = new JLabel("A");
		lblNewLabel_24.setFont(new Font("Conthrax Sb", Font.BOLD, 14));
		lblNewLabel_24.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_24.setBounds(385, 375, 50, 24);
		contentPane.add(lblNewLabel_24);

		Cargaelectrica = new JLabel("--------------");
		Cargaelectrica.setForeground(Color.LIGHT_GRAY);
		Cargaelectrica.setHorizontalAlignment(SwingConstants.LEFT);
		Cargaelectrica.setBounds(305, 425, 228, 24);
		contentPane.add(Cargaelectrica);

		final JLabel lblNewLabel_25 = new JLabel("Culombios");
		lblNewLabel_25.setFont(new Font("Conthrax Sb", Font.BOLD, 14));
		lblNewLabel_25.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_25.setBounds(385, 425, 120, 24);
		contentPane.add(lblNewLabel_25);

		Constantecarga = new JLabel("--------------");
		Constantecarga.setForeground(Color.LIGHT_GRAY);
		Constantecarga.setHorizontalAlignment(SwingConstants.LEFT);
		Constantecarga.setBounds(305, 475, 228, 24);
		contentPane.add(Constantecarga);

		final JLabel lblNewLabel_27 = new JLabel("C");
		lblNewLabel_27.setFont(new Font("Conthrax Sb", Font.BOLD, 14));
		lblNewLabel_27.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_27.setBounds(385, 475, 120, 24);
		contentPane.add(lblNewLabel_27);

		Constantedescarga = new JLabel("--------------");
		Constantedescarga.setForeground(Color.LIGHT_GRAY);
		Constantedescarga.setHorizontalAlignment(SwingConstants.LEFT);
		Constantedescarga.setBounds(305, 525, 228, 24);
		contentPane.add(Constantedescarga);

		final JLabel lblNewLabel_28 = new JLabel("C");
		lblNewLabel_28.setFont(new Font("Conthrax Sb", Font.BOLD, 14));
		lblNewLabel_28.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_28.setBounds(385, 525, 120, 24);
		contentPane.add(lblNewLabel_28);

		final JLabel lblNewLabel_13 = new JLabel("BATERÍA");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_13.setFont(new Font("Conthrax Sb", Font.BOLD, 21));
		lblNewLabel_13.setBounds(846, 50, 228, 24);
		contentPane.add(lblNewLabel_13);

		final JLabel lbl14 = new JLabel("Tensión de salida");
		lbl14.setFont(new Font("Conthrax Sb", Font.PLAIN, 14));
		lbl14.setForeground(Color.LIGHT_GRAY);
		lbl14.setBounds(760, 100, 340, 24);
		contentPane.add(lbl14);

		final JLabel lblNewLabel_15 = new JLabel("Capacidad pretendida");
		lblNewLabel_15.setFont(new Font("Conthrax Sb", Font.PLAIN, 14));
		lblNewLabel_15.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_15.setBounds(760, 150, 340, 24);
		contentPane.add(lblNewLabel_15);

		VSalida = new JTextField();
		VSalida.setFont(new Font("Conthrax Sb",Font.PLAIN,14));
		VSalida.setHorizontalAlignment(SwingConstants.CENTER);
		VSalida.setBounds(1006, 100, 86, 20);
		contentPane.add(VSalida);
		VSalida.setColumns(10);

		CapacidadPret = new JTextField();
		CapacidadPret.setFont(new Font("Conthrax Sb",Font.PLAIN,14));
		CapacidadPret.setHorizontalAlignment(SwingConstants.CENTER);
		CapacidadPret.setBounds(1006, 150, 86, 20);
		contentPane.add(CapacidadPret);
		CapacidadPret.setColumns(10);

		final JLabel lblNewLabel_16 = new JLabel("V");
		lblNewLabel_16.setFont(new Font("Conthrax Sb", Font.BOLD, 14));
		lblNewLabel_16.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_16.setBounds(1100, 100, 50, 24);
		contentPane.add(lblNewLabel_16);

		final JLabel lblNewLabel_17 = new JLabel("mAh");
		lblNewLabel_17.setFont(new Font("Conthrax Sb", Font.BOLD, 14));
		lblNewLabel_17.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_17.setBounds(1100, 150, 50, 24);
		contentPane.add(lblNewLabel_17);

		btnNewButton = new JButton("CALCULAR");
		btnNewButton.setFont(new Font("Conthrax Sb", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				Calcular();
			}
		});
		btnNewButton.setBounds(910, 262, 150, 24);
		contentPane.add(btnNewButton);

		final JLabel lblNewLabel_18 = new JLabel("Pilas en serie");
		lblNewLabel_18.setFont(new Font("Conthrax Sb", Font.PLAIN, 14));
		lblNewLabel_18.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_18.setBounds(823, 350, 228, 24);
		contentPane.add(lblNewLabel_18);

		final JLabel lblNewLabel_19 = new JLabel("Pilas en paralelo");
		lblNewLabel_19.setFont(new Font("Conthrax Sb", Font.PLAIN, 14));
		lblNewLabel_19.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_19.setBounds(823, 400, 228, 24);
		contentPane.add(lblNewLabel_19);

		final JLabel lblNewLabel_20 = new JLabel("TOTAL DE PILAS");
		lblNewLabel_20.setForeground(new Color(255, 228, 51));
		lblNewLabel_20.setFont(new Font("Conthrax Sb", Font.BOLD, 18));
		lblNewLabel_20.setBounds(823, 450, 228, 24);
		contentPane.add(lblNewLabel_20);

		final JLabel lblNewLabel_8 = new JLabel("Volt Motors 2020");
		lblNewLabel_8.setForeground(new Color(230, 10, 10));
		lblNewLabel_8.setFont(new Font("Conthrax Sb", Font.PLAIN, 8));
		lblNewLabel_8.setBounds(1150, 640, 120, 14);
		contentPane.add(lblNewLabel_8);

		PSerie = new JLabel("--------------");
		PSerie.setFont(new Font("Conthrax Sb", Font.PLAIN, 14));
		PSerie.setForeground(new Color(255, 204, 51));
		PSerie.setHorizontalAlignment(SwingConstants.CENTER);
		PSerie.setBounds(1006, 350, 228, 24);
		contentPane.add(PSerie);

		Pparalelo = new JLabel("--------------");
		Pparalelo.setFont(new Font("Conthrax Sb", Font.PLAIN, 14));
		Pparalelo.setForeground(new Color(255, 204, 51));
		Pparalelo.setHorizontalAlignment(SwingConstants.CENTER);
		Pparalelo.setBounds(1006, 400, 228, 24);
		contentPane.add(Pparalelo);

		TotalPilas = new JLabel("--------------");
		TotalPilas.setFont(new Font("Conthrax Sb", Font.PLAIN, 18));
		TotalPilas.setForeground(new Color(255, 204, 51));
		TotalPilas.setHorizontalAlignment(SwingConstants.CENTER);
		TotalPilas.setBounds(1006, 450, 228, 24);
		contentPane.add(TotalPilas);

		final JLabel lblNewLabel_26 = new JLabel("");
		lblNewLabel_26
				.setIcon(new ImageIcon("src/imagenes/fondonegro.jpg"));
		lblNewLabel_26.setBounds(0, 0, 1280, 720);
		contentPane.add(lblNewLabel_26);

		// fin de constructor

	}

	static {
		try {
			Class.forName(CONTROLADOR);
			System.out.println("controlador cargado");

		} catch (final ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
		}
	}

	public Connection conectar() {
		Connection Ventana = null;
		try {

			Class.forName(CONTROLADOR);

		} catch (final ClassNotFoundException e1) {
			
			System.out.println("Error al cargar el controlador");
			e1.printStackTrace();
		}
		try {
			Ventana = DriverManager.getConnection(URL, USUARIO, CLAVE);
			System.out.println("Conexión OK");
		} catch (final SQLException e) {
			System.out.println("Error en la conexión");
			e.printStackTrace();
		}

		return Ventana;
	}

	public void consulta(final String codigoPila) {
		try {
			final Connection conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
			final Statement comando = conexion.createStatement();
			final String temporal = "select marca, modelo,tension,capacidad,corriente_nominal_de_descarga,corriente_pico_de_descarga,"
					+ " carga_electrica,constante_de_carga,constante_de_descarga from bd_pilas where id_pilas=\"" + codigoPila + "\"" + ";";
			System.out.println(temporal);
			final ResultSet rs = comando.executeQuery(temporal);

			while (rs.next()) {

				final float tension = rs.getFloat(3);
				final int capacidad = rs.getInt(4);
				final float corriente_nominal_de_descarga = rs.getFloat(5);
				final int corriente_pico_de_descarga = rs.getInt(6);
				final int carga_electrica = rs.getInt(7);
				final float constante_de_carga = rs.getFloat(8);
				final float constante_de_descarga = rs.getFloat(9);

				labelMarca.setFont(new Font("Conthrax Sb", Font.PLAIN, 14));
				labelMarca.setForeground(Color.cyan);
				labelMarca.setText(rs.getString(1));
				labelModelo.setFont(new Font("Conthrax Sb", Font.PLAIN, 14));
				labelModelo.setForeground(Color.cyan);
				labelModelo.setText(rs.getString(2));
				labelTension.setFont(new Font("Conthrax Sb", Font.PLAIN, 14));
				labelTension.setForeground(Color.cyan);
				labelTension.setText(String.valueOf(tension));
				labelCapacidad.setFont(new Font("Conthrax Sb", Font.PLAIN, 14));
				labelCapacidad.setForeground(Color.cyan);
				labelCapacidad.setText(String.valueOf(capacidad));
				Idescarga.setFont(new Font("Conthrax Sb", Font.PLAIN, 14));
				Idescarga.setForeground(Color.cyan);
				Idescarga.setText(String.valueOf(corriente_nominal_de_descarga));
				IPicoDescarga.setFont(new Font("Conthrax Sb", Font.PLAIN, 14));
				IPicoDescarga.setForeground(Color.cyan);
				IPicoDescarga.setText(String.valueOf(corriente_pico_de_descarga));
				Cargaelectrica.setFont(new Font("Conthrax Sb", Font.PLAIN, 14));
				Cargaelectrica.setForeground(Color.cyan);
				Cargaelectrica.setText(String.valueOf(carga_electrica));
				Constantecarga.setFont(new Font("Conthrax Sb", Font.PLAIN, 14));
				Constantecarga.setForeground(Color.cyan);
				Constantecarga.setText(String.valueOf(constante_de_carga));
				Constantedescarga.setFont(new Font("Conthrax Sb", Font.PLAIN, 14));
				Constantedescarga.setForeground(Color.cyan);
				Constantedescarga.setText(String.valueOf(constante_de_descarga));
			}

			conexion.close();

		} catch (final SQLException ex) {
			setTitle(ex.toString());
		}
	}

	public void showMsj(final String text) {
		JOptionPane.showMessageDialog(null, text, "WARNING", JOptionPane.WARNING_MESSAGE);
	}

	public void Calcular() {
		final String voltaje = labelTension.getText().toString();
		final String corriente = labelCapacidad.getText().toString();
		final String Tension = VSalida.getText().toString();
		final String Ampere = CapacidadPret.getText().toString();
		final String Carga = Cargaelectrica.getText().toString();
		final String constante_carga = Ccarga.getText().toString();
		final String constante_descarga = Cdescarga.getText().toString();

		float v;
		float i;
		float vs;
		float is;
		
		float Vs;
		float ResultVs;
		int ResultVsFinal;
		
		int ResultIsFinal;
		
		int Total;

		//Corriente nominal de descarga = capacidad/24 (horas del día)
		/*int Coulombios; //Coulombios = 3.6(constante)*capacidad
		float C_carga;		//Constante de carga la informa el fabricante
		float C_descarga;*/ //Constante de descarga = capacidad/1000 (constante)


		if (voltaje.equals("------") && corriente.equals("------"))
		{
			showMsj("seleccionar un tipo de pila");
		}
		else
			if(Tension.equals("") || Ampere.equals("")) {
				showMsj("Ingresar datos en todos los campos");
			}
			else {
				v = Float.parseFloat(voltaje);
				i = Integer.parseInt (corriente);
				vs = Float.parseFloat(Tension);
			    is = Integer.parseInt(Ampere);

				Vs = vs/v;
				ResultVs = Vs - (int)Vs;
				if(ResultVs > 0.5) {
					ResultVsFinal = (int)Vs + 1;
					PSerie.setText(""+ResultVsFinal);
					ResultIsFinal = (int) (is/i);
					Pparalelo.setText(""+ResultIsFinal);
					Total = ResultVsFinal * ResultIsFinal;
					TotalPilas.setText(""+Total);
				}
				else {
					PSerie.setText(""+(int)Vs);
					ResultIsFinal = (int) (is/i);
					Pparalelo.setText(""+ResultIsFinal);
					Total = (int) (Vs * ResultIsFinal);
					TotalPilas.setText(""+Total);
				}
			}	
	}
}