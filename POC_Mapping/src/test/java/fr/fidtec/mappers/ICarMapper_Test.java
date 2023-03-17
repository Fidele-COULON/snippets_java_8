package fr.fidtec.mappers;

import org.junit.Test;

import fr.fidtec.beans.Car;
import fr.fidtec.beans.CarDTO;
import fr.fidtec.beans.CarType;

import static org.assertj.core.api.Assertions.*;

public class ICarMapper_Test {

	@Test
	public void shouldMapCarToDto() {
	    //given
	    Car car = new Car("Morris", 5, CarType.Berline);

	    //when
	    CarDTO carDTO = ICarMapper.INSTANCE.carToCarDto(car);

	    //then
	    assertThat(carDTO).isNotNull();
	    assertThat(carDTO.getMake()).isEqualTo("Morris");
	    assertThat(carDTO.getSeatCount()).isEqualTo(5);
	    assertThat(carDTO.getType()).isEqualTo("Berline");
	    
	    System.out.println("car : " + car.toString());
	    System.out.println("carDTO : " + carDTO.toString());
	}
}
