package fr.fidtec.threads;

public class Job implements Runnable{

	public int timeout = 2000;
	
	public void run() {

		System.out.println("J'entre dans le thread : " + Thread.currentThread().getName());
		
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
		System.out.println("Je sors dans le thread : " + Thread.currentThread().getName());

    }

}
