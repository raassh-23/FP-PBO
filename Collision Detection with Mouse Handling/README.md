# **Proyek _Collision Detection with Mouse Handling_**

Perubahan kontrol dari menggunakan _keyboard_ menjadi _mouse_ berarti melakukan perubahan pada kelas _sprite_ yang dapat dikontrol yaitu `SpaceShip` dan kelas dimana input kontrol dideteksi `Board`.

## **Perubahan pada `SpaceShip`**

Pada `SpaceShip` terdapat _method_ `keyPressed` dan  `keyReleased` untuk mengatur kontrol dengan _keyboard_ (dipanggil saat _key_ ditekan dan dilepas). Karena kontrol ingin diganti dengan _mouse_, maka _method_-_method_ tersebut dihapus. 

Setelah itu, _method_ baru untuk kontrol _mouse_ ditambahkan. Kita ingin pesawat bergerak bersama kursor _mouse_ dan menembak saat tombol _mouse_ kiri dipencet. Maka dari itu ditambahkan _method_ `mouseClicked`, `mouseMoved`, dan `mouseDragged`.

Pada `mouseMoved` karena diinginkan posisi pesawat mengikuti posisi kursor _mouse_, maka variabel `dx` dan `dy` di-_assign_ dengan posisi _x_ dan _y_ _mouse_. Selain itu, pada _method_ `move` _line_ `x += dx` dan `y += dy` diganti dengan `x = dx` dan `y = dy`.

```java
public void move() {

    x = dx;
    y = dy;
...
}
```

```java
public void mouseMoved(MouseEvent e) {

    dx = e.getX();
    dy = e.getY();
}
```

Akan tetapi dengan perintah yang demikian, _sprite_ pesawat akan mengikuti gerak _mouse_ termasuk saat _mouse_ keluar dari _board_. Sehingga, pesawat tidak terlihat karena berada diluar _board_. Oleh karena itu perlu dibatasi posisi pesawat agar tidak keluar _board_ permainan.

Pembatasan dilakukan dengan mengecek posisi _mouse_ apakah sudah diluar _board_ atau tidak. Jika posisi _mouse_ diluar _board_, maka posisi pesawat tidak perlu di-_update_ untuk sama dengan posisi _mouse_.

Untuk mengetahui batas posisi pesawat ditambahkan atribut `MAX_X` dan `MAX_Y` yang merupakan batas posisi maksimal pesawat. Nilai `MAX_X` adalah lebar _board_ (400) dikurangi lebar _sprite_ pesawat. Nilai `MAX_Y` adalah tinggi _board_ (300)dikurangi tinggi _sprite_ pesawat.

```java
private void initCraft() {
        
...
    this.MAX_X = 400 - getWidth();
    this.MAX_Y = 300 - getHeight();
}
```

Lalu pada `mouseMoved` dicek sehingga posisi pesawat akan di-_update_ hanya jika posisi _mouse_ kurang dari `MAX_X` dan `MAX_Y`.

```java
public void mouseMoved(MouseEvent e) {

    if(e.getX() < MAX_X) dx = e.getX();
    if(e.getY() < MAX_Y) dy = e.getY();
}
```

Selanjutnya, pada _method_ `mouseClicked` akan dipanggil _method_ `fire` karena pesawat akan menembak jika _mouse_ diklik.

```java
public void mouseClicked(MouseEvent e) {
	fire();    	
}
```

Terakhir, pada _method_ `mouseDragged` akan dipanggil _method_ `fire` dan `mouseMoved` karena _drag mouse_ tidak lain adalah saat _mouse_ bergerak dan ditekan.

```java
public void mouseDragged(MouseEvent e) {
    fire();
    mouseMoved(e);
}
```

Terakhir adalah meng-_import_ `java.awt.event.MouseEvent` karena semua _method_ tadi memakai _library_ tersebut untuk menangkap _event mouse_.

## **Perubahan pada `Board`**

Setelah ditambahkan _method_ pada `SpaceShip` maka dilakukan perubahan pada `Board` dimana _event_ dari _mouse_ akan dideteksi.

Pertama dilakukan perubahan pada kelas `TAdapter`. Karena akan mendeteksi _mouse event_ maka kelas ini akan mewarisi kelas `MouseAdapter` dan meng-_override_ _method_ `mouseClicked`, `mouseDragged`, dan `mouseMoved` dengan _method_ yang ada pada `SpaceShip` yang tadi sudah dibuat.

```java
private class TAdapter extends MouseAdapter {

    @Override
    public void mouseClicked(MouseEvent e) {
        spaceship.mouseClicked(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        spaceship.mouseMoved(e);
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        spaceship.mouseDragged(e);
    }
}
```
Lalu pada `initBoard` saat inisialisasi kelas, ditambahkan _MouseListener_ dan _MouseMotionListener_ yaitu `TAdapter` agar _event_ _mouse_ dapat dideteksi pada kelas ini.

```java
private void initBoard() {

    addMouseListener(new TAdapter());
    addMouseMotionListener(new TAdapter());
...
}
```
Dengan begitu pemain sudah dapat mengontrol pesawat mengunakan _mouse_.
