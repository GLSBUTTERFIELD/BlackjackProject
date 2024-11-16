package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.AbstractHand;
import com.skilldistillery.cards.common.Card;

public class BlackjackHand extends AbstractHand {
	// hand List inherited from AbstractHand

	public BlackjackHand() {
	}

	@Override
	public int getHandValue() {
		int value = 0;
		for (Card card : cardsInHand) {
			value += card.getValue();
		}
		return value;
	}

	public boolean isBlackjack() {
		if (getHandValue() == 21) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isBust() {
		if (getHandValue() > 21) {
			return true;
		} else {
			return false;
		}
	}

}
