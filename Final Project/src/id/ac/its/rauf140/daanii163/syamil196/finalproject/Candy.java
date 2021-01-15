package id.ac.its.rauf140.daanii163.syamil196.finalproject;

public abstract class Candy extends Sprite {
    protected int addToScore;

    public Candy(int x, int y) {
        super(x, y);

        initCandy();
    }

    @Override
    public void move() {
        y += 2;
    }

    protected abstract void initCandy(); 
}
