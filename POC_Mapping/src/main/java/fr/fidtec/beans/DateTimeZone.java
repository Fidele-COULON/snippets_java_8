package fr.fidtec.beans;

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
public class DateTimeZone {
	private String dateTime;
	private String timeZone;
	private int dureeEnMinutes;
}
