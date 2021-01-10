package id.ac.its.rauf140.daanii163.syamil196.finalproject;

public class Candy1 extends Candy {

    public Candy1(int x, int y) {
        super(x, y);
    }

    @Override
    protected void initCandy() {
        loadImage("src/resources/candy1.png");
        getImageDimensions();

        this.MAX_Y = 300 - getHeight();

        addToScore = 5;
    }
    
}