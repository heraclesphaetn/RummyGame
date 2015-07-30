import java.util.List;

public class Deck {
	private List<Card> deck;

	public Deck() {
		int[] deck = new int[159];
		for(int i=0;i<159;i++)
			{
				deck[i]=(i+1)%53;
				if(i%53 == 0) deck[i-1]=53;
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
