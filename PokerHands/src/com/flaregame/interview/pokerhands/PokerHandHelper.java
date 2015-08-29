package com.flaregame.interview.pokerhands;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Vector;

import com.flaregame.interview.pokerhands.exception.PokerHandComparisonNotSameCombinationException;
import com.flaregame.interview.pokerhands.exception.PokerValueNotValidException;

public class PokerHandHelper {

	public static final String[] COMBINATION = { "HighCard", "Pair",
			"TwoPairs", "ThreeOfAKind", "Straight", "Flush", "FullHouse",
			"FourOfAKind", "StraightFlush" };

	public static int samePokerHandCombinationComparison(PokerHand p1,
			PokerHand p2)
			throws PokerHandComparisonNotSameCombinationException,
			PokerValueNotValidException {
		if (!p1.getCombination().equals(p2.getCombination())) {
			throw new PokerHandComparisonNotSameCombinationException();
		}

		String combination = p1.getCombination();
		if (combination.equals("HighCard")) {
			return highCardComparison(p1, p2);
		} else if (combination.equals("Pair")) {
			return pairComparison(p1, p2);
		} else if (combination.equals("TwoPairs")) {
			return twoPairsComparison(p1, p2);
		} else if (combination.equals("ThreeOfAKind")) {
			return threeOfAKindComparison(p1, p2);
		} else if (combination.equals("Straight")) {
			return straightComparison(p1, p2);
		} else if (combination.equals("Flush")) {
			return flushComparison(p1, p2);
		} else if (combination.equals("FullHouse")) {
			return fullHouseComparison(p1, p2);
		} else if (combination.equals("FourOfAKind")) {
			return fourOfAKindComparison(p1, p2);
		} else if (combination.equals("StraightFlush")) {
			return straightFlushComparison(p1, p2);
		}
		return 0;
	}

	private static int straightFlushComparison(PokerHand p1, PokerHand p2) {
		return straightComparison(p1, p2);
	}

	private static int fourOfAKindComparison(PokerHand p1, PokerHand p2)
			throws PokerValueNotValidException {
		HashMap<String, Integer> pm1 = getPokerCardValueCountMap(p1);
		HashMap<String, Integer> pm2 = getPokerCardValueCountMap(p2);

		PokerValue four1 = null;
		PokerValue four2 = null;
		for (Entry<String, Integer> entry : pm1.entrySet()) {
			if (entry.getValue() == 4) {
				four1 = new PokerValue(entry.getKey());
				break;
			}
		}
		for (Entry<String, Integer> entry : pm2.entrySet()) {
			if (entry.getValue() == 4) {
				four2 = new PokerValue(entry.getKey());
				break;
			}
		}
		if (four1 == null || four2 == null) {
			throw new PokerValueNotValidException();
		}

		return four1.compareTo(four2);
	}

	private static int fullHouseComparison(PokerHand p1, PokerHand p2)
			throws PokerValueNotValidException {
		return threeOfAKindComparison(p1, p2);
	}

	private static int flushComparison(PokerHand p1, PokerHand p2) {
		// with flush we need to compare it with the order of highCard
		return highCardComparison(p1, p2);
	}

	private static int straightComparison(PokerHand p1, PokerHand p2) {
		// with straight we just need to compair the hight card
		return p1.getCards()[4].compareTo(p2.getCards()[4]);
	}

	private static int threeOfAKindComparison(PokerHand p1, PokerHand p2)
			throws PokerValueNotValidException {
		HashMap<String, Integer> pm1 = getPokerCardValueCountMap(p1);
		HashMap<String, Integer> pm2 = getPokerCardValueCountMap(p2);

		PokerValue three1 = null;
		PokerValue three2 = null;
		for (Entry<String, Integer> entry : pm1.entrySet()) {
			if (entry.getValue() == 3) {
				three1 = new PokerValue(entry.getKey());
				break;
			}
		}
		for (Entry<String, Integer> entry : pm2.entrySet()) {
			if (entry.getValue() == 3) {
				three2 = new PokerValue(entry.getKey());
				break;
			}
		}
		if (three1 == null || three2 == null) {
			throw new PokerValueNotValidException();
		}

		return three1.compareTo(three2);
	}

	private static int twoPairsComparison(PokerHand p1, PokerHand p2)
			throws PokerValueNotValidException {
		HashMap<String, Integer> pm1 = getPokerCardValueCountMap(p1);
		HashMap<String, Integer> pm2 = getPokerCardValueCountMap(p2);
		Vector<PokerValue> pairs1 = new Vector<PokerValue>();
		Vector<PokerValue> pairs2 = new Vector<PokerValue>();
		PokerValue theOther1 = null;
		PokerValue theOther2 = null;
		for (Entry<String, Integer> entry : pm1.entrySet()) {
			if (entry.getValue() == 2) {
				pairs1.add(new PokerValue(entry.getKey()));
			}
			if (entry.getValue() == 1) {
				theOther1 = new PokerValue(entry.getKey());
			}
		}

		for (Entry<String, Integer> entry : pm2.entrySet()) {
			if (entry.getValue() == 2) {
				pairs2.add(new PokerValue(entry.getKey()));
			}
			if (entry.getValue() == 1) {
				theOther2 = new PokerValue(entry.getKey());
			}
		}
		if (pairs1 == null || pairs2 == null) {
			throw new PokerValueNotValidException();
		}

		PokerValue pvpair1[] = new PokerValue[2], pvpair2[] = new PokerValue[2];
		pairs1.toArray(pvpair1);
		pairs2.toArray(pvpair2);

		if (pvpair1 == null || pvpair2 == null) {
			throw new PokerValueNotValidException();
		}
		Arrays.sort(pvpair1);
		Arrays.sort(pvpair2);

		for (int i = 1; i >= 0; i--) {
			int res = pvpair1[i].compareTo(pvpair2[i]);
			if (res != 0) {
				return res;
			}
		}

		return theOther1.compareTo(theOther2);
	}

	private static int pairComparison(PokerHand p1, PokerHand p2)
			throws PokerValueNotValidException {
		// find the value of pair card
		HashMap<String, Integer> pm1 = getPokerCardValueCountMap(p1);
		HashMap<String, Integer> pm2 = getPokerCardValueCountMap(p2);

		PokerValue pair1 = null;
		PokerValue pair2 = null;
		for (Entry<String, Integer> entry : pm1.entrySet()) {
			if (entry.getValue() == 2) {
				pair1 = new PokerValue(entry.getKey());
				break;
			}
		}
		for (Entry<String, Integer> entry : pm2.entrySet()) {
			if (entry.getValue() == 2) {
				pair2 = new PokerValue(entry.getKey());
				break;
			}
		}
		if (pair1 == null || pair2 == null) {
			throw new PokerValueNotValidException();
		}
		int result = pair1.compareTo(pair2);
		if (result != 0) {
			return result;
		}

		// pair card are the same compare the other three.
		Vector<PokerCard> rest1 = getCardsExceptCardWithValue(pair1.getValue(),
				p1.getCards());
		Vector<PokerCard> rest2 = getCardsExceptCardWithValue(pair2.getValue(),
				p2.getCards());

		if (rest1.size() != 3 || rest2.size() != rest1.size()) {
			throw new PokerValueNotValidException();
		}
		for (int i = 2; i >= 0; i--) {
			if (rest1.elementAt(i).compareTo(rest2.elementAt(i)) > 0) {
				return 1;
			} else if (rest1.elementAt(i).compareTo(rest2.elementAt(i)) < 0) {
				return -1;
			}
		}

		return 0;
	}

	private static int highCardComparison(PokerHand p1, PokerHand p2) {

		PokerCard[] pc1 = p1.getCards();
		PokerCard[] pc2 = p2.getCards();
		for (int i = 4; i >= 0; i--) {
			if (pc1[i].compareTo(pc2[i]) < 0) {
				return -1;
			} else if (pc1[i].compareTo(pc2[i]) > 0) {
				return 1;
			}
		}
		return 0;
	}

	private static Vector<PokerCard> getCardsExceptCardWithValue(String value,
			PokerCard[] cards) {
		Vector<PokerCard> temp = new Vector<PokerCard>();
		for (int i = 0; i < 5; i++) {
			if (!(cards[i].getValue().getValue().equals(value))) {
				temp.add(cards[i]);
			}
		}
		return temp;
	}

	private static HashMap<String, Integer> getPokerCardValueCountMap(
			PokerHand hand) {

		HashMap<String, Integer> result = new HashMap<String, Integer>();
		for (PokerCard card : hand.getCards()) {
			String v = card.getValue().getValue();
			if (result.containsKey(v)) {
				result.put(v, result.get(v) + 1);
			} else {
				result.put(v, 1);
			}
		}
		return result;
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
