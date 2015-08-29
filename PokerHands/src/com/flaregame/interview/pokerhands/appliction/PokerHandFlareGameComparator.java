package com.flaregame.interview.pokerhands.appliction;

import java.util.LinkedList;

import com.flaregame.interview.pokerhands.PokerHand;

public class PokerHandFlareGameComparator implements IPokerComparator{

	@Override
	public PokerHandResult getHigherPokerHand(PokerHand dealer, PokerHand player) {
		if (dealer.compareTo(player) > 0) {
			return PokerHandResult.DEALER;
		} else if (dealer.compareTo(player) < 0) {
			return PokerHandResult.PLAYER;
		}
		return PokerHandResult.SPLIT;
	}

	@Override
	public PokerHands getHighestPokerHands(PokerHands pokerhands) {
		LinkedList<PokerHand> hands = pokerhands.getPokerHands();
		PokerHand highestHand = hands.getFirst();
		LinkedList<PokerHand> highesthands = new LinkedList<PokerHand>();
		highesthands.add(highestHand);
		for (int i = 1; i < hands.size(); i ++) {
			int compare = highestHand.compareTo(hands.get(i));
			if (compare > 0) {
				continue;
			} else if (compare == 0) {
				highesthands.add(hands.get(i));
			} else if (compare < 0) {
				highesthands.clear();
				highestHand = hands.get(i);
				highesthands.add(hands.get(i));
			}
		}
		return new PokerHands(highesthands);
	}

}
