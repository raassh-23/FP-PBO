# Final Project PBO - Game Candy Catch

## **Tentang Game**

### **Deskripsi**
Game ini merupakan game casual dengan tugas utama pemain adalah untuk menangkap semua permen yang jatuh untuk meraih skor setinggi-tingginya. Pemain juga harus menghindari permen yang beracun. Jika pemain menangkap permen beracun maka nyawa akan berkurang. Jika nyawa sudah habis, maka pemain akan dinyatakan kalah.

### **Variasi Level**
Dalam setiap level, pemain akan dihadapkan dengan batasan waktu tertentu. Pemain dinyatakan menang jika berhasil menangkap permen sesuai target tiap level. Pemain dinyatakan kalah jika nyawa habis. Terdapat 3 variasi level pada game Candy Catch ini, yaitu:
1. __Easy__ , pada level ini player memiliki total 5 nyawa yang dapat digunakan dalam menyelesaikan level ini.
2. __Normal__ , nyawa yang dimiliki oleh player pada level ini yaitu sebanyak 3 nyawa yang dapat digunakan dalam menyelesaikan level ini.
3. __Hard__ , pada level ini player hanya memiliki 1 nyawa yang dapat digunakan dalam menyelesaikan level ini.

### **Variasi Permen**
Permen yang dijatuhkan akan bervariasi. Variasi permen akan menentukan variasi skor yang akan didapat pemain jika menangkapnya. Terdapat 4 variasi permen yang dimana akan memberikan perolehan skor yang berbeda-beda, yaitu:	
1. __Candy 1__ , player akan memperoleh skor sebesar 5 poin jika dapat menangkap permen ini.

   ![Candy1](src/resources/candy1.png)

2. __Candy 2__ , permen ini akan memberikan poin yang paling besar yaitu sebesar 15 poin jika player berhasil mendapatkan permen ini.

   ![Candy2](src/resources/candy2.png)
   
3. __Candy 3__ , jika player berhasil menangkap permen ini maka player tersebut akan memperoleh skor
sebesar 7 poin.

   ![Candy3](src/resources/candy3.png)
   
4. __Bad Candy__ , jika player menangkap permen ini, maka player akan mengalami penurunan skor sebesar 1 poin.

   ![BadCandy](src/resources/badcandy.png)	

### **Skor**
Setiap akhir level pemain dapat melihat highscore sehingga pemain bisa mengalahkan rekor skornya sendiri dengan memulai ulang level.

## **Penjelasan Kelas**
![Class Diagram Final Project](Class Diagram Final Project.png)

### **Kelas `Sprite`**
kelas ini adalah modifikasi pada kelas `sprite` pada referensi **1**. kelasi ini memiliki 6 atribut yaitu berupa:
- `x` , yang bertipe `int`
- `y` , yang bertipa `int`
- `width` , yang bertipe `int`
- `heigth`, yang bertipe `int`
- `visible` , yang bertipe `boolean`
- `image`, yang meropaka objek dari `Image`

_Method_  `sprite` merupakan  _public class_  yang berparameter `x` dan `y` pada metode ini nilai `this.x` akan diatur menjadi x, kemudian nilai `this.y` akan diatur menjadi `y` , dan visible akan diubah nilainya menjadi `true`.

```java
public Sprite(int x, int y) {
   this.x = x;
   this.y = y;
   visible = true;
}
```

_Method_  `getImageDimensions` merupakan  _protected void_  yang berfungsi untuk mengatur ukuran gambar ketika fungsi ini dipanggil.

```java
protected void getImageDimensions() {

   width = image.getWidth(null);
   height = image.getHeight(null);
}
````

_Method_  `loadImage` adalah metode yang berfungsi agar menampilkan gambar ketika fugsi ini dipanggil. metode ini berparameter `imageName` yang bertipe data String.

```java
protected void loadImage(String imageName) {

   ImageIcon ii = new ImageIcon(imageName);
   image = ii.getImage();
}
```

_Method_  `getImage` merupakan kelas  _public_  yang mewarisi objek `Image` dan akan mengembalikan `image` ketika _method_ ini dipanggil.

```java
public Image getImage() {
   return image;
}
```

_Method_  `getWidth` merupakan kelas  _public_  yang bertipe data `int` dan akan mengembalikan `width` ketika _method_ ini dipanggil.

``` java
public int getWidth() {
   return width;
}
```

_Method_  `getHeight` merupakan kelas  _public_  yang bertipe data `int` dan akan mengembalikan `height` ketika _method_ ini dipanggil.

```java
public int getHeight() {
   return height;
}
```

_Method_  `getX` merupakan kelas  _public_  yang bertipe data `int` dan akan mengembalikan `x` ketika _method_ ini dipanggil.

```java
public int getX() {
   return x;
}
```

_Method_  `getY` merupakan kelas  _public_  yang bertipe data `int` dan akan mengembalikan `y` ketika _method_ ini dipanggil.

``` java
public int getY() {
   return y;
}
````

_Method_  `isVisible` merupakan kelas  _public_  yang bertipe data `boolean` dan akan mengembalikan `visible` ketika _method_ ini dipanggil.

``` java
public boolean isVisible() {
   return visible;
}
```
_Method_  `setVisible` merupakan kelas  _public_  yang bertipe data `void` dan berparameter `visible` yang bertipe data `Boolean` . metode ini akan mengatur `this.visible` menjadi `visible` ketika metode ini dipanggil.

```java
public void setVisible(Boolean visible) {
   this.visible = visible;
}
```
_Method_  `getBounds` merupakan  _public class_  yang mewarisi objek `Rectangle`. metode ini akan mengembalkan objek `Rectangle`yang berparameter `x`, `y`, `width`, `height`.

``` java
public Rectangle getBounds() {
   return new Rectangle(x, y, width, height);
}
```

_Method_  `move` ini merupakan  _public abstract class_  yang bertipe data `void`, kelas ini tidak mengembelikan nilai apapun namun dijadikan sebagai metode yang berfungsi ketika kita akan melakukan _mouseHandlingEvent_ .

```java
public abstract void move();
```

### **Kelas `Basket`**
Kelas `Basket` merupakan kelas turunan daripada kelas `sprite`yang digunakan untuk menangkap permen ketika program dijalankan. 

kelas ini memiliki dua atribut bertipe `private` yaitu `dx` dan `MAX_X` yang digunakan sebagai menyimpan titik koordinat ketika keranang digerakan.

_method_  `initBasket`  adalah  _Private method_  yang memanggil  `lodImage` dan`getImageDimensions` untuk menampilkan gambar pada object `basket` ketika program dijalankan.

```
    private void initBasket() {
        
        loadImage("src/resources/basket.png");
        getImageDimensions();
        
        this.MAX_X = 400 - getWidth();
    }   
```

`move` merupakan  _public class_  yang akan mengatur pergerakan Basket ketika program dijalankan. pada kelas ini nilai `x` akan dihitung dengan `dx` yang dikurangi dengan `getWidth` dan dibagi 2, kemudian jika nilai `x` lebih kecil daripada 1 maka `x` akan diatur 1, dan jika `x` lebih besar daripada `MAX_X` maka nilai `x` akan diatur sama dengan `MAX_X` .

```
    public void move() {

        x = dx - getWidth()/2;

        if (x < 1) {
            x = 1;
        }

        if (x > MAX_X) {
            x = MAX_X;
        }   
```

`mouseDragged` merupakan _public class_ beripe `void` yang berparameter `MouseEvent e` , terjadi ketika pengguna menekan tombol mouse dan menggerakannya, kelas ini akan memanggil _method_ `mouseMoved` agar dapat memberikan koordinat dimana mouse berada.

```
    public void mouseDragged(MouseEvent e) {
    	mouseMoved(e);
    }
```

`mouseMoved` adalah _public class_ yang berparameter bertipe `void` `MouseEvent e` , terjadi ketika pengguna menggerakan mouse, dan pada kelas ini nilai `dx` akan diatur sama dengan `e.getX()` yang berfungsi sebagai titik koordinat ketika program dijalankan.

```
    public void mouseMoved(MouseEvent e) {
    	dx = e.getX();
    }
```

`checkCollisionWithCandy` merupakan _public class_ bertipe `void` dan berparameter `Candy candy` yang memiliki dua atribut berupa `b` dan `c` yang digunakan untuk mengembalikan nilai yang kemudian akan ditambahkan ke dalam skor.

```
    public int checkCollisionWithCandy(Candy candy) {
        Rectangle b = this.getBounds();
        Rectangle c = candy.getBounds();

        if(b.intersects(c) && candy.isVisible()) {
            candy.setVisible(false);
            return candy.addToScore;
        }

        return 0;
    }
}
````


### **Kelas `Candy`**
Kelas `Candy` merupakan kelas _abstract_ yang diturnkan dari `Sprite` dan menjadi _parent class_ untuk kelas `Candy1`, `Candy2`, `Candy3`, `BadCandy`.

Kelas ini hanya mempunyai atribut bertipe `int` dan bernama `addToScore` yang akan digunakan untuk menyimpan pertambahan _score_ apabila berhasil ditangkap. Kelas ini hanya memiliki 3 _method_, yaitu `Candy`, `initCandy`, dan `move`. 

`initCandy` adalah _abstract method_ yang akan didefinisikan di kelas turunannya. _Method_ ini akan dipanggil oleh _constructor_ untuk melakukan _load resource_ dan juga menginisialisasi atribut lainnya.

`move` adalah _method_ yang diwarisi dari kelas `Sprite` dan merupakan hasil modifikasi dari _method_ yang ada di kelas `Missile` pada referensi **1**. Perbedaannya adalah atribut yang diubah adalah nilai `y`.

```java
@Override
public void move() {
   y += 2;
}
```

### **Kelas `Candy1`**
Kelas `Candy1` merupakan salah satu kelas yang diturunkan dari kelas `Candy`. Di kelas ini, _method_ `initCandy` didefinisikan untuk melakukan _load_ gambar dan menginisialisasi `addToScore` menjadi `5`.

```java
@Override
protected void initCandy() {
   loadImage("src/resources/candy1.png");
   getImageDimensions();

   addToScore = 5;
}
```

### **Kelas `Candy2`**
Kelas `Candy2` juga merupakan salah satu kelas yang diturunkan dari kelas `Candy`. Mirip seperti `Candy1`, kelas ini juga mendefinisikan `initCandy`. Bedanya, nilai inisialisasi dari `addToScore` adalah `15`.

### **Kelas `Candy3`**
Kelas `Candy3` merupakan salah satu kelas lain yang diturunkan dari kelas `Candy`. Juga mirip seperti `Candy1` dam `Candy2`, hal yang berbeda adalah nilai inisialisasi dari `addToScore` yaitu `7`.

### **Kelas `BadCandy`**
Kelas `BadCandy` adalah kelas turunan terakhir dari kelas `Candy`. Sama seperti sebelumnya, disini `addToScore` diinisialisi menjadi `-1`.

### **Kelas `Score`**
Kelas `Score` merupakan kelas yang mengimplementasi `Serializable` dan digunakan untuk menyimpan _score_ pemain. Karena itu, kelas ini mempunyai 2 atribut, yaitu `name` yang bertipe `String` dan `score` yang bertipe `int`

Kelas ini mempunyai 2 _constructor_, yaitu _constructor_ tanpa parameter yang menginisialisasi `name` dan `score` ke nilai _default_, dan _constructor_ dengan 2 parameter yang menginisialisasi atribut sesuai dengan argumennya. Selain itu, kelas ini juga mempunyai _method getter_ `getName` dan `getScore` untuk mendapatkan nilai `name` dan `score`.

### **Kelas `HighscoreManager`**
Kelas `HighscoreManager` adalah kelas yang digunakan untuk mengatur dan menyimpan  _highscore_ . Kelas ini merupakan modifikasi dari referensi **3**. Kelas ini mempunyai atribut `highscores` bertipe `ArrayList` yang digunakan untuk menyimpan  _highscore_  selama program berjalan, `HIGHSCORE_FILE` bertipe `String` yang digunakan untuk menyimpan nama dari _file serializable_ , dan `MAX` bertipe `int` untuk menyimpan jumlah highscore yang perlu disimpan.

Perbedaan pertama dari referensi **3**, _constructor_ dari kelas ini mempunyai 1 parameter untuk mengatur `HIGHSCORE_FILE` sehingga bisa digunakan untuk membuat 3  _file serializable_  sesuai dengan jumlah _level_. Disini, atribut `highscores` juga diinsialisasi dengan `Score` yang bernilai _default_.

_method_  `loadScoreFile` digunakan untuk membuka dan melakukan `deserialize` data yang disimpan di _file_ lalu akan disimpan ke `highscores`.

```java
try {
   inputStream = new ObjectInputStream(new FileInputStream(HIGHSCORE_FILE));
   highscores = (ArrayList<Score>) inputStream.readObject();
}
```

Kemudian jika sudah selesai,  _object_  `inputStream` akan ditutup untuk mencegah  _memory leak_

```java
try {
   if (inputStream  != null) {
      inputStream.flush();
      inputStream.close();
   }
}
```

Dalam proses-proses diatas, bila terjadi _exception_ maka pesan dari _exception_ tersebut akan di  _print_  dan proses tadi dihentikan agar program tidak _crash_ .

_Method_  `updateScoreFile` digunakan untuk melakukan _serialize_ pada `highscores` dan menyimpannya dalam bentuk _file_.

```java
try {
   outputStream = new ObjectOutputStream(new FileOutputStream(HIGHSCORE_FILE));
   outputStream.writeObject(highscores);
}
```

Sama seperti `loadScoreFile` , pada akhir proses  _serialization_  `outputStream` akan ditutup. Dan apabila ada  _exception_  maka akan di- _print_  dan proses sebelumnnya dihentikan.n.

_Method_  `sort` digunakan untuk mengurutkan nilai `highscores` dan nanti akan digunakan dalam _method_ lain. Di _method_ ini ada perbedaan dari referensi **3**, yaitu  _method_  `sort` disini menggunakan _anonymous class_ untuk objek `Comparator`-nya.

```java
private void sort() {
  Collections.sort(highscores, new Comparator<Score>() {
      public int compare(Score score1, Score score2) {
          int sc1 = score1.getScore();
          int sc2 = score2.getScore()
          if (sc1 > sc2) {
              return -1;
          } else if (sc1 < sc2) {
              return 1;
          } else {
              return 0;
          }
      }
  });
}
```

_Method_  `getScores` digunakan untuk mendapatkan nilai `highscores`. _Method_ ini akan memanggil `loadScoreFile` untuk mendapatkan nilai `highscores` dari _file_ dan diurut dengan menggunakan `sort `.

_Method_  `isHighscore` digunakan untuk mengecek apa _score_ yang menjadi argumennya merupakan _highscore_ .  _Method_  ini juga merupakan salah satu perbedaan kelas `HighscoreManager` di referensi *3*. Di  _method_  ini nilai  _score_  argumen akan dibandingkan dengan `MAX` buah  _highscore_  tertinggi, dalam kasus ini `5`  _highscore_  tertinggi, dan akan mengembalikan nilai `True` apabila lebih tinggi dari _highscore_ yang ada.

```java
public boolean isHighscore(int score1) {
   for (int i = 0; i < MAX; i++) {
      int score2 = highscores.get(i).getScore();
      if (score1 > score2)
         return true;
   }

   return false;
}
```

_Method_  `addScore` digunakan untuk menambahkan _highscore_ baru ke `highscores`. _Method_ ini juga memanggil `loadScoreFile` untuk mendapatkan nilai `highscores` sebelum menambahkan _highscore_ baru. Nama dari objek `Score` yang menjadi argumen juga diperiksa agar tidak `null` dan _highscore_ ditambah ke `highscores`. Kemudian  _file_  di- _update_ dengan memanggil `updateScoreFile`.

_Method_  `getHighscoreString` digunakan untuk mengembalikan `String` yang berisi `MAX` buah _highscore_  tertinggi.  _Method_  ini akan memanggil `getScores` untuk mendapatkan nilai-nilai  _highscore_  dan meng  _append_  `name` dan `score` ke sebuah `String`  dengan menggunakan _looping_ .

```java
public String getHighscoreString() {
   String highscoreString = "";

   ArrayList<Score> scores;
   scores = getScores();

   int i = 0;
   int x = scores.size();
   if (x > MAX) {
       x = MAX;
   }
   while (i < x) {
      highscoreString += (i + 1) + ".\t" + scores.get(i).getName() + "\t" + scores.get(i).getScore() + "\n";
      i++;
   }
   return highscoreString;
}
```

### **Kelas `Level`**
Kelas ini adalah modifikasi dari kelas `Board` pada referensi **1**. Kelas ini merupakan kelas dimana permainan akan dijalankan.

Kelas ini mewarisi `JPanel`. Pada kelas ini terdapat beberapa atribut yaitu:
1. `timer` yang merupakan objek `Timer` untuk memperbarui kondisi permainan setiap waktu.
2. `basket` yang merupakan objek `Basket` sebagai keranjang yang dikendalikan pemain untuk menangkap permen.
3. `hm` yang merupakan objek `HighscoreManager` yang mengatur sistem skor.
4. `playerName` yang merupakan nama pemain yang perlu diinput pada akhir permainan.
5. `bg` yang merupakan `Image` sebagai _background_ dari level.
6. `candies` yang merupakan `List<Candy>` sebagai _collection_ dari permen-permen dalam permainan.
7. `ingame` sebagai indikator masih dalam permainan atau tidak.
8. `backButton` yang merupakan tombol kembali pada akhir permainan.
9. `pos` yang merupakan posisi-posisi permen-permen awal.
10. `candyCount` untuk menghitung berapa banyak permen yang telah dibuat.
11. `score` untuk mencatat skor.
12. `lives` untuk mencatat sisa nyawa.

Terdapat beberapa atribut `final` yaitu `IBASKET_Y`, `IBASKET_X`, `DELAY`, dan `LIVES_TOTAL` yang masing-masingg merupakan posisi awal dari `basket`, _delay_ pada `timer`, dan total nyawa pada level.

Saat kelas dibuat, _constructor_ akan memanggil _method_ `initLevel` serta menginisialisasi `backButton` dan mengatur visibilitasnya menjadi `false` karena akan ditampilkan pada layar _game over_ saja.

```java
public Level() {
   initLevel();
   
   backButton = new JButton("Back");
   add(backButton);
   backButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
         CandyCatch.cardLayout.show(CandyCatchminPanel, "title");
      }
   });

   setLayout(new GridBagLayout());
   GridBagConstraints gbc = new GridBagConstraints();
   gbc.insets = new Insets(250,0,0,0);
   add(backButton, gbc);

   backButton.setVisible(false);
}
```

_Method_ `initLevel` menambahkan `MouseMotionListener` dan `MouseListener` karena pemain akan mengendalikan keranjang dengan _mouse_. Lalu, _method_ ini menginisialisasi `timer`, `playerName`, `ingame`, `candyCount`, dan`score`. Permen-permen awal juga diinisialisasi dengan memanggil _method_ `initCandies`. Terakhir adalah _setting_ panel.

```java
protected void initLevel() {

   addMouseListener(new TAdapter());
   addMouseMotionListener(new TAdapter());
   setFocusable(true);
   setBackground(Color.BLACK);
   playerName = "";
   ingame = true;
   candyCount = 0;
   score = 0;

   setPreferredSize(new Dimension(CandyCatch.WIDTH CandyCatch.HEIGHT));

   basket = new Basket(IBASKET_X, IBASKET_Y);

   initCandies();

   timer = new Timer(DELAY, this);
   timer.start();
}
```

_Method_ `initCandies` menginisialisasi permen-permen pada `candies` dengan memanggil _method_ `newCandy` yang mengatur `Candy` jenis apa yang harus dibuat dengan posisi-posisi yang ada pada `pos`.

```java
public void initCandies() {
        
   candies = new ArrayList<>();       
   for (int p : pos) {
      candies.add(newCandy(p - 700));
   }
}
```

_Method_ `paintComponent` akan menggambar objek-objek dalam permainan. _Method_ ini mengecek kondisi `ingame`. Jika masih dalam permainan (`ingame` = `true`) akan digambar _background_ level dan memanggil _method_ `drawObjects` untk menggambar objek-objek permainan. Jika sudah tidak dalam permainan atau kalah (`ingame` = `false`) maka dipanggil _method_ `drawGameOver` untuk menggambar layar _game over_.

_Method_ `drawObjects` menggambar `basket` dan semua permen dalam `candies` jika masih _visible_. Lalu digambar juga dua String untuk menunjukkan skor dan sisa nyawa.

```java
private void drawObjects(Graphics g) {

   if (basket.isVisible()) {
      g.drawImage(basket.getImage(), basket.getX(), baskegetY()this);
    
   for (Candy candy : candies) {
      if (candy.isVisible()) {
         g.drawImage(candy.getImage(), candy.getX()candy.getY(), this);
      }
   }
   
   Font font = new Font("Helvetica", Font.BOLD, 12);
   g.setFont(font);
   g.setColor(Color.BLACK);
   g.drawString("Lives: " + lives, 5, 15);
   g.drawString("Score: " + score, 5, 35);
}
```

_Method_ `drawGameOver` menggambar String judul dengan tulisan "Game Over" dan skor tertinggi yang didapat menggunakan HighscoreManager `hm`. Untuk menggambar skor tertinggi, dipanggil _method_ `getHighscoreString` pada `hm`. Lalu, dipisahkan berdasarkan karakter _newline_ (\n) dan karakter tab (\t) karena _method_ `drawString` tidak bisa menggambarkan karakter tersebut. Setelah dipisahkan, tiap kata pada tiap baris skor digambar satu-persatu. Terakhir `backButton` ditampilkan (_set_ `visible` menjadi `true`).

```java
private void drawGameOver(Graphics g) {   	
        
   int scoreY, scoreX, titleY, tabWidth = 10;
   String title = "Game Over";
   
   Font fontTitle = new Font("Helvetica", Font.BOLD, 36);
   FontMetrics fmTitle = getFontMetrics(fontTitle);
   Font fontScore = new Font("Helvetica", Font.BOLD, 18);
   FontMetrics fmScore = getFontMetrics(fontScore);
   
   g.setColor(Color.white);
   
   titleY = (CandyCatch.HEIGHT - fmTitle.getHeight() - 20-5 *fmScore.getHeight()) / 2;
   g.setFont(fontTitle);
   g.drawString(title, (CandyCatch.WIDTH -fmTitlestringWidt(title)) / 2, titleY);
   
   scoreY = titleY + 20 + fmTitle.getHeight();
   g.setFont(fontScore);

   for (String line : hm.getHighscoreString().split("\n")){
      scoreX = (CandyCatch.WIDTH - fmScore.stringWidth(line- 2 *tabWidth) / 2;     
      for (String word : line.split("\t")) {       		
   		g.drawString(word, scoreX, scoreY);
   		scoreX += tabWidth + fmScore.stringWidth(word);
      }     
   	scoreY += fmScore.getHeight();        	
   }
   
   backButton.setVisible(true);
}
```

_Method_ `actionPerformed` dipanggil tiap waktu sesuai `timer`. _Method_ ini memanggil _method_ `inGame`, `updateBasket`, `updateCandies`, `checkCollisions`, dan `repaint`. _Method_ ini memperbarui kondisi permainan.

_Method_ `inGame` mengecek kondisi `ingame` apakah masih berada dalam permainan atau tidak. Jika tidak, `timer` akan diberhentikan dan memunculkan Option Pane untuk mengambil input nama pemain untuk dicatat pada _highscore_.

```java
private void inGame() {

   if (!ingame) {
      timer.stop()

      if(hm.isHighscore(score)) {
         playerName = JOptionPane.showInputDialo("Entename""Player");
         hm.addScore(playerName, score);
      }
   }
}
```

_Method_ `updateBasket` akan memanggil _method_ `move` pada `basket` untuk menggerakkan keranjang.

``` java
private void updateBasket() {
   if (basket.isVisible()) basket.move();       
}
```

_Method_ `updateCandies` akan mengecek setiap objek `Candy` dalam `candies`. Jika posisi permen sudah melewati batas layar bawah, `Candy` tersebut akan dihapus dari `candies` dan dibuat `Candy` baru dengan memanggil _method_ `newCandy` dengan posisi Y yaitu 0. Jika tidak, akan dicek kembali apakah permen tersebut _visible_ atau tidak. Jika iya, permen akan digerakkan dengan _method_ `move` pada `Candy`. Jika tidak, `Candy` tersebut juga akan dihapus dari `candies` dan dibuat `Candy` baru dengan posisi Y yaitu 0 - tinggi `basket`.

```java
private void updateCandies() {

   for (int i = 0; i < candies.size(); i++) {

      Candy c = candies.get(i);
            
      if(c.getY() >= CandyCatch.HEIGHT) {
         candies.remove(i);
         candies.add(newCandy(0));        		
      } else {
         if (c.isVisible()) c.move();
         else {
            candies.add(newCandy(0 - basket.getHeight()));
            candies.remove(i);
         }
      }
   }
}
```

_Method_ `newCandy` mengembalikan objek salah satu objek `Candy` yang ditentukan dengan melihat `candyCount`. Jika `candyCount` merupakan kelipatan 5 akan dikembalikan `Candy2`, `BadCandy` jika kelipatan 7, `Candy3` jika kelipatan 11, dan selain itu mengembalikan `Candy1`. `Candy` yang dibuat dengan posisi X _random_ dan posisi Y dari argumen.

```java
private Candy newCandy(int posY) {

   candyCount++;
   
   Random rand = new Random();
   int posX = rand.nextInt(CandyCatch.WIDTH - 36)

   if (candyCount % 5 == 0) return new Candy2(posX, posY);
   else if (candyCount % 7 == 0) return new BadCan(posX, posY;
   else if (candyCount % 11 == 0) return new Candy3(posX, posY);
   else return new Candy1(posX, posY);      
}
```

_Method_ `checkCollisions` mengecek tabrakan setiap `Candy` dalam `candies` dengan `basket` dengan memanggil _method_ `checkCollisionWithCandy` pada `basket` untuk setiap permen. _Method_ tersebut akan mengembalikan nilai `addToScore` yang digunakan untuk meng-_update_ `score`. Jika `scoreUpdate` sama dengan -1 (bertabrakan dengan `BadCandy`), `lives` akan di-_decrement_. Terakhir adalah mengececk `lives`. Jika `lives` kurang dari sama dengan 0, maka `ingame` akan di-_set_ menjadi `false`.

```java
public void checkCollisions() {

   for (Candy c : candies) {
      int scoreUpdate = basket.checkCollisionWithCandy(c);
            
      if (scoreUpdate == -1) lives--;
      else score += scoreUpdate;

      if (lives <= 0) {
         ingame = false;
         break;
      }
   }
}
```

Terdapat juga _inner class_ `TAdapter` yang mewarisi `MouseAdapter` yang menjadi _event listener_ untuk _mouse_ dengan meng-_override_ _method_ `mouseMoved` dan `mouseDragged` dengan memanggil _method_ sama di `basket`.

### **Kelas `LevelEasy`, `LevelNormal`, dan `LevelHard`**
Kelas-kelas ini merupakan turunan dari kelas `Level` yang menjadi variasi level. Variasi untuk tiap turunan ini adalah pada _background_ level dan jumlah nyawa (`lives`). Pada `LevelEasy`, `lives` diinisialisasi dengan `TOTAL_LIVES`. Pada `LevelNormal`, `lives` diinisialisasi dengan `TOTAL_LIVES - 2`. Pada `LevelHard`, `lives diinisialisasi dengan `TOTAL_LIVES - 4`.

### **Kelas `Menu`**
Kelas ini merupakan _parent class_ untuk menu utama, kredit, dan menu pilih level dan mewarisi `JPanel`. Pada kelas ini terdapat properti `Image` dengan nama `bg` sebagai _background_ dari menu.

### **Kelas `MainMenu`**
Kelas ini mewarisi kelas `Menu`. Saat kelas dibuat, _constructor_ akan membuat 2 objek `JButton` yang berfungsi untuk mengganti panel yang ditampilkan menjadi panel `LevelSelect` atau `CreditPage`. Posisi tombol diatur dengan _Layout manager_ `GridBagLayout`.

Pada _method_ `paintComponent` digambarkan _background_ dan String judul game yaitu "Candy Catch".

### **Kelas `CreditPage`**
Kelas ini juga mewarisi kelas `Menu`. Saat dibuat, _constructor_ kelas ini akan membuat sebuah `JButton` sebagai tombol kembali (mengganti panel menjadi panel `MainMenu`). Posisi tombol diatur dengan _Layout manager_ `GridBagLayout`.

Pada _method_ `paintComponent` digambar String untuk judul dan isi kredit dengan 2 font berbeda.

### **Kelas `LevelSelect`**
Kelas ini juga turunan dari kelas `Menu`. Kelas ini berfungsi untuk memilih level yang ingin dimainkan. Saat dibuat, _constructor_ kelas ini membuat 4 objek `JButton`. Tiga tombol digunakan untuk memilih level. Saat diklik masing-masing akan mengganti panel dengan panel level bersangkutan. Dan 1 tombol untuk kembali ke menu utama. Posisi tombol diatur dengan _Layout manager_ `GridBagLayout`.

### **Kelas `CandyCatch`**
Kelas `CandyCatch` ini adalah merupakan kelas turunan dari `JFrame` dan juga _driver class_ dari program ini. 

Kelas ini juga mempunyai 2 _constant_ , yaitu `HEIGHT` dan `WIDTH` yang merupakan tinggi dan lebar dimensi program. 2 _constant_  ini bersifat `static` sehingga bisa diakses oleh kelas lain tanpa perlu membuat objeknya.

Selain itu, kelas ini juga mempunyai 2 atribut yang bersifat `static`, yaitu `cardLayout` dan `mainPanel` yang nantinya akan digunakan dalam mengatur _frame_.

Selain terdapat `main`, di kelas ini juga terdapat `initUi` yang merupakan hasil modifikasi dari referensi **4** dan berfungsi untuk mengatur frame. `mainPanel` digunakan untuk tempat menambahkan objek _panel_ lain seperti `MainMenu`, `LevelSelect`, dll. `mainPanel` menggunakan _layout manager_ `cardLayout` sehingga dapat memudahkan penggantian panel yang ditampilkan. Perbedaan dengan referensi **4** adalah `mainPanel` dan `cardLayout` bersifat `static` sehingga dapat digunakan tanpa membuat objek baru di kelas lain.

## **Referensi**
1. http://zetcode.com/javagames/collision/
2. http://zetcode.com/javagames/puzzle/
3. http://forum.codecall.net/topic/50071-making-a-simple-high-score-system/
4. https://www.edureka.co/community/38265/switch-jpanels-inside-a-jframe
