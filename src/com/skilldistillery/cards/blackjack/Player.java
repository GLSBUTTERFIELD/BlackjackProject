package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;

public class Player {
	protected BlackjackHand hand;

	public Player() {
		hand = new BlackjackHand();
	}

	public void addCardToHand(Card card) {
		hand.addCard(card);
	}

	public int getHandValue() {
		return hand.getHandValue();
	}
	
	public String showHand() {
		return hand.showHand() + "\nTotal: " + hand.getHandValue();
	}
	
	public boolean isBusted () {
		return hand.isBust();
	}
	
	public boolean hasBlackjack() {
		return hand.isBlackjack();
	}
	
	public boolean has21() {
		return hand.is21();
	}
	
	public void clearHand() {
		hand.clear();
	}
	
}
