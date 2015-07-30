import java.util.ArrayList;
import java.util.List;

public class Game {
	private List<Card> hand;
	private int numOfNaturalSeq;
	private int numOfSeq;
	private int numOfGroup;
	private int numOfTriplets;
	private int numOfQuadruples;

	public Game() {
		this.hand = new ArrayList<Card>();
		this.numOfNaturalSeq = 0;
		this.numOfSeq = 0;
		this.numOfGroup = 0;
		this.numOfTriplets = 0;
		this.numOfQuadruples = 0;
	}

	public void deal() {
		// initialise hand with 12 cards and 1 joker
		// call card() cons for joker
	}

	public int calcMinCardsForDeclare() {
		return 0;
	}

	private boolean isSequence(Card[] cards) {
		return false;
	}

	private boolean isNaturalSequence(Card[] cards) {
		
	}

	private boolean isGroup(Card[] cards) {
		for (int i = 1; i < cards.length; i++) {
			if (!cards[0].isRankSame(cards[i])) {
				return false;
			}
		}
		return true;
	}

	private boolean isTriplet(Card[] cards) {
		return cards.length == 3;
	}

	private boolean isQuadruple(Card[] cards) {
		return cards.length == 4;
	}

	private boolean isCanasta(Card[] cards) {
		for (int i = 1; i < cards.length; i++) {
			if (!(cards[0].isRankSame(cards[i]) && cards[0].isSuitSame(cards[i]))) {
				return false;
			}
		}
		return true;
	}
}
