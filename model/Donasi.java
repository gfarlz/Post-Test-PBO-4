package model;

public abstract class Donasi {
    protected int id;
    protected String namaDonatur;
    protected String penerima;

    public Donasi(int id, String namaDonatur, String penerima) {
        this.id = id;
        this.namaDonatur = namaDonatur;
        this.penerima = penerima;
    }

    // Abstract Method → harus dioverride di subclass
    public abstract String getDetail();

    // Getter & Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNamaDonatur() { return namaDonatur; }
    public void setNamaDonatur(String namaDonatur) { this.namaDonatur = namaDonatur; }

    public String getPenerima() { return penerima; }
    public void setPenerima(String penerima) { this.penerima = penerima; }
}
