package Applis;

import utils.MavenInformations;

public class TestGetMavenArtifactVersion {

	public static void main(String[] args) {
		// Get the version information that is stored in a .jar-files MANIFEST.MF (POM avec section maven-jar-plugin)
		// Ne fonctionne que dans un JAR géré lancé par java -jar POC_Versions-0.0.1-SNAPSHOT.jar
		System.out.println("Version : " + TestGetMavenArtifactVersion.class.getPackage().getImplementationVersion());
		System.out.println("Version : " + TestGetMavenArtifactVersion.class.getPackage().getImplementationTitle());
		
		// Ne fonctionne pas dans un JAR car le POM n'est pas trouvé
		System.out.println("From pom.xml : " + new MavenInformations().toString());
		
		// Fonctionne dans un JAR mail il faut précisé le chemin dans le JAR
		System.out.println("From pom.properties : " + new MavenInformations("/META-INF/maven/fr.fidtec/POC_Versions").toString());
      	        
	}

}
