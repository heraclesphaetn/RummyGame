
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardGame {

	List<Card> hand;
	private int numOfJokers;
	private int n;

	private boolean isNaturalSeq;
	private boolean isCanasta;
	private Deck deck;

	public CardGame() {
		this.hand = new ArrayList<Card>();
		this.isNaturalSeq = false;
		this.isCanasta = false;
		this.numOfJokers = 0;
		this.deck = new Deck();
		this.n = 0;
	}

	public void deal() {
		for (int i = 1; i <= 13; i++) {
			Card card = deck.getRandomCard();
			if (card.isJoker()) {
				numOfJokers++;
			} else {
				hand.add(card);
			}
		}
		this.n = 13 - numOfJokers;
	}

	public int calcMinCardsForDeclare() {
		System.out.println(hand);
		removeCanasta();
		removeNaturalseq();
		System.out.println(hand);
		// --->
		removeGroups();
		System.out.println(hand);
		System.out.println("n=" + n);
		// ---->
		int minCardsForDeclare = n - hand.size();
		return minCardsForDeclare;
	}

	private void removeNaturalseq() {
		Map<Integer, List<Integer>> handSuitWise = getHandSuitWise();
		for (Map.Entry<Integer, List<Integer>> entry : handSuitWise.entrySet()) {
			List<Integer> seq = entry.getValue();
			Collections.sort(seq);
			for (int i = 0; i < seq.size() - 1; i++) {
				int cnt = 0;
				int j = i;
				while (i < seq.size() - 1) {
					if (seq.get(i + 1) - seq.get(i) != 1) {
						break;
					}
					cnt++;
					i++;
				}
				if (cnt >= 3) {
					isNaturalSeq = true;
					for (int k = j; k < i; k++) {
						hand.remove(new Card(seq.get(k), entry.getKey()));
					}
				}
			}
		}
	}

	private Map<Integer, List<Integer>> getHandSuitWise() {
		Map<Integer, List<Integer>> handSuitWise = new HashMap<Integer, List<Integer>>();
		for (Card card : hand) {
			List<Integer> set = new ArrayList<Integer>();
			if (handSuitWise.containsKey(card.getSuit())) {
				set = handSuitWise.get(card.getSuit());
			}
			set.add(card.getRank());
			handSuitWise.put(card.getSuit(), set);
		}
		return handSuitWise;
	}

	private void removeCanasta() {

	}

	private void removeGroups() {
		Map<Integer, List<Card>> handGroupWise = getHandGroupWise();
		for (Map.Entry<Integer, List<Card>> entry : handGroupWise.entrySet()) {
			if (entry.getValue().size() >= 3) {
				for (Card card : entry.getValue()) {
					hand.remove(card);
				}
			}
		}
	}

	private Map<Integer, List<Card>> getHandGroupWise() {
		Map<Integer, List<Card>> handGroupWise = new HashMap<Integer, List<Card>>();
		for (Card card : hand) {
			List<Card> set = new ArrayList<Card>();
			if (handGroupWise.containsKey(card.getRank())) {
				set = handGroupWise.get(card.getRank());
			}
			set.add(card);
			handGroupWise.put(card.getRank(), set);
		}
		return handGroupWise;
	}

}
