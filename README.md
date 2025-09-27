# Post-Test-PBO-4 (Dibawah)

# Post-Test-PBO-3

### Nama: Ghifari Al Azhar
### NIM: 2409116059

## DESKRIPSI PROGRAM
Program Donasi ini dibuat untuk mengelola data donasi dari para donatur dengan konsep OOP (Object-Oriented Programming). Program menggunakan Java dengan penerapan prinsip-prinsip OOP seperti Encapsulation, Inheritance, Polymorphism, dan Overriding.
Donasi dibagi menjadi dua jenis, yaitu Donasi Uang dan Donasi Barang. Untuk itu, dibuat sebuah superclass bernama Donasi yang menyimpan atribut umum seperti id, namaDonatur, dan penerima. Lalu, ada dua subclass yaitu:
- DonasiUang → menyimpan tambahan atribut jumlah untuk nilai uang.
- DonasiBarang → menyimpan tambahan atribut jenisBarang untuk barang yang didonasikan.

Data donasi dikelola menggunakan ArrayList di dalam DonasiService. Class ini berfungsi sebagai pengelola logika CRUD sederhana seperti menambahkan donasi uang/barang dan menampilkan daftar donasi.
Program ini juga menerapkan polymorphism: meskipun semua objek donasi disimpan dalam ArrayList<Donasi>, setiap objek tetap bisa menampilkan informasi berbeda sesuai jenisnya. Misalnya, DonasiUang akan menampilkan jumlah uang, sedangkan DonasiBarang menampilkan jenis barang.

## ALUR PROGRAM
Program dimulai dari MainApp
Menu utama ditampilkan ke layar dengan 7 pilihan.
1. Tampilkan Donasi
2. Tambah Donasi Uang
3. Tambah Donasi Barang
4. Edit Donasi
5. Hapus Donasi
6. Cari Donasi
7. Keluar

Pengguna memilih menu sesuai kebutuhan:
Pilihan 1: Tampilkan Donasi
Menampilkan semua donasi yang tersimpan di ArrayList.
Jika kosong → tampil pesan "Belum ada donasi".
Jika ada data → setiap donasi ditampilkan sesuai jenisnya (uang/barang).

Pilihan 2: Tambah Donasi Uang
Meminta input nama donatur, penerima, dan jumlah uang.
Data disimpan dalam objek DonasiUang lalu masuk ke listDonasi.

Pilihan 3: Tambah Donasi Barang
Meminta input nama donatur, penerima, dan jenis barang.
Data disimpan dalam objek DonasiBarang lalu masuk ke listDonasi.

Pilihan 4: Edit Donasi
Meminta ID donasi yang akan diedit.
Jika ID ditemukan → pengguna bisa mengubah data donatur, penerima, jumlah (untuk uang), atau jenis barang (untuk barang).
Jika tidak ditemukan → tampil pesan "Donasi tidak ditemukan".

Pilihan 5: Hapus Donasi
Meminta ID donasi yang akan dihapus.
Jika ID valid → donasi dihapus dari listDonasi.
Jika tidak valid → tampil pesan error.

Pilihan 6: Cari Donasi
Meminta kata kunci pencarian (misalnya nama donatur atau penerima).
Sistem menampilkan semua donasi yang sesuai.
Jika tidak ada hasil → tampil pesan "Tidak ada hasil pencarian".

Pilihan 7: Keluar
Program berhenti dan menampilkan pesan “Terima kasih, program selesai!”.
Looping Program
Setelah setiap aksi selesai, menu utama akan muncul kembali.
Program hanya berhenti jika pengguna memilih menu 7 (Keluar).

## STRUKTUR PACKAGE
<img width="387" height="183" alt="image" src="https://github.com/user-attachments/assets/7e92e11b-74ed-4752-aee0-a3005455c892" />

1. Package main

- Berisi class App.java

Ini adalah class utama (entry point) dari program.
Di dalamnya terdapat main() method yang berfungsi menampilkan menu utama dan mengatur alur interaksi dengan pengguna.
Semua pilihan menu (tambah, tampilkan, edit, hapus, cari, keluar) dipanggil lewat class ini.
Jadi package main isinya kode untuk menghubungkan user dengan sistem.

2. Package model
- Berisi class-class yang merepresentasikan struktur data donasi.
- Isinya:
    - Donasi.java → class superclass (induk) yang menyimpan atribut umum (id, nama donatur, penerima).
    - DonasiBarang.java → class subclass turunan dari Donasi, khusus untuk donasi barang (punya atribut tambahan: jenis barang).
    - DonasiUang.java → class subclass turunan dari Donasi, khusus untuk donasi uang (punya atribut tambahan: jumlah uang).
- Package ini mendukung prinsip OOP (enkapsulasi, inheritance, polymorphism).
→ Semua data donasi diatur di sini, sementara logika CRUD dan UI dipisahkan ke package lain.

3. Package service
- Berisi class DonasiService.java
Class ini digunakan untuk mengatur logika bisnis dari program, seperti:
    - Menambah donasi ke dalam list
    - Menampilkan donasi
    - Mengedit donasi
    - Menghapus donasi
    - Mencari donasi
- Semua proses yang berhubungan dengan CRUD (Create, Read, Update, Delete) ada di sini.
- Package ini menjadi penghubung antara data (model) dengan interaksi user (main).



## PENJELASAN CODE
#### 1. App.java
```bash
   package main;

import service.DonasiService;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        DonasiService service = new DonasiService();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== MENU DONASI ===");
            System.out.println("1. Tampilkan Donasi");
            System.out.println("2. Tambah Donasi Uang");
            System.out.println("3. Tambah Donasi Barang");
            System.out.println("4. Edit Donasi");
            System.out.println("5. Hapus Donasi");
            System.out.println("6. Cari Donasi");
            System.out.println("7. Keluar");

            int pilihan = -1;
            try {
                System.out.print("Pilih menu: ");
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
                continue;
            }

            switch (pilihan) {
                case 1 -> service.tampilkanDonasi();
                case 2 -> service.tambahDonasiUang();
                case 3 -> service.tambahDonasiBarang();
                case 4 -> service.editDonasi();
                case 5 -> service.hapusDonasi();
                case 6 -> service.cariDonasi();
                case 7 -> {
                    running = false;
                    System.out.println("Terima kasih, program selesai!");
                }
                default -> System.out.println("Pilihan tidak valid!");
            }
        }
    }
}

```
Class MainApp berfungsi sebagai entry point aplikasi. Di sinilah program mulai dijalankan.
- Program menampilkan menu interaktif dengan pilihan untuk menambah donasi uang, donasi barang, melihat daftar donasi, atau keluar.


- Input diproses menggunakan switch-case. Jika pengguna memilih 1, maka program akan memanggil method tambahDonasiUang() dari DonasiService, dan seterusnya.
- Loop while(true) membuat program berjalan terus sampai pengguna memilih opsi 0 untuk keluar.

Dengan pembagian ini, kode menjadi lebih rapi: package model menyimpan struktur data, package service berisi logika bisnis, dan package main berisi titik masuk aplikasi.



#### 2. Donasi.java
```bash
package model;

public class Donasi {
    private int id;
    private String namaDonatur;
    private String penerima;

    public Donasi(int id, String namaDonatur, String penerima) {
        this.id = id;
        this.namaDonatur = namaDonatur;
        this.penerima = penerima;
    }

    public int getId() {
        return id;
    }

    public String getNamaDonatur() {
        return namaDonatur;
    }

    public String getPenerima() {
        return penerima;
    }

    public void setNamaDonatur(String namaDonatur) {
        this.namaDonatur = namaDonatur;
    }

    public void setPenerima(String penerima) {
        this.penerima = penerima;
    }

    public String getDetail() {
        return id + ". " + namaDonatur + " → " + penerima;
    }
}
```
Class Donasi berada di package model dan berperan sebagai superclass. Atribut id, namaDonatur, dan penerima ditulis dengan access modifier private agar tidak bisa diakses langsung dari luar class. Untuk itu, disediakan method getter dan setter supaya data tetap bisa diakses dan diubah dengan cara yang aman sesuai prinsip enkapsulasi.

Selain itu, terdapat constructor untuk mengisi nilai awal setiap atribut ketika objek Donasi dibuat. Kemudian, ada method getInfo() yang berfungsi menampilkan informasi umum dari sebuah donasi berupa ID, nama donatur, dan penerima. Method ini nantinya akan dioverride di subclass agar informasi lebih lengkap sesuai jenis donasi.

#### 3. DonasiUang.java
```bash
package model;

public class DonasiUang extends Donasi {
    private double jumlah;

    public DonasiUang(int id, String namaDonatur, String penerima, double jumlah) {
        super(id, namaDonatur, penerima);
        this.jumlah = jumlah;
    }

    public double getJumlah() {
        return jumlah;
    }

    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    @Override
    public String getDetail() {
        return super.getDetail() + " | Uang: Rp" + jumlah;
    }
}
```
Class DonasiUang adalah turunan dari Donasi. Perbedaan utamanya adalah adanya atribut tambahan jumlah untuk menyimpan nilai donasi dalam bentuk uang. Sama seperti sebelumnya, atribut ini dienkapsulasi dan diakses melalui getter dan setter.

Pada constructor, super(...) dipanggil untuk mengisi atribut warisan dari superclass (id, namaDonatur, penerima), lalu atribut jumlah diinisialisasi.

Method getInfo() dioverride dari superclass untuk menambahkan informasi jumlah uang. Dengan overriding ini, ketika objek DonasiUang dipanggil melalui polymorphism, hasilnya akan lebih spesifik.

#### 4. DonasiBarang.java
```bash
package model;

public class DonasiBarang extends Donasi {
    private String jenisBarang;

    public DonasiBarang(int id, String namaDonatur, String penerima, String jenisBarang) {
        super(id, namaDonatur, penerima);
        this.jenisBarang = jenisBarang;
    }

    public String getJenisBarang() {
        return jenisBarang;
    }

    public void setJenisBarang(String jenisBarang) {
        this.jenisBarang = jenisBarang;
    }

    @Override
    public String getDetail() {
        return super.getDetail() + " | Barang: " + jenisBarang;
    }
}
```
Class DonasiBarang juga merupakan turunan dari Donasi. Bedanya, ada atribut tambahan jenisBarang untuk menyimpan informasi barang yang disumbangkan. Sama seperti class lain, data ini dilindungi dengan enkapsulasi dan diakses lewat getter serta setter.

Constructor-nya memanggil super(...) untuk mengisi data umum dari Donasi, lalu menambahkan jenisBarang. Method getInfo() dioverride supaya menampilkan informasi tambahan berupa barang yang diberikan.

#### 5. DonasiService.java
```bash
package service;

import model.Donasi;
import model.DonasiUang;
import model.DonasiBarang;
import java.util.ArrayList;
import java.util.Scanner;

public class DonasiService {
    private ArrayList<Donasi> listDonasi = new ArrayList<>();
    private int nextId = 1;
    private Scanner scanner = new Scanner(System.in);

    public DonasiService() {
        listDonasi.add(new DonasiUang(nextId++, "Budi", "Yayasan Anak Yatim", 500000));
        listDonasi.add(new DonasiBarang(nextId++, "Ani", "Panti Asuhan", "Buku Bacaan"));
        listDonasi.add(new DonasiUang(nextId++, "Citra", "Yayasan Pendidikan", 1000000));
    }

    public void tambahDonasiUang() {
        System.out.print("Nama Donatur: ");
        String nama = scanner.nextLine();
        System.out.print("Penerima: ");
        String penerima = scanner.nextLine();
        System.out.print("Jumlah Uang: ");
        double jumlah = scanner.nextDouble();
        scanner.nextLine();

        Donasi d = new DonasiUang(nextId++, nama, penerima, jumlah);
        listDonasi.add(d);
        System.out.println("Donasi uang berhasil ditambahkan!");
    }

    public void tambahDonasiBarang() {
        System.out.print("Nama Donatur: ");
        String nama = scanner.nextLine();
        System.out.print("Penerima: ");
        String penerima = scanner.nextLine();
        System.out.print("Jenis Barang: ");
        String barang = scanner.nextLine();

        Donasi d = new DonasiBarang(nextId++, nama, penerima, barang);
        listDonasi.add(d);
        System.out.println("Donasi barang berhasil ditambahkan!");
    }

    public void tampilkanDonasi() {
        if (listDonasi.isEmpty()) {
            System.out.println("Belum ada donasi tercatat.");
        } else {
            System.out.println("Daftar Donasi:");
            for (Donasi d : listDonasi) {
                System.out.println(d.getDetail()); // polymorphism jalan di sini
            }
        }
    }

    public void editDonasi() {
        System.out.print("Masukkan ID Donasi yang akan diubah: ");
        int id = Integer.parseInt(scanner.nextLine());
        Donasi target = cariById(id);

        if (target == null) {
            System.out.println("Donasi tidak ditemukan!");
            return;
        }

        System.out.print("Nama Donatur baru (kosong = tidak diubah): ");
        String nama = scanner.nextLine();
        if (!nama.isEmpty()) target.setNamaDonatur(nama);

        System.out.print("Penerima baru (kosong = tidak diubah): ");
        String penerima = scanner.nextLine();
        if (!penerima.isEmpty()) target.setPenerima(penerima);

        System.out.println("Donasi berhasil diperbarui!");
    }

    public void hapusDonasi() {
        System.out.print("Masukkan ID Donasi yang akan dihapus: ");
        int id = Integer.parseInt(scanner.nextLine());
        Donasi target = cariById(id);

        if (target == null) {
            System.out.println("Donasi tidak ditemukan!");
            return;
        }

        listDonasi.remove(target);
        System.out.println("Donasi berhasil dihapus!");
    }

    public void cariDonasi() {
        System.out.print("Masukkan kata kunci pencarian: ");
        String keyword = scanner.nextLine().toLowerCase();

        boolean found = false;
        for (Donasi d : listDonasi) {
            if (d.getNamaDonatur().toLowerCase().contains(keyword) ||
                d.getPenerima().toLowerCase().contains(keyword)) {
                System.out.println(d.getDetail());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Tidak ada hasil pencarian.");
        }
    }

    private Donasi cariById(int id) {
        for (Donasi d : listDonasi) {
            if (d.getId() == id) {
                return d;
            }
        }
        return null;
    }
}
```
Class DonasiService merupakan inti dari logika bisnis dalam program donasi. Di dalamnya terdapat sebuah ArrayList<Donasi> bernama listDonasi yang digunakan untuk menyimpan seluruh data donasi baik berupa uang (DonasiUang) maupun barang (DonasiBarang). Agar setiap donasi memiliki nomor urut yang unik, disediakan atribut nextId yang terus bertambah setiap kali ada donasi baru ditambahkan. Input dari pengguna ditangani menggunakan objek Scanner.

Pada constructor DonasiService(), secara otomatis ditambahkan beberapa record data awal, misalnya donasi uang dari Budi sebesar Rp500.000, donasi barang dari Ani berupa buku bacaan, dan donasi uang dari Citra sebesar Rp1.000.000. Tujuannya agar ketika program pertama kali dijalankan, daftar donasi tidak kosong sehingga langsung ada data yang bisa ditampilkan.

Fitur-fitur utama yang disediakan antara lain:
- tambahDonasiUang() dan tambahDonasiBarang() digunakan untuk menambahkan data baru sesuai jenis donasinya. User diminta memasukkan nama donatur, penerima, dan jumlah uang atau jenis barang. Data tersebut kemudian dibuat menjadi objek (DonasiUang atau DonasiBarang) dan dimasukkan ke dalam listDonasi.
- tampilkanDonasi() berfungsi menampilkan seluruh donasi yang sudah tercatat. Pada bagian ini terlihat konsep polymorphism, karena meskipun semua data disimpan dalam ArrayList<Donasi>, saat dipanggil d.getDetail(), Java akan secara otomatis menjalankan method getDetail() milik subclass yang sesuai (DonasiUang atau DonasiBarang). Dengan begitu, format tampilan bisa berbeda sesuai jenis donasi.
- editDonasi() memungkinkan user memperbarui data donasi berdasarkan ID. Jika donasi ditemukan, maka nama donatur dan penerima dapat diubah sesuai input user. Jika input kosong, nilai lama akan dipertahankan.
- hapusDonasi() digunakan untuk menghapus donasi dari daftar. User diminta memasukkan ID donasi, lalu program akan mencari data tersebut dan menghapusnya jika ditemukan.
- cariDonasi() dipakai untuk melakukan pencarian berdasarkan kata kunci. Program akan mencocokkan input user dengan nama donatur atau penerima, lalu menampilkan hasil yang sesuai. Jika tidak ditemukan, akan ditampilkan pesan bahwa data tidak ada.
- cariById() adalah method privat pendukung yang digunakan oleh fitur edit dan hapus untuk menemukan objek donasi berdasarkan ID. Method ini melakukan iterasi pada listDonasi dan mengembalikan objek yang cocok, atau null jika tidak ada.

Secara keseluruhan, class DonasiService menjadi pusat pengelolaan data donasi. Semua operasi CRUD (Create, Read, Update, Delete) serta pencarian dilakukan di sini. Dengan adanya pemisahan class ini ke dalam package service, kode menjadi lebih terstruktur, mudah dipelihara, dan sesuai dengan prinsip OOP.


## PENJELASAN OUTPUT TERBARU
#### 1. Menu 2
   <img width="741" height="343" alt="image" src="https://github.com/user-attachments/assets/6af4fbcc-1732-4ebd-847f-303fd1b3035f" />
   
  Ini adalah output dari fitur baru yaitu untuk mencatat donasi berupa uang

#### 2. Menu 3
   <img width="584" height="342" alt="image" src="https://github.com/user-attachments/assets/91334cc5-6dcd-4439-86e3-b07ba30ebdd5" />
   
   Ini adalah output dari fitu baru yaitu untuk mencatat donasi yang berbentuk barang

# Post-Test-PBO-4
