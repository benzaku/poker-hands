package com.flaregame.interview.pokerhands.appliction;

import java.util.LinkedList;

import com.flaregame.interview.pokerhands.PokerHand;

public class PokerHands {
	LinkedList<PokerHand> pokerHands;

	public PokerHands() {
		this.pokerHands = new LinkedList<PokerHand>();
	}
	
	public PokerHands(LinkedList<PokerHand> hands) {
		this.pokerHands = hands;
	}

	public LinkedList<PokerHand> getPokerHands() {
		return this.pokerHands;
	}

	public void addPokerHand(PokerHand hand) {
		pokerHands.add(hand);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(PokerHand hand : this.pokerHands) {
			sb.append(hand.toString() + "\n");
		}
		return sb.toString();
	}
}
