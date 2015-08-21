package com.flaregame.interview.pokerhands.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.flaregame.interview.pokerhands.PokerCard;
import com.flaregame.interview.pokerhands.PokerHand;
import com.flaregame.interview.pokerhands.PokerSuit;
import com.flaregame.interview.pokerhands.PokerValue;
import com.flaregame.interview.pokerhands.exception.InvalidPokerCardsRowException;
import com.flaregame.interview.pokerhands.exception.PokerCardsRowContainsInvalidElementException;
import com.flaregame.interview.pokerhands.exception.PokerCardsRowWrongSizeException;

public class PokerHandTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void constructorTest() {
		try {
			PokerCard nullcards[] = null;
			PokerHand ph = new PokerHand(nullcards);
		} catch (Exception e) {
			assertEquals(InvalidPokerCardsRowException.class, e.getClass());
		}
		
		try {
			PokerCard wrongSizeCards[] = new PokerCard[6];
			PokerHand ph = new PokerHand(wrongSizeCards);
		} catch (Exception e) {
			assertEquals(PokerCardsRowWrongSizeException.class, e.getClass());
		}
		
		try {
			PokerCard cardswithnull[] = new PokerCard[5];
			cardswithnull[0] = new PokerCard(PokerSuit.DIAMONDS, new PokerValue("2"));
			cardswithnull[1] = new PokerCard(PokerSuit.DIAMONDS, new PokerValue("5"));
			cardswithnull[4] = new PokerCard(PokerSuit.DIAMONDS, new PokerValue("8"));
			cardswithnull[2] = new PokerCard(PokerSuit.DIAMONDS, new PokerValue("10"));
			PokerHand ph = new PokerHand(cardswithnull);
		} catch (Exception e) {
			assertEquals(PokerCardsRowContainsInvalidElementException.class, e.getClass());
		}
		
		try {
			PokerCard cards[] = new PokerCard[5];
			cards[0] = new PokerCard(PokerSuit.DIAMONDS, new PokerValue("2"));
			cards[1] = new PokerCard(PokerSuit.CLUB, new PokerValue("5"));
			cards[2] = new PokerCard(PokerSuit.SPADE, new PokerValue("8"));
			cards[3] = new PokerCard(PokerSuit.DIAMONDS, new PokerValue("10")); 
			cards[4] = new PokerCard(PokerSuit.HEART, new PokerValue("J"));
			PokerHand ph = new PokerHand(cards);
			for (int i = 0; i < 5; i ++) {
				assertTrue(cards[i].equalsTo(ph.getCards()[i]));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail("unknown error");
		}
	}
	
}
