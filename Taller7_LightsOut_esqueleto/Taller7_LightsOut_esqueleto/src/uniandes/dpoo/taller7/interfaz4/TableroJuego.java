package uniandes.dpoo.taller7.interfaz4;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import uniandes.dpoo.taller7.modelo.Tablero;

public class TableroJuego extends JPanel {
    private Tablero tablero; // Instancia de la clase Tablero
    private Tablero tableroOriginal;
   

    public TableroJuego(int tamanio) {
        this.tablero = new Tablero(tamanio);
        this.setPreferredSize(new Dimension(500, 500));
        tableroOriginal = this.tablero;

        // Añadir MouseListener para manejar los clics
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	
                int cellWidth = getWidth() / tablero.darTablero().length;
                int cellHeight = getHeight() / tablero.darTablero().length;
                int col = e.getX() / cellWidth;
                int row = e.getY() / cellHeight;
                tablero.jugar(row, col);
                repaint();
                
                ((VentanaPrincipal) SwingUtilities.getWindowAncestor(TableroJuego.this)).actualizarJugadas();
               
                if(tablero.tableroIluminado() == true) {
                	finalizarPartida();
                }          	
            }      
        });
    }
    

    // Actualizar el tamaño y la dificultad del tablero
    public void cambiarTamaño(int tamaño, int dificultad) {
        this.tablero = (new Tablero(tamaño));
        this.tablero.desordenar(dificultad);
        this.tablero.salvar_tablero();
        
        repaint();
    }
    
    //Ir sumando jugadas
    public int jugadasActuales() {
        return tablero.darJugadas();
    }
    
    //Reiniciar al tablero guardado como Nuevo
    public void reiniciarTablero(){
    	tablero.reiniciar();
    	repaint();
    }
    
    //Finalizar partida
    public void finalizarPartida() {
    	 ((VentanaPrincipal) SwingUtilities.getWindowAncestor(TableroJuego.this)).partidaFinalizada();
    }
    
    //Obtener puntaje
    public int obtenerPuntaje() {
    	return this.tablero.calcularPuntaje();
    }
    
    /*public boolean verificarPuntaje() {
    	if(this.tablero.)
    }*/
    
    //Tablero
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
                    g2d.setColor(Color.GREEN);
                } else {
                    g2d.setColor(Color.GRAY);
                }
                g2d.fillRect(col * anchoCelda, row * altoCelda, anchoCelda, altoCelda);
                g2d.setColor(Color.WHITE);
                g2d.drawRect(col * anchoCelda, row * altoCelda, anchoCelda, altoCelda);
            }
        }
    }
    
  
}
