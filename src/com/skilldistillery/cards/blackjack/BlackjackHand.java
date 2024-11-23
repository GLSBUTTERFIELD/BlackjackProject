package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.AbstractHand;
import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Rank;
import com.skilldistillery.cards.common.Suit;

public class BlackjackHand extends AbstractHand {
	public BlackjackHand() {
	}

	@Override
	public int getHandValue() {
		int value = 0;
		int acesInHand = 0;
		for (Card card : cardsInHand) {
			value += card.getValue();
			if (card.getRank() == Rank.ACE) {
				acesInHand++;
			}
			if (value > 21 && acesInHand > 0) {
				value -= 10;
				acesInHand--;
			}
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

	public boolean hasAce() {
		for (Card card : cardsInHand) {
			if (card.getRank() == Rank.ACE) {
				return true;
			}
		}
		return false;
	}
}
