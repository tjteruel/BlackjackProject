package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.cards.Deck;
import com.skilldistillery.blackjack.players.BlackjackDealer;
import com.skilldistillery.blackjack.players.BlackjackPlayer;

public class BlackjackApp {
	// F I E L D S 
	BlackjackDealer dealer = new BlackjackDealer();
	BlackjackPlayer player = new BlackjackPlayer();
	Deck deck = new Deck();
	Scanner kb = new Scanner(System.in);


	// M E T H O D S 
	public static void main(String[] args) {
		BlackjackApp app = new BlackjackApp();		
		app.intro();
	}// E N D  M A I N 
	
	
	//INTRO
	private void intro() {
		System.out.println("\t\tWelcome to the Blackjack Table!");
		boolean menuLoop = true;
		while(menuLoop) {
			try {
				System.out.println("Are you ready to be delt in?");
				System.out.println("1. Be dealt a hand \n2. Leave table");
				int userChoice = kb.nextInt();
				switch(userChoice) {
				case 1: 
					firstHand();
					break;
				case 2:
					System.out.println("Maybe next time? Goodbye!");
					menuLoop = false;
					break;
				default:
					System.out.println("Please enter 1 or 2.");
					break;
				}
			} catch (Exception e) {
				System.out.println("Please enter 1 or 2.");
			}
		}
		
	}
	//DEALS FIRST HAND
	private void firstHand() {	
		dealer.dealerShuffle();
		System.out.println("Dealing cards...");
		dealer.dealCard(player);
		System.out.println("Your hand: " + player.getHand().toString());
		dealer.dealCard(dealer);
		System.out.println("The dealer places his first card face down.");
		dealer.dealCard(player);
		System.out.println("Your hand: " + player.getHand().toString());
		dealer.dealCard(dealer);		
		dealer.printHiddenHand();
		System.out.println( "Your total hand is " + player.getHand().getHandValue());
		checkBlackjack();
		
		if (!player.getHand().isBlackjack() && !dealer.getHand().isBlackjack()) {
			hitOrStay();		
			}	
	}//END FIRST HAND METHOD
	
	//PLAYER HITS OR STAYS
	private void hitOrStay() {
		System.out.println("\nWhat would you like to do next? ");
		System.out.println("1. Hit \n2. Stay \n3. Quit");
		try {
			int userChoice = kb.nextInt();
			switch (userChoice) {
			case 1:
				System.out.println("The dealer hands you another card. ");
				dealer.dealCard(player);
				System.out.println("Your hand: " + player.getHand().toString());
				System.out.println( "Your total hand is " + player.getHand().getHandValue());
				checkBlackjack();
				checkBust();
				break;
			case 2:
				System.out.println("Your hand: " + player.getHand().toString());
				System.out.println( "Your total hand is " + player.getHand().getHandValue());
				dealer.dealerHits();
				checkBlackjack();
				checkBust();
				break;
			case 3: 
				System.out.println("Thanks for playing!");
				System.exit(0);
				break;
			default:
				System.out.println("Please enter 1, 2, or 3. ");
				break;
			}
		} catch (Exception e) {
			System.out.println("Please enter 1, 2, or 3. ");
		}
	}
	
	
	//CHECKS FOR BLACKJACK
	private void checkBlackjack() {
		if (player.getHand().isBlackjack()) {
			System.out.println("Blackjack! You win!");
		}
		if (dealer.getHand().isBlackjack()) {
			dealer.printDealerCards();
			System.out.println("Blackjack! The Dealer won. "  );
		}
	}
	
	//CHECKS FOR BUST
	private void checkBust() {
		if (player.getHand().isBust()) {
			System.out.println("Busted! Dealer wins.");
		}
		if (dealer.getHand().isBust()) {
			System.out.println("The Dealer busted! YOU WIN!");
		}
	}
	
	//DEALER HITS UNDER 17

}
