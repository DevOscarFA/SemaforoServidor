package presentacion;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Vista extends JComponent {

	private static final long serialVersionUID = 2183908252623796318L;

	private final Modelo modelo;
	private Controlador controlador;

	private JFrame jFrame;

	// Grupo de atributos para linea 1
	private JButton botonEncenderRojoL1;
	private JButton botonApagarRojoL1;

	private JButton botonEncenderAmarilloL1;
	private JButton botonApagarAmarilloL1;

	private JButton botonEncenderVerdeL1;
	private JButton botonApagarVerdeL1;

	// Grupo de atributos para linea 2
	private JButton botonEncenderRojoL2;
	private JButton botonApagarRojoL2;

	private JButton botonEncenderAmarilloL2;
	private JButton botonApagarAmarilloL2;

	private JButton botonEncenderVerdeL2;
	private JButton botonApagarVerdeL2;
	// ---------------------------------

	private JButton botonDesconectar;

	private JScrollPane scrollPanel;
	private JTable tabla;

	public Vista(Modelo aThis) {
		modelo = aThis;
		initComponents();
		capturarEventos();
	}

	public JFrame getjFrame() {
		if (jFrame == null) {
			jFrame = new JFrame("SERVIDOR - Administrador de Semaforos");
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jFrame.getContentPane().add(this);
			jFrame.setResizable(false);
			jFrame.setVisible(true);
			jFrame.pack();
		}
		return jFrame;
	}

	private void initComponents() {

		pintarSemaforoLinea1();
		pintarSemaforoLinea2();

		// Datos para la tabla
		Object[][] datos = null;

		// Cabeceras para las columnas de la tabla
		String[] cabeceras = new String[] { "IP Cliente", "Cant. Rojas Fund L1", "Cant. Amarillas Fund L1",
				"Cant. Verdes Fund L1", "Cant. Intermitentes L1", "Cant. Rojas Fund L2", "Cant. Amarillas Fund L2",
				"Cant. Verdes Fund L2", "Cant. Intermitentes L2" };

		tabla = new JTable();
		tabla.setModel(new DefaultTableModel(datos, cabeceras));
		scrollPanel = new JScrollPane();
		scrollPanel.setViewportView(tabla);
		add(scrollPanel, BorderLayout.CENTER);
		scrollPanel.setBounds(10, 200, 760, 150);

	}

	private void pintarSemaforoLinea1() {
		// --------------------------------------------------------------------
		// Establece las posiciones de los botones relacionados con la luz Roja
		botonEncenderRojoL1 = new JButton("Encender");
		add(botonEncenderRojoL1);
		botonEncenderRojoL1.setBounds(80, 25, 100, 30);

		botonApagarRojoL1 = new JButton("Apagar");
		add(botonApagarRojoL1);
		botonApagarRojoL1.setBounds(180, 25, 100, 30);
		// --------------------------------------------------------------------

		// --------------------------------------------------------------------
		// Establece las posiciones de los botones relacionados con la luz
		// Amarilla
		botonEncenderAmarilloL1 = new JButton("Encender");
		add(botonEncenderAmarilloL1);
		botonEncenderAmarilloL1.setBounds(80, 80, 100, 30);

		botonApagarAmarilloL1 = new JButton("Apagar");
		add(botonApagarAmarilloL1);
		botonApagarAmarilloL1.setBounds(180, 80, 100, 30);
		// --------------------------------------------------------------------

		// ---------------------------------------------------------------------
		// Establece las posiciones de los botones relacionados con la luz Verde
		botonEncenderVerdeL1 = new JButton("Encender");
		add(botonEncenderVerdeL1);
		botonEncenderVerdeL1.setBounds(80, 135, 100, 30);

		botonApagarVerdeL1 = new JButton("Apagar");
		add(botonApagarVerdeL1);
		botonApagarVerdeL1.setBounds(180, 135, 100, 30);
		// ---------------------------------------------------------------------

		// ---------------------------------------------------------------------
		// Establece las posiciones del boton relacionad con Desconectar
		botonDesconectar = new JButton("Desconectar");
		add(botonDesconectar);
		botonDesconectar.setBounds(620, 360, 150, 30);
		// ---------------------------------------------------------------------

		botonEncenderRojoL1.setEnabled(false);
		botonEncenderAmarilloL1.setEnabled(false);
		botonEncenderVerdeL1.setEnabled(false);
	}

	private void pintarSemaforoLinea2() {
		// --------------------------------------------------------------------
		// Establece las posiciones de los botones relacionados con la luz Roja
		botonEncenderRojoL2 = new JButton("Encender");
		add(botonEncenderRojoL2);
		botonEncenderRojoL2.setBounds(480, 25, 100, 30);

		botonApagarRojoL2 = new JButton("Apagar");
		add(botonApagarRojoL2);
		botonApagarRojoL2.setBounds(580, 25, 100, 30);
		// --------------------------------------------------------------------

		// --------------------------------------------------------------------
		// Establece las posiciones de los botones relacionados con la luz
		// Amarilla
		botonEncenderAmarilloL2 = new JButton("Encender");
		add(botonEncenderAmarilloL2);
		botonEncenderAmarilloL2.setBounds(480, 80, 100, 30);

		botonApagarAmarilloL2 = new JButton("Apagar");
		add(botonApagarAmarilloL2);
		botonApagarAmarilloL2.setBounds(580, 80, 100, 30);
		// --------------------------------------------------------------------

		// ---------------------------------------------------------------------
		// Establece las posiciones de los botones relacionados con la luz Verde
		botonEncenderVerdeL2 = new JButton("Encender");
		add(botonEncenderVerdeL2);
		botonEncenderVerdeL2.setBounds(480, 135, 100, 30);

		botonApagarVerdeL2 = new JButton("Apagar");
		add(botonApagarVerdeL2);
		botonApagarVerdeL2.setBounds(580, 135, 100, 30);
		// ---------------------------------------------------------------------

		botonEncenderRojoL2.setEnabled(false);
		botonEncenderAmarilloL2.setEnabled(false);
		botonEncenderVerdeL2.setEnabled(false);

	}

	private void capturarEventos() {
		// -------------------------------------------------------
		// Botones para linea 1
		botonEncenderRojoL1.addActionListener(getControlador());
		botonApagarRojoL1.addActionListener(getControlador());

		botonEncenderAmarilloL1.addActionListener(getControlador());
		botonApagarAmarilloL1.addActionListener(getControlador());

		botonEncenderVerdeL1.addActionListener(getControlador());
		botonApagarVerdeL1.addActionListener(getControlador());

		// -------------------------------------------------------
		// Botones para linea 2
		botonEncenderRojoL2.addActionListener(getControlador());
		botonApagarRojoL2.addActionListener(getControlador());

		botonEncenderAmarilloL2.addActionListener(getControlador());
		botonApagarAmarilloL2.addActionListener(getControlador());

		botonEncenderVerdeL2.addActionListener(getControlador());
		botonApagarVerdeL2.addActionListener(getControlador());
		// -------------------------------------------------------

		botonDesconectar.addActionListener(getControlador());
	}

	@Override
	public void paintComponent(Graphics g) {
		modelo.pintarSemaforos(g);
	}

	public Controlador getControlador() {
		if (controlador == null) {
			controlador = new Controlador(this);
		}

		return controlador;
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public JButton getBotonDesconectar() {
		return botonDesconectar;
	}

	public void setBotonDesconectar(JButton botonDesconectar) {
		this.botonDesconectar = botonDesconectar;
	}

	public JTable getTabla() {
		return tabla;
	}

	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}

	public JButton getBotonEncenderRojoL1() {
		return botonEncenderRojoL1;
	}

	public void setBotonEncenderRojoL1(JButton botonEncenderRojoL1) {
		this.botonEncenderRojoL1 = botonEncenderRojoL1;
	}

	public JButton getBotonApagarRojoL1() {
		return botonApagarRojoL1;
	}

	public void setBotonApagarRojoL1(JButton botonApagarRojoL1) {
		this.botonApagarRojoL1 = botonApagarRojoL1;
	}

	public JButton getBotonEncenderAmarilloL1() {
		return botonEncenderAmarilloL1;
	}

	public void setBotonEncenderAmarilloL1(JButton botonEncenderAmarilloL1) {
		this.botonEncenderAmarilloL1 = botonEncenderAmarilloL1;
	}

	public JButton getBotonApagarAmarilloL1() {
		return botonApagarAmarilloL1;
	}

	public void setBotonApagarAmarilloL1(JButton botonApagarAmarilloL1) {
		this.botonApagarAmarilloL1 = botonApagarAmarilloL1;
	}

	public JButton getBotonEncenderVerdeL1() {
		return botonEncenderVerdeL1;
	}

	public void setBotonEncenderVerdeL1(JButton botonEncenderVerdeL1) {
		this.botonEncenderVerdeL1 = botonEncenderVerdeL1;
	}

	public JButton getBotonApagarVerdeL1() {
		return botonApagarVerdeL1;
	}

	public void setBotonApagarVerdeL1(JButton botonApagarVerdeL1) {
		this.botonApagarVerdeL1 = botonApagarVerdeL1;
	}

	public JButton getBotonEncenderRojoL2() {
		return botonEncenderRojoL2;
	}

	public void setBotonEncenderRojoL2(JButton botonEncenderRojoL2) {
		this.botonEncenderRojoL2 = botonEncenderRojoL2;
	}

	public JButton getBotonApagarRojoL2() {
		return botonApagarRojoL2;
	}

	public void setBotonApagarRojoL2(JButton botonApagarRojoL2) {
		this.botonApagarRojoL2 = botonApagarRojoL2;
	}

	public JButton getBotonEncenderAmarilloL2() {
		return botonEncenderAmarilloL2;
	}

	public void setBotonEncenderAmarilloL2(JButton botonEncenderAmarilloL2) {
		this.botonEncenderAmarilloL2 = botonEncenderAmarilloL2;
	}

	public JButton getBotonApagarAmarilloL2() {
		return botonApagarAmarilloL2;
	}

	public void setBotonApagarAmarilloL2(JButton botonApagarAmarilloL2) {
		this.botonApagarAmarilloL2 = botonApagarAmarilloL2;
	}

	public JButton getBotonEncenderVerdeL2() {
		return botonEncenderVerdeL2;
	}

	public void setBotonEncenderVerdeL2(JButton botonEncenderVerdeL2) {
		this.botonEncenderVerdeL2 = botonEncenderVerdeL2;
	}

	public JButton getBotonApagarVerdeL2() {
		return botonApagarVerdeL2;
	}

	public void setBotonApagarVerdeL2(JButton botonApagarVerdeL2) {
		this.botonApagarVerdeL2 = botonApagarVerdeL2;
	}

}
