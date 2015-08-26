package com.flaregame.interview.pokerhands;

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
		return false;
	}

	public static boolean isStraightFlush(PokerHand pokerHand) {
		return false;
	}

}
