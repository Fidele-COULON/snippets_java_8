package fr.fidtec.threads;

import org.junit.Test;

public class ThreadsWithExecutorService_Test {

	@Test
	public void ThreadsWithExecutorService_FewThreads_Test() throws InterruptedException {
		ThreadsWithExecutorService.submit(10000);
		
		ThreadsWithExecutorService.submit(100);
		ThreadsWithExecutorService.submit(100);
		ThreadsWithExecutorService.submit(100);
		ThreadsWithExecutorService.submit(100);
		
		Thread.sleep(20000);
		
		System.out.println("C'est fini !!!");
	}
	
//	@Test
//	public void ThreadsWithExecutorService_FullThreads_Test() throws InterruptedException {

	/*
	 * for (int i=0; i < 3; i ++) { ThreadsWithExecutorService.submit(); }
	 */

    //		
//	       Thread.sleep(5000);
//	      
//	       for (int i=0; i < 10; i ++) {
//	    	   ThreadsWithExecutorService.submit();
//	       }
//	       
//	       Thread.sleep(5000);
//	       
//
//	       for (int i=0; i < 20; i ++) {
//	    	   ThreadsWithExecutorService.submit();
//	       }
//	       
//	       ThreadsWithExecutorService.stop();
//	 
//	       // ThreadsWithExecutorService.submit(new Job()); // lève une RejectedExecutionException 
//	       
//	       System.out.println("Je suis dans le thread : " + Thread.currentThread().getName()); 
//		
//	}
}
