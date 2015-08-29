package com.flaregame.interview.pokerhands;

public class PokerCard implements Comparable<PokerCard> {
	private PokerSuit suit = null;
	private PokerValue value = null;

	public PokerCard(PokerSuit suit, PokerValue value) {
		this.suit = suit;
		this.value = value;
	}

	public PokerSuit getSuit() {
		return suit;
	}

	public PokerValue getValue() {
		return value;
	}

	public boolean equalsTo(PokerCard card) {
		if (this.suit == card.getSuit()
				&& this.value.compareTo(card.getValue()) == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int compareTo(PokerCard pc) {
		return this.value.compareTo(pc.getValue());
	}
}
