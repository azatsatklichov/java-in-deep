package net.sahet.designpatterns.creational.abstractfactory;

import java.util.List;

public class GrapeGardenFactory extends GardenFactory {	

	@Override
	public List<String> getFruits(FruitColorType fruitColorType) {
		switch (fruitColorType) {
		case RED:
			return List.of("Allegro", "Aleatico", "Aglianico");
		case MIX:
			return  List.of("Agdam Gyzyl Uzumu", "Gelin Barmak", "Rozaki", "Mazzarrone");
		}
		throw new IllegalArgumentException("We do not have such " + fruitColorType + " fruit ");
	}
}
