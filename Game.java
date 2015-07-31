import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Game {
	private List<Card> hand;
	private int numOfJokers;

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
		this.numOfJokers = 0;
		this.deck = new Deck();
	}

	public void deal() {
		for (int i = 0; i < 13; i++) {
			Card card = deck.getRandomCard();
			if (card.isJoker()) {
				numOfJokers++;
			} else {
				hand.add(card);
			}
		}
	}

	public int calcMinCardsForDeclare() {
		int minCardsForDeclare = 0;
		int minCardsForSequence = 0;
		numOfSeq = getNumOfNaturalSequences();
		if (numOfSeq < 2) {
			for (int i = 0; i < hand.size() - 1; i++) {
				if (hand.get(i + 1).getValue() - hand.get(i).getValue() == 2) {
					minCardsForDeclare++;
				}
			}
			minCardsForSequence -= numOfSeq == 0 ? numOfJokers - 1 : numOfJokers;
		}
		numOfGroup = getNumOfGroups();
		
		return 0;
	}

	private int getNumOfGroups() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getNumOfNaturalSequences() {
//		Card[] cards = new Card[4];
//		for (int i = 0; i < hand.size() - 3; i++) {
//			cards[0] = hand.get(i);
//			cards[1] = hand.get(i + 1);
//			cards[2] = hand.get(i + 2);
//			cards[3] = hand.get(i + 3);
//			if (isNaturalSequence(cards)) {
//				numOfQuadruples++;
//				return true;
//			}
//		}
//		for (int i = 0; i < hand.size() - 2; i++) {
//			cards[0] = hand.get(i);
//			cards[1] = hand.get(i + 1);
//			cards[2] = hand.get(i + 2);
//			if (isNaturalSequence(cards)) {
//				numOfTriplets++;
//				return true;
//			}
//		}
//		return false;
	}

	private boolean isSequence(Card[] cards) {
		// check special case
		Collections.sort(Arrays.asList(cards));
		for (int i = 0; i < cards.length - 1; i++) {
			if (!cards[i].isNext(cards[i + 1])) {
				return false;
			}
		}
		return true;
	}

	private boolean isNaturalSequence(Card[] cards) {
		// check special case
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
