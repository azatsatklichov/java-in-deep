package net.sahet.designpatterns.behavioral.state;

public class GameStartState implements State {

	@Override
	public void act() {
		System.out.println("Game started");
	}

}