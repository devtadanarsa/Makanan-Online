import java.util.ArrayList;

class Makanan{
    private String namaMakanan;
    private double harga;

    //Constructor
    public Makanan(String namaMakanan, double harga){
        this.namaMakanan = namaMakanan;
        this.harga = harga;
    }

    //Getter Method
    public String getNamaMakanan() {
        return this.namaMakanan;
    }

    public double getHarga(){
        return this.harga;
    }
}


class Restoran{
    private String namaRestoran;
    private String alamat;
    ArrayList<Makanan> menu;

    public Restoran(String namaRestoran, String alamat){
        this.namaRestoran = namaRestoran;
        this.alamat = alamat;
        menu = new ArrayList<>();
    }

    public void tambahMenu(){
        String namaMenu;
        double hargaMenu;
        System.out.println("|| ==================================================||");
        System.out.println("|| \t\t\t\t\t   Tambah Menu\t\t\t\t\t ||");
        System.out.println("|| ==================================================||");
        System.out.println("|| Nama : ");
        System.out.println("|| Harga : ");
    }

}

public class Main {
    public static void main(String[] args) {
        Restoran tes = new Restoran("Bang Ganteng", "Denpasar");
        tes.tambahMenu();
    }
}
