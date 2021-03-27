package fr.fidtec.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadsWithExecutorService {
	
	  private static ExecutorService pool = null;
    		   
	  public static void submit(int timeout) {
		  if (pool == null) {
			  pool =  new ThreadPoolExecutor(3, 10, 100L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
			  ((ThreadPoolExecutor) pool).allowCoreThreadTimeOut(true);
		  }
		  
		  System.out.println( ((ThreadPoolExecutor) pool).getCorePoolSize() + "/" + ((ThreadPoolExecutor) pool).getMaximumPoolSize());
		  
		  Job job = new Job();
		  job.timeout= timeout;
		  pool.submit(job);
	  }
    		             
	public static void stop() {
		pool.shutdown();
	}
	
}
