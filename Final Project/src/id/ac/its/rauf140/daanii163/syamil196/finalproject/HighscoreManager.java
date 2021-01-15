package id.ac.its.rauf140.daanii163.syamil196.finalproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HighscoreManager {
    private ArrayList<Score> highscores;
    private String HIGHSCORE_FILE;
    private final int MAX = 5;

    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;

    public HighscoreManager(String fileName) {
        highscores = new ArrayList<Score>();
        HIGHSCORE_FILE = fileName;

        for (int i = 0; i < 5; i++) {
            highscores.add(new Score());
        }
    }

    public ArrayList<Score> getScores() {
        loadScoreFile();
        sort();
        return highscores;
    }

    private void sort() {
        Collections.sort(highscores, new Comparator<Score>() {
            public int compare(Score score1, Score score2) {

                int sc1 = score1.getScore();
                int sc2 = score2.getScore();

                if (sc1 > sc2) {
                    return -1;
                } else if (sc1 < sc2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }

    public boolean isHighscore(int score1) {
        for (int i = 0; i < MAX; i++) {
            int score2 = highscores.get(i).getScore();
            if (score1 > score2)
                return true;
        }

        return false;
    }

    public void addScore(String name, int score) {
        loadScoreFile();
        if (name == null)
            name = "Player";
        highscores.add(new Score(name, score));
        updateScoreFile();
    }

    public void loadScoreFile() {
        try {
            inputStream = new ObjectInputStream(new FileInputStream(HIGHSCORE_FILE));
            highscores = (ArrayList<Score>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("[Laad] FNF Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("[Laad] IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("[Laad] CNF Error: " + e.getMessage());
        } finally {
            try {
                if (inputStream  != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Laad] IO Error: " + e.getMessage());
            }
        }
    }

    public void updateScoreFile() {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(HIGHSCORE_FILE));
            outputStream.writeObject(highscores);
        } catch (FileNotFoundException e) {
            System.out.println("[Update] FNF Error: " + e.getMessage() + ",the program will try and make a new file");
        } catch (IOException e) {
            System.out.println("[Update] IO Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Update] Error: " + e.getMessage());
            }
        }
    }

    public String getHighscoreString() {
        String highscoreString = "";

        ArrayList<Score> scores;
        scores = getScores();

        int i = 0;
        int x = scores.size();
        if (x > MAX) {
            x = MAX;
        }
        while (i < x) {
            highscoreString += (i + 1) + ".\t" + scores.get(i).getName() + "\t" + scores.get(i).getScore() + "\n";
            i++;
        }
        return highscoreString;
    }
}
