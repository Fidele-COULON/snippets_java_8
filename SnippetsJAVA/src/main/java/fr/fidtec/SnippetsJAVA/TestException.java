package fr.fidtec.SnippetsJAVA;

public class TestException {

	public static void main(String[] args) throws MyException {
	
		try {
			throw new MyException("Coucou, j'ai planté !!!");			
		} catch (MyException e) {
			System.out.println("J'ai attrapé une " + e.getMessage() + "\n toString : " + e.toString());
		}
		
		try {
			throw new MyException(new Exception());			
		} catch (MyException e) {
			System.out.println("J'ai aussi attrapé une " + e.getMessage()+ "\n toString : " + e.toString());
		}
		
		try {
			throw new MyException(new Exception());			
		} catch (MyException e) {
			System.out.println("J'ai encore attrapé une " + e.getMessage()+ "\n toString : " + e.toString());
		} finally {
			System.out.println("je suis en phase Finally");
		}
		
		try {
			throw new MyException(new Exception());	// si pas de catch rend obligatoire throws MyException dans la méthode appellante		
		} finally {
			System.out.println("je suis en phase Finally");
		}
		
	}

}
