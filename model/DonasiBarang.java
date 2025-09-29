package model;

public class DonasiBarang extends Donasi implements CetakInfo {
    private String jenisBarang;

    // Constructor Overloading
    public DonasiBarang(int id, String namaDonatur, String penerima, String jenisBarang) {
        super(id, namaDonatur, penerima);
        this.jenisBarang = jenisBarang;
    }

    public DonasiBarang(int id, String namaDonatur, String jenisBarang) {
        super(id, namaDonatur, "Panti Asuhan");
        this.jenisBarang = jenisBarang;
    }

    @Override
    public String getDetail() {
        return id + ". " + namaDonatur + " → " + penerima + " | Barang: " + jenisBarang;
    }

    @Override
    public void cetakRingkas() {
        System.out.println("Donasi barang dari " + namaDonatur + " berupa " + jenisBarang);
    }
}
