package br.ufba.mata55.celular;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Main extends JFrame {
    
	private Painel painel;

    public Main() {
        painel = new Painel();
        painel.setPreferredSize(new Dimension(Painel.LARGURA, Painel.ALTURA));
        add(painel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        addKeyListener(painel);
        
        //Altera o cursor para ficar "invisivel"
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
        cursorImg, new Point(0, 0), "blank cursor");
        painel.setCursor(blankCursor);       
    }
    private void executa() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Timer timer1 = new Timer(3000 / 1, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	painel.adicionaComidas();
                    	painel.adicionaVenenos();
                    }
                });
                Timer timer2 = new Timer(1000 / 50, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	painel.detectaColisão();
                        painel.atualiza();
                        painel.repaint();
                    }
                });
                timer1.start();
                timer2.start();
            }
        });
    }
    public static void main(String[] args) {
        new Main().executa();
    }
}