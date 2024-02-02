package fr.fidtec.samples;

import java.util.Observable;

public class EventSource extends Observable {

	public void run(String response, boolean setChanged) {
	     if (setChanged) {
	    	 setChanged();  
	     }
         
	     notifyObservers(response);  
         
         System.out.println("Changed : " + hasChanged()); //NOSONAR
	}
}
