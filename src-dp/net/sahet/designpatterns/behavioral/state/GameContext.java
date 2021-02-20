package net.sahet.designpatterns.behavioral.state;

public class GameContext implements State {

	private State gameState;

	public void setState(State state) {
		this.gameState = state;
	}

	public State getState() {
		return this.gameState;
	}

	@Override
	public void act() {
		this.gameState.act();

	}
}
