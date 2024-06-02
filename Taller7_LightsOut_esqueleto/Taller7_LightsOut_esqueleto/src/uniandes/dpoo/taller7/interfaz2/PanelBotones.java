package uniandes.dpoo.taller7.interfaz2;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBotones extends JPanel  {

	public PanelBotones() {
		setVisible(true);
		GridLayout layout = new GridLayout(4,1);
		layout.setVgap(40);
		
		setLayout(layout);
		
		JButton nuevo = new JButton("NUEVO");
		JButton reiniciar = new JButton("REINICIAR");
		JButton top10 = new JButton("TOP-10");
		JButton cambiar = new JButton("CAMBIAR JUGADOR");
		
		add(nuevo);
		add(reiniciar);
		add(top10);
		add(cambiar);
	}

}
