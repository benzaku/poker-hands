package com.flaregame.interview.pokerhands;

import java.util.Arrays;

import com.flaregame.interview.pokerhands.exception.InvalidPokerCardsRowException;
import com.flaregame.interview.pokerhands.exception.PokerCardsRowContainsInvalidElementException;
import com.flaregame.interview.pokerhands.exception.PokerCardsRowWrongSizeException;
import com.flaregame.interview.pokerhands.exception.PokerHandComparisonNotSameCombinationException;
import com.flaregame.interview.pokerhands.exception.PokerValueNotValidException;

public class PokerHand implements Comparable<PokerHand>{
	private static final int NUMBER_CARDS = 5;
	private PokerCard[] cards = null;
	
	private String combination = "unknown";

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
				this.cards[i] = new PokerCard(cards[i].getSuit(), new PokerValue(cards[i].getValue().getValue()));
			}
		}
		Arrays.sort(this.cards);
	}

	public PokerCard[] getCards() {
		return cards;
	}

	public String getCombination() {
		if (this.combination.equals("unknown")){
			this.combination = PokerHandHelper.getPokerHandCombination(this);
		}
		return this.combination;
	}

	@Override
	public int compareTo(PokerHand ph) {
		int compareValue = PokerHandHelper.getPokerHandCombinationPosition(this) - PokerHandHelper.getPokerHandCombinationPosition(ph); 
		if (compareValue != 0) {
			return compareValue;
		}
		int res = 0;
		try {
			res = PokerHandHelper.samePokerHandCombinationComparison(this, ph);
		} catch (PokerHandComparisonNotSameCombinationException e) {
			e.printStackTrace();
		}
		return res;
	}
	
}
