package fr.fidtec.beans;

import java.util.GregorianCalendar;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DateCalendar {
	private GregorianCalendar calendar;
	private int dureeEnSecondes;
}
