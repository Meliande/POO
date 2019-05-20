package br.ufba.mata55.celular;

import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;

public class Veneno{
		private int x;
		private int y;
		private int tamanho;
		private boolean ativo;
		private String cor;
		
		public Veneno() {
		    Random gerador = new Random();
			x = gerador.nextInt(Painel.LARGURA)+1;
			y = gerador.nextInt(Painel.ALTURA)+1;
			//tamanho = gerador.nextInt(20)+10;
			tamanho = 10;
			ativo = true;
			cor = "GREEN";
		}
		protected void Desenha(Graphics g) {
        	g.setColor(Color.GREEN);
        	g.fillOval(x-tamanho/2, y-tamanho/2, tamanho, tamanho);
        	g.setColor(Color.BLUE);
        	g.fillOval(x-tamanho/4, y-tamanho/4, tamanho/2, tamanho/2);
        	g.setColor(Color.GREEN);
        	g.fillOval(x-tamanho/8, y-tamanho/8, tamanho/4, tamanho/4);
		}
	
		void setTamanho(int valor_tamanho) {
			tamanho = valor_tamanho;
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
