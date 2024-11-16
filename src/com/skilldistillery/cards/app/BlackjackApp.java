package com.skilldistillery.cards.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.cards.blackjack.Dealer;
import com.skilldistillery.cards.blackjack.Player;
import com.skilldistillery.cards.common.Card;

public class BlackjackApp {
//FIELDS
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
		if (player.getHandValue() == 21) {
			System.out.println("\nDealer " + dealer.showHand());
			player.isBlackjack();
			return;
		}

		int playerChoice = hitOrStay();

		if (playerChoice == 1) {
			Card nextCard = dealer.dealCard();
			player.addCardToHand(nextCard);
			System.out.println(player.showHand());
			if (player.getHandValue() > 21) {
				player.isBust();
				System.out.println("\nDealer " + dealer.showHand());
				return;
			}

			else if (player.getHandValue() == 21) {
				player.is21();
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

	}

	public void dealerTurn() {
		int dealerHand = dealer.getHandValue();
		while (dealerHand <= 17) {
			Card nextCard = dealer.dealCard();
			dealer.addCardToHand(nextCard);
			dealerHand = dealer.getHandValue();
		}

		if (dealerHand > 21) {
			dealer.isBust();
			System.out.println("\nDealer " + dealer.showHand());
			System.out.println("\nYou win.");
		} else if (dealerHand == player.getHandValue()) {
			System.out.println("\nDealer " + dealer.showHand());
			System.out.println("\nPush.");
		} else {
			if (dealerHand > player.getHandValue()) {
				System.out.println("\nDealer " + dealer.showHand());
				System.out.println("\nThe dealer won.");
			} else {
				System.out.println("\nDealer " + dealer.showHand());
				System.out.println("\nYou won.");

			}
		}

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

}
