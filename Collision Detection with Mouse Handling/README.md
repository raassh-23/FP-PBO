# **Proyek _Collision Detection with Mouse Handling_**

Perubahan kontrol dari menggunakan _keyboard_ menjadi _mouse_ berarti melakukan perubahan pada kelas _sprite_ yang dapat dikontrol yaitu `SpaceShip` dan kelas dimana input kontrol dideteksi `Board`.

## **Perubahan pada `SpaceShip`**

Pada `SpaceShip` terdapat _method_ `keyPressed` dan  `keyReleased` untuk mengatur kontrol dengan _keyboard_ (dipanggil saat _key_ ditekan dan dilepas). Karena kontrol ingin diganti dengan _mouse_, maka _method_-_method_ tersebut dihapus. 

Setelah itu, _method_ baru untuk kontrol _mouse_ ditambahkan. Kita ingin pesawat bergerak bersama kursor _mouse_ dan menembak saat tombol _mouse_ kiri dipencet. Maka dari itu ditambahkan _method_ `mouseClicked`, `mouseMoved`, dan `mouseDragged`.


