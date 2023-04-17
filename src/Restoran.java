import utility.Other;

import java.util.ArrayList;
import java.util.Scanner;

public class Restoran {
    private Integer idRestoran;
    private String namaResto;
    private String alamatResto;
    private ArrayList <Menu> menu;

    //Constructor
    public Restoran(String namaResto, String alamatResto){
        this.setNamaResto(namaResto);
        this.setAlamatResto(alamatResto);
        this.setIdRestoran(ListRestoran.size() + 1);
        menu = new ArrayList<>();
    }

    //Getter dan Setter
    public String getNamaResto() {return namaResto;}
    public String getAlamatResto() {return alamatResto;}
    public void setNamaResto(String namaResto) {this.namaResto = namaResto;}
    public void setAlamatResto(String alamatResto) {this.alamatResto = alamatResto;}
    public void setIdRestoran(Integer idRestoran) {this.idRestoran = idRestoran;}
    public Integer getIdRestoran() {return idRestoran;}
    public Menu getMenu(int index) {return menu.get(index);}
    public int jumlahMenu() {return menu.size();}

    /**
     * Fungsi untuk menambah menu.
     * Input : namaMenu(String), harga(Integer).
     * Output : menu.add(new Makanan(namaMenu, harga)
     */
    public void tambahMenu(){
        String namaMenu;
        int harga;
        Scanner scanner = new Scanner(System.in);
        System.out.println("|| ================================================== ||");
        System.out.println("||                      Tambah Menu                   ||");
        System.out.println("|| ================================================== ||");
        System.out.print("|| Nama Menu : ");
        namaMenu = scanner.nextLine();
        System.out.print("|| Harga : Rp.");
        harga = scanner.nextInt();

        menu.add(new Menu(namaMenu, harga));
    }

    /**
     * Fungsi untuk melihat menu yang tersedia pada satu restoran.
     * Tidak memerlukan input & output.
     */
    public void lihatMenu(){
        if(menu.isEmpty()){
            System.out.println("|| ================================================== ||");
            System.out.println("||                    Tidak ada Menu                  ||");
            System.out.println("|| ================================================== ||");
        }else{
            System.out.println("|| ================================================== ||");
            System.out.println("||                          MENU                      ||");
            System.out.println("|| ================================================== ||");
            System.out.println("|| No |          Nama            |        Harga       ||");
            System.out.println("|| ================================================== ||");
            for(int i = 0; i < menu.size(); i++){
                System.out.printf("||  %d | %-25s | Rp.%-14s ||\n", (i + 1), menu.get(i).getNamaMenu(), menu.get(i).getHarga());
            }
            System.out.println("|| ================================================== ||");
        }
    }

    /**
     * Fungsi untuk melihat detail dari satu restoran.
     * Tampilan :
     * - Nama Restoran
     * - Lokasi
     * - List Menu
     */
    public void detailRestoran(){
        System.out.println("|| ================================================== ||");
        System.out.printf("|| Nama Restoran : %-34s ||\n", this.getNamaResto());
        System.out.printf("|| Id Restoran : 00%-34d ||\n", this.getIdRestoran());
        System.out.printf("|| Lokasi : %-41s ||\n", (this.getAlamatResto() + ", Bali"));
        lihatMenu();
    }

}
