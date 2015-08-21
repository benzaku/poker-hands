package com.flaregame.interview.pokerhands;

import com.flaregame.interview.pokerhands.exception.InvalidPokerCardsRowException;
import com.flaregame.interview.pokerhands.exception.PokerCardsRowContainsInvalidElementException;
import com.flaregame.interview.pokerhands.exception.PokerCardsRowWrongSizeException;
import com.flaregame.interview.pokerhands.exception.PokerValueNotValidException;

public class PokerHand {
	private static final int NUMBER_CARDS = 5;
	private PokerCard[] cards = null;

	public PokerHand(PokerCard[] cards) throws InvalidPokerCardsRowException, PokerValueNotValidException {
		// check cards .
		if (cards == null) {
			throw new InvalidPokerCardsRowException();
		}
		if (cards.length != 5) {
			throw new PokerCardsRowWrongSizeException();
		}
		this.cards = new PokerCard[NUMBER_CARDS];
		for (int i = 0; i < 5; i++) {
			if (cards[i] == null) {
				throw new PokerCardsRowContainsInvalidElementException();
			} else {
				this.cards[i] = new PokerCard(cards[i].getSuit(),
						new PokerValue(cards[i].getValue().getValue()));
			}
		}
	}

	public PokerCard[] getCards() {
		return cards;
	}
}
