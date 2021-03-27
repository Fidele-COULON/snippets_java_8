package fr.fidtec.threads;

public class ThreadWithTraitement {
	
	public static void main(String[] args) {
		
	   Thread t1 = new Thread(new Traitement("Fidele"), "Premier thread"); 
       t1.start();
 
       Thread t2 = new Thread(new Traitement("Laurence"), "Second thread");
       t2.start();
 
       System.out.println("Je suis dans le thread : " + Thread.currentThread().getName());
       
	}
}
