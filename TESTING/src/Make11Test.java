import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Make11Test {


    @Test
    public void testDeckIsEmpty() {

        Deck emptyDeck = new Deck();

        while (!emptyDeck.deckIsEmpty()) {
            emptyDeck.deal();
        }

        assertTrue(emptyDeck.deckIsEmpty());
    }
    @Test
    public void testDeckIsNotEmpty() {
        Deck nonEmptyDeck = new Deck();

        assertFalse(nonEmptyDeck.deckIsEmpty());
    }

    public static void testingPrint() {
        Deck deck = new Deck();
        Card[] playerCards = new Card[5];
        deck.dealPlayerCards(playerCards);

        Card computerCard = deck.deal();
        System.out.println("Computer Deals : " + computerCard + "\n");

        deck.displayPlayerOptions(playerCards);
    }

    public static void main(String[] args)  {
        testingPrint();
    }


    @Test
    public void SumIs11() {

        int computerRank1 = 4; //index value from the rank array 4th index = rank 5
        int computerSuit1 = 0;

        int playerRank1 = 5; //index value from the rank array 5th index value = rank 6
        int playerSuit1 = 2;

        Card computerCard1 = new Card(computerRank1, computerSuit1);
        Card playerCard1 = new Card(playerRank1, playerSuit1);

        int TotalSumOfCardSet1 = computerCard1.getRankValue() + playerCard1.getRankValue();
        assertEquals(11,TotalSumOfCardSet1);

    }
    @Test
    public void sameSuitTest() {

        int computerSuit = 1;
        int computerRank = 2;

        int playerCardSuit = 1;
        int playerCardRank =3;

        Card computerCard = new Card(computerRank,computerSuit);
        Card playerCard = new Card(playerCardRank,playerCardSuit);

        assertTrue(playerCard.getSuit() == (computerCard.getSuit()));

        System.out.println("Matching suits");

    }

    @Test
    public void ReplaceCard(){

        Deck deck = new Deck();

        Card[] playerCards = new Card[5];
        deck.dealPlayerCards(playerCards);

        //Mock user input
        String userOption = "A";

        Card originalCard = playerCards[userOption.charAt(0) - 'A'];

        playerCards[userOption.charAt(0) - 'A'] = deck.deal();

        assertNotEquals(originalCard, playerCards[userOption.charAt(0) - 'A']);
    }


    @Test
    public void testDealPlayerCards() {

        Card[] playerCards = new Card[5];
        assertEquals(playerCards.length,5);

        for (Card card : playerCards) {
            assertNotNull(playerCards);
        }
    }

    @Test
    public  void testDisplayPlayerOptions() {
        Deck deck = new Deck();

        Card[] playerCards = new Card[5];
        for (int i = 0; i < playerCards.length; i++) {
            playerCards[i] = deck.deal();
        }

        deck.displayPlayerOptions(playerCards);
    }

    @Test
    public void testingCardChange() {

        Deck deck = new Deck();
        Card[] playerCards = new Card[5];
        deck.dealPlayerCards(playerCards); //populates the playerCard array

        Card orgCard  = playerCards[0];
        Card newCard = deck.deal();
        playerCards[0] = newCard;

        assertNotEquals(orgCard,playerCards[0]);
    }



    @Test
    public void testEdgeCaseMinimumRank() {
        Card card = new Card(0,4); //0 rank corresponds to the 0th index in rank = Ace

        assertEquals("Ace", card.getRank());
    }

    @Test
    public void testEdgeCaseMaxrank(){
        Card card = new Card(12,4);
        assertEquals("King", card.getRank());

    }

    @Test
    public void testIfCardIsPictureCard() {

        Card pictureCard = new Card(11,2);

        int playerCardValue = pictureCard.getRankValue();
        if (playerCardValue > 10) {
            playerCardValue = 10;
        }

        assertTrue(playerCardValue >= 10);

    }

}