package fr.fidtec.threads;

public class Traitement implements Runnable {
	
	private String name;
	
	public Traitement(String name ) {
		this.name = name;
	}
	
	 public void run() {
		 System.out.println("Je suis dans le thread : " + Thread.currentThread().getName() + " et je m'appelle " + name);
     }

}
