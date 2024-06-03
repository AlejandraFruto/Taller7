package uniandes.dpoo.taller7.interfaz4;

import uniandes.dpoo.taller7.modelo.*;
import java.awt.EventQueue;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JRadioButtonMenuItem;

public class VentanaPrincipal extends JFrame  implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JRadioButton rdbtnFacil;
	private JRadioButton rdbtnMedio;
	private JRadioButton rdbtnDificil;
	
	private JLabel cantJugadas;
	private JTextField textField_1;
	
	public static final String BOTON_1 = "B1";
	public static final String BOTON_2 = "B2";
	public static final String BOTON_3 = "B3";
	public static final String BOTON_4 = "B4";
	public static final String COMBO = "C1";
	
	public static final int DIF_FACIL = 2;
	public static final int DIF_MEDIA = 7;
	public static final int DIF_DIFICIL = 12;
	
	private TableroJuego tablero;
	private Tablero tableroOriginal;
	private Top10 top10;
	private JComboBox<String> tamanios;
	private DialogTop10 dialog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		getContentPane().setBackground(new Color(0, 0, 0));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		getContentPane().setLayout(null);
		
		top10 = new Top10(); 
		dialog = new DialogTop10(top10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 886, 44);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		//Panel Superior
		JLabel lblNewLabel = new JLabel("                 Tamaño");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblNewLabel);
		
		tamanios = new JComboBox<String>();
		tamanios.setForeground(new Color(255, 255, 255));
		tamanios.setBackground(new Color(0, 0, 0));
		tamanios.addItem("5x5");
		tamanios.addItem("4x4");
		tamanios.addItem("6x6");
		tamanios.addItem("7x7");
		
		panel.add(tamanios);
		tamanios.setActionCommand(COMBO);
		tamanios.addActionListener(this);
		
		JLabel lblNewLabel_1 = new JLabel("      Dificultad");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
			//Botón fácil
		rdbtnFacil = new JRadioButton("Fácil");
		rdbtnFacil.setForeground(new Color(255, 255, 255));
		rdbtnFacil.setBackground(new Color(0, 0, 0));
		rdbtnFacil.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(rdbtnFacil);
		
			//Botón Medio
		rdbtnMedio = new JRadioButton("Medio");
		rdbtnMedio.setBackground(new Color(0, 0, 0));
		rdbtnMedio.setForeground(new Color(255, 255, 255));
		rdbtnMedio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(rdbtnMedio);
		
	    rdbtnDificil = new JRadioButton("Díficil");
		rdbtnDificil.setForeground(new Color(255, 255, 255));
		rdbtnDificil.setBackground(new Color(0, 0, 0));
		rdbtnDificil.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(rdbtnDificil);
		
		ButtonGroup dificultadGrupo = new ButtonGroup();
        dificultadGrupo.add(rdbtnFacil);
        dificultadGrupo.add(rdbtnMedio);
        dificultadGrupo.add(rdbtnDificil);
		
		//Panel Lateral -> Botones
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(714, 45, 172, 572);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNuevo = new JButton("NUEVO");
		btnNuevo.setBackground(new Color(255, 255, 255));
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		btnNuevo.setBounds(10, 152, 142, 31);
		panel_1.add(btnNuevo);
		btnNuevo.setActionCommand(BOTON_1);
		btnNuevo.addActionListener(this);
		
		JButton btnReiniciar = new JButton("REINICIAR");
		btnReiniciar.setBackground(new Color(255, 255, 255));
		btnReiniciar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		btnReiniciar.setBounds(10, 193, 142, 31);
		panel_1.add(btnReiniciar);
		btnReiniciar.setActionCommand(BOTON_2);
		btnReiniciar.addActionListener(this);
		
		JButton btnTop = new JButton("TOP 10");
		btnTop.setBackground(new Color(255, 255, 255));
		btnTop.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		btnTop.setBounds(10, 234, 142, 31);
		panel_1.add(btnTop);
		btnTop.setActionCommand(BOTON_3);
		btnTop.addActionListener(this);
		
		JLabel label = new JLabel("");
		label.setBounds(81, 180, 81, 180);
		panel_1.add(label);
		
		JButton btnCambiarJugador = new JButton("CAMBIAR JUGADOR");
		btnCambiarJugador.setBackground(new Color(255, 255, 255));
		btnCambiarJugador.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		btnCambiarJugador.setBounds(10, 275, 142, 31);
		panel_1.add(btnCambiarJugador);
		btnCambiarJugador.setActionCommand(BOTON_4);
		btnCambiarJugador.addActionListener(this);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(81, 360, 81, 180);
		panel_1.add(label_1);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 619, 876, 44);
		getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(0, 4, 0, 0));
		
		
		//Panel Inferior -> Jugadas
		JLabel lblNewLabel_2 = new JLabel("Jugadas:   ");
		lblNewLabel_2.setBackground(new Color(0, 0, 0));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_2.add(lblNewLabel_2);
		
		cantJugadas = new JLabel();
		cantJugadas.setBackground(new Color(0, 0, 0));
		cantJugadas.setForeground(new Color(0, 0, 0));
		cantJugadas.setText("0");
		cantJugadas.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_2.add(cantJugadas);
		
		
		JLabel lblNewLabel_3 = new JLabel("Jugador:    ");
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setBackground(new Color(0, 0, 0));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_2.add(lblNewLabel_3);
		
		textField_1 = new JTextField(" ");
		textField_1.setForeground(new Color(0, 0, 0));
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_1.enable(false);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
	
		
		
		//Panel Cnentral -> Tablero de Juego
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 0));
		panel_3.setBounds(0, 45, 712, 572);
		getContentPane().add(panel_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		tablero = new TableroJuego(5);
		tableroOriginal = new Tablero(5);
		panel_3.add(tablero);
		
		top10 = new Top10();
			
	}
	
	public void btnNuevo() {
		String selectedSize = (String) tamanios.getSelectedItem();
		int gridSize = Integer.parseInt(selectedSize.substring(0, selectedSize.indexOf('x')));
		
		
		if (rdbtnFacil.isSelected() == true) {
			tablero.cambiarTamaño(gridSize, DIF_FACIL);
			cantJugadas.setText("0");
		}
		
		else if(rdbtnMedio.isSelected() == true) {
			tablero.cambiarTamaño(gridSize, DIF_MEDIA);
			cantJugadas.setText("0");
		}
		
		else if(rdbtnDificil.isSelected() == true) {
			tablero.cambiarTamaño(gridSize, DIF_DIFICIL);
			cantJugadas.setText("0");
		}
		
		else {
			JOptionPane.showMessageDialog(this, "Se debe escoger una dificultad.",
					"Dificultad no elegida", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
    void actualizarJugadas() {
       cantJugadas.setText(Integer.toString(tablero.jugadasActuales()));
    }
	
	public void btnReiniciar() {
		tablero.reiniciarTablero();
		cantJugadas.setText("0");
	}
	
	public void btnTop10() {
		 DialogTop10 dialog = new DialogTop10(top10);
	     dialog.setVisible(true);
	     
	}
	
	public void partidaFinalizada() {
        JOptionPane.showMessageDialog(this, "¡Completaste el tablero! Tu puntaje ha sido registrado.");
        int puntaje = tablero.obtenerPuntaje();
        if (top10.esTop10(puntaje)) {
            String nombre = textField_1.getText();
            top10.agregarRegistro(nombre, puntaje);
          
        }
        cantJugadas.setText("0");
    }
		
		
		
	
	
	public void cambiarJugador() {
		textField_1.setText("");
		String name = JOptionPane.showInputDialog("Escribre tu nombre");
		textField_1.setText(name);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_1.setForeground(new Color(0, 0, 0));
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
String comando = e.getActionCommand();
		
		if(BOTON_1.equals(comando)) {
			btnNuevo();
		}else if(BOTON_2.equals(comando)) {
			btnReiniciar();
		}else if(BOTON_3.equals(comando)) {
			btnTop10();
		}else if(BOTON_4.equals(comando)) {
			cambiarJugador();
		}
		
	}
}
