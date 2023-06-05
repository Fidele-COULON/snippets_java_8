package fr.fidtec.hystrix;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class CommandHelloWorld_Test {
	
	@Test
	public void givenInputBobAndDefaultSettings_whenCommandExecuted_thenReturnHelloBob(){
	    // assertThat(new CommandHelloWorld("Bob").execute(), equalTo("Hello Bob!"));
		
		String reponse = new CommandHelloWorld("Bob").execute();
		System.out.println("Reponse :" + reponse);
		assertEquals("Hello Bob!", reponse);
	}
	
}
