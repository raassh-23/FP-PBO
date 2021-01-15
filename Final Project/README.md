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

### Kelas `Candy`
Kelas `Candy` merupakan kelas _abstract_ yang diturnkan dari `Sprite` dan menjadi _parent class_ untuk kelas `Candy1`, `Candy2`, `Candy3`, `BadCandy`.

Kelas ini hanya mempunyai atribut integer bernama `addToScore` yang akan digunakan untuk menyimpan pertambahan _score_ apabila berhasil ditangkap. Kelas ini hanya memiliki 3 _method_, yaitu `Candy`, `initCandy`, dan `move`. 

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

### Referensi
1. http://zetcode.com/javagames/collision/
2. http://zetcode.com/javagames/puzzle/
3. http://forum.codecall.net/topic/50071-making-a-simple-high-score-system/
4. https://www.edureka.co/community/38265/switch-jpanels-inside-a-jframe
