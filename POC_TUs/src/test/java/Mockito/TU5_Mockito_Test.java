package Mockito;

import org.junit.Before;
import org.junit.Test;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import fr.fidtec.POC_TUs.User;


/* Limitations du framework Mockito :

    Nécessite Java 1.5+
    impossible de mocker une classe ou une méthode finale
    impossible de mocker une méthode statique ou privée
    impossible de mocker les méthodes equals() et hashcode() (Mockito redéfinit et dépend fortement de ces 2 dernières)
    impossible de mocker les enums

    Les objets ‘mockés’ doivent être maintenus au fur et à mesure des évolutions du code à tester.

*/
    
public class TU5_Mockito_Test {
	
	/* Autre initialisation de Mockito si @RunWith(MockitoJUnitRunner.class) n'est pas utilisé, car deprecated */
	@Before
	public void setUp() {
	    MockitoAnnotations.initMocks(this);
	}

	@Test
	public void Test1() {
		User user = Mockito.mock(User.class); // Mockito encapsule et contrôle tous les appels effectués sur l’objet User. 
		
		/* Variante de la déclaration précédente
		   @Mock
		   User user;
		*/
		System.out.println(user.getNom() + " / " + user.toString()); // affiche null car la méthode n'est pas mockée
		
		// Le stubbing permet de définir le comportement des objets mockés face aux appels de méthodes sur ces objets.
		Mockito.when(user.getNom()).thenReturn("Fidele");
		System.out.println(user.getNom() + " / " + user.toString()); // affiche Fidele
		
		user.setNom("bob");
		System.out.println(user.getNom() + " / " + user.toString()); // affiche encore Fidele !
		
		Mockito.when(user.getNom()).thenReturn("Riri","Fifi","Loulou"); // suite de valeurs à renvoyer
		System.out.println(user.getNom() + " / " + user.toString()); // affiche Riri
		System.out.println(user.getNom() + " / " + user.toString()); // affiche Fifi
		System.out.println(user.getNom() + " / " + user.toString()); // affiche Loulou
	}
	
	@Test
	public void Test2() {
		User user = Mockito.mock(User.class);
		
		// On rétablit le comportement du getNom (Faire appel à la méthode d’origine)
		Mockito.when(user.getNom()).thenCallRealMethod();
		System.out.println(user.getNom() + " / " + user.toString()); // affiche null car le nom n'est pas setté
		
		// on rétablit également le comportement de la méthode setNom()
		Mockito.doCallRealMethod().when(user).setNom(Mockito.anyString()); // Mockito.anyString() est un Matcher
		user.setNom("Fidele");
		System.out.println(user.getNom() + " / " + user.toString()); // affiche Fidele
	}
	
	@Test
	public void Test3() {
		
		/* spy permet d’instancier l’objet mocké, ce qui peut être très utile quand nous souhaitons mocker une classe et non pas une interface.
		   Une autre différence est le stubbing. Si nous ne redéfinissons pas le comportement des méthodes de l’objet espionné,
		   les méthodes réelles seront appelées, alors qu’avec @Mock, nous sommes obligés de spécifier leurs comportements,
		   sinon la valeur nulle est retournée par défaut.
	    */ 
		
		User user = Mockito.spy(new User());
		/* Variante de la déclaration précédente
		   @Spy
	       User user = new User(‘user1’);
	       user.getLogin() // retourne user1
		*/
		
		Mockito.doReturn("fidele").when(user).getNom();
		System.out.println(user.getNom() + " / " + user.toString()); // affiche Fidele
		
		user.setNom("bob");
		System.out.println(user.getNom() + " / " + user.toString()); // affiche Fidele mais l'user est setté avec bob
		
		Mockito.doThrow(new IllegalArgumentException()).when(user).setNom(Mockito.eq("bad"));
		
		try {
			user.setNom("bad");	
		} catch (Exception e) {
			System.out.println("Erreur : " + e.toString());
		}
		
		System.out.println(user.getNom() + " / " + user.toString()); // affiche Fidele mais l'user est setté avec bob
		
		Mockito.doNothing().when(user).setNom("bob2"); // on bloque l'exécution si le nom est bob2 ... Mockito.anyString() pour tous les paramètres
		
		user.setNom("bob2"); 
		System.out.println(user.getNom() + " / " + user.toString()); // affiche bob car bob2 est bloqué
		
		user.setNom("bob3");
		System.out.println(user.getNom() + " / " + user.toString()); // affiche bob3 car seul bob2 est bloqué
		
	}
	
}
