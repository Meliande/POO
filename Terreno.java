package br.ufba.mata55.celular;

import java.awt.Color;
import java.awt.Graphics;

public class Terreno{
	protected void Desenha(Graphics g) {
    	// Desenha terreno
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Painel.LARGURA, Painel.ALTURA);
	}
}