package fr.fidtec.SnippetsJAVA;

public class MethodeWithOptionalParameters {

	private static void callMe(Object... o) {
		System.out.println("Lancement de callMe");
		for (int i=0; i < o.length; i++) {
			System.out.println("Parameter " + i + " : " + o[i]);
		}
	}
	public static void main(String[] args) {
		callMe("Coucou");
		callMe("Coucou","Salut");
		callMe("Coucou","Salut","Au revoir");
	}

}
