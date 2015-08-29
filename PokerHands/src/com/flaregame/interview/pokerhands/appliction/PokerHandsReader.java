package com.flaregame.interview.pokerhands.appliction;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.flaregame.interview.pokerhands.PokerCard;
import com.flaregame.interview.pokerhands.PokerHand;
import com.flaregame.interview.pokerhands.PokerSuit;
import com.flaregame.interview.pokerhands.exception.InvalidPokerCardsRowException;
import com.flaregame.interview.pokerhands.exception.InvalidPokerSuitException;
import com.flaregame.interview.pokerhands.exception.PokerValueNotValidException;

public class PokerHandsReader {

	private PokerHands pokerHands = null;

	public PokerHandsReader() {

	}

	public PokerHands parsePokerHandsInputFile(String inputFileName) {
		File fXmlFile = new File(inputFileName);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		Document doc = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			this.pokerHands = readPokerHandsFromXmlDoc(doc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.pokerHands;
	}

	private PokerHands readPokerHandsFromXmlDoc(Document doc)
			throws InvalidPokerSuitException, PokerValueNotValidException,
			InvalidPokerCardsRowException {
		PokerHands res = new PokerHands();
		if (!(doc.getDocumentElement().getNodeName()).equals("pokerHands")) {
			System.out.println("Wrong input file!");
			return null;
		}
		PokerCard cards[] = new PokerCard[5];
		NodeList pokerHandList = doc.getElementsByTagName("pokerHand");
		for (int i = 0; i < pokerHandList.getLength(); i++) {
			Element hand = (Element) (pokerHandList.item(i));
			String name = hand.getAttribute("name");
			NodeList pokerCards = hand.getElementsByTagName("pokerCard");
			if (pokerCards.getLength() != 5) {
				System.out.println("Wrong input file");
				return null;
			}
			
			for (int j = 0; j < pokerCards.getLength(); j++) {
				Element card = (Element) pokerCards.item(j);
				String suitStr = card.getAttribute("suit");
				String valueStr = card.getAttribute("value");
				cards[j] = new PokerCard(getPokerSuit(suitStr), valueStr);
						
			}
			PokerHand handToAdd = new PokerHand(cards);
			handToAdd.setName(name);
			res.addPokerHand(handToAdd);
		}
		return res;
	}

	private PokerSuit getPokerSuit(String suit)
			throws InvalidPokerSuitException {
		if (suit.equals("SPADE")) {
			return PokerSuit.SPADE;
		} else if (suit.equals("HEART")) {
			return PokerSuit.HEART;
		} else if (suit.equals("CLUB")) {
			return PokerSuit.CLUB;
		} else if (suit.equals("DIAMONDS")) {
			return PokerSuit.DIAMONDS;
		}
		throw new InvalidPokerSuitException();
	}

	public PokerHands getPokerHands() {
		return pokerHands;
	}

}
