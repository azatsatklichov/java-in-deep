/*
 * package net.sahet.java.essentials.collections.streams.lambdas;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * 
 * abstract class Animalb { public abstract void checkup(); }
 * 
 * class Dogb extends Animalb { public void checkup() { // implement
 * Dog-specific code System.out.println("Dog checkup"); } }
 * 
 * class Catb extends Animalb { public void checkup() { // implement
 * Cat-specific code System.out.println("Cat checkup"); } }
 * 
 * 
 * class AnimalDoctorb { // method takes an array of any animal subtype public
 * void checkAnimals(Animalb[] animals) { for (Animalb a : animals) {
 * a.checkup(); } }
 * 
 * public static void main(String[] args) { // test it Dogb[] dogs = { new
 * Dogb(), new Dogb() }; Catb[] cats = { new Catb(), new Catb(), new Catb() };
 * //Birdb[] birds = { new Birdb() }; AnimalDoctorb doc = new AnimalDoctor();
 * doc.checkAnimals(dogs); // pass the Dog[] doc.checkAnimals(cats); // pass the
 * Cat[] //doc.checkAnimals(birds); // pass the Bird[] } }
 * 
 * class AnimalDoctorGeneric { // change the argument from Animal[] to
 * ArrayList<Animal> public void checkAnimals(ArrayList<Animalb> animals) { for
 * (Animalb a : animals) { a.checkup(); } }
 * 
 * public void addAnimal(List<? super Dog> animals) {
 * 
 * }
 * 
 * public static void main(String[] args) { // make ArrayLists instead of arrays
 * for Dog, Cat, Bird List<Dogb> dogs = new ArrayList<Dogb>(); dogs.add(new
 * Dog()); dogs.add(new Dog()); List<Catb> cats = new ArrayList<Catb>();
 * cats.add(new Cat()); cats.add(new Cat()); List<Birdb> birds = new
 * ArrayList<Birdb>(); birds.add(new Birdb()); // this code is the same as the
 * Array version AnimalDoctorGeneric doc = new AnimalDoctorGeneric(); // this
 * worked when we used arrays instead of ArrayLists //doc.checkAnimals(dogs); //
 * send a List<Dog> //doc.checkAnimals(cats); // send a List<Cat>
 * //doc.checkAnimals(birds); // send a List<Bird> } }
 */