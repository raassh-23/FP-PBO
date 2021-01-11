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
import javax.swing.Timer;

public class Level extends JPanel implements ActionListener {
    private Timer timer;
    private Basket basket;
    private Image bg;
    private List<Candy> candies;
    private boolean ingame;
    private int candyCount;
    private Random randX;
    private final int ICRAFT_X = 200;
    private final int ICRAFT_Y = 675;
    private final int B_WIDTH = 400;
    private final int B_HEIGHT = 700;
    private final int DELAY = 15;
    private int lives;
    private int score;

    private final int[] pos = {
    		0, 100, 200, 300, 400,
    		500, 600, 700};
    
    public Level() {
    	initBoard();
	}

    private void initBoard() {

        addMouseListener(new TAdapter());
        addMouseMotionListener(new TAdapter());
        setFocusable(true);
        bg = new ImageIcon("src/resources/lv_bg.png").getImage();
        ingame = true;
        candyCount = 4;
        score = 0;
        lives = 5;

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        basket = new Basket(ICRAFT_X, ICRAFT_Y);
        randX = new Random();

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
        
        g.drawImage(bg, 0, 0, this);
        
        if (ingame) {

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
        g.drawString("Score: " + score, 200, 15);
        g.drawString("Candy: " + candyCount, 5, 35);
    }

    private void drawGameOver(Graphics g) {

        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - fm.stringWidth(msg)) / 2,
                B_HEIGHT / 2);
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
            		candies.add(newCandy(0));
            		candies.remove(i);
            	}
        	}
        }
    }

    private Candy newCandy(int posY) {
    	candyCount++;
        if (candyCount % 5 == 0) return new Candy2(randX.nextInt(400), posY);
        else if (candyCount % 7 == 0) return new BadCandy(randX.nextInt(400), posY);
        else if (candyCount % 11 == 0) return new Candy3(randX.nextInt(400), posY);
        else return new Candy1(randX.nextInt(400), posY);      
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
