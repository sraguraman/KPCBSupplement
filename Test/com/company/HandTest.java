package com.company;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    /**
     * Tests if the Ace is read correctly.
     * The value of King and Queen add up to 20.
     * Rather than reading the Ace as having value 11, the function
     * reads it as having value 1, preventing the hand from busting.
     */

    @org.junit.jupiter.api.Test
    void testGetValueOfHand() {
        Hand h = new Hand();
        Card c1 = new Card("CLUBS", 10, "KING");
        Card c2 = new Card("SPADES", 10, "QUEEN");
        h.addCard(c1);
        h.addCard(c2);
        int initialValue = h.getValueOfHand();
        assertEquals(initialValue, 20);
        Card c3 = new Card("HEARTS", 11, "ACE");
        h.addCard(c3);
        int valueWithSoftAce = h.getValueOfHand();
        assertEquals(valueWithSoftAce, 21);
    }
}