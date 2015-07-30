import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Game {
	private List<Card> hand;
	private int numOfNaturalSeq;
	private int numOfSeq;
	private int numOfGroup;
	private int numOfTriplets;
	private int numOfQuadruples;
	private Deck deck;

	public Game() {
		this.hand = new ArrayList<Card>();
		this.numOfNaturalSeq = 0;
		this.numOfSeq = 0;
		this.numOfGroup = 0;
		this.numOfTriplets = 0;
		this.numOfQuadruples = 0;
		this.deck = new Deck();
	}

	public void deal() {
		for (int i = 0; i < 13; i++) {
			hand.add(deck.getRandomCard());
		}
	}

	public int calcMinCardsForDeclare() {
		return 0;
	}

	private boolean isSequence(Card[] cards) {
		Collections.sort(Arrays.asList(cards));
		for (int i = 0; i < cards.length - 1; i++) {
			if (!cards[i].isNext(cards[i + 1])) {
				return false;
			}
		}
		return true;
	}

	private boolean isNaturalSequence(Card[] cards) {
		Collections.sort(Arrays.asList(cards));
		for (int i = 0; i < cards.length - 1; i++) {
			if (!cards[i].isNext(cards[i + 1]) || cards[i].isJoker() || cards[i + 1].isJoker()) {
				return false;
			}
		}
		return true;
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
