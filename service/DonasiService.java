package service;

import model.Donasi;
import model.DonasiUang;
import model.DonasiBarang;
import model.CetakInfo;
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
                System.out.println(d.getDetail()); 
                if (d instanceof CetakInfo) {
                    ((CetakInfo) d).cetakRingkas(); 
                }
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

