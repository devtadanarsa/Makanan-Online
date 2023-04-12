import java.util.ArrayList;
import java.util.Scanner;

public class Admin {

    public static void menuAdmin(){
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        System.out.println("|| ================================================== ||");
        System.out.println("||                      Menu Admin                    ||");
        System.out.println("|| ================================================== ||");
        System.out.println("|| [1] Lihat Restoran                                 ||");
        System.out.println("|| [2] Tambah Restoran                                ||");
        System.out.println("|| [3] Hapus Restoran                                 ||");
        System.out.println("|| [4] Kembali ke login                               ||");
        System.out.println("|| ================================================== ||");
        System.out.print("|| Masukkan pilihan anda : ");
        pilihan = scanner.nextInt();

        switch (pilihan){
            case 1 :
                lihatRestoran();
                menuAdmin();
                break;
            case 2 :
                tambahRestoran();
                menuAdmin();
                break;
            case 3 :
                hapusRestoran();
                menuAdmin();
                break;
            case 4 :
                Main.menuLogin();
                break;
        }
    }

    public static void lihatRestoran(){
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        System.out.println("|| ================================================== ||");
        System.out.println("||                    List Restoran                   ||");
        System.out.println("|| ================================================== ||");
        for(int i = 0; i < ListRestoran.size(); i++){
            System.out.printf("|| [%d] %-30s \n||", (i + 1), ListRestoran.get(i).getNamaResto());
        }
        System.out.println("|| Pilih Restoran : ");
        pilihan = scanner.nextInt();
        Restoran restoran = ListRestoran.get(pilihan - 1);
        restoran.detailRestoran();
    }

    public static void tambahRestoran(){
        String namaResto;
        String alamatResto;
        Scanner scanner = new Scanner(System.in);

        System.out.println("|| ================================================== ||");
        System.out.println("||                    Tambah Restoran                 ||");
        System.out.println("|| ================================================== ||");
        System.out.print("|| Nama Restoran : ");
        namaResto = scanner.nextLine();
        System.out.print("|| Alamat Restoran : ");
        alamatResto = scanner.nextLine();
        ListRestoran.tambah(new Restoran(namaResto, alamatResto));
    }

    public static void hapusRestoran(){
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        lihatRestoran();
        System.out.println(" Pilih Restoran Untuk Dihapus : ");
        pilihan = scanner.nextInt();
        ListRestoran.hapus(pilihan - 1);
    }
}
