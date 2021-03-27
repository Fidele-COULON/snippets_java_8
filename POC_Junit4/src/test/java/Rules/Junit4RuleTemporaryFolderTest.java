package Rules;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class Junit4RuleTemporaryFolderTest {

	private static String FOLDER_NAME ="Temp Folder Junit4";
	
	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();

	// Every time the above test method is executed, a temporary folder is created and it gets deleted after the execution of the method.
	// This is an example of an out-of-box rule provided by Junit.
	@Test
	public void testRule() throws IOException {
	  File newFolder = tempFolder.newFolder(FOLDER_NAME);
	  System.out.println("newFolder :" + newFolder.toString()); // newFolder :C:\Users\fidel\AppData\Local\Temp\junit5381585492657312164\Temp Folder Junit4
	  assertTrue(newFolder.exists());
	}
	  
}
