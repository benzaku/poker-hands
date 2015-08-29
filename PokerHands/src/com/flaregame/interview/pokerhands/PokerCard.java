package com.flaregame.interview.pokerhands;

public class PokerCard implements Comparable<PokerCard> {
	private PokerSuit suit = PokerSuit.SPADE; // default;
	private PokerValue value = new PokerValue();

	public PokerCard() {
	}
	
	public PokerCard(PokerSuit suit, String value) {
		this.suit = suit;
		this.value.setValue(value);
	}
	
	public PokerCard(PokerSuit suit, PokerValue value) {
		this.suit = suit;
		this.value = value;
	}

	public PokerSuit getSuit() {
		return suit;
	}
	
	public void setSuit(PokerSuit suit) {
		this.suit = suit;
	}

	public PokerValue getValue() {
		return value;
	}
	
	public void setValue(PokerValue value) {
		this.value.setValue(value.getValue());
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
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.suit.toString() + ":" + this.value.getValue());
		return sb.toString();
	}
}
