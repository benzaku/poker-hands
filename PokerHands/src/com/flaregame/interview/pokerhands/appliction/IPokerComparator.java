package com.flaregame.interview.pokerhands.appliction;

import com.flaregame.interview.pokerhands.PokerHand;

public interface IPokerComparator {
	public PokerHandResult getHigherPokerHand(PokerHand p1, PokerHand p2);
	public PokerHands getHighestPokerHands(PokerHands pokerhands);
}
