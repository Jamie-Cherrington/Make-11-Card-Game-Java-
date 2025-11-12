
public class Card { private int rank;
    private  int suit;


    private static String[] ranks  = { "Ace", "2", "3", "4", "5","6","7","8","9", "10",   // this is the setting ace as 1 / index 0
            "Jack", "Queen", "King"};

    private static String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };



    public  Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return Card.ranks[this.rank];

    }

    public String getSuit() {
        return Card.suits[this.suit];
    }
    public int getRankValue() {
        return this.rank + 1 ;      //this was the return rank + 1 due to the way values stores in index array
    }



    public String toString(){
        return getRank() + " of " + getSuit();
    }

}
