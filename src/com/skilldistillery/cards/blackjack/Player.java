package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;

public class Player {
	protected BlackjackHand hand;

	public Player() {
		hand = new BlackjackHand();
	}

	public String showHand() {
		return hand.showHand() + "\nTotal: " + hand.getHandValue();
	}
	
	public BlackjackHand getHand() {
		return hand;
	}

}
