import java.util.Scanner;

public class Make11 {
    public static void main(String[] args) throws Exception {


        HighScore.printHighScoresTable(); //calls the high score print table method
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();

        int round = 1, totalScore = 0;

        Card[] playerCards = new Card[5];
        deck.dealPlayerCards(playerCards);

        while (true) {

            if (deck.deckIsEmpty()) {
                System.out.println("Deck is empty game over!!");
                break;
            }

            Card computerCard = deck.deal();
            int computerCardValue = computerCard.getRankValue();
            System.out.println("\n"+"--------- "+"Round " + round + " ---------");
            System.out.println("Computer Deals : " + computerCard + "\n");

            deck.displayPlayerOptions(playerCards); //method used from the deck class


            System.out.print("Choose an option (A, B, C, D, E): ");
            String userChoices = scanner.next().toUpperCase();


            char userOption = userChoices.charAt(0);
            int playerCardValue;
            String playerCardString;
            switch (userOption) {
                case 'A':
                    playerCardValue = playerCards[0].getRankValue();
                    playerCardString = playerCards[0].toString();
                    break;
                case 'B':
                    playerCardValue = playerCards[1].getRankValue();
                    playerCardString = playerCards[1].toString();
                    break;
                case 'C':
                    playerCardValue = playerCards[2].getRankValue();
                    playerCardString = playerCards[2].toString();
                    break;
                case 'D':
                    playerCardValue = playerCards[3].getRankValue();
                    playerCardString = playerCards[3].toString();
                    break;
                case 'E':
                    playerCardValue = playerCards[4].getRankValue();
                    playerCardString = playerCards[4].toString();
                    break;
                default:
                    System.out.println("Invalid choice please choose from A-E ");
                    userOption = scanner.next().toUpperCase().charAt(0);

                    playerCardValue = playerCards[userOption - 'A'].getRankValue();
                    playerCardString = playerCards[userOption - 'A'].toString();

                    break;

            }

            if (playerCardValue > 10) playerCardValue = 10; // 10th value in array
            if (computerCardValue > 10) computerCardValue = 10; // same for computer card

            System.out.println("\n"+"You selected: " + playerCardString + ", Computer's card: " + computerCard);

            if (playerCardValue + computerCardValue == 11) {
                System.out.println("Sum is 11. You win!");

                totalScore++;
                System.out.println("\nTotal score is " + totalScore);


                //if the chosen card is a picture card
                if (userChoices.length() > 1) {
                    char userChoice2 = userChoices.charAt(1);

                    //a check to see if the user has chosen a picture card
                    if (playerCards[userChoice2 - 'A'].getRankValue() >= 11 && playerCards[userChoice2 - 'A'].getRankValue() <= 12) {
                        // Replace the picture card with a new one from the deck
                        playerCards[userChoice2 - 'A'] = deck.deal();
                        //round++;
                    } else {
                        System.out.println("The chosen card is not a picture card.");
                    }
                }
                round++;

                playerCards[userOption - 'A'] = deck.deal();
            } else if (playerCards[userOption - 'A'].getSuit() == computerCard.getSuit()) {
                System.out.println("Matching suits... continue ");
                round++;
                playerCards[userOption - 'A'] = deck.deal();
            } else {
                System.out.println("Game Over!");
                int highestScore = HighScore.retrieveHighestScore(HighScore.highScoreTable());

                if (totalScore > highestScore) {
                    HighScore.addNewScores(HighScore.highScoreTable(),totalScore);
                    HighScore.printHighScoresTable(); //so it shows changes made
                }
                break;
            }

        }System.out.println("\nTotal score is " + totalScore);



    }
}




