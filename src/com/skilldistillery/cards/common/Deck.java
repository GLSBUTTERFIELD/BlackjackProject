package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cards = new ArrayList<>();

	public Deck() {
		Suit[] suits = Suit.values();
		Rank[] ranks = Rank.values();

		for (Suit suit : suits) {
			for (Rank rank : ranks) {
				cards.add(new Card(suit,rank));
			}
		}
	}

	public Card dealCard() {
		return cards.remove(0);
	}
		
	public int cardsLeftInDeck() {
		return cards.size();
	}

	public void shuffleDeck() {
		Collections.shuffle(cards);
	}

}
