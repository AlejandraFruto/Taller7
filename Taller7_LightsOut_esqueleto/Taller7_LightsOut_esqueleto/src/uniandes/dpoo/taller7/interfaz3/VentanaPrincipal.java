package uniandes.dpoo.taller7.interfaz3;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JTextField;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JRadioButton rdbtnNewRadioButton = new JRadioButton("Fácil");
	private JTextField textField;
	private JTextField textField_1;

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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 886, 44);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("      Tamaño");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblNewLabel);
		
		JComboBox<String> tamanios = new JComboBox<String>();
		tamanios.addItem("5x5");
		tamanios.addItem("6x6");
		tamanios.addItem("7x7");
		
		panel.add(tamanios);
		
		JLabel lblNewLabel_1 = new JLabel("Dificultad");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Medio");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Díficil");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(rdbtnNewRadioButton_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(714, 45, 172, 572);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNuevo = new JButton("NUEVO");
		btnNuevo.setBounds(10, 152, 142, 31);
		panel_1.add(btnNuevo);
		
		JButton btnNewButton = new JButton("REINICIAR");
		btnNewButton.setBounds(10, 193, 142, 31);
		panel_1.add(btnNewButton);
		
		JButton btnTop = new JButton("TOP 10");
		btnTop.setBounds(10, 234, 142, 31);
		panel_1.add(btnTop);
		
		JLabel label = new JLabel("");
		label.setBounds(81, 180, 81, 180);
		panel_1.add(label);
		
		JButton btnCambiarJugador = new JButton("CAMBIAR JUGADOR");
		btnCambiarJugador.setBounds(10, 275, 142, 31);
		panel_1.add(btnCambiarJugador);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(81, 360, 81, 180);
		panel_1.add(label_1);
		panel_1.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnNewButton, btnNuevo, btnTop, btnCambiarJugador, label, label_1}));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 619, 876, 44);
		getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("   Jugadas:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_2.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setText("0");
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Jugador:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_2.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 45, 712, 572);
		getContentPane().add(panel_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		TableroJuego tablero = new TableroJuego();
		panel_3.add(tablero);
			
	}
}
