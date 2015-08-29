package com.flaregame.interview.pokerhands.appliction;

public class MainApplication {

	private static final String USAGE = "Usage: PokerHands <inputFile>";

	public static void main(String args[]) {
		if (args.length != 1) {
			printUsage();
			return;
		}
		String inputFileName = args[0];
		System.out.println("Input file: " + inputFileName);

		PokerHandsReader reader = new PokerHandsReader();
		reader.parsePokerHandsInputFile(inputFileName);
		IPokerComparator comparator = new PokerHandFlareGameComparator();
		PokerHands highHands = comparator.getHighestPokerHands(reader
				.getPokerHands());
		System.out.println(highHands.toString());
	}

	private static void printUsage() {
		System.out.println(USAGE);
	}
}
