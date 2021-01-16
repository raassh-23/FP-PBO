package id.ac.its.rauf140.daanii163.syamil196.finalproject;

import javax.swing.ImageIcon;

public class LevelHard extends Level {

    public LevelHard() {
        super();
        
    }
    
    @Override
    protected void initLevel() {
        super.initLevel();

        hm = new HighscoreManager("highscoreHard.ser");
        bg = new ImageIcon("src/resources/bgHard.png").getImage();
        lives = LIVES_TOTAL - 4;
    }
}
