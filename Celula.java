package br.ufba.mata55.celular;

import java.awt.Color;
import java.awt.Graphics;

public class Celula {
	private int x;
	private int y;
	private int tamanho;
	private boolean ativo;
	private String cor;
	
	public Celula() {
		x = Controle.mouseX;
		y = Controle.mouseY;
		tamanho = 10;
		ativo = true;
		cor = "WHITE";
	}
	protected void Desenha(Graphics g) {
    	// Desenha célula         
    	g.setColor(Color.WHITE);
		g.fillOval(x-tamanho/2, y-tamanho/2, tamanho, tamanho);
	}
	
	void setTamanho(int valor_tamanho) {
		tamanho = valor_tamanho;
	}
	void incrementaTamanho() {
		tamanho++;
	}
	void decrementaTamanho() {
		tamanho--;
	}
	void incrementaTamanho(int quantidade) {
		tamanho += quantidade;
	}
	void decrementaTamanho(int quantidade) {
		tamanho -= quantidade;
	}
	void setPosicao(int valor_x, int valor_y) {
		x = valor_x;
		y = valor_y;
	}
	void setAtivo(boolean valor_ativo ) {
		ativo = valor_ativo;
	}
	void setCor(String valor_cor) {
		cor = valor_cor;
	}
	int getTamanho() {
		return(tamanho);
	}
	boolean getAtivo() {
		return(ativo);
	}
	String getCor() {
		return(cor);
	}
	int getX() {
		return(x);
	}
	int getY() {
		return(y);
	}
}