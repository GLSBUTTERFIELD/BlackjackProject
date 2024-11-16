package com.skilldistillery.cards.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.cards.blackjack.Dealer;
import com.skilldistillery.cards.blackjack.Player;
import com.skilldistillery.cards.common.Card;

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
		dealFirstRound();
		playerTurn();

	}

	private void dealFirstRound() {
		dealer.shuffleDeck();
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
		if (player.isBlackjack()) {
			System.out.println("\nBlackjack!");
			dealerTurn();
			return;
		}

		int playerChoice = hitOrStay();

		if (playerChoice == 1) {
			Card nextCard = dealer.dealCard();
			player.addCardToHand(nextCard);
			System.out.println(player.showHand());

			if (player.isBust()) {
				System.out.println("You lose.");
				System.out.println("\nDealer " + dealer.showHand());
				return;
			}

			else if (player.is21()) {
				System.out.println("You hit 21!");
				dealerTurn();
				return;
			}

			hitOrStay();

		} else if (playerChoice == 2) {
			System.out.println("Final Hand: " + player.showHand());
			dealerTurn();

		} else {
			System.out.println("Invalid input.");
			hitOrStay();
		}

	}

	public void dealerTurn() {
		int dealerHand = dealer.getHandValue();
		if (dealer.isBlackjack()) {
			System.out.println("\nDealer Blackjack!\nDealer wins.");
			return;
		}
		while (dealerHand <= 17) {
			Card nextCard = dealer.dealCard();
			dealer.addCardToHand(nextCard);
			dealerHand = dealer.getHandValue();
		}

		if (dealer.isBust()) {
			System.out.println("\nDealer " + dealer.showHand());
			System.out.println("\nYou win.");

		} else if (dealerHand == player.getHandValue()) {
			System.out.println("\nDealer " + dealer.showHand());
			System.out.println("\nPush.");

		} else {
			if (dealerHand > player.getHandValue()) {
				System.out.println("\nDealer " + dealer.showHand());
				System.out.println("\nThe dealer wins.");
			} else {
				System.out.println("\nDealer " + dealer.showHand());
				System.out.println("\nYou win.");

			}
		}
		playAgain();
	}

	public int hitOrStay() {
		int playerChoice = 0;

		System.out.println("\nWhat would you like to do?");
		System.out.println("1: hit/add card to your hand");
		System.out.println("2: stay\n");
		try {
			playerChoice = sc.nextInt();
			sc.nextLine();
		}

		catch (InputMismatchException e) {
			System.err.println("Invalid input.");
		}
		return playerChoice;
	}

	public void playAgain() {
		boolean keepGoing = true;
		System.out.println("\nWould you like to play again?");
		System.out.println("1: yes");
		System.out.println("2: no");
		try {
			int playAgain = sc.nextInt();
			sc.nextLine();
			if (playAgain == 1) {
				player.clearHand();
				dealer.clearHand();
				dealFirstRound();
				playerTurn();
				keepGoing = false;
			} else if (playAgain == 2) {
				System.out.println("Thanks for playing! Goodbye.");
				keepGoing = false;
			} else {
				System.out.println("Invalid input. Please try again.");
				keepGoing = true;
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please try again.");
			keepGoing = true;
		}
	}

}
