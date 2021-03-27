package utils;

import java.io.FileReader;
import java.io.InputStream;
import java.util.Properties;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;

public class MavenInformations {

	private String groupId;
	private String artifactId;
	private String version;
		
	public String getGroupId() {
		return groupId;
	}
	
	public String getArtifactId() {
		return artifactId;
	}
	
	public String getVersion() {
		return version;
	}

	// Utilisé depuis Eclipse
	public MavenInformations() {
		super();
	
		MavenXpp3Reader reader = new MavenXpp3Reader();
        Model model;
        
		try {
			model = reader.read(new FileReader("pom.xml"));		
					 		

			System.out.println("id" + model.getId());
			
			groupId = model.getGroupId();
			artifactId = model.getArtifactId();
			version = model.getVersion();
		      
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	// Utilisé dans un JAR 
	public MavenInformations(String myLocalPath) {
		super();
	
		 // try to load from maven properties first
	    try {
	        Properties p = new Properties();
	        InputStream is = getClass().getResourceAsStream(myLocalPath + "/pom.properties");
	        if (is != null) {
	            p.load(is);
				groupId = p.getProperty("groupId", "");
				artifactId = p.getProperty("artifactId", "");			
	            version = p.getProperty("version", ""); 
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Override
	public String toString() {
		return "MavenInformations groupId=" + groupId + ", artifactId=" + artifactId + ", version=" + version + "]";
	}
	
}
