package net.sahet.designpatterns.creational.abstractfactory;

import java.util.List;

/**
 * Abstract Factory which returns one of gardens
 *
 */
public abstract class GardenFactory {
 

	public static GardenFactory getGardenFactory(GardenType gardenType) {
		switch (gardenType) {
		case APPLE:
			return new AppleGardenFactory();
		case GRAPE:
			return new GrapeGardenFactory();
		}
		throw new IllegalArgumentException("We do not have such " + gardenType + " garden");
	}

	public abstract List<String> getFruits(FruitColorType fruitColorType);
}
