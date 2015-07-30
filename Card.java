
public class Card implements Comparable<Card> {
	private int value;

	public Card(int value) {
		this.value = value;
	}

	public boolean isNext(Card card) {
		return card.getValue() - this.getValue() == 1;
	}

	public boolean isPrevious(Card card) {
		return this.getValue() - card.getValue() == 1;
	}

	public boolean isSuitSame(Card card) {
		return (int) (card.getValue() / 13) == (int) (this.value / 13);
	}

	public boolean isRankSame(Card card) {
		return (card.getValue() % 13) == (this.value % 13);
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		// ToDo
		return "Card [value=" + value + "]";
	}

	@Override
	public int compareTo(Card other) {
		return Integer.compare(this.value, other.value);
	}

	public boolean isJoker() {
		return this.value == 53;
	}

}
