package id.ac.its.rauf140.daanii163.syamil196.finalproject;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public class Basket extends Sprite {
    private int dx;
    private int dy;
    private int MAX_X;
    private int MAX_Y;

    public Basket(int x, int y) {
        super(x, y);

        initBasket();
    }

    private void initBasket() {
        
        loadImage("src/resources/basket.png");
        getImageDimensions();
        
        this.MAX_X = 400 - getWidth();
        this.MAX_Y = 700 - getHeight();
    }

    public void move() {

        x = dx;
        y = dy;

        if (x < 1) {
            x = 1;
        }

        if (x > MAX_X) {
            x = MAX_X;
        }

        if (y < MAX_Y) {
            y = MAX_Y;
        }

        if (y > MAX_Y) {
            y = MAX_Y;
        }
        
    }
    
    public void mouseDragged(MouseEvent e) {
    	mouseMoved(e);
    }
    
    public void mouseMoved(MouseEvent e) {
    	dx = e.getX();
    	dy = e.getY();
    }

    public int checkCollisionWithCandy(Candy candy) {
        Rectangle b = this.getBounds();
        Rectangle c = candy.getBounds();

        if(b.intersects(c) && candy.isVisible()) {
            candy.setVisible(false);
            return candy.addToScore;
        }

        return 0;
    }
}

