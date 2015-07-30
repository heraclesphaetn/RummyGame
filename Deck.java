import java.util.ArrayList;
import java.util.List;

public class Deck {
	private List<Card> deck;

	public Deck() {
		this.deck = new ArrayList<Card>();
		int j;
		for (int i = 1; i <= 159; i++) {
			j = i % 53 == 0 ? 53 : i % 53;
			deck.add(new Card(j));
		}
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
		int index = (int) (Math.random() * 160);
		Card card = new Card(deck.get(index).getValue());
		deck.remove(index);
		return card;
	}

}
