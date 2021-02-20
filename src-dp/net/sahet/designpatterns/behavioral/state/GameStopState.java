package net.sahet.designpatterns.behavioral.state;

public class GameStopState implements State {

	@Override
	public void act() {
		System.out.println("Game stopped");
	}

}