package id.ac.its.rauf140.daanii163.syamil196.finalproject;

import java.util.Scanner;

public class HighscoresTest {
    public static void main(String[] args) {
        HighscoreManager hm = new HighscoreManager("highscoreTest.ser");

        Scanner scanner = new Scanner(System.in);

        System.out.print(hm.getHighscoreString());

        while (scanner.hasNextLine()) {
            String name = scanner.nextLine();
            int score = Integer.parseInt(scanner.nextLine());

            hm.addScore(name, score);
            System.out.print(hm.getHighscoreString());
        }
    }
}
