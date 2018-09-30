package com.company;

import java.util.ArrayList;

/**
 * Class represents the player/dealer's current hand of cards.
 */
public class Hand {

    public ArrayList<Card> cardList;

    /**
     * Constructor
     * Creates new instance of cardList ArrayList.
     */
    public Hand(){
        cardList = new ArrayList<Card>();
    }

    /**
     * Adds a card to the hand.
     * @param Card - card chosen to add to the hand
     */
    public void addCard(Card c){
        this.cardList.add(c);
    }

    /**
     * @return Int - total score of the hand
     * Counts value of Ace as 11 only if hand value < 10
     */
    public int getValueOfHand(){
        int runningTotal = 0;
        int numberOfAces = 0;

        for (int i = 0; i < this.cardList.size(); i++){
            Card currentCard = this.cardList.get(i);
            if (currentCard.getFace().equals("ACE")){
                numberOfAces++;
            }
            else {
                runningTotal += currentCard.getValue();
            }
        }
        if (numberOfAces != 0){
            for (int i = 0; i < numberOfAces; i++){
                if (runningTotal > 10){
                    runningTotal += 1;
                }
                else{
                    runningTotal += 11;
                }
            }
        }
        return runningTotal;
    }
}
