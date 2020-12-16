package id.ac.its.rauf140.daanii163.syamil196.collisiondetection;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class SpaceShip extends Sprite {
    private int dx;
    private int dy;
    private int MAX_X;
    private int MAX_Y;
    private List<Missile> missiles;

    public SpaceShip(int x, int y) {
        super(x, y);

        initCraft();
    }

    private void initCraft() {
        
        missiles = new ArrayList<>();
        loadImage("src/resources/craft.png");
        getImageDimensions();
        
        this.MAX_X = 400 - getWidth();
        this.MAX_Y = 300 - getHeight();
    }

    public void move() {

        x = dx;
        y = dy;

        if (x < 1) {
            x = 1;
        }

        if (y < 1) {
            y = 1;
        }
    }

    public List<Missile> getMissiles() {
        return missiles;
    }

    public void mouseClicked(MouseEvent e) {
    	fire();
    	
    }
    
    public void mouseDragged(MouseEvent e) {
    	fire();
    	mouseMoved(e);
    }
    
    public void mouseMoved(MouseEvent e) {
    	if(e.getX() < MAX_X) dx = e.getX();
    	if(e.getY() < MAX_Y)dy = e.getY();
    }


    public void fire() {
        missiles.add(new Missile(x + width, y + height / 2));
    }

}

