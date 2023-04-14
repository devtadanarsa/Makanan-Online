public class Makanan {
    private String namaMakanan;
    private int harga;

    public Makanan(String namaMakanan, int harga){
        this.namaMakanan = namaMakanan;
        this.harga = harga;
    }

    public String getNamaMakanan() {return namaMakanan;}

    public int getHarga() {return harga;}

    public void setNamaMakanan(String namaMakanan) {this.namaMakanan = namaMakanan;}

    public void setHarga(int harga) {this.harga = harga;}
}
