package net.sahet.designpatterns.creational.abstractfactory;

import java.util.List;

public class AppleGardenFactory extends GardenFactory {

	@Override
	public List<String> getFruits(FruitColorType fruitColorType) {
		switch (fruitColorType) {
		case RED:
			return List.of("Akane", "Ariane", "Cortland", "Honeycrisp");
		case MIX:
			return List.of("Granny Smith[", "Golden Delicious", "Crispin", "Jass");
		}
		throw new IllegalArgumentException("We do not have such " + fruitColorType + " fruit ");
	}

}
