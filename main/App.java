package main;

import service.DonasiService;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        DonasiService service = new DonasiService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MENU DONASI ===");
            System.out.println("1. Tambah Donasi Uang");
            System.out.println("2. Tambah Donasi Barang");
            System.out.println("3. Tampilkan Donasi");
            System.out.println("4. Edit Donasi");
            System.out.println("5. Hapus Donasi");
            System.out.println("6. Cari Donasi");
            System.out.println("7. Keluar");
            System.out.print("Pilih: ");
            int pilih = scanner.nextInt();
            scanner.nextLine();

            switch (pilih) {
                case 1: service.tambahDonasiUang(); break;
                case 2: service.tambahDonasiBarang(); break;
                case 3: service.tampilkanDonasi(); break;
                case 4: service.editDonasi(); break;
                case 5: service.hapusDonasi(); break;
                case 6: service.cariDonasi(); break;
                case 7: System.exit(0);
                default: System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
