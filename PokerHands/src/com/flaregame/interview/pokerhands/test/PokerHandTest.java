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
import com.flaregame.interview.pokerhands.exception.PokerValueNotValidException;

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
		PokerCard highCards[] = {
				new PokerCard(PokerSuit.CLUB, new PokerValue("2")),
				new PokerCard(PokerSuit.DIAMONDS, new PokerValue("5")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("6")),
				new PokerCard(PokerSuit.HEART, new PokerValue("K")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("A")) };
		highCard = new PokerHand(highCards);
		PokerCard pairs[] = {
				new PokerCard(PokerSuit.CLUB, new PokerValue("2")),
				new PokerCard(PokerSuit.DIAMONDS, new PokerValue("5")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("6")),
				new PokerCard(PokerSuit.HEART, new PokerValue("K")),
				new PokerCard(PokerSuit.SPADE, new PokerValue("2")) };
		pair = new PokerHand(pairs);
		PokerCard twoPairCards[] = {
				new PokerCard(PokerSuit.CLUB, new PokerValue("2")),
				new PokerCard(PokerSuit.DIAMONDS, new PokerValue("5")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("5")),
				new PokerCard(PokerSuit.HEART, new PokerValue("K")),
				new PokerCard(PokerSuit.SPADE, new PokerValue("2")) };
		twoPairs = new PokerHand(twoPairCards);
		PokerCard threeOfAKindCards[] = {
				new PokerCard(PokerSuit.CLUB, new PokerValue("2")),
				new PokerCard(PokerSuit.DIAMONDS, new PokerValue("2")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("5")),
				new PokerCard(PokerSuit.HEART, new PokerValue("K")),
				new PokerCard(PokerSuit.SPADE, new PokerValue("2")) };
		threeOfAKind = new PokerHand(threeOfAKindCards);
		PokerCard straightCards[] = {
				new PokerCard(PokerSuit.CLUB, new PokerValue("2")),
				new PokerCard(PokerSuit.DIAMONDS, new PokerValue("3")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("4")),
				new PokerCard(PokerSuit.HEART, new PokerValue("5")),
				new PokerCard(PokerSuit.SPADE, new PokerValue("6")) };
		straight = new PokerHand(straightCards);
		PokerCard flushCards[] = {
				new PokerCard(PokerSuit.CLUB, new PokerValue("K")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("10")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("2")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("5")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("7")) };
		flush = new PokerHand(flushCards);
		PokerCard fullHauseCards[] = {
				new PokerCard(PokerSuit.CLUB, new PokerValue("K")),
				new PokerCard(PokerSuit.SPADE, new PokerValue("K")),
				new PokerCard(PokerSuit.HEART, new PokerValue("2")),
				new PokerCard(PokerSuit.DIAMONDS, new PokerValue("2")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("2")) };
		fullHouse = new PokerHand(fullHauseCards);
		PokerCard fourOfAKindCards[] = {
				new PokerCard(PokerSuit.CLUB, new PokerValue("K")),
				new PokerCard(PokerSuit.SPADE, new PokerValue("K")),
				new PokerCard(PokerSuit.HEART, new PokerValue("K")),
				new PokerCard(PokerSuit.DIAMONDS, new PokerValue("K")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("2")) };
		fourOfAKind = new PokerHand(fourOfAKindCards);
		PokerCard StraightFlushCards[] = {
				new PokerCard(PokerSuit.CLUB, new PokerValue("3")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("2")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("5")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("6")),
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
			cardswithnull[0] = new PokerCard(PokerSuit.DIAMONDS,
					new PokerValue("2"));
			cardswithnull[1] = new PokerCard(PokerSuit.DIAMONDS,
					new PokerValue("5"));
			cardswithnull[4] = new PokerCard(PokerSuit.DIAMONDS,
					new PokerValue("8"));
			cardswithnull[2] = new PokerCard(PokerSuit.DIAMONDS,
					new PokerValue("10"));
			PokerHand ph = new PokerHand(cardswithnull);
		} catch (Exception e) {
			assertEquals(PokerCardsRowContainsInvalidElementException.class,
					e.getClass());
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
		assertEquals("HighCard", highCard.getCombination());
		assertEquals("Pair", pair.getCombination());
		assertEquals("TwoPairs", twoPairs.getCombination());
		assertEquals("ThreeOfAKind", threeOfAKind.getCombination());
		assertEquals("Straight", straight.getCombination());
		assertEquals("Flush", flush.getCombination());
		assertEquals("FullHouse", fullHouse.getCombination());
		assertEquals("FourOfAKind", fourOfAKind.getCombination());
		assertEquals("StraightFlush", straightFlush.getCombination());
	}

	@Test
	public void differentCombinationCompareTest()
			throws PokerValueNotValidException, InvalidPokerCardsRowException {
		// comparison between different combination.
		assertTrue(highCard.compareTo(pair) < 0);
		assertTrue(pair.compareTo(twoPairs) < 0);
		assertTrue(twoPairs.compareTo(threeOfAKind) < 0);
		assertTrue(threeOfAKind.compareTo(straight) < 0);
		assertTrue(straight.compareTo(flush) < 0);
		assertTrue(flush.compareTo(fullHouse) < 0);
		assertTrue(fullHouse.compareTo(fourOfAKind) < 0);
		assertTrue(fourOfAKind.compareTo(straightFlush) < 0);
		assertTrue(highCard.compareTo(straightFlush) < 0);
	}

	@Test
	public void highCardCompareTest() throws PokerValueNotValidException,
			InvalidPokerCardsRowException {
		// comparison between high cards.
		PokerHand psmall, pbig;

		PokerCard highCardsSmall[] = {
				new PokerCard(PokerSuit.CLUB, new PokerValue("2")),
				new PokerCard(PokerSuit.DIAMONDS, new PokerValue("5")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("6")),
				new PokerCard(PokerSuit.HEART, new PokerValue("K")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("Q")) };
		psmall = new PokerHand(highCardsSmall);

		PokerCard highCardsBig[] = {
				new PokerCard(PokerSuit.CLUB, new PokerValue("2")),
				new PokerCard(PokerSuit.DIAMONDS, new PokerValue("5")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("6")),
				new PokerCard(PokerSuit.HEART, new PokerValue("K")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("A")) };
		pbig = new PokerHand(highCardsBig);
		assertTrue(psmall.compareTo(pbig) < 0);
		assertTrue(pbig.compareTo(psmall) > 0);
		assertEquals(0, psmall.compareTo(psmall));
		assertEquals(0, pbig.compareTo(pbig));
	}

	@Test
	public void pairCompareTest() throws PokerValueNotValidException,
			InvalidPokerCardsRowException {
		// comparison between high cards.
		PokerHand psmall, pbig;

		PokerCard pairSmall[] = {
				new PokerCard(PokerSuit.CLUB, new PokerValue("2")),
				new PokerCard(PokerSuit.DIAMONDS, new PokerValue("5")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("6")),
				new PokerCard(PokerSuit.HEART, new PokerValue("K")),
				new PokerCard(PokerSuit.SPADE, new PokerValue("2")) };
		psmall = new PokerHand(pairSmall);

		PokerCard pairBig[] = {
				new PokerCard(PokerSuit.CLUB, new PokerValue("3")),
				new PokerCard(PokerSuit.DIAMONDS, new PokerValue("5")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("6")),
				new PokerCard(PokerSuit.HEART, new PokerValue("K")),
				new PokerCard(PokerSuit.SPADE, new PokerValue("3")) };
		pbig = new PokerHand(pairBig);
		assertTrue(psmall.compareTo(pbig) < 0);
		assertTrue(pbig.compareTo(psmall) > 0);
		assertEquals(0, psmall.compareTo(psmall));
		assertEquals(0, pbig.compareTo(pbig));
	}

	@Test
	public void twoPairsCompareTest() throws PokerValueNotValidException,
			InvalidPokerCardsRowException {
		// comparison between high cards.
		PokerHand psmall, pbig, pbig2;

		PokerCard twoPairsSmall[] = {
				new PokerCard(PokerSuit.CLUB, new PokerValue("2")),
				new PokerCard(PokerSuit.DIAMONDS, new PokerValue("2")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("5")),
				new PokerCard(PokerSuit.HEART, new PokerValue("K")),
				new PokerCard(PokerSuit.SPADE, new PokerValue("5")) };
		psmall = new PokerHand(twoPairsSmall);

		PokerCard twoPairsBig[] = {
				new PokerCard(PokerSuit.CLUB, new PokerValue("3")),
				new PokerCard(PokerSuit.DIAMONDS, new PokerValue("3")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("6")),
				new PokerCard(PokerSuit.HEART, new PokerValue("K")),
				new PokerCard(PokerSuit.SPADE, new PokerValue("6")) };
		pbig = new PokerHand(twoPairsBig);

		PokerCard twoPairsBig2[] = {
				new PokerCard(PokerSuit.CLUB, new PokerValue("3")),
				new PokerCard(PokerSuit.DIAMONDS, new PokerValue("3")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("6")),
				new PokerCard(PokerSuit.HEART, new PokerValue("A")),
				new PokerCard(PokerSuit.SPADE, new PokerValue("6")) };
		pbig2 = new PokerHand(twoPairsBig2);

		assertTrue(psmall.compareTo(pbig) < 0);
		assertTrue(pbig.compareTo(psmall) > 0);
		assertEquals(0, psmall.compareTo(psmall));
		assertEquals(0, pbig.compareTo(pbig));
		assertTrue(pbig2.compareTo(pbig) > 0);
		assertTrue(pbig.compareTo(pbig2) < 0);
	}

	@Test
	public void threeOfAKindComparisonTest()
			throws PokerValueNotValidException, InvalidPokerCardsRowException {
		// comparison between high cards.
		PokerHand psmall, pbig;

		PokerCard threeOfAKindComparisonSmall[] = {
				new PokerCard(PokerSuit.CLUB, new PokerValue("2")),
				new PokerCard(PokerSuit.DIAMONDS, new PokerValue("2")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("5")),
				new PokerCard(PokerSuit.HEART, new PokerValue("K")),
				new PokerCard(PokerSuit.SPADE, new PokerValue("2")) };
		psmall = new PokerHand(threeOfAKindComparisonSmall);

		PokerCard threeOfAKindComparisonBig[] = {
				new PokerCard(PokerSuit.CLUB, new PokerValue("3")),
				new PokerCard(PokerSuit.DIAMONDS, new PokerValue("3")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("5")),
				new PokerCard(PokerSuit.HEART, new PokerValue("K")),
				new PokerCard(PokerSuit.SPADE, new PokerValue("3")) };
		pbig = new PokerHand(threeOfAKindComparisonBig);
		assertTrue(psmall.compareTo(pbig) < 0);
		assertTrue(pbig.compareTo(psmall) > 0);
		assertEquals(0, psmall.compareTo(psmall));
		assertEquals(0, pbig.compareTo(pbig));
	}

	@Test
	public void straightComparisonTest() throws PokerValueNotValidException,
			InvalidPokerCardsRowException {
		// comparison between high cards.
		PokerHand psmall, pbig;

		PokerCard straightComparisonSmall[] = {
				new PokerCard(PokerSuit.CLUB, new PokerValue("2")),
				new PokerCard(PokerSuit.DIAMONDS, new PokerValue("3")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("4")),
				new PokerCard(PokerSuit.HEART, new PokerValue("5")),
				new PokerCard(PokerSuit.SPADE, new PokerValue("6")) };
		psmall = new PokerHand(straightComparisonSmall);

		PokerCard straightComparisonBig[] = {
				new PokerCard(PokerSuit.CLUB, new PokerValue("6")),
				new PokerCard(PokerSuit.DIAMONDS, new PokerValue("3")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("4")),
				new PokerCard(PokerSuit.HEART, new PokerValue("5")),
				new PokerCard(PokerSuit.SPADE, new PokerValue("7")) };
		pbig = new PokerHand(straightComparisonBig);
		assertTrue(psmall.compareTo(pbig) < 0);
		assertTrue(pbig.compareTo(psmall) > 0);
		assertEquals(0, psmall.compareTo(psmall));
		assertEquals(0, pbig.compareTo(pbig));
	}

	@Test
	public void flushComparisonTest() throws PokerValueNotValidException,
			InvalidPokerCardsRowException {
		// comparison between high cards.
		PokerHand psmall, pbig;

		PokerCard flushComparisonSmall[] = {
				new PokerCard(PokerSuit.CLUB, new PokerValue("K")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("10")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("2")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("5")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("7")) };
		psmall = new PokerHand(flushComparisonSmall);

		PokerCard flushComparisonBig[] = {
				new PokerCard(PokerSuit.CLUB, new PokerValue("A")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("10")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("2")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("5")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("7")) };
		pbig = new PokerHand(flushComparisonBig);
		assertTrue(psmall.compareTo(pbig) < 0);
		assertTrue(pbig.compareTo(psmall) > 0);
		assertEquals(0, psmall.compareTo(psmall));
		assertEquals(0, pbig.compareTo(pbig));
	}

	@Test
	public void fullHouseComparisonTest() throws PokerValueNotValidException,
			InvalidPokerCardsRowException {
		// comparison between high cards.
		PokerHand psmall, pbig;

		PokerCard fullHouseComparisonSmall[] = {
				new PokerCard(PokerSuit.CLUB, new PokerValue("K")),
				new PokerCard(PokerSuit.SPADE, new PokerValue("K")),
				new PokerCard(PokerSuit.HEART, new PokerValue("2")),
				new PokerCard(PokerSuit.DIAMONDS, new PokerValue("2")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("2")) };
		psmall = new PokerHand(fullHouseComparisonSmall);

		PokerCard fullHouseComparisonBig[] = {
				new PokerCard(PokerSuit.CLUB, new PokerValue("K")),
				new PokerCard(PokerSuit.SPADE, new PokerValue("K")),
				new PokerCard(PokerSuit.HEART, new PokerValue("3")),
				new PokerCard(PokerSuit.DIAMONDS, new PokerValue("3")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("3")) };
		pbig = new PokerHand(fullHouseComparisonBig);
		assertTrue(psmall.compareTo(pbig) < 0);
		assertTrue(pbig.compareTo(psmall) > 0);
		assertEquals(0, psmall.compareTo(psmall));
		assertEquals(0, pbig.compareTo(pbig));
	}

	@Test
	public void fourOfAKindComparisonTest() throws PokerValueNotValidException,
			InvalidPokerCardsRowException {
		// comparison between high cards.
		PokerHand psmall, pbig;

		PokerCard fourOfAKindComparisonSmall[] = {
				new PokerCard(PokerSuit.CLUB, new PokerValue("K")),
				new PokerCard(PokerSuit.SPADE, new PokerValue("K")),
				new PokerCard(PokerSuit.HEART, new PokerValue("K")),
				new PokerCard(PokerSuit.DIAMONDS, new PokerValue("K")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("2")) };
		psmall = new PokerHand(fourOfAKindComparisonSmall);

		PokerCard fourOfAKindComparisonBig[] = {
				new PokerCard(PokerSuit.CLUB, new PokerValue("A")),
				new PokerCard(PokerSuit.SPADE, new PokerValue("A")),
				new PokerCard(PokerSuit.HEART, new PokerValue("A")),
				new PokerCard(PokerSuit.DIAMONDS, new PokerValue("A")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("2")) };
		pbig = new PokerHand(fourOfAKindComparisonBig);
		assertTrue(psmall.compareTo(pbig) < 0);
		assertTrue(pbig.compareTo(psmall) > 0);
		assertEquals(0, psmall.compareTo(psmall));
		assertEquals(0, pbig.compareTo(pbig));
	}

	@Test
	public void straightFlushComparisonTest()
			throws PokerValueNotValidException, InvalidPokerCardsRowException {
		// comparison between high cards.
		PokerHand psmall, pbig;

		PokerCard straightFlushComparisonSmall[] = {
				new PokerCard(PokerSuit.CLUB, new PokerValue("3")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("2")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("5")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("6")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("4")) };
		psmall = new PokerHand(straightFlushComparisonSmall);

		PokerCard straightFlushComparisonBig[] = {
				new PokerCard(PokerSuit.CLUB, new PokerValue("3")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("6")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("5")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("7")),
				new PokerCard(PokerSuit.CLUB, new PokerValue("4")) };
		pbig = new PokerHand(straightFlushComparisonBig);
		assertTrue(psmall.compareTo(pbig) < 0);
		assertTrue(pbig.compareTo(psmall) > 0);
		assertEquals(0, psmall.compareTo(psmall));
		assertEquals(0, pbig.compareTo(pbig));
	}
}
