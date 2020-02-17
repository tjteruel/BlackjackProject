package com.skilldistillery.blackjack.hand;

import java.util.*;

import com.skilldistillery.blackjack.cards.Card;

public abstract class Hand {
	
	protected List<Card> cards;
	
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
	
	public List<Card> getHand(){
		List<Card> cardsDefensive = new ArrayList<>();
		cardsDefensive.addAll(cards);
		return cardsDefensive;
	}

	
	//toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();		
		builder.append(cards);		
		return builder.toString();
	}
	
	

}
