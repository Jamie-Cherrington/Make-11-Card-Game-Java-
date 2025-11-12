import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class HighScore {

    public static String[][]highScoreTable() throws Exception {
        File file = new File("src/highscores.txt");
        Scanner fileInput = new Scanner(file);
        String highScoreData;
        int marker1 = 0, marker2;
        String name, score;


        String[][] highscores = new String[5][2]; //holds only 5 names and the 2 ia for the score and name

        int index = 0;
        while (fileInput.hasNextLine()){
            highScoreData = fileInput.nextLine();
            marker2 = highScoreData.indexOf(",",marker1);
            name = highScoreData.substring(marker1,marker2);
            score = highScoreData.substring(marker2+1);


            highscores[index][0] = name;
            highscores[index][1] = score;

            index++;


        }
        fileInput.close();
        return highscores;

    }

    public static void printHighScoresTable() throws Exception {
        String[][] highscores = highScoreTable();
        System.out.println("High-scores: " + "\n");
        for (String[] highscore : highscores) {
            System.out.printf("%-10s %s\n", highscore[0], highscore[1]);

        }
    }


    public static void addNewScores(String[][] highscores , int NewScore) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("New high score! please input name >");
        String name = scanner.nextLine();

        int Score = NewScore;

        String[] newEntry = {name, String.valueOf(Score) };
        highscores[highscores.length - 1] = newEntry;

        //bubble sort
        for (int i = 0; i < highscores.length - 1; i++) {
            for (int j = 0; j < highscores.length - i - 1; j++) {
                int score1 = Integer.parseInt(highscores[j][1]);
                int score2 = Integer.parseInt(highscores[j + 1][1]);

                if (score1 < score2) {
                    String[] temp = highscores[j]; //creates a temp array and swaps positions of the high score
                    highscores[j] = highscores[j + 1];
                    highscores [j + 1] = temp;
                }

            }

        }

        FileWriter fileOut = new FileWriter("src/highscores.txt");
        for (int i = 0; i< highscores.length; i++) {
            fileOut.write(highscores[i][0] + "," + highscores[i][1] + "\n");
        } fileOut.close();

    }

    public static int retrieveHighestScore(String[][] highscores) {
        if (highscores.length == 0) {
            return 0;
        }
        int highestScore = Integer.parseInt(highscores[0][1]);

        for (int i = 1; i < highscores.length; i++) {
            int currentScore = Integer.parseInt(highscores[0][1]);

            if (currentScore > highestScore) {
                highestScore = currentScore;
            }

        }
        return highestScore;
    }
}
