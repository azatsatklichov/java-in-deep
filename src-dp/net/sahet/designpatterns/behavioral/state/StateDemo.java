package net.sahet.designpatterns.behavioral.state;

public class StateDemo {
	public static void main(String[] args) {
		System.out.println("\n	State design patterns example ");
		GameContext context = new GameContext();
		State gameStartState = new GameStartState();
		State gameStopState = new GameStopState();

		context.setState(gameStartState);
		context.act();

		context.setState(gameStopState);
		context.act();
	}
}
