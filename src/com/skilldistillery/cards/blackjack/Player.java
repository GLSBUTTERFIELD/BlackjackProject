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

	public void addCardToHand(Card card) {
		hand.addCard(card);
	}

	public int getHandValue() {
		return hand.getHandValue();
	}
	
	public String showHand() {
		return hand.showHand() + "\nTotal: " + hand.getHandValue();
	}
	
	public boolean isBust () {
		if (hand.getHandValue() > 21) {
			return true;}
		else {
			return false;
		}
	}
	
	public boolean isBlackjack() {
		if (hand.getHandValue() ==21) {
			return true;			
		}
		else {
			return false;
		}
	}
	
	public boolean is21() {
		if (hand.getHandValue() == 21) {
		return true;
	}
		else {
			return false;
		}
	}
	
	public void clearHand() {
		hand.clear();
	}
	
}
