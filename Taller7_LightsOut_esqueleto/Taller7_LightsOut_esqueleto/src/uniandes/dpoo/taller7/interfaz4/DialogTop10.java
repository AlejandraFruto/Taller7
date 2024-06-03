package uniandes.dpoo.taller7.interfaz4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import uniandes.dpoo.taller7.modelo.RegistroTop10;
import uniandes.dpoo.taller7.modelo.Top10;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;

public class DialogTop10 extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Top10 top10 = new Top10(); 
			DialogTop10 dialog = new DialogTop10(top10);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogTop10(Top10 top10) {
		setTitle("Top 10");
        setBounds(100, 100, 292, 389);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JList<String> list = new JList<>();
        list.setBackground(new Color(0, 0, 0));
        list.setVisibleRowCount(10);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setForeground(new Color(255, 255, 255));
        list.setBorder(new LineBorder(new Color(0, 255, 0), 4, true));
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(5, 5, 268, 336);
        contentPanel.add(scrollPane);

        ArrayList<String> top10List = new ArrayList<>();
        Collection<RegistroTop10> registros = top10.darRegistros();
        Integer i = 1;
        for (RegistroTop10 registro : registros) {
        	if (i>=1 & i<=3) {
        		String nombre = registro.darNombre();
        		
        	}
            top10List.add("    "+Integer.toString(i)+ "    "+ registro.darNombre() + ": " + registro.darPuntos());
            i++;
        }
        list.setListData(top10List.toArray(new String[0]));
	}
}
