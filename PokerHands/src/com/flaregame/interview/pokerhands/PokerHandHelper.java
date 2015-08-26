package com.flaregame.interview.pokerhands;

import java.util.HashMap;

public class PokerHandHelper {
	public static String getPokerHandCombination(PokerHand pokerHand) {
		if (isStraightFlush(pokerHand)) {
			return "StraightFlush";
		} else if (isFourOfAKind(pokerHand)) {
			return "FourOfAKind";
		} else if (isFullHause(pokerHand)) {
			return "FullHouse";
		} else if (isFlush(pokerHand)) {
			return "Flush";
		} else if (isStraight(pokerHand)) {
			return "Straight";
		} else if (isThreeOfAKind(pokerHand)) {
			return "ThreeOfAKind";
		} else if (isTwoPairs(pokerHand)) {
			return "TwoPairs";
		} else if (isPair(pokerHand)) {
			return "Pair";
		} else if (isHighCard(pokerHand)) {
			return "HighCard";
		}
		return "unknown";
	}

	public static boolean isHighCard(PokerHand pokerHand) {
		return false;
	}

	public static boolean isPair(PokerHand pokerHand) {
		return false;
	}

	public static boolean isTwoPairs(PokerHand pokerHand) {
		return false;
	}

	public static boolean isThreeOfAKind(PokerHand pokerHand) {
		return false;
	}

	public static boolean isStraight(PokerHand pokerHand) {
		return false;
	}

	public static boolean isFlush(PokerHand pokerHand) {
		return false;
	}

	public static boolean isFullHause(PokerHand pokerHand) {
		return false;
	}

	public static boolean isFourOfAKind(PokerHand pokerHand) {
		HashMap<String, Integer> pokerValueCount = new HashMap<String, Integer>();
		for (PokerCard card: pokerHand.getCards()) {
			String v = card.getValue().getValue();
			if (!pokerValueCount.containsKey(v)){
				pokerValueCount.put(v, 1);
			} else {
				pokerValueCount.put(v, pokerValueCount.get(v) + 1);
				if (pokerValueCount.get(v) == 4) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean isStraightFlush(PokerHand pokerHand) {
		// check suit
		PokerSuit ps0 = pokerHand.getCards()[0].getSuit();
		
		for (PokerCard card : pokerHand.getCards()) {
			if (!card.getSuit().equals(ps0)) {
				return false;
			}
		}
		// check value
		PokerValue currentValue = pokerHand.getCards()[0].getValue();
		for (int i = 1; i < pokerHand.getCards().length; i ++) {
			if (currentValue.compareTo(pokerHand.getCards()[i].getValue()) != -1) {
				return false;
			}
			currentValue = pokerHand.getCards()[i].getValue();
		}
		return true;
	}

}
