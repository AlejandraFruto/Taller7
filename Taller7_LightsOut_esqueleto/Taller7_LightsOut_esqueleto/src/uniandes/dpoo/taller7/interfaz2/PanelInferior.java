package uniandes.dpoo.taller7.interfaz2;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelInferior extends JPanel{

	public PanelInferior() {
		setVisible(true);
		setLayout(new GridLayout());
		
		JLabel jugadas = new JLabel("Jugadas:");
		JTextField jugadas_1 = new JTextField("0");
		
		JLabel jugador = new JLabel("Jugador:");
		JTextField jugador_1 = new JTextField();
		
		
		add(jugadas);
		add(jugadas_1);
		add(jugador);
		add(jugador_1);
	}

}
