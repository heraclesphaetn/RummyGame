import java.util.List;

public class Deck {
	private List<Card> deck;

	public Deck() {
		// initialise deck with 159 cards
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

}
