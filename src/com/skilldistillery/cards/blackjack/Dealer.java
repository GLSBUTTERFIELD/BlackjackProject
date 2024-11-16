package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class Dealer extends Player {
	private Deck deck;
	
	public Dealer() {
		deck = new Deck();
	}
	
	public Card dealCard() {
		return deck.dealCard();
	}
	
	public Card[] dealCard(int numToDeal) {
		Card[] dealtCards = new Card [numToDeal];
		for (int i = 0; i < numToDeal; i++) {
			dealtCards [i] = deck.dealCard();
		}
		return dealtCards;
	}
	
	public void shuffleDeck() {
		deck.shuffleDeck();
	}
	
}
