package entity;

public class Menu {
    private String namaMenu;
    private Integer harga;

    public Menu(String namaMenu, Integer harga){
        this.setNamaMenu(namaMenu);
        this.setHarga(harga);
    }

    public String getNamaMenu() {return namaMenu;}
    public Integer getHarga() {return harga;}
    public void setNamaMenu(String namaMenu) {this.namaMenu = namaMenu;}
    public void setHarga(Integer harga) {this.harga = harga;}
}
