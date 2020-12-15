# Proyek _Collision Detection_

Proyek ini adalah sebuah proyek _game shooter_ dimana pemain mengendalikan **Space Ship** untuk menembak dan menghindari **Alien**. Tujuan utamanya adalah agar Space Ship pemain tidak menabrak Alien.

Oleh karena itu untuk mendeteksi tabrakan perlu adanya _**Collission Detection**_ atau deteksi benturan/tabrakan. 

Akan tetapi, sebelum itu perlu kita buat _class_ untuk meng-_handle_ objek yang diperlukan yaitu: 

1. Kelas `Sprite` sebagai _parent class_ untuk kelas `Alien`, `Missile`, dan `SpaceShip` yang berturut-turut adalah objek dari Alien, Misil, dan Pesawat pemain.
2. Kelas `Board` sebagai kanvas dari permainan dan juga kelas yang menginisialisasi permainan.
3. Kelas `CollissionEx` sebagai _driver class_.

![Diagram kelas dari kelas yang dibutuhkan](https://github.com/raassh-23/fp-pbo/blob/main/Collision%20Detection/Class%20Diagram%20Collision%20Detection.jpg)

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
Kelas ini adalah kelas utama yang akan dipanggil saat _game_ dijalankan. Sehingga, hampir semua instruksi dan logika agar _game_ berjalan sesuai keinginan ada di kelas ini.

Kelas ini memiliki atribut:
1. `spaceship` sebagai objek SpaceShip.
2. `aliens` berupa List untuk menampung objek objek Alien.
3. `ingame` berupa boolean untuk indikator masih dalam _game_ atau tidak.
4. `ICRAFT_X` dan `ICRAFT_Y` sebagai atribut konstan posisi awal `spaceship`.
5. `B_WIDTH` dan `B_HEIGHT` sebagai atribut konstan ukuran _board_.
6. `timer` dan `DELAY` untuk mengatur _update_ pada kondisi _game_.
7. `pos` yang merupakan daftar posisi awal dari Alien.
```java
private final int[][] pos = {
    {2380, 29}, {2500, 59}, {1380, 89},
    {780, 109}, {580, 139}, {680, 239},
    {790, 259}, {760, 50}, {790, 150},
    {980, 209}, {560, 45}, {510, 70},
    {930, 159}, {590, 80}, {530, 60},
    {940, 59}, {990, 30}, {920, 200},
    {900, 259}, {660, 50}, {540, 90},
    {810, 220}, {860, 20}, {740, 180},
    {820, 128}, {490, 170}, {700, 30}
};
```
Saat objek Board dibuat, akan dipanggil _method_ `initBoard` untuk mengatur `timer`, mengatur board (ukuran, _background_, dll.), menambahkan _keyListener_ untuk mendeteksi input _keyboard_, dan memanggil _method_ `initAlien`. `initAlien` mengisi `aliens` dengan objek-objek Alien dengan posisi yang ditentukan oleh `pos`.

```java
public void initAliens() {
        
    aliens = new ArrayList<>();

    for (int[] p : pos) {
        aliens.add(new Alien(p[0], p[1]));
    }
}
```
Kemudian pada _method_ `paintComponent` akan dicek kondisi `ingame`. Jika masih dalam permainan (`ingame` bernilai `true`) maka akan memanggil _method_ `drawObjects` untuk menggambar objek dalam _game_. Jika tidak (`ingame` bernilai `false`) akan dipanggil _method_ `drawGameOver` untuk menampilkan layar _game over_.
```java
@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);

    if (ingame) {
        drawObjects(g);

    } else {
        drawGameOver(g);
    }

    Toolkit.getDefaultToolkit().sync();
}
```
_Method_ `drawObjects` menggambar objek-objek dalam permainan. Dimulai dengan menggambar pesawat pemain (`spaceship`) dan misil yang ditembakkan (didapat dari `spaceship.getMissiles()`) dengan terlebih dahulu mengecek visibilitasnya.
```java
private void drawObjects(Graphics g) {

    if (spaceship.isVisible()) {
        g.drawImage(spaceship.getImage(), spaceship.getX(), spaceship.getY(),
            this);
    }
    
    List<Missile> ms = spaceship.getMissiles();

    for (Missile missile : ms) {
        if (missile.isVisible()) {
            g.drawImage(missile.getImage(), missile.getX(), 
                missile.getY(), this);
        }
    }
...
}   
```
Selanjutnya menggambar semua alien pada `aliens` dengan _looping_ dan juga mengecek apakah alien sudah ter-_destroy_ dengan cek visibilitas terlebih dahulu.
```java
private void drawObjects(Graphics g) {
...
    for (Alien alien : aliens) {
        if (alien.isVisible()) {
            g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
        }
    }
...
}   
```
Kemudian yang terakhir menggambar indikator jumlah alien tersisa di pojok kiri atas board.
```java
private void drawObjects(Graphics g) {

...
    g.setColor(Color.WHITE);
    g.drawString("Aliens left: " + aliens.size(), 5, 15);
}   
```
Selanjutnya _method_ `drawGameOver` menggambar layar _game over_ yaitu pesan "Game Over" di tengah board saat permainan selesai (tersissa 0 alien atau pesawat menabrak alien).
```java
private void drawGameOver(Graphics g) {

    String msg = "Game Over";
    Font small = new Font("Helvetica", Font.BOLD, 14);
    FontMetrics fm = getFontMetrics(small);

    g.setColor(Color.white);
    g.setFont(small);
    g.drawString(msg, (B_WIDTH - fm.stringWidth(msg)) / 2,
        B_HEIGHT / 2);
}
```
_Method_ `actionPerformed` menggunakan `ActionEvent` yang merepresentasikan siklus _update game_. Setiap siklus juga mengecek apakah masih dalam permainan atau tidak dengan memanggil _method_ `inGame`. Dalam setiap siklus juga, _sprite_ dalam game akan di-_update_ (posisi) dan dilakukan cek tabrakan dengan _method_ `checkCollission`. 
```java
@Override
public void actionPerformed(ActionEvent e) {

    inGame();

    updateShip();
    updateMissiles();
    updateAliens();

    checkCollisions();

    repaint();
}
```
_Method_ `inGame` akan menghentikan `timer` jika sudah tidak dalam _game_ (`ingame` bernilai `false`).
```java
private void inGame() {

    if (!ingame) {
        timer.stop();
    }
}
```
_Method_ `updateSpaceship` meng-_update_ posisi pesawat dengan _method_ `move` milik `spaceship`.
```java
private void updateShip() {

    if (spaceship.isVisible()) {            
        spaceship.move();
    }
}
```
_Method_ `updateMissile` meng-_update_ posisi _sprite_ misil dengan `move` atau men-_destroy_ (menghapus dari list misil yang didapat dari `getMissile`) saat `visible` dari misil tersebut bernilai `0`.
```java
private void updateMissiles() {

    List<Missile> ms = spaceship.getMissiles();

    for (int i = 0; i < ms.size(); i++) {

        Missile m = ms.get(i);

        if (m.isVisible()) {
            m.move();
        } else {
            ms.remove(i);
        }
    }
}
```
_Method_ `updateAliens` melakukan _update_ _sprite_ alien dengan syarat sama seperti pada `updateMissiles` dan juga mengatur `ingame` menjadi `false` (sudah tidak dalam permainan) saat sudah tidak ada alien tersisa (list `aliens` kosong).
```java
private void updateAliens() {

    if (aliens.isEmpty()) 
        
       ingame = false;
       return;
    }

    for (int i = 0; i < aliens.size(); i++) {

        Alien a = aliens.get(i);
        
        if (a.isVisible()) {
            a.move();
        } else {
            aliens.remove(i);
        }
    }
}
```
_Method_ `checkCollision` mengecek benturan antara Alien - Spaceship dan Missile - Alien dengan cara mengecek batas dari setiap _sprite_ berupa objek `Rectangle` yang didapat dari `getBound` masing-masing _sprite_ yang beririsan (menggunakan _method_ `intersects` yang dimiliki `Rectangle`). 

Jika _bound_ dari Alien dan Spaceship beririsan (pesawat menabrak alien), maka permainan akan berhenti (`ingame` diatur `false`) dan visibilitas keduanya diatur `false`. Jika _bound_ dari Missile dan Alien beririsan (misil mengenai alien), `visible` keduan objek bersangkutan akan diatur `false`.

```java
Public void checkCollisions() {

    Rectangle r3 = spaceship.getBounds();

    for (Alien alien : aliens) {
            
        Rectangle r2 = alien.getBounds();

        if (r3.intersects(r2)) {
                
            spaceship.setVisible(false);
            alien.setVisible(false);
            ingame = false;
        }
    }

    List<Missile> ms = spaceship.getMissiles();

    for (Missile m : ms) {

        Rectangle r1 = m.getBounds();

        for (Alien alien : aliens) {

            Rectangle r2 = alien.getBounds();

            if (r1.intersects(r2)) {
                    
                m.setVisible(false);
                alien.setVisible(false);
            }
        }
    } 
}
```

Terakhir adalah kelas ini memiliki kelas lain didalamnya yaitu `TAdapter` untuk mendeteksi input pemain.

## **Kelas `CollissionEx`**
Kelas ini adalah _driver class_ yang akan mengatur _frame_ program dan menambahkan objek _Board_ (yang akan memuulai permainan) saat program dijalankan.

### _Run_ Program
Saat program dijalankan akan tampak seperti gamber berikut ini.

![Tampilan program dengan latar belakang hitam dan objek-objek game (pesawat, misil, dan alien)](https://github.com/raassh-23/fp-pbo/blob/main/Collision%20Detection/Collision%20Detection.PNG)
