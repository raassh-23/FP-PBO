package id.ac.its.rauf140.daanii163.syamil196.finalproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Level extends JPanel implements ActionListener {
    private Timer timer;
    private Basket basket;
    private HighscoreManager hm;
    private Image bg;
    private List<Candy> candies;
    private boolean ingame;
    private int candyCount;
    private final int IBASKET_X = 200;
    private final int IBASKET_Y = 675;
    private final int B_WIDTH = 400;
    private final int B_HEIGHT = 700;
    private final int DELAY = 15;
    private final int LIVES_TOTAL = 5;
    private int lives;
    private int score;

    private final int[] pos = {
    		650, 550, 450, 350, 250,
    		150, 50};
    
    public Level() {
    	initBoard();
	}

    private void initBoard() {

        addMouseListener(new TAdapter());
        addMouseMotionListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        hm = new HighscoreManager("highscoreTest.ser");
        bg = new ImageIcon("src/resources/lv_bg.png").getImage();
        ingame = true;
        candyCount = 0;
        score = 0;
        lives = LIVES_TOTAL;

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        basket = new Basket(IBASKET_X, IBASKET_Y);

        initCandies();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void initCandies() {
        
        candies = new ArrayList<>();       

        for (int p : pos) {
            candies.add(newCandy(p - 700));
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (ingame) {
        	g.drawImage(bg, 0, 0, this);
            drawObjects(g);
        } else {      	
            drawGameOver(g);
        }

        Toolkit.getDefaultToolkit().sync();
    }

    private void drawObjects(Graphics g) {

        if (basket.isVisible()) {
            g.drawImage(basket.getImage(), basket.getX(), basket.getY(),
                    this);
        }

        for (Candy candy : candies) {
            if (candy.isVisible()) {
                g.drawImage(candy.getImage(), candy.getX(), candy.getY(), this);
            }
        }

        g.setColor(Color.BLACK);
        g.drawString("Lives: " + lives, 5, 15);
        g.drawString("Score: " + score, 5, 35);
    }

    private void drawGameOver(Graphics g) {
    	
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        int iScoreY = 400, iScoreX, tabWidth = 10;
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - fm.stringWidth(msg)) / 2,
                B_HEIGHT / 2);

        hm.addScore("Pemain", score);

        for (String line : hm.getHighscoreString().split("\n")) {
        	iScoreX = (B_WIDTH - fm.stringWidth(line) - 2 * tabWidth) / 2;
        	for (String word : line.split("\t")) {       		
        		g.drawString(word, iScoreX, iScoreY);
        		iScoreX += tabWidth + fm.stringWidth(word);
        	}
        	iScoreY += fm.getHeight();        	
    	}
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        inGame();

        updateBasket();
        updateCandies();

        checkCollisions();

        repaint();
    }

    private void inGame() {

        if (!ingame) {
            timer.stop();
        }
    }

    private void updateBasket() {

        if (basket.isVisible()) {
            
            basket.move();
        }
    }

    private void updateCandies() {

        for (int i = 0; i < candies.size(); i++) {

            Candy c = candies.get(i);
            
            if(c.getY() >= B_HEIGHT) {
            	candies.remove(i);
        		candies.add(newCandy(0));        		
        	} else {
        		if (c.isVisible()) {
            		c.move();
            	} else {
            		candies.add(newCandy(0 - basket.getHeight()));
            		candies.remove(i);
            	}
        	}
        }
    }

    private Candy newCandy(int posY) {
    	candyCount++;
    	Random randX = new Random();
        if (candyCount % 5 == 0) return new Candy2(randX.nextInt(B_WIDTH), posY);
        else if (candyCount % 7 == 0) return new BadCandy(randX.nextInt(B_WIDTH), posY);
        else if (candyCount % 11 == 0) return new Candy3(randX.nextInt(B_WIDTH), posY);
        else return new Candy1(randX.nextInt(B_WIDTH), posY);      
    };


    public void checkCollisions() {
        for (Candy c : candies) {
            int scoreUpdate = basket.checkCollisionWithCandy(c);
            score += scoreUpdate;
            
            if (scoreUpdate == -1) lives--;
            if (lives <= 0) {
                ingame = false;
                break;
            }
        }
    }

    private class TAdapter extends MouseAdapter {

    	@Override
        public void mouseMoved(MouseEvent e) {
            basket.mouseMoved(e);
        }
        
        @Override
        public void mouseDragged(MouseEvent e) {
            basket.mouseDragged(e);
        }
    }
}
