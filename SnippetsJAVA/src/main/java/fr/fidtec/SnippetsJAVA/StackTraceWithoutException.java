package fr.fidtec.SnippetsJAVA;

public class StackTraceWithoutException {
	final static long NB_BOUCLES = 100000;
	
	@SuppressWarnings("unused")
	private static String showgetStackTraceWithException() {
		// new Exception().printStackTrace();
		
		 StringBuilder result = new StringBuilder();
		 final String NEW_LINE = System.getProperty("line.separator");
		 
		// add each element of the stack trace
	    for (StackTraceElement element : new Exception().getStackTrace() ){
	      result.append( element );
	      result.append( NEW_LINE );
	    }
	    return result.toString();
	    
	  //  return ExceptionUtils.getStackTrace(new Exception());
	    
	}
	
	@SuppressWarnings("unused")
	private static String showgetStackTraceWithThread() {
	
		 StringBuilder result = new StringBuilder();
		 final String NEW_LINE = System.getProperty("line.separator");
		 
		 // add each element of the stack trace
		 for (StackTraceElement element : Thread.currentThread().getStackTrace() ){
		     result.append("Méthode " + element.getMethodName() + " - "); 
			 result.append( element );
		     result.append( NEW_LINE );
		 }
		   
		 return result.toString();
   
	}

	public static String getCallingMethod1() {
	    StackTraceElement[] stack = new Throwable().getStackTrace();
	    return ( stack.length > 1 && null != stack[1] ? stack[1].getMethodName() : "[Unavailable]");
	}
	
	public static String getCallingMethod2() {		
		StackTraceElement[] stack = Thread.currentThread().getStackTrace();
		return ( stack.length > 2 && null != stack[2] ? stack[2].getMethodName() : "[Unavailable]");
	}
	
	public static String getParentCallingMethod() {		
		StackTraceElement[] stack = Thread.currentThread().getStackTrace();
		return ( stack.length > 3 && null != stack[3] ? stack[3].toString() : "[Unavailable]");
	}
	
	public static String myChild() {
		return getParentCallingMethod();
	}
	public static void main(String[] args) {
		
		// System.out.println("ici : \n" + showgetStackTraceWithException());
		// System.out.println("Liste des appels de méthodes : \n" + showgetStackTraceWithThread());
		
	/*	Date d1 = new Date() ;
		for (int i=0;i<NB_BOUCLES;i++) {
			getCallingMethod1();
		}
		
		long ecart1 = new Date().getTime() - d1.getTime();
		
		System.out.println("Durée 1 : " + ecart1 + " Méthode parente : " + getCallingMethod1());
		
		Date d2 = new Date() ;
		for (int i=0;i<NB_BOUCLES;i++) {
			getCallingMethod2();
		}
		
		long ecart2 = new Date().getTime() - d2.getTime();
		
		System.out.println("Durée 2: " + ecart2 + " Méthode parente : " + getCallingMethod2());*/
	
		System.out.println("ici : " + myChild());
	}

}
