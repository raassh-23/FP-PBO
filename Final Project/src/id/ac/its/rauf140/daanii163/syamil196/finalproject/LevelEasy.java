package id.ac.its.rauf140.daanii163.syamil196.finalproject;

import javax.swing.ImageIcon;

public class LevelEasy extends Level {

    public LevelEasy() {
        super();
    }

    @Override
    protected void initBoard() {
        super.initBoard();

        hm = new HighscoreManager("highscoreEasy.ser");
        bg = new ImageIcon("src/resources/bgEasy.png").getImage();
        lives = LIVES_TOTAL;
    }

    
    
}
