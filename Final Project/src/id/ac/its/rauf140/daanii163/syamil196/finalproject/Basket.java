package id.ac.its.rauf140.daanii163.syamil196.finalproject;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public class Basket extends Sprite {
    private int dx;
    private int MAX_X;

    public Basket(int x, int y) {
        super(x, y);

        initBasket();
    }

    private void initBasket() {
        
        loadImage("src/resources/basket.png");
        getImageDimensions();
        
        this.MAX_X = 400 - getWidth();

    }

    public void move() {

        x = dx - getWidth()/2;

        if (x < 1) {
            x = 1;
        }

        if (x > MAX_X) {
            x = MAX_X;
        }
        
    }
    
    public void mouseDragged(MouseEvent e) {
    	mouseMoved(e);
    }
    
    public void mouseMoved(MouseEvent e) {
    	dx = e.getX();
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

