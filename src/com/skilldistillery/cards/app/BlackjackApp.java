package com.skilldistillery.cards.app;

import java.util.Scanner;

import com.skilldistillery.cards.blackjack.Dealer;
import com.skilldistillery.cards.blackjack.Player;

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

		playerOptions();
		// TODO Auto-generated method stub

	}

	public void playerOptions() {
		System.out.println("\nWhat would you like to do?");
		System.out.println("1: hit/add card to your hand");
		System.out.println("2: stay\n");
	}

//	public void 

}
