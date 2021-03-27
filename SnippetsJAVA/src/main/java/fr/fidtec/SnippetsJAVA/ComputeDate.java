package fr.fidtec.SnippetsJAVA;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ComputeDate {

	static SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd HH:mm:ss"); 
	
	public static void main(String[] args) throws ParseException {
		
		Date dateNow = new Date();
		String dateSavedString = "18/02/14 20:39:00";
		Date dateSaved = null ;
		
		try {
			dateSaved = format.parse(dateSavedString);
		} catch (Exception e) {
			// nothing ToDo
		}
		
		if (null == dateSaved) {
			System.out.println("Expiré");
		} else {
			long diff = dateNow.getTime() - dateSaved.getTime();
			long diffSeconds = diff / 1000;  
			
			System.out.println("Maintenant : " + dateNow + " " + dateSaved + " "+ diff + " "+ diffSeconds);
			
			DateFormat dateFormat = DateFormat.getDateTimeInstance(
			        DateFormat.SHORT,
			        DateFormat.FULL);
			 
			System.out.println("ICI : " + dateFormat.format(dateNow));
			
			SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		    System.out.println(formater.format(dateNow));
		    
		}
		
	}

}
