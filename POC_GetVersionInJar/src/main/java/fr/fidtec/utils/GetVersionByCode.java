package fr.fidtec.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

public class GetVersionByCode {

	public static void main(String[] args) throws IOException {
		
		String title = "Vide";
		String version = "Vide";
		
		InputStream manifestStream = GetVersionByCode.class.getClassLoader().getResourceAsStream("META-INF/MANIFEST.MF");
		if (manifestStream != null) {
			Manifest manifest = new Manifest(manifestStream);
			Attributes attributes = manifest.getMainAttributes();
			title = attributes.getValue("Implementation-Title");
			version = attributes.getValue("Implementation-Version");
		}
		
		// Pour affichage console
		System.out.println("Titre : " + title); //NOSONAR
		System.out.println("Version : " + version); //NOSONAR

		// Une autre solution (plus compacte pour un JAR)
		System.out.println("Titre (getPackage): " + GetVersionByCode.class.getPackage().getImplementationTitle()); //NOSONAR
		System.out.println("Version (getPackage): " + GetVersionByCode.class.getPackage().getImplementationVersion()); //NOSONAR

	}

}


