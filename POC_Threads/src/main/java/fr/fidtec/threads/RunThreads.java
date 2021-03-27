package fr.fidtec.threads;

public class RunThreads {

	public static void main(String[] args) {
		
		 Thread t = new Thread() {
	           public void run() {
	               System.out.println("Je suis dans le thread : " + Thread.currentThread().getName());
	           }
	       };
	       // t.run(); // ERREUR, lancé dans le thread principal !
	 
	       t.start();
	       
	       System.out.println("Je suis dans le thread : " + Thread.currentThread().getName());
	}

}
