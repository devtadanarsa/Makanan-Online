import java.util.ArrayList;
import java.util.Scanner;

public class Restoran {
    private static int jmlResto;
    private String namaResto;
    private String alamatResto;
    private ArrayList <Makanan> menu;

    //Constructor
    public Restoran(String namaResto, String alamatResto){
        this.namaResto = namaResto;
        this.alamatResto = alamatResto;
        menu = new ArrayList<>();
        jmlResto++;
    }

    //Getter dan Setter
    public static int getJmlResto() {return jmlResto;}
    public String getNamaResto() {return namaResto;}
    public String getAlamatResto() {return alamatResto;}
    public void setNamaResto(String namaResto) {this.namaResto = namaResto;}
    public void setAlamatResto(String alamatResto) {this.alamatResto = alamatResto;}

    public void tambahMenu(){
        String namaMakanan;
        int harga;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nama Makanan : ");
        namaMakanan = scanner.nextLine();
        System.out.print("Harga : ");
        harga = scanner.nextInt();

        menu.add(new Makanan(namaMakanan, harga));
    }

    public void lihatMenu(){
        for(int i = 0; i < menu.size(); i++){
            System.out.printf("%s (Rp. %.2f)", menu.get(i).getNamaMakanan(), menu.get(i).getHarga());
        }
    }

}
