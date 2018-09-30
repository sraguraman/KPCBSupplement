package com.company;

import java.util.Scanner;

/**
 * Class contains the game logic for blackjack.
 */
public class Blackjack {

    public Deck currentDeck;
    public Hand playerHand;
    public Hand dealerHand;

    public static void main(String[] args) {
        Blackjack game = new Blackjack();
        game.startGame();
    }

    /**
     * Creates and shuffles a new deck.
     * Deals cards to player/dealer.
     * Asks player to hit or stand.
     */
    public void startGame(){
        currentDeck = new Deck();
        currentDeck.shuffleDeck();
        playerHand = new Hand();
        dealerHand = new Hand();

        playerHand.addCard(currentDeck.dealCard());
        playerHand.addCard(currentDeck.dealCard());
        dealerHand.addCard(currentDeck.dealCard());
        dealerHand.addCard(currentDeck.dealCard());

        System.out.println("---------------------");
        System.out.println("Welcome to Blackjack!");

        System.out.println("Your Hand:");
        printHand(playerHand);
        System.out.println("Total Score: " + playerHand.getValueOfHand());

        System.out.println("Dealer's Card:");
        System.out.println(dealerHand.cardList.get(0));
        System.out.println("Total Score: " + dealerHand.cardList.get(0).getValue());
        checkInitialBlackjack();

        hitOrStand();
    }

    /**
     * Adds card to player's hand.
     * Displays score to user.
     * Decides to hit, stand or restart game.
     */
    public void Hit() {
        playerHand.addCard(currentDeck.dealCard());
        System.out.println("Your Hand:");
        printHand(playerHand);

        if (playerHand.getValueOfHand() == 21) {
            System.out.println("------------------------------------------------------");
            System.out.println("Blackjack! The sum of your cards is 21. Time to stand.");
            Stand();
        } else if (playerHand.getValueOfHand() < 21) {
            System.out.println("Here is the value of your hand: " + playerHand.getValueOfHand());
            hitOrStand();
        } else{
            System.out.println("Total Score: " + playerHand.getValueOfHand());
            System.out.println("The value of your cards has exceeded 21! You Lost!");
            restartGame();
        }
    }

    /**
     * Adds cards to dealer's hand until dealer's score is >= 17.
     * Displays final result of game.
     */
    public void Stand(){
        System.out.println("Dealer Hand:");
        printHand(dealerHand);
        System.out.println("Total Score: " + dealerHand.getValueOfHand());

        if (dealerHand.getValueOfHand() == 21){
            System.out.println("Dealer has a blackjack! You Lost!");
            restartGame();
        }
        else if (dealerHand.getValueOfHand() > 21){
            System.out.println("Dealer's hand score exceeded 21. You win!");
            restartGame();
        }
        else if (dealerHand.getValueOfHand() >= 17){
            if (playerHand.getValueOfHand() > dealerHand.getValueOfHand()) {
                System.out.println("Your hand score of " + playerHand.getValueOfHand()
                        + " " + "exceeds the dealer's hand score of" + " "
                        + dealerHand.getValueOfHand() + "." + " You win!");
                restartGame();
            } else if (playerHand.getValueOfHand() == dealerHand.getValueOfHand()){
                System.out.println("Your hand score of " + playerHand.getValueOfHand()
                        + " " + "is equal to the dealer's hand score of" + " "
                        + dealerHand.getValueOfHand() + "." + " You tied!");
                restartGame();
            } else {
                System.out.println("Your hand score of " + playerHand.getValueOfHand()
                        + " " + "is less than the dealer's hand score of" + " "
                        + dealerHand.getValueOfHand() + "." + " You Lose!");
                restartGame();
            }
        }
        else {
            System.out.println("-------------------------------");
            System.out.println("The Dealer takes another hit...");
            dealerHand.addCard(currentDeck.dealCard());
            Stand();
        }
    }

    /**
     * Checks if the dealer/player has a blackjack when the game begins.
     * Outputs results and restarts game if player and/or dealer has a blackjack.
     */
    public void checkInitialBlackjack(){
        if (playerHand.getValueOfHand() == 21 && dealerHand.getValueOfHand() == 21){
            System.out.println("It's a tie! Both yours and the dealer's cards add up to 21!");
            System.out.println("Dealer's other card: " + dealerHand.cardList.get(1).toString());
            restartGame();
        }
        else if (playerHand.getValueOfHand() == 21){
            System.out.println("Your cards add up to 21! You win!");
            restartGame();
        }
    }

    /**
     * Prints the cards in the player/dealer's hand.
     */
    public void printHand(Hand h){
        for (int i = 0; i < h.cardList.size(); i++){
            System.out.println(h.cardList.get(i).toString());
        }
    }

    /**
     * Asks the player if they would like to play again.
     * Restarts if yes, quits if no.
     */
    public void restartGame(){
        System.out.println("---------------------------------------------------");
        System.out.println("Would you like to play again? (y for yes, n for no)");
        Scanner in = new Scanner(System.in);
        String choice = in.nextLine();

        while (!(choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("N")
                || choice.equalsIgnoreCase("YES") || choice.equalsIgnoreCase("NO"))){
            System.out.println("Invalid input...try again");
            choice = in.nextLine();
        }

        if (choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("YES")){
            startGame();
        }
        else if (choice.equalsIgnoreCase("N") || choice.equalsIgnoreCase("NO")){
            System.out.println("Thank you for playing at Sid's casino!");
            System.exit(0);
        }
    }

    /**
     * Asks the player if they would like to hit or stand.
     * Triggers either hit or stand function.
     */
    public void hitOrStand(){
        System.out.println("Would you like to hit or stand? (type h for hit and s for stand)");
        Scanner in = new Scanner(System.in);
        String choice = in.nextLine();

        while (!(choice.equalsIgnoreCase("H") || choice.equalsIgnoreCase("S")
                || choice.equalsIgnoreCase("HIT") || choice.equalsIgnoreCase("STAND"))){
            System.out.println("Invalid input...try again!");
            choice = in.nextLine();
        }

        if (choice.equalsIgnoreCase("H") || (choice.equalsIgnoreCase("HIT"))){
            Hit();
        }
        else if (choice.equalsIgnoreCase("S") || (choice.equalsIgnoreCase("STAND"))){
            Stand();
        }
    }
}

