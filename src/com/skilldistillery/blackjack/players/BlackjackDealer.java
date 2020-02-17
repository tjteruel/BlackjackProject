package com.skilldistillery.blackjack.players;

import com.skilldistillery.blackjack.cards.Deck;
import com.skilldistillery.blackjack.hand.BlackjackHand;

public class BlackjackDealer extends BlackjackPlayer {
	private Deck deck = new Deck();
	private BlackjackHand hand = new BlackjackHand();
		
	public BlackjackDealer(Deck deck) {
		super();
		this.deck = deck;
	}
	
	public BlackjackDealer() {
	}
	
	//DEALS TO PLAYER OR DEALER
	public void dealCard(BlackjackPlayer bjp) {
		bjp.getHand().addCard(deck.dealCard());
	}
	
	//DEALER SHUFFLES DECK
	public void dealerShuffle() {
		deck.shuffle();
	}
	
	//DEALER CHECKS HAND
	public int dealerCheckHand() {
		int handValue = hand.getHandValue();
		return handValue;
			}
	
	//SHOWS DEALER HAND w/ FACEDOWN
	public void printHiddenHand() {
		System.out.println("Dealer has one card face down and shows a " + hand.getHand().get(1));
	}
	
	//SHOWS WHOLE HAND
	public void printDealerCards() {
		System.out.println("The Dealer's hand is: " + hand.toString());
	}
	
	//DEALER HITS (HITS UNDER 17)
	public void dealerHits() {
		while (!getHand().isBust())
		if (dealerCheckHand() < 17 ) {
			System.out.println("The Dealer hits and shows the following cards: ");
			printDealerCards();
		} else {
			System.out.println("The Dealer stays and shows the following cards: ");
			printDealerCards();
		}
			
		}

	public BlackjackHand getHand() {
		return hand;
	}

	public void setHand(BlackjackHand hand) {
		this.hand = hand;
	}
	}
	


//dealer must hit below 17 - if(total hand < 17){draw }