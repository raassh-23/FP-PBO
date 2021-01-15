package id.ac.its.rauf140.daanii163.syamil196.finalproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Level extends JPanel implements ActionListener {
    protected Timer timer;
    protected Basket basket;
    protected HighscoreManager hm;
    protected String playerName;
    protected Image bg;
    protected List<Candy> candies;
    protected boolean ingame;
    protected int candyCount;
    protected final int IBASKET_X = 200;
    protected final int IBASKET_Y = 663;
    protected final int DELAY = 15;
    protected final int LIVES_TOTAL = 5;
    protected int lives;
    protected int score;
    protected JButton backButton;

    private final int[] pos = {
    		650, 550, 450, 350, 250,
    		150, 50};
    
    public Level() {
        initBoard();
        
        backButton = new JButton("Back");
        add(backButton);
        backButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CandyCatch.cardLayout.show(CandyCatch.mainPanel, "title");
            }

        });

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(250,0,0,0);
        add(backButton, gbc);

        backButton.setVisible(false);

	}

    protected void initBoard() {

        addMouseListener(new TAdapter());
        addMouseMotionListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        playerName = "";
        ingame = true;
        candyCount = 0;
        score = 0;

        setPreferredSize(new Dimension(CandyCatch.WIDTH, CandyCatch.HEIGHT));

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
        
        int scoreY, scoreX, titleY, tabWidth = 10;
        String title = "You're A Failure";
        
        Font fontTitle = new Font("Helvetica", Font.BOLD, 36);
        FontMetrics fmTitle = getFontMetrics(fontTitle);
        Font fontScore = new Font("Helvetica", Font.BOLD, 18);
        FontMetrics fmScore = getFontMetrics(fontScore);
        
        g.setColor(Color.white);
        
        titleY = (CandyCatch.HEIGHT - fmTitle.getHeight() - 20 - 5 * fmScore.getHeight()) / 2;
        g.setFont(fontTitle);
        g.drawString(title, (CandyCatch.WIDTH - fmTitle.stringWidth(title)) / 2, titleY);
        
        scoreY = titleY + 20 + fmTitle.getHeight();
        g.setFont(fontScore);

        for (String line : hm.getHighscoreString().split("\n")) {
        	scoreX = (CandyCatch.WIDTH - fmScore.stringWidth(line) - 2 * tabWidth) / 2;
        	for (String word : line.split("\t")) {       		
        		g.drawString(word, scoreX, scoreY);
        		scoreX += tabWidth + fmScore.stringWidth(word);
        	}
        	scoreY += fmScore.getHeight();        	
    	}
        
        backButton.setVisible(true);
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

            if(hm.isHighscore(score)) {
                playerName = JOptionPane.showInputDialog("Enter name", "Player");
                hm.addScore(playerName, score);
            }
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
            
            if(c.getY() >= CandyCatch.HEIGHT) {
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

        if (candyCount % 5 == 0) return new Candy2(randX.nextInt(CandyCatch.WIDTH - 36), posY);
        else if (candyCount % 7 == 0) return new BadCandy(randX.nextInt(CandyCatch.WIDTH - 36), posY);
        else if (candyCount % 11 == 0) return new Candy3(randX.nextInt(CandyCatch.WIDTH - 36), posY);
        else return new Candy1(randX.nextInt(CandyCatch.WIDTH - 36), posY);      
    };


    public void checkCollisions() {
        for (Candy c : candies) {
            int scoreUpdate = basket.checkCollisionWithCandy(c);
            
            if (scoreUpdate == -1) lives--;
            else score += scoreUpdate;

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
