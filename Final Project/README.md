# Final Project PBO - Game Candy Catch

### Deskripsi
Game ini merupakan game casual dengan tugas utama pemain adalah untuk menangkap semua permen yang jatuh dalam waktu tertentu. Pemain juga harus menghindari bom yang jatuh. Jika pemain menangkap bom maka nyawa akan berkurang. Jika nyawa sudah habis, maka pemain akan dinyatakan kalah.

### Level Progression
Dalam setiap level, pemain akan dihadapkan dengan batasan waktu tertentu. Pemain dinyatakan menang jika berhasil menangkap permen sesuai target tiap level. Pemain dinyatakan kalah jika nyawa habis atau belum mencapai target permen hingga waktu habis. Terdpat 3 tingkatan level pada game Candy Catcth ini, yaitu:
1. __Easy__ , pada level ini player memiliki total 5 nyawa yang dapat digunakan dalam menyelesaikan level ini.
2. __Normal__ , nyawa yang dimiliki oleh player pada level ini yaitu sebanyak 3 nyawa yang dapat digunakan dalam menyelesaikan level ini.
3. __Hard__ , pada level ini player hanya memiliki 1 nyawa yang dapat digunakan dalam menyelesaikan level ini.

### Variasi Permen
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

### Skor
Setiap akhir level pemain dapat melihat highscore sehingga pemain bisa mengalahkan rekor skornya sendiri dengan memulai ulang level.

### KELAS `Basket`
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
_

### Kelas `Candy`
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

### Kelas `Candy1`
Kelas `Candy1` merupakan salah satu kelas yang diturunkan dari kelas `Candy`. Di kelas ini, _method_ `initCandy` didefinisikan untuk melakukan _load_ gambar dan menginisialisasi `addToScore` menjadi `5`.

```java
@Override
protected void initCandy() {
   loadImage("src/resources/candy1.png");
   getImageDimensions();

   addToScore = 5;
}
```

### Kelas `Candy2`
Kelas `Candy2` juga merupakan salah satu kelas yang diturunkan dari kelas `Candy`. Mirip seperti `Candy1`, kelas ini juga mendefinisikan `initCandy`. Bedanya, nilai inisialisasi dari `addToScore` adalah `15`.

### Kelas `Candy3`
Kelas `Candy3` merupakan salah satu kelas lain yang diturunkan dari kelas `Candy`. Juga mirip seperti `Candy1` dam `Candy2`, hal yang berbeda adalah nilai inisialisasi dari `addToScore` yaitu `7`.

### Kelas `BadCandy`
Kelas `BadCandy` adalah kelas turunan terakhir dari kelas `Candy`. Sama seperti sebelumnya, disini `addToScore` diinisialisi menjadi `-1`.

### Kelas `Score`
Kelas `Score` merupakan kelas yang mengimplementasi `Serializable` dan digunakan untuk menyimpan _score_ pemain. Karena itu, kelas ini mempunyai 2 atribut, yaitu `name` yang bertipe `String` dan `score` yang bertipe `int`

Kelas ini mempunyai 2 _constructor_, yaitu _constructor_ tanpa parameter yang menginisialisasi `name` dan `score` ke nilai _default_, dan _constructor_ dengan 2 parameter yang menginisialisasi atribut sesuai dengan argumennya. Selain itu, kelas ini juga mempunyai _method getter_ `getName` dan `getScore` untuk mendapatkan nilai `name` dan `score`.

### Kelas `HighscoreManager`
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
### Kelas `CandyCatch`
Kelas `CandyCatch` ini adalah merupakan kelas turunan dari `JFrame` dan juga _driver class_ dari program ini. 

Kelas ini juga mempunyai 2 _constant_ , yaitu `HEIGHT` dan `WIDTH` yang merupakan tinggi dan lebar dimensi program. 2 _constant_  ini bersifat `static` sehingga bisa diakses oleh kelas lain tanpa perlu membuat objeknya.

Selain itu, kelas ini juga mempunyai 2 atribut yang bersifat `static`, yaitu `cardLayout` dan `mainPanel` yang nantinya akan digunakan dalam mengatur _frame_.

Selain terdapat `main`, di kelas ini juga terdapat `initUi` yang merupakan hasil modifikasi dari referensi **4** dan berfungsi untuk mengatur frame. `mainPanel` digunakan untuk tempat menambahkan objek _panel_ lain seperti `MainMenu`, `LevelSelect`, dll. `mainPanel` menggunakan _layout manager_ `cardLayout` sehingga dapat memudahkan penggantian panel yang ditampilkan. Perbedaan dengan referensi **4** adalah `mainPanel` dan `cardLayout` bersifat `static` sehingga dapat digunakan tanpa membuat objek baru di kelas lain.

### Referensi
1. http://zetcode.com/javagames/collision/
2. http://zetcode.com/javagames/puzzle/
3. http://forum.codecall.net/topic/50071-making-a-simple-high-score-system/
4. https://www.edureka.co/community/38265/switch-jpanels-inside-a-jframe
