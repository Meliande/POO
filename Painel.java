package br.ufba.mata55.celular;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import java.lang.Math;

public class Painel extends JPanel implements KeyListener, MouseInputListener {
    private static final long serialVersionUID = 1L;
    
    public static final int LARGURA = 500;
    public static final int ALTURA = 500;
   
	ArrayList<Comida> comidas = new ArrayList<Comida>();
	ArrayList<Veneno> venenos = new ArrayList<Veneno>();
	ArrayList<Comida> comidas_deletadas = new ArrayList<Comida>();
	ArrayList<Veneno> venenos_deletados = new ArrayList<Veneno>();
	
	 public void adicionaVenenos() {
	 	   	venenos.add(new Veneno());
	 	 }
	 	 public void adicionaComidas() {
	 	  	comidas.add(new Comida());
	 	 }	     
	     Celula player = new Celula();
	     Terreno terreno = new Terreno();
	     
    public Painel() {
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    public void atualiza() {
    	player.setPosicao(Controle.mouseX, Controle.mouseY);
    }
	void detectaColisão() {
		
		 //Colisão Comidas
		
    	comidas_deletadas.removeAll(comidas_deletadas);
    	for (Comida comida : comidas ) {    		
    		double distanciaX = 0;
    		double distanciaY = 0;
    		double distancia = 0;
    		double tamanhos = (player.getTamanho()+comida.getTamanho())/2;
    		//Player no mesmo ponto X e Y
    		if (player.getX() == comida.getX() && player.getY() == comida.getY()) {
				distancia = 0;
			} else {
    		//Player no mesmo ponto X e Y maior
				if (player.getX() == comida.getX() && player.getY() < comida.getY()) {
					distancia = distanciaX = distanciaY = comida.getY() - comida.getTamanho()/2 - player.getY() + player.getTamanho()/2;
				} else {
					//Player no mesmo ponto X e Y menor
					if (player.getX() == comida.getX() && player.getY() > comida.getY()) {
						distancia = distanciaX = distanciaY = player.getY()-player.getTamanho()/2 - comida.getY() + comida.getTamanho()/2;
					} else {
						//Player no mesmo ponto Y e X maior
						if (player.getY() == comida.getY() && player.getX() < comida.getX()) {
							distancia =	distanciaY = distanciaX = comida.getX()-comida.getTamanho()/2 - player.getX() + player.getTamanho()/2;
						} else {
							//Player no mesmo ponto Y e X menor
							if (player.getY() == comida.getY() && player.getX() > comida.getX()) {
								distancia =	distanciaY = distanciaX = player.getX()-player.getTamanho()/2 - comida.getX() + comida.getTamanho()/2;
							} else {
								distanciaX = comida.getX() - player.getX();
								distanciaY = player.getY() - comida.getY();
								distancia = Math.sqrt(Math.pow(distanciaX,2) + Math.pow(distanciaY,2));
									}
								}
							}
						}
					}
    		if (distancia < tamanhos) {
    			comida.setAtivo(false);
    			//player.incrementaTamanho(comida.getTamanho());
    			player.incrementaTamanho();
    			//if (player.getTamanho() >= 100) {
    			//	xTODO Finalizar o jogo e dar mensagem de vitória
    			//}
    		comidas_deletadas.add(comida);    		
    		}
    	}
    	comidas.removeAll(comidas_deletadas);
    	
    	//Colisão Venenos
    	
		venenos_deletados.removeAll(venenos_deletados);
		for (Veneno veneno : venenos ) {
    		double distanciaX = 0;
    		double distanciaY = 0;
    		double distancia = 0;
    		double tamanhos = (player.getTamanho()+veneno.getTamanho())/2;

    		//Player no mesmo ponto X e Y
    		if (player.getX() == veneno.getX() && player.getY() == veneno.getY()) {
				distancia = 0;
			} else {
    		//Player no mesmo ponto X e Y maior
				if (player.getX() == veneno.getX() && player.getY() < veneno.getY()) {
					distancia = distanciaX = distanciaY = veneno.getY() - veneno.getTamanho()/2 - player.getY() + player.getTamanho()/2;
				} else {
					//Player no mesmo ponto X e Y menor
					if (player.getX() == veneno.getX() && player.getY() > veneno.getY()) {
						distancia = distanciaX = distanciaY = player.getY()-player.getTamanho()/2 - veneno.getY() + veneno.getTamanho()/2;
					} else {
						//Player no mesmo ponto Y e X maior
						if (player.getY() == veneno.getY() && player.getX() < veneno.getX()) {
							distancia =	distanciaY = distanciaX = veneno.getX()-veneno.getTamanho()/2 - player.getX() + player.getTamanho()/2;
						} else {
							//Player no mesmo ponto Y e X menor
							if (player.getY() == veneno.getY() && player.getX() > veneno.getX()) {
								distancia =	distanciaY = distanciaX = player.getX()-player.getTamanho()/2 - veneno.getX() + veneno.getTamanho()/2;
							} else {
								distanciaX = veneno.getX() - player.getX();
								distanciaY = player.getY() - veneno.getY();
								distancia = Math.sqrt(Math.pow(distanciaX,2) + Math.pow(distanciaY,2));
									}
								}
							}
						}
					}
    		if (distancia < tamanhos) {
    			veneno.setAtivo(false);
				//player.decrementaTamanho(veneno.getTamanho());
				player.decrementaTamanho();
				venenos_deletados.add(veneno);
				//if (player.getTamanho() < 3) {
				//	//TODO Finalizar o jogo e dar mensagem de Game Over
				//}
			}
	}
	venenos.removeAll(venenos_deletados);
	}
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        	// Desenha terreno
        
        	terreno.Desenha(g);
        
        	// Desenha célula 

        	player.Desenha(g);
        	
    		// Desenha comidas e venenos
    		
    		for (Comida comida : comidas ) {
    			comida.Desenha(g);
    		}
    		for (Veneno veneno : venenos ) {
    			veneno.Desenha(g);}
    		}
    @Override
    public void keyTyped(KeyEvent e) {
        char keyChar = e.getKeyChar();

        if (keyChar == 27) { // Esc
            System.exit(0);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Controle.mouseX = e.getX();
        Controle.mouseY = e.getY();
    }
}
