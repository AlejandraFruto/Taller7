package uniandes.dpoo.taller7.interfaz4;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import uniandes.dpoo.taller7.modelo.Tablero;

public class TableroJuego extends JPanel {
    private Tablero tablero; // Instancia de la clase Tablero

    public TableroJuego(int tamanio) {
        this.tablero = new Tablero(tamanio);
        this.setPreferredSize(new Dimension(500, 500));

        // Añadir MouseListener para manejar los clics
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int cellWidth = getWidth() / tablero.darTablero().length;
                int cellHeight = getHeight() / tablero.darTablero().length;
                int col = e.getX() / cellWidth;
                int row = e.getY() / cellHeight;
                tablero.jugar(row, col);
                repaint();
            }
        });
    }

    // Método para actualizar el tamaño del tablero
    public void cambiarTamaño(int nuevo) {
        this.tablero = new Tablero(nuevo);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        dibujarTablero(g2d);
    }

    private void dibujarTablero(Graphics2D g2d) {
        boolean[][] cells = tablero.darTablero();
        int ancho = getWidth();
        int alto = getHeight();
        int anchoCelda = ancho / cells.length;
        int altoCelda = alto / cells.length;

        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells.length; col++) {
                if (cells[row][col]) {
                    g2d.setColor(Color.GRAY);
                } else {
                    g2d.setColor(Color.GREEN);
                }
                g2d.fillRect(col * anchoCelda, row * altoCelda, anchoCelda, altoCelda);
                g2d.setColor(Color.WHITE);
                g2d.drawRect(col * anchoCelda, row * altoCelda, anchoCelda, altoCelda);
            }
        }
    }
}
