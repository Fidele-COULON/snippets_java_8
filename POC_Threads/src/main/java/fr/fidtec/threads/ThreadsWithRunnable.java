package fr.fidtec.threads;

public class ThreadsWithRunnable {

	public static void main(String[] args) {
		
		 // Notre traitement, encapsulé dans un Runnable
	       Runnable job = new Runnable() {  // #1
	           public void run() {
	               System.out.println("Je suis dans le thread : " + Thread.currentThread().getName());
	           }
	       };
	 
	       Thread t1 = new Thread(job, "Premier thread"); //#2
	       t1.start();
	 
	       Thread t2 = new Thread(job, "Second thread");
	       t2.start();
	 
	       System.out.println("Je suis dans le thread : " + Thread.currentThread().getName());

	}

}
