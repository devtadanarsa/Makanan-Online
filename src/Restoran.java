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

        System.out.print("|| Nama Makanan : ");
        namaMakanan = scanner.nextLine();
        System.out.print("|| Harga : ");
        harga = scanner.nextInt();

        menu.add(new Makanan(namaMakanan, harga));
    }

    public void lihatMenu(){
        if(menu.isEmpty() == true){
            System.out.println("|| ================================================== ||");
            System.out.println("||                     Tidak ada Menu                 ||");
            System.out.println("|| ================================================== ||");
        }else{
            System.out.println("|| ================================================== ||");
            System.out.println("||                          MENU                      ||");
            System.out.println("|| ================================================== ||");
            System.out.println("||            Nama            |         Harga         ||");
            System.out.println("|| ================================================== ||");
            for(int i = 0; i < menu.size(); i++){
                System.out.printf("%-25s | Rp.-%20s\n", menu.get(i).getNamaMakanan(), menu.get(i).getHarga());
            }
        }
    }

    public void detailRestoran(){
        System.out.println("|| ================================================== ||");
        System.out.printf("|| Nama Restoran : %-40s\n", this.getNamaResto());
        System.out.printf("|| Lokasi : %-40s\n", this.getAlamatResto() + ", Bali");
        System.out.println("|| ================================================== ||");
        lihatMenu();
    }

}
