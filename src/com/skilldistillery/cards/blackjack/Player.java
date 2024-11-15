package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;

public class Player {
//FIELD - only 1
	protected BlackjackHand hand;
//ctor
	public Player() {
		hand = new BlackjackHand();
	}
	
	private void addCardToHand (Card card) {
		hand.addCard(card);
	}
	
	
	
}
