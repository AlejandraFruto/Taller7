package uniandes.dpoo.taller7.interfaz3;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;

public class TableroJuego extends JPanel {
    private int gridSize = 5; // Tamaño por defecto del tablero

    public TableroJuego() {
        this.setPreferredSize(new Dimension(700, 500));
    }

    // Método para actualizar el tamaño del tablero
    public void setGridSize(int size) {
        this.gridSize = size;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        drawBoard(g2d);
    }

    private void drawBoard(Graphics2D g2d) {
        int width = getWidth();
        int height = getHeight();
        int cellWidth = width / gridSize;
        int cellHeight = height / gridSize;

        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                g2d.setColor(Color.YELLOW);
                g2d.fillRect(col * cellWidth, row * cellHeight, cellWidth, cellHeight);
                g2d.setColor(Color.BLACK);
                g2d.drawRect(col * cellWidth, row * cellHeight, cellWidth, cellHeight);
            }
        }
    }
}

