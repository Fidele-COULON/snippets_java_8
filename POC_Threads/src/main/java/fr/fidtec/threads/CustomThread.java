package fr.fidtec.threads;

public class CustomThread extends Thread {

    private String threadName;
    
    public CustomThread(String threadName) {
        this.threadName = threadName;
    }

    public void run() {
        try {
            for(int i=0;i<500;i++) {
                System.out.println("Thread nommé : " + this.threadName + " - itération : " + i);
                Thread.sleep(30);  
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
    
	public static void main(String[] args) {
		Thread thr1 = new CustomThread("Toto");
		Thread thr2 = new CustomThread("Tata");

		thr1.start();
		thr2.start();
	}

}
