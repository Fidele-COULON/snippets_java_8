package fr.fidtec.heritage;

public class RunMe_Parent_Enfant {

	public static void main(String[] args) {
		Parent p = new Parent("COULON", "Fidele");
		System.out.println("Parent : " + p);
		
		Enfant e1 = new Enfant(p, "Vanille");
		System.out.println("Enfant1 : " + e1);

		// Enfant e2 = new Enfant("COULON", "PetitFidele"); // Constructeur non trouvé (non hérité)
		Enfant e2 = new Enfant(p, "PetitFidele");
		System.out.println("Enfant2 : " + e2);
		
		// Enfant e3 = new Enfant(); // Constructeur non trouvé (non hérité) car sans argument
		Enfant e3 = new Enfant(p, "Capucine");
		System.out.println("Enfant3 : " + e3);
		
		System.out.println("Du même parent : " + (e1.getParent().equals(e2.getParent()) && e1.getParent().equals(e3.getParent())));
	}

}
