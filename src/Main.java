import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * Array List ini berfungsi untuk menyimpan restoran yang dibuat saat berjalannya program.
     * Penambahan restoran terjadi pada fungsi tambahResto()
     */
    public static ArrayList <Restoran> listResto;

    /**
     * Fungsi menuLogin() :
     * Menerima input username(string) dan password(string) dari user melalui scanner.
     * Jika (username == admin && password == termosdingin) -> program berjalan melalui menuAdmin().
     * Selain itu -> program berjalan melalui menuCustomer().
     */
    public static void menuLogin(){
        listResto = new ArrayList<>();
        String username;
        String password;
        Scanner scanner = new Scanner(System.in);

        System.out.println("|| ================================================== ||");
        System.out.println("||                    Menu Login                      ||");
        System.out.println("|| ================================================== ||");
        System.out.print("|| Username : ");
        username = scanner.nextLine();
        System.out.print("|| Password : ");
        password = scanner.nextLine();

        if(username.equals("admin") && password.equals("termosdingin")){
            menuAdmin();
        }else{
            menuCustomer();
        }
    }

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
                lihatResto();
                menuAdmin();
                break;
            case 2 :
                tambahResto();
                menuAdmin();
                break;
            case 3 :
                hapusResto();
                menuAdmin();
                break;
            case 4 :
                menuLogin();
                break;
        }
    }

    public static void lihatResto(){
        System.out.println("|| ================================================== ||");
        System.out.println("||                     List Restoran                  ||");
        System.out.println("|| ================================================== ||");
        for(int i = 0; i < listResto.size(); i++){
            System.out.printf("|| [%d] %s\n", (i + 1), listResto.get(i).getNamaResto());
        }
        System.out.println("|| ================================================== ||");
    }

    public static void tambahResto(){
        String namaResto;
        String alamatResto;
        Scanner scanner = new Scanner(System.in);

        System.out.println("|| ================================================== ||");
        System.out.println("||                 Tambah Restoran Baru               ||");
        System.out.println("|| ================================================== ||");
        System.out.print("|| Nama Restoran : ");
        namaResto = scanner.nextLine();
        System.out.print("|| Alamat Restoran : ");
        alamatResto = scanner.nextLine();

        listResto.add(new Restoran(namaResto, alamatResto));
    }

    public static void hapusResto(){
        int pilihan;
        Scanner scanner = new Scanner(System.in);
        System.out.println("|| ================================================== ||");
        System.out.println("||                    Hapus Restoran                  ||");
        System.out.println("|| ================================================== ||");
        for(int i = 0; i < listResto.size(); i++){
            System.out.printf("|| [%d] %s\n", (i + 1), listResto.get(i).getNamaResto());
        }
        System.out.println("|| ================================================== ||");
        System.out.print("|| Pilih Restoran : ");
        pilihan = scanner.nextInt() - 1;
        listResto.remove(pilihan);
    }


    public static void menuCustomer(){
        System.out.println("1. Buat Pesanan");
        System.out.println("2. Lihat Pesanan");
        System.out.println("3. Kembali ke login");
    }

    public static void main(String[] args) {
        menuLogin();
    }
}
