package fr.fidtec.demos;

public class DoubleCheckingLockingSingleton {
	
	private static volatile DoubleCheckingLockingSingleton instance; // NOSONAR
    
	private DoubleCheckingLockingSingleton() {
        System.out.println("Creation du Singleton au premier appel"); // NOSONAR
    }
	
	public static DoubleCheckingLockingSingleton getInstance() {
        
		if (instance == null) {
            synchronized (DoubleCheckingLockingSingleton .class) {
                if (instance == null) {
                    instance = new DoubleCheckingLockingSingleton();
                }
            }
        }
        
        return instance;
    }
	
	public String getMessage() {
	      return "Hello World !"; // NOSONAR
	}
}
