import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck;

	public Deck() {
		this.deck = new ArrayList<Card>();
		for (int j = 1; j <= 3; j++) {
			for (int i = 1; i <= 13; i++) {
				deck.add(new Card(i, 1));
				deck.add(new Card(i, 2));
				deck.add(new Card(i, 3));
				deck.add(new Card(i, 4));
			}
			deck.add(new Card(-1, -1));
		}
		Collections.shuffle(deck);
	}

	public List<Card> getDeck() {
		return deck;
	}

	public void putCard(Card card) {
		this.deck.add(card);
	}

	public void removeCard(Card card) {
		this.deck.remove(card);
	}

	public Card getRandomCard() {
		int index = (int) (Math.random() * (deck.size()));
		Card card = deck.get(index);
		deck.remove(index);
		return card;
	}

}
