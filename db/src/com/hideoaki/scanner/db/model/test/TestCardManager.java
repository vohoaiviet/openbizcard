package com.hideoaki.scanner.db.model.test;

import java.util.List;

import com.hideoaki.scanner.db.model.Card;
import com.hideoaki.scanner.db.model.Group;
import com.hideoaki.scanner.db.utils.Privacy;
import com.hideoaki.scanner.db.utils.ScannerDBException;

import junit.framework.TestCase;

public class TestCardManager extends TestCase {
	public static final String DEFAULT_TEST_CARD_FILE = "defaulttestcard.csv";

	public TestCardManager(String name) {
		super(name);
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(TestCardManager.class);
	}

	public static void testLoadLocalCSV() throws Exception {
		try {
			List<Card> list = Card.loadLocalCard(DEFAULT_TEST_CARD_FILE);
			assertEquals(list.size(), 9);
		} catch (ScannerDBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void testSaveLocalCSV() throws Exception {

		List<Card> cards = Card.loadLocalCard(DEFAULT_TEST_CARD_FILE);
		Card card1 = new Card("krissada3", "chalermsook", "Project LEader",
				"hideoaki@gmail.com", "Crie Company Limited",
				"http://www.hideoaki.com", "\"400/107 \' Soi", "Bangkok",
				"��", "d", "a", "025894821", "ssss", "0805511559", "aa",
				"sss", "sss", new Group("Test"), Privacy.GROUP);
		Card card2 = new Card("krissada4", "chalermsook2", "Project LEader2",
				"hideoaki@gmail.com2", "Crie Company Limited2",
				"http://www.hideoaki.com", "\"400/107 \' Soi", "Bangkok",
				"��", "d", "a", "025894821", "ssss", "0805511559", "aa",
				"sss", "sss", new Group("Test"), Privacy.GROUP);
		cards.add(card1);
		cards.add(card2);
		try {
			Card.saveLocalCard(cards, DEFAULT_TEST_CARD_FILE);
			assertEquals(11, cards.size());
			Card.deleteLocalCard(10, DEFAULT_TEST_CARD_FILE);
			List<Card> afterDeleteCards = Card.deleteLocalCard(9,
					DEFAULT_TEST_CARD_FILE);
			assertEquals(afterDeleteCards.size(), 9);
		} catch (ScannerDBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
