package com.flaregame.interview.pokerhands;

import java.util.HashMap;

import com.flaregame.interview.pokerhands.exception.PokerValueNotValidException;

public class PokerValue implements Comparable<PokerValue> {

	public static final String[] VALID_VALUES = { "2", "3", "4", "5", "6", "7",
			"8", "9", "10", "J", "Q", "K", "A" };

	private static HashMap<String, Integer> VALUE_MAP = new HashMap<String, Integer>();

	static {
		for (int i = 0; i < VALID_VALUES.length; i++) {
			VALUE_MAP.put(VALID_VALUES[i], i + 2);
		}
	}

	private String value = "2"; // default value is 2;

	public PokerValue(){
		
	}
	
	public PokerValue(String value) throws PokerValueNotValidException {
		if (!isValid(value)) {
			throw new PokerValueNotValidException();
		} else {
			this.value = value;
		}
	}

	private boolean isValid(String v) {
		if (!(VALUE_MAP.containsKey(v))) {
			return false;
		} else {
			return true;
		}
	}

	public String getValue() {
		return this.value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int compareTo(PokerValue pv) {

		return VALUE_MAP.get(this.value) - VALUE_MAP.get(pv.getValue());
	}
}
