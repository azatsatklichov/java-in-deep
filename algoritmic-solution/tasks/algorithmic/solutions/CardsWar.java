package tasks.algorithmic.solutions;

import java.util.ArrayList;
import java.util.List;

public class CardsWar {

	public static void main(String[] args) {

		CardsWar cardsWar = new CardsWar();
		int win = cardsWar.getWinCountForAlec("A586QK", "JJ653K");
		System.out.println(win);

		win = cardsWar.getWinCountForAlec("23A84Q", "K2Q25J");
		System.out.println(win);
	}

	public int getWinCountForAlec(String A, String B) {
		int win = 0;

		List<Card> alecCards = getCards(A);
		List<Card> bobCards = getCards(B);
		for (int i = 0; i < alecCards.size(); i++) {
			if (win(alecCards.get(i), bobCards.get(i)))
				win++;
		}

		return win;
	}

	private List<Card> getCards(String cards) {
		List<Card> deck = new ArrayList<>();
		for (String card : cards.split("")) {
			deck.add(Card.getCard(card));
		}
		return deck;
	}

	private boolean win(Card c1, Card c2) {
		return c1.getWeight() > c2.getWeight();
	}

}

enum Card {

	ACE("A", 14), KING("K", 13), QUEEN("Q", 12), JACK("J", 11), TWO("2", 2), THREE("3", 3), FOUR("4", 4), FIVE("5", 5),
	SIX("6", 6), SEVEN("7", 7), EIGHT("8", 8), NINE("9", 9), TEN("10", 10);

	private String name;
	private int weight;

	private Card(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	public String getName() {
		return name;
	}

	public static Card getCard(String name) {
		Card card = null;
		for (Card c : Card.values()) {
			if (name.equals(c.getName())) {
				card = c;
				break;
			}
		}
		if (card == null)
			throw new IllegalArgumentException("Illegal card value");
		return card;
	}

	public static void main(String[] args) {

	}

}
