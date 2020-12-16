package id.ac.its.rauf140.daanii163.syamil196.collisiondetection;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class SpaceShip extends Sprite {
    private int dx;
    private int dy;
    private List<Missile> missiles;

    public SpaceShip(int x, int y) {
        super(x, y);

        initCraft();
    }

    private void initCraft() {
        
        missiles = new ArrayList<>();
        loadImage("src/resources/craft.png");
        getImageDimensions();
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
    
    public void mouseMoved(MouseEvent e) {
    	dx = e.getX();
    	dy = e.getY();
    }

    public void fire() {
        missiles.add(new Missile(x + width, y + height / 2));
    }

}

