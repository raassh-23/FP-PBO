package id.ac.its.rauf140.daanii163.syamil196.finalproject;

import javax.swing.ImageIcon;

public class LevelNormal extends Level {

    public LevelNormal() {
        super();
    
    }

    @Override
    protected void initLevel() {
        super.initLevel();

        hm = new HighscoreManager("highscoreNormal.ser");
        bg = new ImageIcon("src/resources/bgNormal.png").getImage();
        lives = LIVES_TOTAL - 2;
    }
    
}
