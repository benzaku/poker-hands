===========================================================================================================================
Instructions:
===========================================================================================================================
 - Import the project PokerHands in eclipse, compiling with JDK 1.6+
 - To run the unit test, run com.flaregame.interview.pokerhands.test.PokerHandTestSuite as JUnit test.
 - To run the main application, run com.flaregame.interview.pokerhands.appliction.MainApplication as Java application with one argument - path of input file.
 - Input file format: see PokerHands/input.xml as example.
 - Output: A list of highest pokerhands from input file.

 - Example:
  - input: PokerHands/input.xml

  - output:
Natasha: {SPADE:10, SPADE:J, SPADE:Q, SPADE:K, SPADE:A}
Jackie: {SPADE:10, SPADE:J, SPADE:Q, SPADE:K, SPADE:A}

===========================================================================================================================
Poker Hands
===========================================================================================================================

Your job is to compare several pairs of poker hands and to indicate which, if either, has a higher rank.

===========================================================================================================================
Poker rules description
===========================================================================================================================

A poker deck contains 52 cards - each card has a suit which is one of clubs, diamonds, hearts, or spades (denoted C, D, H, and S in the input data). Each card also has a value which is one of 2, 3, 4, 5, 6, 7, 8, 9, 10, jack, queen, king, ace (denoted 2, 3, 4, 5, 6, 7, 8, 9, T, J, Q, K, A). For scoring purposes, the suits are unordered while the values are ordered as given above, with 2 being the lowest and ace the highest value.

A poker hand consists of 5 cards dealt from the deck. Poker hands are ranked by the following partial order from lowest to highest.
High Card: Hands which do not fit any higher category are ranked by the value of their highest card. If the highest cards have the same value, the hands are ranked by the next highest, and so on.

Pair: 2 of the 5 cards in the hand have the same value. Hands which both contain a pair are ranked by the value of the cards forming the pair. If these values are the same, the hands are ranked by the values of the cards not forming the pair, in decreasing order.

Two Pairs: The hand contains 2 different pairs. Hands which both contain 2 pairs are ranked by the value of their highest pair. Hands with the same highest pair are ranked by the value of their other pair. If these values are the same the hands are ranked by the value of the remaining card.

Three of a Kind: Three of the cards in the hand have the same value. Hands which both contain three of a kind are ranked by the value of the 3 cards.

Straight: Hand contains 5 cards with consecutive values. Hands which both contain a straight are ranked by their highest card.
Flush: Hand contains 5 cards of the same suit. Hands which are both flushes are ranked using the rules for High Card.

Full House: 3 cards of the same value, with the remaining 2 cards forming a pair. Ranked by the value of the 3 cards.

Four of a kind: 4 cards with the same value. Ranked by the value of the 4 cards.

Straight flush: 5 cards of the same suit with consecutive values. Ranked by the highest card in the hand.

===========================================================================================================================
Remarks
===========================================================================================================================

You are free to decide if it's a standalone application or a web application.
Please use Java for the implementation.
You are free to decide on how the input of the Poker Hands work (may be stdin in a format specified by you, or even a simple web interface - your choice).
UI doesn't matter - it doesn't have to look good, it has to work. =)
Please do an estimation beforehand and let us know when you plan on delivering. Speed is not decisive - if you're busy all week and need a week or more that's fine, but please let us know beforehand when you expect to be ready.
It's required to use a public version control system. (GitHub, BitBucket...) Please commit regularly so we can see how the project has evolved.
Deliverable is: a link to above mentioned VCS where we can download the result, together with instructions on how to run the application.
Apply a level of test coverage which you think is appropriate.
