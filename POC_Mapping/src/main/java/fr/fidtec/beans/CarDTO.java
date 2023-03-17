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
public class CarDTO {

    private String make;
    private int seatCount;
    private String type;
    
    private String invariable;
    
    private CarColor couleur;
    
}
