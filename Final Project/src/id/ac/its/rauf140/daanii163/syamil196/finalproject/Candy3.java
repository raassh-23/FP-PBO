package id.ac.its.rauf140.daanii163.syamil196.finalproject;

public class Candy3 extends Candy {

    public Candy3(int x, int y) {
        super(x, y);
    }

    @Override
    protected void initCandy() {
        loadImage("src/resources/candy3.png");
        getImageDimensions();

        this.MAX_Y = 700 - getHeight();

        addToScore = 7;
    }
    
}