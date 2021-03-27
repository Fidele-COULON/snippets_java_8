package fr.fidtec.SnippetsJAVA;

import java.util.HashMap;

public class POC_ThreadLocal {
	
	private static HashMap<Integer, Long> bing = new HashMap<Integer, Long>();
	
	 public static class MyRunnable implements Runnable {	 
		 	
	        private ThreadLocal<String> threadLocal = new ThreadLocal<String>()  {
			    @Override protected String initialValue() {
			        return "This is the initial value";
			    }
			};

	        public void run() {
	            threadLocal.set("MyRunnable - ID=" + Thread.currentThread().getId()  );
	            
	            for (int i=0; i < 1000000 ; i ++) {
	            	bing.put(0, Thread.currentThread().getId());
	            }
	            
	            try {
	                Thread.sleep(2000);
	            } catch (InterruptedException e) {
	            }
	    
	            System.out.println("Fin : " + threadLocal.get());
	        }
	    }
	
	public static void main(String[] args) throws InterruptedException {	
			MyRunnable sharedRunnableInstance = new MyRunnable();

	        Thread thread1 = new Thread(sharedRunnableInstance);
	        Thread thread2 = new Thread(sharedRunnableInstance);

	        thread1.start();
	        thread2.start();

	        thread1.join(); //wait for thread 1 to terminate
	        thread2.join(); //wait for thread 2 to terminate
	        
	        System.out.println("Fin : " + bing.keySet().size() + " - " + bing.toString());
	}
}
