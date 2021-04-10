package fr.fidtec.beans;

public class Compteur {

	private int valeur = 0;
	
	public int inc() {
		valeur ++;
		return valeur;
	}
	
	public int inc(int inc) {
		valeur += inc;
		return valeur;
	}
	
	public int dec() {
		valeur --;
		return valeur;
	}
	
	public int dec(int dec) {
		valeur -= dec;
		return valeur;
	}
	
	public int getValeur() {
		return valeur;
	}
	
}
