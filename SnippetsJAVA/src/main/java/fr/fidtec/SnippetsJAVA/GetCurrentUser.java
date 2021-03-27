package fr.fidtec.SnippetsJAVA;

public class GetCurrentUser {

	public static ThreadLocal<String> currentUserThreadLocal = new ThreadLocal<String>();
	 
	public static void main(String[] args) {
		String currentUser = currentUserThreadLocal.get();
		System.out.println("Je suis " + currentUser);
		
		currentUserThreadLocal.set("Fidele");
		currentUser = currentUserThreadLocal.get();
		System.out.println("Je suis " + currentUser);
		
	}

}
