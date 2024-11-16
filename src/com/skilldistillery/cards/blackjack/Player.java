package com.skilldistillery.cards.blackjack;

import java.util.List;

import com.skilldistillery.cards.common.Card;

public class Player {
//FIELD - only 1
	protected BlackjackHand hand;

//ctor
	public Player() {
		hand = new BlackjackHand();
	}

	private void addCardToHand(Card card) {
		hand.addCard(card);
	}

	public int getHandValue() {
		return hand.getHandValue();
	}
	
	public boolean isBust () {
		return hand.isBust();
	}
	
	public boolean isBlackjack() {
		return hand.isBlackjack();
	}
	
}
