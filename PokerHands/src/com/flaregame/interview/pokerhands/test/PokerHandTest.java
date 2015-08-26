package com.flaregame.interview.pokerhands.test;

import static org.junit.Assert.*;

import java.util.Arrays;

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

	private PokerHand highCard = null;
	private PokerHand pair = null;
	private PokerHand twoPairs = null;
	private PokerHand threeOfAKind = null;
	private PokerHand straight = null;
	private PokerHand flush = null;
	private PokerHand fullHouse = null;
	private PokerHand fourOfAKind = null;
	private PokerHand straightFlush = null;

	@Before
	public void setUp() throws Exception {
		PokerCard highCards[] = { new PokerCard(PokerSuit.CLUB, new PokerValue("2")),
				new PokerCard(PokerSuit.DIAMONDS, new PokerValue("5")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("6")), new PokerCard(PokerSuit.HEART, new PokerValue("K")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("A")) };
		highCard = new PokerHand(highCards);
		PokerCard pairs[] = { new PokerCard(PokerSuit.CLUB, new PokerValue("2")),
				new PokerCard(PokerSuit.DIAMONDS, new PokerValue("5")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("6")), new PokerCard(PokerSuit.HEART, new PokerValue("K")),
				new PokerCard(PokerSuit.SPADE, new PokerValue("2")) };
		pair = new PokerHand(pairs);
		PokerCard twoPairCards[] = { new PokerCard(PokerSuit.CLUB, new PokerValue("2")),
				new PokerCard(PokerSuit.DIAMONDS, new PokerValue("5")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("5")), new PokerCard(PokerSuit.HEART, new PokerValue("K")),
				new PokerCard(PokerSuit.SPADE, new PokerValue("2")) };
		twoPairs = new PokerHand(twoPairCards);
		PokerCard threeOfAKindCards[] = { new PokerCard(PokerSuit.CLUB, new PokerValue("2")),
				new PokerCard(PokerSuit.DIAMONDS, new PokerValue("2")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("5")), new PokerCard(PokerSuit.HEART, new PokerValue("K")),
				new PokerCard(PokerSuit.SPADE, new PokerValue("2")) };
		threeOfAKind = new PokerHand(threeOfAKindCards);
		PokerCard straightCards[] = { new PokerCard(PokerSuit.CLUB, new PokerValue("2")),
				new PokerCard(PokerSuit.DIAMONDS, new PokerValue("3")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("4")), new PokerCard(PokerSuit.HEART, new PokerValue("5")),
				new PokerCard(PokerSuit.SPADE, new PokerValue("6")) };
		straight = new PokerHand(straightCards);
		PokerCard flushCards[] = { new PokerCard(PokerSuit.CLUB, new PokerValue("K")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("10")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("2")), new PokerCard(PokerSuit.CLUB, new PokerValue("5")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("7")) };
		flush = new PokerHand(flushCards);
		PokerCard fullHauseCards[] = { new PokerCard(PokerSuit.CLUB, new PokerValue("K")),
				new PokerCard(PokerSuit.SPADE, new PokerValue("K")),
				new PokerCard(PokerSuit.HEART, new PokerValue("2")), new PokerCard(PokerSuit.DIAMONDS, new PokerValue("2")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("2")) };
		fullHouse = new PokerHand(fullHauseCards);
		PokerCard fourOfAKindCards[] = { new PokerCard(PokerSuit.CLUB, new PokerValue("K")),
				new PokerCard(PokerSuit.SPADE, new PokerValue("K")),
				new PokerCard(PokerSuit.HEART, new PokerValue("K")), new PokerCard(PokerSuit.DIAMONDS, new PokerValue("K")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("2")) };
		fourOfAKind = new PokerHand(fourOfAKindCards);
		PokerCard StraightFlushCards[] = { new PokerCard(PokerSuit.CLUB, new PokerValue("3")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("2")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("5")), new PokerCard(PokerSuit.CLUB, new PokerValue("6")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("4")) };
		straightFlush = new PokerHand(StraightFlushCards);
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
			cards[3] = new PokerCard(PokerSuit.DIAMONDS, new PokerValue("K"));
			cards[4] = new PokerCard(PokerSuit.HEART, new PokerValue("J"));
			PokerHand ph = new PokerHand(cards);
			Arrays.sort(cards);
			for (int i = 0; i < 5; i++) {
				assertTrue(cards[i].equalsTo(ph.getCards()[i]));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail("unknown error");
		}
	}

	@Test
	public void getCombinationTest() {
//		assertEquals("HighCard", highCard.getCombination());
//		assertEquals("Pair", pair.getCombination());
//		assertEquals("TowPairs", twoPairs.getCombination());
//		assertEquals("ThreeOfAKind", threeOfAKind.getCombination());
//		assertEquals("Straight", straight.getCombination());
//		assertEquals("Flush", flush.getCombination());
//		assertEquals("FullHouse", fullHouse.getCombination());
		assertEquals("FourOfAKind", fourOfAKind.getCombination());
		assertEquals("StraightFlush", straightFlush.getCombination());
	}

}
