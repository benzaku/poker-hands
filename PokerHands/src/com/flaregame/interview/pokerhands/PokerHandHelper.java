package com.flaregame.interview.pokerhands;

import java.util.Collection;
import java.util.HashMap;

import com.flaregame.interview.pokerhands.exception.PokerHandComparisonNotSameCombinationException;

public class PokerHandHelper {

	public static final String[] COMBINATION = { "HighCard", "Pair",
			"TwoPairs", "ThreeOfAKind", "Straight", "Flush", "FullHouse",
			"FourOfAKind", "StraightFlush" };

	public static int samePokerHandCombinationComparison(PokerHand p1,
			PokerHand p2) throws PokerHandComparisonNotSameCombinationException {
		if (!p1.getCombination().equals(p2.getCombination())) {
			throw new PokerHandComparisonNotSameCombinationException();
		}
		return 0;
	}

	public static int getPokerHandCombinationPosition(PokerHand pokerHand) {
		String comb = pokerHand.getCombination();
		for (int i = 0; i < COMBINATION.length; i++) {
			if (comb.equals(COMBINATION[i])) {
				return i;
			}
		}
		return -1;
	}

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
		HashMap<String, Integer> pokerValueCount = new HashMap<String, Integer>();
		for (PokerCard card : pokerHand.getCards()) {
			String v = card.getValue().getValue();
			if (!pokerValueCount.containsKey(v)) {
				pokerValueCount.put(v, 1);
			} else {
				pokerValueCount.put(v, pokerValueCount.get(v) + 1);
			}
		}
		Collection<Integer> values = pokerValueCount.values();
		if (values.size() == 5 && !isStraight(pokerHand) && !isFlush(pokerHand)) {
			return true;
		}
		return false;
	}

	public static boolean isPair(PokerHand pokerHand) {
		HashMap<String, Integer> pokerValueCount = new HashMap<String, Integer>();
		for (PokerCard card : pokerHand.getCards()) {
			String v = card.getValue().getValue();
			if (!pokerValueCount.containsKey(v)) {
				pokerValueCount.put(v, 1);
			} else {
				pokerValueCount.put(v, pokerValueCount.get(v) + 1);
			}
		}
		Collection<Integer> values = pokerValueCount.values();
		if (values.size() == 4 && values.contains(2)) {
			return true;
		}
		return false;
	}

	public static boolean isTwoPairs(PokerHand pokerHand) {
		HashMap<String, Integer> pokerValueCount = new HashMap<String, Integer>();
		for (PokerCard card : pokerHand.getCards()) {
			String v = card.getValue().getValue();
			if (!pokerValueCount.containsKey(v)) {
				pokerValueCount.put(v, 1);
			} else {
				pokerValueCount.put(v, pokerValueCount.get(v) + 1);
			}
		}
		Collection<Integer> values = pokerValueCount.values();
		if (values.size() == 3) {
			int numberOfTwo = 0;
			for (Integer i : values) {
				if (i == 2) {
					numberOfTwo++;
				}
			}
			if (numberOfTwo == 2) {
				return true;
			}
		}
		return false;
	}

	public static boolean isThreeOfAKind(PokerHand pokerHand) {
		HashMap<String, Integer> pokerValueCount = new HashMap<String, Integer>();
		for (PokerCard card : pokerHand.getCards()) {
			String v = card.getValue().getValue();
			if (!pokerValueCount.containsKey(v)) {
				pokerValueCount.put(v, 1);
			} else {
				pokerValueCount.put(v, pokerValueCount.get(v) + 1);
			}
		}
		Collection<Integer> values = pokerValueCount.values();
		if (values.size() == 3 && values.contains(3)) {
			return true;
		}
		return false;
	}

	public static boolean isStraight(PokerHand pokerHand) {
		PokerValue currentValue = pokerHand.getCards()[0].getValue();
		for (int i = 1; i < pokerHand.getCards().length; i++) {
			if (currentValue.compareTo(pokerHand.getCards()[i].getValue()) != -1) {
				return false;
			}
			currentValue = pokerHand.getCards()[i].getValue();
		}
		return true;
	}

	public static boolean isFlush(PokerHand pokerHand) {
		PokerSuit suit = pokerHand.getCards()[0].getSuit();
		for (PokerCard card : pokerHand.getCards()) {
			if (!card.getSuit().equals(suit)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isFullHause(PokerHand pokerHand) {
		HashMap<String, Integer> pokerValueCount = new HashMap<String, Integer>();
		for (PokerCard card : pokerHand.getCards()) {
			String v = card.getValue().getValue();
			if (!pokerValueCount.containsKey(v)) {
				pokerValueCount.put(v, 1);
			} else {
				pokerValueCount.put(v, pokerValueCount.get(v) + 1);
			}
		}
		Collection<Integer> pokerValues = pokerValueCount.values();
		if (pokerValues.size() == 2) {
			Integer valueArray[] = new Integer[2];
			pokerValues.toArray(valueArray);
			if ((valueArray[0] == 2 && valueArray[1] == 3)
					|| (valueArray[0] == 3 && valueArray[1] == 2)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isFourOfAKind(PokerHand pokerHand) {
		HashMap<String, Integer> pokerValueCount = new HashMap<String, Integer>();
		for (PokerCard card : pokerHand.getCards()) {
			String v = card.getValue().getValue();
			if (!pokerValueCount.containsKey(v)) {
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

		return (isStraight(pokerHand) && isFlush(pokerHand));
	}

}
