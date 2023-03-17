package fr.fidtec.mappers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import fr.fidtec.beans.DateCalendar;
import fr.fidtec.beans.DateTimeZone;

@Mapper
public interface IDateMapper {

	@Mapping(target = "dateTime", expression = "java(getDateTime(dateCalendar.getCalendar()))")
	@Mapping(target = "timeZone", expression = "java(getTimeZone(dateCalendar.getCalendar()))")
	@Mapping(target = "dureeEnMinutes", expression = "java(getDureeMinutes(dateCalendar.getDureeEnSecondes()))")
	DateTimeZone dateCalendarToDateTime(DateCalendar dateCalendar);
	
	 default String getDateTime(GregorianCalendar calendar) {
	     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
	     sdf.setTimeZone(calendar.getTimeZone());
		 Date date =  calendar.getTime();
		 return sdf.format(date);		 
	}
	 
	default String getTimeZone(GregorianCalendar calendar) {		 
		 return calendar.getTimeZone().getID();
	}
	 
	default int getDureeMinutes(int dureeEnSecondes) {		 
		return dureeEnSecondes / 60;
	}
}
