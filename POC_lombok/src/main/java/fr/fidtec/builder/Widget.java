package fr.fidtec.builder;

import lombok.Builder;
import lombok.Getter;

// https://projectlombok.org/features/Builder
// https://www.baeldung.com/lombok-builder
@Getter
@Builder(toBuilder = true)
public class Widget {
	private final String name;
    private final int id;
}
