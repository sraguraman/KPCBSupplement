package com.company;

/**
 * Class represents a card in the deck.
 */
public class Card {
    private String suit;
    private Integer value;
    private String face;

    /**
     * Constructor
     * @param String value of suit (eg: Clubs).
     * @param Integer - score of the card (eg: 10).
     * @param String face of the card (eg: King).
     */
    public Card(String suit, Integer value, String face){
        this.suit = suit;
        this.value = value;
        this.face = face;
    }

    /**
     * Returns suit of card.
     * @return String value of suit.
     */
    public String getSuit(){
        return this.suit;
    }

    /**
     * Returns score of card.
     * @return Integer score of card.
     */
    public Integer getValue() {
        return this.value;
    }

    /**
     * Returns face of card.
     * @return String face of card.
     */
    public String getFace(){
        return this.face;
    }

    /**
     * Pretty prints the face and suit of the card.
     */
    public String toString(){
        return this.getFace() + " of " + this.getSuit();
    }
}
