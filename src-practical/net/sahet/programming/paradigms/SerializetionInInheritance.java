package net.sahet.programming.paradigms;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializetionInInheritance {

}

class Player {
	Player() {
		System.out.println("p:parent ");
	}
}

class CardPlayer extends Player implements Serializable {
	CardPlayer() {
		System.out.println("c:child ");
	}

	public static void main(String[] args) {
	    System.out.println("     serialization");
		CardPlayer c1 = new CardPlayer();
		try {
			
			FileOutputStream fos = new FileOutputStream("play.txt");
			ObjectOutputStream os = new ObjectOutputStream(fos);
			os.writeObject(c1);
			os.close();
			
			System.out.println("    deserialization");
			
			FileInputStream fis = new FileInputStream("play.txt");
			ObjectInputStream is = new ObjectInputStream(fis);
			CardPlayer c2 = (CardPlayer) is.readObject();
			is.close();

			System.out
					.println("\n You see, during deserialization, \n"
					        + "only Parent object DEFAULT-CONSTRUCT is invoked");
		} catch (Exception x) {
		}
	}
}
