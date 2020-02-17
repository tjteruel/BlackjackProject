package com.skilldistillery.blackjack.players;

import com.skilldistillery.blackjack.hand.BlackjackHand;

public class BlackjackPlayer extends Player {

	private BlackjackHand hand = new BlackjackHand();
		
	public BlackjackPlayer() {
	}
	
	public BlackjackHand playerHandValue() {
		//getHand().getHandValue();
		return hand;
	}

	public BlackjackHand getHand() {
		return hand;
	}

	public void setHand(BlackjackHand hand) {
		this.hand = hand;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BlackjackPlayer [hand=");
		builder.append(hand);
		builder.append("]");
		return builder.toString();
	}

	
	
	
}
