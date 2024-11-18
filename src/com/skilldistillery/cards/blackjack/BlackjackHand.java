package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.AbstractHand;
import com.skilldistillery.cards.common.Card;

public class BlackjackHand extends AbstractHand {

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
		return is21() && cardsInHand.size() == 2;
	}

	public boolean isBust() {
		return getHandValue() > 21;
	}

	public boolean is21() {
		return getHandValue() == 21;
	}
}
