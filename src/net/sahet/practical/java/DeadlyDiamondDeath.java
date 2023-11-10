package net.sahet.practical.java;

/**
 * 
 * Some programming languages (like C++) allow a class to extend more than one
 * other class. This capability is known as "multiple inheritance." The reason
 * that Java's creators chose not to allow multiple inheritance is that it can
 * become quite messy. In a nutshell, the problem is that if a class extended
 * two other classes, and both superclasses had, say, a doStuff() method, which
 * version of doStuff() would the subclass inherit? This issue can lead to a
 * scenario known as the "Deadly Diamond of Death," because of the shape of the
 * class diagram that can be created in a multiple inheritance design. The
 * diamond is formed when classes B and C both extend A, and both B and C
 * inherit a method from A. If class D extends both B and C, and both B and C
 * have overridden the method in A, class D has, in theory, inherited two
 * different implementations of the same method. Drawn as a class diagram, the
 * shape of the four classes looks like a diamond.
 * 
 * Java supports single inheritance model via Classes
 * 
 * Use Interfaces to apply multiple inheritance model in Java
 * 
 * 
 */
public class DeadlyDiamondDeath {

}

class A {
	int doDiamond() {
		return 3;
	}
}

class B extends A {
	int doDiamond() {
		return 3;
	}
}

class C extends A {
	int doDiamond() {
		return 2;
	}
}

//deadly diamond death situation
/*
 * class D extends B, C { //NO, never, C++ has this approach int doDiamond(){
 * return 3; } }
 */
