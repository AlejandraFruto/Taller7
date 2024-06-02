package uniandes.dpoo.taller7.interfaz2;
import java.awt.BorderLayout;

import javax.swing.*;

public class VentanaPrincipal1 extends JFrame {
	
	private PanelSuperior superior;
	private PanelInferior inferior;
	private PanelBotones lateral;
	private PanelCentral central;
	
	public VentanaPrincipal1() {
		setTitle("Lights Out");
		setSize(900,700);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		superior = new PanelSuperior();
		add(superior, BorderLayout.NORTH);
		getContentPane().add(superior);
		
		inferior = new PanelInferior();
		add(inferior, BorderLayout.SOUTH);
		getContentPane().add(inferior);
		
		lateral = new PanelBotones();
		add(superior, BorderLayout.EAST);
		getContentPane().add(lateral);
		
		central = new PanelCentral();
		add(superior, BorderLayout.NORTH);
		getContentPane().add(central);
		
		
	}

	
	
	public static void main( String[] pArgs ) {
		VentanaPrincipal1 interfaz = new VentanaPrincipal1();
		
	}
	
}
