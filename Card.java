
public class Card implements Comparable<Card> {
	private int value;

	public Card(int value) {
		super();
		this.value = value;
	}

	public boolean isNext(Card card) {
		return false;

	}

	public boolean isPrevious(Card card) {
		return false;

	}

	public boolean isSuitSame(Card card) {
		return false;

	}

	public boolean isRankSame(Card card) {
		return false;

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

}
