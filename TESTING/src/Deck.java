import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> deck = new ArrayList<Card>();


    public Deck() {
        for (int i = 0; i < 52; i++) {              // set up to hold 52 card objects via for-loop and adds to it
            this.deck.add(new Card(i % 13, i / 13));
        }
        Collections.shuffle(this.deck);
    }

    public Card deal() {
        if (this.deck.size() > 0) {
            Card card = this.deck.get(0);
            this.deck.remove(0);
            return card;
        } else return null;
    }

    public boolean deckIsEmpty() {
        return (deal() == null);
    }

    public void dealPlayerCards(Card[] playerCards) {
        for (int i = 0; i < playerCards.length; i++) {
            playerCards[i] = deal();
        }
    }

    public void displayPlayerOptions(Card[] playerCards) {
        System.out.println("Player's Options:");
        for (int i = 0; i < playerCards.length; i++) {
            System.out.println((char) ('A' + i) + ": " + playerCards[i].toString());
        }
    }



    public int convertLetterToIndex(char letter) {
        return letter - 'A';
    }


    public int getCardValue(char cardOption) {
        int index = convertLetterToIndex(cardOption);
        if (index >= 0 && index < deck.size()) {
            return deck.get(index).getRankValue();
        } else {

            return 0; //handles invalid input
        }
    }




}
