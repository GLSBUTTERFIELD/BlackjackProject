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
		 System.out.println("You lose.");
		 return true;
	}
	
	public boolean isBlackjack() {
		hand.showHand();
		System.out.println("\nBlackjack! You win.");
		return true;
	}
	
	public boolean is21() {
		hand.showHand();
		System.out.println("You hit 21!");
		return true;
	}
	
}
