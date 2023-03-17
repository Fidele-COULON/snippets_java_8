package fr.fidtec.mappers;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.junit.Test;
import org.mapstruct.factory.Mappers;

import fr.fidtec.beans.DateTimeZone;
import fr.fidtec.beans.DateCalendar;


public class IDateMapper_Test {

	private IDateMapper dateMapper = Mappers.getMapper(IDateMapper.class);
	
	@Test
	public void date_Test() throws ParseException {
		Date date = new Date();
		System.out.println("Date : " + date);
		
		System.out.println("TimeZone : "+ new GregorianCalendar().getTimeZone().toString());

		// When using a DateFormat, it defaults to the timezone of the JVM it's running in
		/*DateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		Date dateZ = utcFormat.parse(date.toString());
		System.out.println("DateZ : " + dateZ);*/
		
	}
	
	@Test
	public void shouldMapCalendarToDateTime() {
		
	    //given
		DateCalendar dateCalendar = new DateCalendar(new GregorianCalendar(1969,9,25,10,15,11), 240);
		System.out.println("TimeZone : "+ new GregorianCalendar().getTimeZone().getID());
		
	    //when
		DateTimeZone customDateTime = dateMapper.dateCalendarToDateTime(dateCalendar);

	    //then
	    assertThat(customDateTime).isNotNull();
	       
	    System.out.println("dateCalendar : " + dateCalendar);
	    System.out.println("customDateTime : " + customDateTime);
	}
	
}
