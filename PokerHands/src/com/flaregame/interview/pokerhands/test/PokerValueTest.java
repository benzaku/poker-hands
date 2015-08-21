package com.flaregame.interview.pokerhands.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.flaregame.interview.pokerhands.PokerValue;
import com.flaregame.interview.pokerhands.exception.PokerValueNotValidException;

public class PokerValueTest {

	private static final String[] VALID_VALUES_FOR_TEST = { "2", "3", "4", "5",
			"6", "7", "8", "9", "10", "J", "Q", "K", "A" };

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void constructorSuccessTest() {
		try {
			for (String v : VALID_VALUES_FOR_TEST) {
				PokerValue p = new PokerValue(v);
				assertEquals(v, p.getValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof PokerValueNotValidException) {
				fail("Invalid poker value.");
			} else {
				fail("unknown error.");
			}
		}
	}

	@Test
	public void constructorFailureTest() {
		try {
			PokerValue p = new PokerValue("1");
		} catch (Exception e) {
			assertEquals(PokerValueNotValidException.class, e.getClass());
		}

		try {
			PokerValue p = new PokerValue("B");
		} catch (Exception e) {
			assertEquals(PokerValueNotValidException.class, e.getClass());
		}

		try {
			PokerValue p = new PokerValue("11");
		} catch (Exception e) {
			assertEquals(PokerValueNotValidException.class, e.getClass());
		}
	}

	@Test
	public void compareTest() throws PokerValueNotValidException {
		// general test
		assertTrue((new PokerValue("A").compareTo(new PokerValue("J")) > 0));
		assertTrue((new PokerValue("K").compareTo(new PokerValue("8")) > 0));
		assertTrue((new PokerValue("2").compareTo(new PokerValue("A")) < 0));
		// equal test
		for (String v : VALID_VALUES_FOR_TEST) {
			PokerValue v1 = new PokerValue(v);
			PokerValue v2 = new PokerValue(v);
			assertEquals(0, v1.compareTo(v2));
		}

		// larger test
		for (int i = 1; i < VALID_VALUES_FOR_TEST.length; i++) {
			PokerValue v1 = new PokerValue(VALID_VALUES_FOR_TEST[i]);
			PokerValue v2 = new PokerValue(VALID_VALUES_FOR_TEST[i - 1]);
			assertTrue(v1.compareTo(v2) > 0);
		}

		// smaller test
		for (int i = 1; i < VALID_VALUES_FOR_TEST.length; i++) {
			PokerValue v1 = new PokerValue(VALID_VALUES_FOR_TEST[i]);
			PokerValue v2 = new PokerValue(VALID_VALUES_FOR_TEST[i - 1]);
			assertTrue(v2.compareTo(v1) < 0);
		}
	}
}
