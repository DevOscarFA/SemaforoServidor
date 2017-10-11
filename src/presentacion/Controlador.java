package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;

public class Controlador implements ActionListener {

	private final Vista ventana;

	public Controlador(Vista aThis) {
		ventana = aThis;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton = (JButton) e.getSource();

		// -------------------------------------------------
		// Para linea 1
		// -------------------------------------------------
		if (boton.equals(ventana.getBotonEncenderRojoL1())) {
                    try {
                        ventana.getModelo().encenderBombillaRoja(1);
                    } catch (IOException ex) {
                        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
			ventana.repaint();
			return;
		}

		if (boton.equals(ventana.getBotonApagarRojoL1())) {
			ventana.getModelo().apagarBombillaRoja(1);
			ventana.repaint();
			return;
		}

		if (boton.equals(ventana.getBotonEncenderAmarilloL1())) {
			ventana.getModelo().encenderBombillaAmarilla(1);
			ventana.repaint();
			return;
		}

		if (boton.equals(ventana.getBotonApagarAmarilloL1())) {
			ventana.getModelo().apagarBombillaAmarilla(1);
			ventana.repaint();
			return;
		}

		if (boton.equals(ventana.getBotonEncenderVerdeL1())) {
			ventana.getModelo().encenderBombillaVerde(1);
			ventana.repaint();
			return;
		}

		if (boton.equals(ventana.getBotonApagarVerdeL1())) {
			ventana.getModelo().apagarBombillaVerde(1);
			ventana.repaint();
			return;
		}

		// -------------------------------------------------
		// Para linea 2
		// -------------------------------------------------
		if (boton.equals(ventana.getBotonEncenderRojoL2())) {
                    try {
                        ventana.getModelo().encenderBombillaRoja(2);
                    } catch (IOException ex) {
                        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
			ventana.repaint();
			return;
		}

		if (boton.equals(ventana.getBotonApagarRojoL2())) {
			ventana.getModelo().apagarBombillaRoja(2);
			ventana.repaint();
			return;
		}

		if (boton.equals(ventana.getBotonEncenderAmarilloL2())) {
			ventana.getModelo().encenderBombillaAmarilla(2);
			ventana.repaint();
			return;
		}

		if (boton.equals(ventana.getBotonApagarAmarilloL2())) {
			ventana.getModelo().apagarBombillaAmarilla(2);
			ventana.repaint();
			return;
		}

		if (boton.equals(ventana.getBotonEncenderVerdeL2())) {
			ventana.getModelo().encenderBombillaVerde(2);
			ventana.repaint();
			return;
		}

		if (boton.equals(ventana.getBotonApagarVerdeL2())) {
			ventana.getModelo().apagarBombillaVerde(2);
			ventana.repaint();
			return;
		}

	}

}
