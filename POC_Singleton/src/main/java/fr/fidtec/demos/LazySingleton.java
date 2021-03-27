package fr.fidtec.demos;

public class LazySingleton {
	
	// This takes advantage of the fact that static fields and blocks are initialized one after another
	// A class initialization occurs the first time we use one of its methods or fields
	private static final LazySingleton INSTANCE = new LazySingleton();

    private LazySingleton() {
        System.out.println("Création du Singleton au premier appel");
    }

    public static final LazySingleton getInstance() {
        return INSTANCE;
    }

}
