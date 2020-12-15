# Proyek _Collision Detection_

Proyek ini adalah sebuah proyek _game shooter_ dimana pemain mengendalikan **Space Ship** untuk menembak dan menghindari **Alien**. Tujuan utamanya adalah agar Space Ship pemain tidak menabrak Alien.

Oleh karena itu untuk mendeteksi tabrakan perlu adanya _**Collission Detection**_ atau deteksi benturan/tabrakan. 

Akan tetapi, sebelum itu perlu kita buat _class_ untuk meng-_handle_ objek yang diperlukan yaitu: 

1. Kelas `Sprite` sebagai _parent class_ untuk kelas `Alien`, `Missile`, dan `SpaceShip` yang berturut-turut adalah objek dari Alien, Misil, dan Pesawat pemain.
2. Kelas `Board` sebagai kanvas dari permainan dan juga kelas yang menginisialisasi permainan.
3. Kelas `CollissionEx` sebagai _driver class_.

## **Kelas `Sprite`**

Kelas ini merupakan _parent class_ untuk objek _sprite_ alien, misil, dan pesawat pemain. Untuk itu, atribut yang diperlukan:
1. `x` dan `y` sebagai posisi _sprite_.
2. `width` dan `height` sebagai tinggi dan lebar dari _sprite_.
3. `visible` untuk mengatur visibilitas _sprite_.
4. `image` yang merupakan gambar dari _sprite_ (_asset_).

Dari atribut-atribut tersebut kemudian _method_ `getImageDimension` untuk mendapatkan tinggi dan lebar gambar sprite juga `loadImage` dan `getImage` untuk _load_ gambar dan mengembalikan gambar dari sprite.

_Method_ `getX`, `getY`, `isVisible`, dan `setVisible` berfungsi untuk mengembalikan posisi dan visibilitas _sprite_ serta mengatur visibilitas tersebut. Visibilitas sendiri digunakan untuk mengatur kondisi _sprite_ sudah ter-_destroy_ atau belum.

_Method_ `getBound` merupakan kunci dari _collission detection_. _Method_ ini mengembalikan tepian (_boundary_) berupa objek Rectangle yang mengelilingi sprite. 
```java
public Rectangle getBounds() {
    return new Rectangle(x, y, width, height);
}
```

## **Kelas `Alien`**

Kelas ini mewarisi kelas `Sprite`. Tambahan atributnya adalah `INITIAL_X` yang merupakan atribut final yaitu koordinat x awal yaitu `400` (lebar kanvas _game_). Sehingga sprite Alien akan muncul pertama dari tepi kanan kanvas.

_Method_ `initAlien` berfungsi me-_load_ gambar _sprite_ dan mengambil ukurannya dengan memanggil fungsi _parent class_. _Method_ ini dipanggil saat inisialisasi objek Alien.

```java
private void initAlien() {
    loadImage("src/resources/alien.png");
    getImageDimensions();
}
```
_Method_ `move` dipanggil untuk perubahan posisi Alien. Karena Alien bergerak terus ke kiri dari titik awal di tepi kanan kanvas, maka _method_ ini mengurangi variabel `x` hingga `x < 0` untuk kemudian dikembalikan ke posisi awal `INITIAL_X`.

```java
public void move() {
    if (x < 0) {
        x = INITIAL_X;
    }

    x -= 1;
}
```
## **Kelas `Missile`**

Atribut tambahan untuk kelas ini adalah `BOARD_WIDTH` yang merupakan batas lebar sebelum _sprite_ misil hilang. `BOARD_WIDTH` merupakan atribut final dengan nilai `390` sehingga misil akan hilang sebelum sampai di tepi kanvas.

Terdapat juga atribut `MISSILE_SPEED` yang merupakan representasi kecepatan misil yang sebenarnya adalah atribut final yang menentukan penambahan posisi misil.

_Method_ hampir sama dengan kelas `Alien` hanya pada _method_ `move` variabel `x` akan ditambah dengan `MISSILE_SPEED` dan koordinat `x` lebih dari `BOARD_WIDTH` _sprite_ misil akan hilang (`visible` di-_set_ 0).

```java
private void initMissile() {
    loadImage("src/resources/missile.png");
    getImageDimensions();        
}

public void move() {       
    x += MISSILE_SPEED;
        
    if (x > BOARD_WIDTH)
    visible = false;
}
```

## **Kelas `SpaceShip`**

Terdapat atribut `dx` dan `dy` sebagai perubahan posisi. Ada juga atribut list `missile` untuk menyimpan objek-objek `Missile` yang ditembakkan.

Terdapat _method_ `initCraft` yang mengambil gambar `sprite` dan inisialisasi `missile`. Sama dengan kelas objek _sprite_ lainnya, terdapat kelas `move` yang pertambahan perpindahannya adalah sesuai `dx` dan `dy`.

```java
public void move() {

    x += dx;
    y += dy;

    if (x < 1) {
        x = 1;
    }

    if (y < 1) {
        y = 1;
    }
}
```

_Method_ `fire` dipanggil saat pemain menembakkan misil. _Method_ ini menambahkan objek `Missile` pada list `missile` tadi. Kemudian ada juga _method_ `getMissile` untuk mengembalikan list `missile` tadi.

```java
public void fire() {
    missiles.add(new Missile(x + width, y + height / 2);
}
```

Objek `SpaceShip` merupakan objek yang akan dikontrol pemain sehingga perlu dilakukan deteksi terhadap _keyboard_ yang akan menjadi input pergerakan pesawat. Untuk itu kelas ini menggunakan kelas `java.awt.event.KeyEvent`.

Input yang digunakan adalah tombol Spasi untuk menembak dan tombol Arrow untuk kendali. _Method_ `keyPressed` mendeteksi tombol _keyboard_ yang ditekan pemain. Kemudian akan dijalankan perintah sesuai tombol yang ditekan:
1. `SPACE`: memanggil `fire` untuk menembak;
2. `UP`: _set_ `dy` menjadi `1`;
3. `DOWN`: _set_ `dy` menjadi `-1`;
4. `RIGHT`: _set_ `dx` menjadi `1`;
5. `LEFT`: _set_ `dx` menjadi `-1`;

```java
public void keyPressed(KeyEvent e) {

    int key = e.getKeyCode();

    if (key == KeyEvent.VK_SPACE) {
        fire();
    }

    if (key == KeyEvent.VK_LEFT) {
        dx = -1;
    }

    if (key == KeyEvent.VK_RIGHT) {
        dx = 1;
    }

    if (key == KeyEvent.VK_UP) {
        dy = -1;
    }

    if (key == KeyEvent.VK_DOWN) {
        dy = 1;
    }
}
```

Kemudian pada _method_ `keyReleased`, saat tombol tadi dilepas, `dx` dan `dy` akan kembali di-_set_ `0` sesuai tombol yang dilepas.

```java
public void keyReleased(KeyEvent e) {

    int key = e.getKeyCode();

    if (key == KeyEvent.VK_LEFT) {
        dx = 0;
    }

    if (key == KeyEvent.VK_RIGHT) {
        dx = 0;
    }

    if (key == KeyEvent.VK_UP) {
        dy = 0;
    }

    if (key == KeyEvent.VK_DOWN) {
        dy = 0;
    }
}
```
## **Kelas `Board`**
