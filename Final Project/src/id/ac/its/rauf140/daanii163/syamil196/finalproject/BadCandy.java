package id.ac.its.rauf140.daanii163.syamil196.finalproject;

public class BadCandy extends Candy{
    public BadCandy(int x, int y) {
        super(x, y);
    }

    @Override
    protected void initCandy() {
        loadImage("src/resources/badcandy.png");
        getImageDimensions();

        addToScore = -1;
    }
}