package fr.fidtec.demos;

public enum LazySingletonWithEnum {
	
	INSTANCE;

    private LazySingletonWithEnum() {
        System.out.println("Création du LazySingletonEnum");
    }

    public static LazySingletonWithEnum getInstance() {
        return INSTANCE;
    }

    public String getMessage() {
        return String.format("Reference : %s", super.toString());
    }
}
