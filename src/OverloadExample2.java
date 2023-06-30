package net.sahet.iviews;
 

	class Animalz {
	}

	class Horsez extends Animalz {
	}

	class UseAnimalsz {
		public void doStuff(Animalz a) {
			System.out.println("In the Animal version");
		}

		public void doStuff(Horsez h) {
			System.out.println("In the Horse version");
		}

		public static void main(String[] args) {
			UseAnimalsz ua = new UseAnimalsz();
			Animalz animalObj = new Animalz();
			Horsez horseObj = new Horsez();
			ua.doStuff(animalObj);
			ua.doStuff(horseObj);
		}
	} 