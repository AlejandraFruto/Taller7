package uniandes.dpoo.taller7.interfaz2;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelSuperior extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelSuperior() {
		setVisible(true);
		setLayout(new GridLayout());
		
		JLabel tamanio = new JLabel("Tamaño");
		JComboBox<String> tamanios = new JComboBox<String>();
		tamanios.addItem("5x5");
		tamanios.addItem("6x6");
		tamanios.addItem("7x7");
		
		JLabel dificultad = new JLabel("Dificultad");
		
		JRadioButton facil = new JRadioButton();
		facil.setText("Fácil");
		JRadioButton medio = new JRadioButton();
		facil.setText("Medio");
		JRadioButton dificil = new JRadioButton();
		facil.setText("Díficil");
	
		add(tamanio);
		add(tamanios);
		add(dificultad);
		add(facil);
		add(medio);
		add(dificil);
	}

}
