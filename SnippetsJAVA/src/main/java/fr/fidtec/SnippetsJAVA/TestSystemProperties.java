package fr.fidtec.SnippetsJAVA;

public class TestSystemProperties {

	public static void main(String[] args) {

		// System.getProperty() gets a property as defined by the JVM
		// (either the JVM itself or any -D options you may have passed at the command line).
		
		System.out.println("JRE Home : " + System.getProperty("java.home"));
		
		System.out.println("Operating system architecture : " + System.getProperty("os.arch"));
		
		System.out.println("Operating system name : " + System.getProperty("os.name"));
		
		System.out.println("Operating system version : " + System.getProperty("os.version"));
		
		System.out.println("JRE Home : " + System.getProperty("java.home"));
			
		System.out.println("User account name : " + System.getProperty("user.name"));
		
		System.out.println("Message : " + System.getProperty("Message")); // Custom JVM Option -DMessage="Coucou"
		
		System.out.println("------------------------------------------------------------");
		
		System.out.println("ALL : " + System.getProperties());
		
		System.out.println("------------------------------------------------------------");
		
		 // display new properties
        System.getProperties().list(System.out);
	}

}
