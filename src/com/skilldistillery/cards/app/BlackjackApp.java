package com.skilldistillery.cards.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.cards.blackjack.Dealer;
import com.skilldistillery.cards.blackjack.Player;
import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Rank;
import com.skilldistillery.cards.common.Suit;

public class BlackjackApp {
	private Dealer dealer;
	private Player player;
	private Scanner sc;

	private BlackjackApp() {
		dealer = new Dealer();
		player = new Player();
		sc = new Scanner(System.in);
	}

	public static void main(String[] args) {
		BlackjackApp app = new BlackjackApp();
		app.startGame();
	}

	public void startGame() {
		System.out.println("Welcome to the Skill Distillery Blackjack Game!");
		System.out.println("Enter any key to get started.");
		sc.nextLine();

		dealer.newDeck();
		boolean playAgain = true;
		while (playAgain) {
			dealFirstRound();
			playerTurn();
			dealerTurn();
			checkWinner();
			playAgain = playAgain();
		}
		System.out.println("\nThanks for playing! Goodbye.");

	}

	private void dealFirstRound() {
		System.out.println("\nDealing cards ...");
		Card firstCard = dealer.dealCard();
		player.addCardToHand(firstCard);

		Card secondCard = dealer.dealCard();
		dealer.addCardToHand(secondCard);

		Card thirdCard = dealer.dealCard();
		player.addCardToHand(thirdCard);
		System.out.println("Player Hand: \n" + firstCard + "\n" + thirdCard + "\nTotal: " + player.getHandValue());

		Card fourthCard = dealer.dealCard();
		dealer.addCardToHand(fourthCard);
		System.out.println("\nDealer Hand: \n" + fourthCard + "\n[face down card]");

	}

	public void playerTurn() {
		if (player.hasBlackjack()) {
			return;
		}

		int playerChoice = hitOrStay();

		while (playerChoice == 1) {
			Card nextCard = dealer.dealCard();
			player.addCardToHand(nextCard);
			System.out.println("Player " + player.showHand());

			if (player.isBusted()) {
				return;
			}

			else if (player.has21()) {
				System.out.println("You hit 21!");
				return;
			}
			playerChoice = hitOrStay();
		}

		if (playerChoice == 2) {
			System.out.println("Player " + player.showHand());
			return;

		} else {
			System.out.println("Invalid input.");
			playerChoice = hitOrStay();
			System.out.println("Player " + player.showHand());
		}
	}

	public int hitOrStay() {
		int playerChoice = 0;

		System.out.println("\nWhat would you like to do?");
		System.out.println("1: Hit");
		System.out.println("2: Stay\n");
		try {
			playerChoice = sc.nextInt();
		} catch (InputMismatchException e) {
			System.err.println("Invalid input.");
		} finally {
			sc.nextLine();
		}
		return playerChoice;
	}

	public void dealerTurn() {
		System.out.println("\nDealer " + dealer.showHand());
		if (dealer.hasBlackjack()) {
			return;
		}

		int dealerValue = dealer.getHandValue();
		while (dealerValue < 17 || dealerValue == 17 && dealer.hasAce()) {
			Card nextCard = dealer.dealCard();
			dealer.addCardToHand(nextCard);
			dealerValue = dealer.getHandValue();
//			System.out.println(dealerValue + "!!!!");
			System.out.println("Dealer " + dealer.showHand());
			if (dealer.has21()) {
				System.out.println("Dealer hit 21.");
				return;
			}
		}
	}

	public void checkWinner() {
		if (dealer.hasBlackjack() && player.hasBlackjack()) {
			System.out.println("\nPlayer & Dealer blackjack. Push.");
		} else if (player.hasBlackjack() && !dealer.hasBlackjack()) {
			System.out.println("\nPlayer blackjack. You win.");
		} else if (dealer.hasBlackjack() && !player.hasBlackjack()) {
			System.out.println("/nDealer blackjack. The dealer wins.");
		} else if (dealer.isBusted() && player.isBusted()) {
			System.out.println("Dealer and player bust. Push.");
		} else if (player.isBusted() && !dealer.isBusted()) {
			System.out.println("\nPlayer bust. The dealer wins.");
		} else if (dealer.isBusted() && !player.isBusted()) {
			System.out.println("\nDealer bust. You win.");
		} else if (dealer.getHandValue() == player.getHandValue()) {
			System.out.println("\nPush.");
		} else if (dealer.getHandValue() > player.getHandValue()) {
			System.out.println("\nThe dealer wins.");
		} else if (dealer.getHandValue() < player.getHandValue()) {
			System.out.println("\nYou win.");
		}
		return;
	}

	public boolean playAgain() {
		playAgainMenu();
		try {
			int playAgain = sc.nextInt();
			sc.nextLine();
			if (playAgain == 1) {
				reset();
				return true;
			} else if (playAgain == 2) {
				return false;
			} else {
				System.out.println("Invalid input.");
				return false;
			}
		} catch (InputMismatchException e) {
			System.err.println("Invalid input.");
			return false;
		}
	}

	public void playAgainMenu() {
		System.out.println("\nWould you like to play again?");
		System.out.println("1: yes");
		System.out.println("2: no");
	}

	public void reset() {
		player.clearHand();
		dealer.clearHand();
		if (dealer.shouldReshuffle()) {
			System.out.println("\n[Dealer reshuffling deck]");
			dealer.newDeck();
		}
	}

}
