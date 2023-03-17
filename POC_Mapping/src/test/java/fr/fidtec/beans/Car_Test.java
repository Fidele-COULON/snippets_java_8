package fr.fidtec.beans;

import org.junit.Test;

public class Car_Test {

	@Test
	public void car_Creation() {
		Car car = new Car("Morris", 5, CarType.Berline);
		System.out.println("Car " + car.toString());
	}
}
