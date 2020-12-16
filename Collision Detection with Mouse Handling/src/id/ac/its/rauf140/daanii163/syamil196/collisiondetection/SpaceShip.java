package id.ac.its.rauf140.daanii163.syamil196.collisiondetection;

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

        MAX_X = 400 - getWidth();
        MAX_Y = 300 - getHeight();
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

        if (x > MAX_X) {
            x = MAX_X;
        }
            
        if (y > MAX_Y){
            y = MAX_Y;
        }
    }

    public List<Missile> getMissiles() {
        return missiles;
    }

    public void fire() {
        missiles.add(new Missile(x + width, y + height / 2));
    }

    public void mouseMoved(MouseEvent e) {
    	dx = e.getX();
    	dy = e.getY();
    }
}

