package fr.fidtec.demos;

public enum LazySingletonWithEnum {
	
	INSTANCE; // Thread-Safe

    private LazySingletonWithEnum() {
        System.out.println("Creation du LazySingletonEnum"); // NOSONAR
    }

    public static LazySingletonWithEnum getInstance() {
        return INSTANCE;
    }

    public String getMessage() {
	      return "Hello World !"; // NOSONAR
	}
}
