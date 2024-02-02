package fr.fidtec.samples;

import fr.fidtec.observers.ResponseHandler1;
import fr.fidtec.observers.ResponseHandler2;

public class RunMe {

	// https://www.javatpoint.com/observer-pattern
	public static void main(String[] args) {
		EventSource eventSource = new EventSource();
		
		eventSource.addObserver(new ResponseHandler1());
		eventSource.addObserver(new ResponseHandler2());

		System.out.println("Nb Observers : " + eventSource.countObservers()); //NOSONAR
		
		eventSource.run("Coucou 1", false);
		
		eventSource.run("Coucou 2", true);
	}

}
