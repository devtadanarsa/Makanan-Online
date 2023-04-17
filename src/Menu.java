public class Menu {
    private String namaMenu;
    private int harga;

    public Menu(String namaMenu, int harga){
        this.namaMenu = namaMenu;
        this.harga = harga;
    }

    public String getNamaMenu() {return namaMenu;}
    public int getHarga() {return harga;}
    public void setNamaMenu(String namaMenu) {this.namaMenu = namaMenu;}
    public void setHarga(int harga) {this.harga = harga;}
}
