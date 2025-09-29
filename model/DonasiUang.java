package model;

public class DonasiUang extends Donasi implements CetakInfo {
    private double jumlahUang;

    // Constructor Overloading
    public DonasiUang(int id, String namaDonatur, String penerima, double jumlahUang) {
        super(id, namaDonatur, penerima);
        this.jumlahUang = jumlahUang;
    }

    public DonasiUang(int id, String namaDonatur, double jumlahUang) {
        super(id, namaDonatur, "Yayasan");
        this.jumlahUang = jumlahUang;
    }

    @Override
    public String getDetail() {
        return id + ". " + namaDonatur + " → " + penerima + " | Uang: Rp" + jumlahUang;
    }

    @Override
    public void cetakRingkas() {
        System.out.println("Donasi uang dari " + namaDonatur + " sebesar Rp" + jumlahUang);
    }
}
