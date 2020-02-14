package com.skilldistillery.blackjack.hand;

import java.util.*;

import com.skilldistillery.blackjack.cards.Card;

public abstract class Hand {
	
	private List<Card> cards;
	
	public Hand() {
		cards = new ArrayList<Card>();
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public void clear() {
		cards = new ArrayList<Card>();
	}
	
	public abstract int getHandValue();

	
	//toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hand [cards=");
		builder.append(cards);
		builder.append("]");
		return builder.toString();
	}
	
	

}
