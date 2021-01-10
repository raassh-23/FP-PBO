package id.ac.its.rauf140.daanii163.syamil196.finalproject;

public abstract class Candy extends Sprite {
    protected final int INITIAL_Y = 0;
    protected int MAX_Y;
    protected int addToScore;

    public Candy(int x, int y) {
        super(x, y);

        initCandy();
    }

    @Override
    public void move() {

        if (y > MAX_Y) {
            y = INITIAL_Y;
        }

        y += 1;
    }

    protected abstract void initCandy(); 
}
