# Proyek Collision Detection

Proyek ini adalah sebuah proyek _game shooter_ dimana pemain mengendalikan **Space Ship** untuk menembak dan menghindari **Alien**. Tujuan utamanya adalah agar Space Ship pemain tidak menabrak Alien.

Oleh karena itu untuk mendeteksi tabrakan perlu adanya _**Collission Detection**_ atau deteksi benturan/tabrakan. 

Akan tetapi, sebelum itu perlu kita buat _class_ untuk meng-_handle_ objek yang diperlukan yaitu: 

1. Kelas `Sprite` sebagai _parent class_ untuk kelas `Alien`, `Missile`, dan `SpaceShip` yang berturut-turut adalah objek dari Alien, Misil, dan Pesawat pemain.
2. Kelas `Board` sebagai kanvas dari permainan.
3. Kelas `CollissionExe` sebagai _driver class_.

## **Kelas `Sprite`**

***

Kelas ini merupakan _parent class_ untuk objek _sprite_ alien, misil, dan pesawat pemain. Untuk itu, atribut yang diperlukan:
1. `x` dan `y` sebagai posisi _sprite_.
2. `width` dan `height` sebagai tinggi dan lebar dari _sprite_.
3. `visible` untuk mengatur visibilitas _sprite_.
4. `image` yang merupakan gambar dari _sprite_ (_asset_).


```java
public class Sprite {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected boolean visible;
    protected Image image;

    public Sprite(int x, int y) {

        this.x = x;
        this.y = y;
        visible = true;
    }

    protected void getImageDimensions() {

        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    protected void loadImage(String imageName) {

        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
```