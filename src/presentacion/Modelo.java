package presentacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.json.JSONObject;

import dto.ClienteConectado;

public class Modelo {

	private Vista ventanaPrincipal;

	private List<ClienteConectado> listaClientes;
	private boolean swBombillaRojaOnL1;
	private boolean swBombillaAmarillaOnL1;
	private boolean swBombillaVerdeOnL1;

	private boolean swBombillaRojaOnL2;
	private boolean swBombillaAmarillaOnL2;
	private boolean swBombillaVerdeOnL2;
	

	public Vista getVentanaPrincipal() {
		if (ventanaPrincipal == null) {
			ventanaPrincipal = new Vista(this);
		}
		return ventanaPrincipal;
	}

	public void iniciar() {

		getVentanaPrincipal().setPreferredSize(new Dimension(800, 500));
		getVentanaPrincipal().getjFrame().setLocationRelativeTo(null);

		// A continuacion se resetea las bombillas y los botones se inhabilitan
		resetear();

		try {
			activarServidor();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(getVentanaPrincipal(), e.getMessage());
		}

	}

	public void activarServidor() throws Exception {
		System.out.println("***************************");
		System.out.println("SERVIDOR iniciado ...... Ok");
		System.out.println("Escuchando clientes .... Ok");
		System.out.println("***************************");

		Socket s = null;
		@SuppressWarnings("resource")
		ServerSocket ss = new ServerSocket(5001);

		while (true) {
			try {
				// El ServerSocket me da el Socket
				s = ss.accept();

				// Instancio un Thread
				(new Tarea(s, getVentanaPrincipal())).start();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void resetear() {
		swBombillaRojaOnL1 = true;
		swBombillaAmarillaOnL1 = true;
		swBombillaVerdeOnL1 = true;
		
		swBombillaRojaOnL2 = true;
		swBombillaAmarillaOnL2 = true;
		swBombillaVerdeOnL2 = true;
		
		// ------------------------------------------------------------
		// LINEA 1
		// ------------------------------------------------------------
		// COLOR -> Rojo
		getVentanaPrincipal().getBotonApagarRojoL1().setEnabled(true);
		getVentanaPrincipal().getBotonEncenderRojoL1().setEnabled(false);

		// COLOR -> Amarillo
		getVentanaPrincipal().getBotonApagarAmarilloL1().setEnabled(true);
		getVentanaPrincipal().getBotonEncenderAmarilloL1().setEnabled(false);

		// COLOR -> Verde
		getVentanaPrincipal().getBotonApagarVerdeL1().setEnabled(true);
		getVentanaPrincipal().getBotonEncenderVerdeL1().setEnabled(false);

		// ------------------------------------------------------------
		// LINEA 2
		// ------------------------------------------------------------
		// COLOR -> Rojo
		getVentanaPrincipal().getBotonApagarRojoL2().setEnabled(true);
		getVentanaPrincipal().getBotonEncenderRojoL2().setEnabled(false);

		// COLOR -> Amarillo
		getVentanaPrincipal().getBotonApagarAmarilloL2().setEnabled(true);
		getVentanaPrincipal().getBotonEncenderAmarilloL2().setEnabled(false);

		// COLOR -> Verde
		getVentanaPrincipal().getBotonApagarVerdeL2().setEnabled(true);
		getVentanaPrincipal().getBotonEncenderVerdeL2().setEnabled(false);

	}

	public void pintarSemaforos(Graphics g) {
		// A partir de que llega la primera conexion de un cliente
//		if (listaClientes != null && !listaClientes.isEmpty()) {
			// ---------------------------------------
			// Bombillas para linea 1
			// ---------------------------------------
			if (swBombillaRojaOnL1) {
				g.setColor(Color.RED);
			} else {
				g.setColor(new Color(152, 145, 145));
			}
			g.fillOval(20, 15, 50, 50);

			if(swBombillaAmarillaOnL1){
				g.setColor(Color.YELLOW);
			} else {
				g.setColor(new Color(152, 145, 145));
			}
			g.fillOval(20, 70, 50, 50);

			if(swBombillaVerdeOnL1){
				g.setColor(Color.GREEN);	
			}else{
				g.setColor(new Color(152, 145, 145));
			}
			g.fillOval(20, 125, 50, 50);

			// ---------------------------------------
			// Bombillas para linea 2
			// ---------------------------------------
			if(swBombillaRojaOnL2){
				g.setColor(Color.RED);	
			}else{
				g.setColor(new Color(152, 145, 145));
			}
			g.fillOval(420, 15, 50, 50);

			if(swBombillaAmarillaOnL2){
				g.setColor(Color.YELLOW);
			}else{
				g.setColor(new Color(152, 145, 145));
			}
			g.fillOval(420, 70, 50, 50);
			
			if(swBombillaVerdeOnL2){
				g.setColor(Color.GREEN);
			} else {
				g.setColor(new Color(152, 145, 145));
			}
			g.fillOval(420, 125, 50, 50);
			
//		} else { 
//			// Cuando inicia y no hay ningun cliente conectado
//			
//			// Linea 1
//			g.setColor(new Color(152, 140, 140));
//			g.fillOval(20, 15, 50, 50);
//
//			g.setColor(new Color(152, 140, 140));
//			g.fillOval(20, 70, 50, 50);
//
//			g.setColor(new Color(152, 140, 140));
//			g.fillOval(20, 125, 50, 50);
//
//			// Linea 2
//			g.setColor(new Color(152, 140, 140));
//			g.fillOval(420, 15, 50, 50);
//
//			g.setColor(new Color(152, 140, 140));
//			g.fillOval(420, 70, 50, 50);
//
//			g.setColor(new Color(152, 140, 140));
//			g.fillOval(420, 125, 50, 50);
//
//		}

	}

	public void encenderBombillaRoja(int numLinea) {
		System.out.println("Encendida bombilla Roja - Linea = " + numLinea);
		if (numLinea == 1) {
			getVentanaPrincipal().getBotonApagarRojoL1().setEnabled(true);
			getVentanaPrincipal().getBotonEncenderRojoL1().setEnabled(false);
			swBombillaRojaOnL1 = true;
		} else {
			getVentanaPrincipal().getBotonApagarRojoL2().setEnabled(true);
			getVentanaPrincipal().getBotonEncenderRojoL2().setEnabled(false);
			swBombillaRojaOnL2 = true;
		}
	}

	public void apagarBombillaRoja(int numLinea) {
		System.out.println("Apagada bombilla Roja - Linea = " + numLinea);
		if (numLinea == 1) {
			getVentanaPrincipal().getBotonApagarRojoL1().setEnabled(false);
			getVentanaPrincipal().getBotonEncenderRojoL1().setEnabled(true);
			swBombillaRojaOnL1 = false;
		} else {
			getVentanaPrincipal().getBotonApagarRojoL2().setEnabled(false);
			getVentanaPrincipal().getBotonEncenderRojoL2().setEnabled(true);
			swBombillaRojaOnL2 = false;
		}
	}

	public void encenderBombillaAmarilla(int numLinea) {
		System.out.println("Encendida bombilla Amarilla - Linea = " + numLinea);
		if (numLinea == 1) {
			getVentanaPrincipal().getBotonApagarAmarilloL1().setEnabled(true);
			getVentanaPrincipal().getBotonEncenderAmarilloL1().setEnabled(false);
			swBombillaAmarillaOnL1 = true;
		} else {
			getVentanaPrincipal().getBotonApagarAmarilloL2().setEnabled(true);
			getVentanaPrincipal().getBotonEncenderAmarilloL2().setEnabled(false);
			swBombillaAmarillaOnL2 = true;
		}
	}

	public void apagarBombillaAmarilla(int numLinea) {
		System.out.println("Apagada bombilla Amarilla - Linea = " + numLinea);
		if (numLinea == 1) {
			getVentanaPrincipal().getBotonApagarAmarilloL1().setEnabled(false);
			getVentanaPrincipal().getBotonEncenderAmarilloL1().setEnabled(true);
			swBombillaAmarillaOnL1 = false;
		} else {
			getVentanaPrincipal().getBotonApagarAmarilloL2().setEnabled(false);
			getVentanaPrincipal().getBotonEncenderAmarilloL2().setEnabled(true);
			swBombillaAmarillaOnL2 = false;
		}
	}

	public void encenderBombillaVerde(int numLinea) {
		System.out.println("Encendida bombilla Verde - Linea = " + numLinea);
		if (numLinea == 1) {
			getVentanaPrincipal().getBotonApagarVerdeL1().setEnabled(true);
			getVentanaPrincipal().getBotonEncenderVerdeL1().setEnabled(false);
			swBombillaVerdeOnL1 = true;
		} else {
			getVentanaPrincipal().getBotonApagarVerdeL2().setEnabled(true);
			getVentanaPrincipal().getBotonEncenderVerdeL2().setEnabled(false);
			swBombillaVerdeOnL2 = true;
		}
	}

	public void apagarBombillaVerde(int numLinea) {
		System.out.println("Apagada bombilla Verde - Linea = " + numLinea);
		if (numLinea == 1) {
			getVentanaPrincipal().getBotonApagarVerdeL1().setEnabled(false);
			getVentanaPrincipal().getBotonEncenderVerdeL1().setEnabled(true);
			swBombillaVerdeOnL1 = false;

		} else {
			getVentanaPrincipal().getBotonApagarVerdeL2().setEnabled(false);
			getVentanaPrincipal().getBotonEncenderVerdeL2().setEnabled(true);
			swBombillaVerdeOnL2 = false;
		}
	}

	public List<ClienteConectado> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<ClienteConectado> listaClientes) {
		this.listaClientes = listaClientes;
	}

}

class Tarea extends Thread {

	private Socket s = null;
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;

	ObjectOutputStream oos_c = null;
	ObjectInputStream ois_c = null;

	private Vista ventanaPrincipal;

	public Tarea(Socket socket, Vista ventana) {
		this.s = socket;
		this.ventanaPrincipal = ventana;
	}

	public void run() {
		try {
			// Enmascaro la entrada y la salida de bytes
			ois = new ObjectInputStream(s.getInputStream());
			oos = new ObjectOutputStream(s.getOutputStream());

			String obj = (String) ois.readObject();

			// Captura de los valores del JSON
			JSONObject jr = new JSONObject(obj.toString());

			// Obtiene los valores relacionados con el cliente que se conecto.
			String dirIp = s.getInetAddress().toString();
			dirIp = dirIp.substring(1, dirIp.length());

			int cli_numLineas = (int) jr.get("numLineas");
			int cli_numBombRojasFund = (int) jr.get("numBombRojasFund");
			int cli_numBombAmarillasFund = (int) jr.get("numBombAmarillasFund");
			int cli_numBombVerdesFund = (int) jr.get("numBombVerdesFund");

			// Procedemos a ingresar el registro del cliente que se conecto
			DefaultTableModel dtm = (DefaultTableModel) ventanaPrincipal.getTabla().getModel();
			Object nuevoReg[] = { dirIp, cli_numLineas, cli_numBombRojasFund, cli_numBombAmarillasFund,
					cli_numBombVerdesFund };
			dtm.addRow(nuevoReg);

			// ----------------------------------------------------------------------
			// Esta seccion de codigo es para abrir la segunda conexion al
			// cliente
			// Instancio el server con la IP y el PUERTO
			// s = new Socket(dirIp, 5002);
			//
			// oos_c = new ObjectOutputStream(s.getOutputStream());
			// ois_c = new ObjectInputStream(s.getInputStream());

			// ----------------------------------------------------------------------

			// System.out.println(dtm.getColumnName(1));

			// // Envio el saludo al cliente
			// oos.writeObject(saludo);
			// System.out.println("Saludo enviado ... OK");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
