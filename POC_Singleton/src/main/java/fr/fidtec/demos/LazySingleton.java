package fr.fidtec.demos;

public class LazySingleton {
	
	// This takes advantage of the fact that static fields and blocks are initialized one after another
	// A class initialization occurs the first time we use one of its methods or fields
	private static final LazySingleton INSTANCE = new LazySingleton();

	// make the constructor private so that this class cannot be instantiated
    private LazySingleton() {
        System.out.println("Creation du Singleton au premier appel"); // NOSONAR
    }

    // Get the only object available
    public static final LazySingleton getInstance() {
        return INSTANCE;
    }

    // Singleton Method(s)
    public String getMessage() {
	      return "Hello World !"; // NOSONAR
	}
	
}
