package com.skilldistillery.blackjack.cards;

public enum Suit {
	HEARTS("Hearts"), 
	SPADES("Spades"), 
	CLUBS("Clubs"), 
	DIAMONDS("Diamonds");

	Suit(String name) {
		this.name = name;
	}

	private String name;

	// toString is written manually, this shortcut doesn't work for enum.
	@Override
	public String toString() {
		return name;
	}
}