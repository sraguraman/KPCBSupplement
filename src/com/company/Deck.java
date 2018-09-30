package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

/**
 * Class represents the deck of cards.
 */
public class Deck {

    /**
     * Enumerations of possible suits and faces of the cards.
     */
    public enum cardSuits {HEARTS, DIAMONDS, CLUBS, SPADES;}
    public enum cardFaces {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;}

    /**
     * Static Map holding card faces and corresponding scores.
     */
    static final Map<String, Integer> valueMap;
    static {
        valueMap = new HashMap<String, Integer>();
        valueMap.put("TWO", 2);
        valueMap.put("THREE", 3);
        valueMap.put("FOUR", 4);
        valueMap.put("FIVE", 5);
        valueMap.put("SIX", 6);
        valueMap.put("SEVEN", 7);
        valueMap.put("EIGHT", 8);
        valueMap.put("NINE", 9);
        valueMap.put("TEN", 10);
        valueMap.put("JACK", 10);
        valueMap.put("QUEEN", 10);
        valueMap.put("KING", 10);
        valueMap.put("ACE", 11);
    }

    public ArrayList<Card> deckOfCards;

    /**
     * Constructor
     * Creates new instance of deckOfCards ArrayList.
     * Creates 52 unique card instances to build the deck.
     */
    public Deck(){
        deckOfCards = new ArrayList<Card>();

        for (cardSuits cs: cardSuits.values()){
            for (cardFaces cf: cardFaces.values()){
                String currentSuit = cs.name();
                int valueToAdd = valueMap.get(cf.name());
                String currentFace = cf.name();

                Card toAdd = new Card(currentSuit, valueToAdd, currentFace);
                deckOfCards.add(toAdd);
            }
        }
    }

    /**
     * Shuffles the deck using Collections framework shuffle function.
     */
    public void shuffleDeck(){
        Collections.shuffle(deckOfCards);
    }

    /**
     * Removes and returns the first card in the deck.
     */
    public Card dealCard(){
        return deckOfCards.remove(0);
    }
}
