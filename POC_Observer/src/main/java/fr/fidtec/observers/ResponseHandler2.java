package fr.fidtec.observers;

import java.util.Observable;
import java.util.Observer;

public class ResponseHandler2 implements Observer {

    public void update(Observable obj, Object arg) {  
    	System.out.println("Declenchement de ResponseHandler2"); // NOSONAR
	    if (arg instanceof String) {  
	        String response = (String) arg;  
	        System.out.println("\nReceived Response: " + response );  // NOSONAR
	    }  
    }
}
