import utility.Input;
import utility.Other;

import java.util.List;
import java.util.Scanner;

public class Admin {

    /**
     * Fungsi menuLogin() :
     * Menerima input username(string) dan password(string) dari user melalui scanner.
     * Jika (username == admin && password == termosdingin) -> program berjalan melalui menuAdmin().
     * Selain itu -> program berjalan melalui introCustomer().
     */
    public static void menuLogin(){
        Other.clearScreen();
        System.out.println("|| ================================================== ||");
        System.out.println("||                    Menu Login                      ||");
        System.out.println("|| ================================================== ||");
        System.out.print("|| Username : ");
        String username = Input.inputString();
        System.out.print("|| Password : ");
        String password = Input.inputString();

        if(username.equals("admin") && password.equals("termosdingin")){
            Admin.menuAdmin();
        }else{
            Customer customer = new Customer();
            customer.introCustomer();
        }
    }

    /**
     * Fungsi untuk menentukan aksi dari admin.
     * Input : pilihan(Integer)
     */
    public static void menuAdmin(){
        Other.clearScreen();
        System.out.println("|| ================================================== ||");
        System.out.println("||                      Menu Admin                    ||");
        System.out.println("|| ================================================== ||");
        System.out.println("|| [1] Lihat Restoran                                 ||");
        System.out.println("|| [2] Tambah Restoran                                ||");
        System.out.println("|| [3] Hapus Restoran                                 ||");
        System.out.println("|| [4] Kembali ke login                               ||");
        System.out.println("|| [5] Keluar dari Program                            ||");
        System.out.println("|| ================================================== ||");
        System.out.print("|| Masukkan pilihan anda : ");

        Integer pilihan = Input.inputInteger();
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
                Admin.menuLogin();
                break;
            case 5 :
                System.exit(0);
                break;
            default :
                Input.inputSalah();
                Other.pressEnter();
                menuAdmin();
        }
    }

    /**
     * Fungsi untuk melihat daftar restoran admin.
     * Pada fungsi ini, admin dapat melihat detail restoran sesuai dengan pilihannya.
     */
    public static void lihatRestoran(){
        Other.clearScreen();
        if(ListRestoran.isEmpty()){
            System.out.println("|| ================================================== ||");
            System.out.println("||                 Tidak ada Restoran                 ||");
            System.out.println("||                    Yang Tersedia                   ||");
            System.out.println("|| ================================================== ||");
            Other.pressEnter();
        }else{
            System.out.println("|| ================================================== ||");
            System.out.println("||                    List Restoran                   ||");
            System.out.println("|| ================================================== ||");
            for (int i = 0; i < ListRestoran.size(); i++) {
                System.out.printf("|| [%d] %-46s ||\n", (i + 1), ListRestoran.get(i).getNamaResto());
            }
            System.out.println("|| [0] Kembali ke Menu Admin                          ||");
            System.out.println("|| ================================================== ||");
            System.out.print("|| Pilih Restoran : ");
            Integer pilihanRestoran = Input.inputInteger();

            if(pilihanRestoran == 0){
                menuAdmin();
            }else if(pilihanRestoran < 0 || pilihanRestoran > ListRestoran.size()){
                System.out.println("|| ================================================== ||");
                System.out.println("||               Restoran Tidak Ditemukan             ||");
                System.out.println("|| ================================================== ||");
                Other.pressEnter();
            }else{
                Restoran restoran = ListRestoran.get(pilihanRestoran - 1);
                restoran.detailRestoran();

                System.out.println("|| [1] Tambah Menu                                    ||");
                System.out.println("|| [2] Kembali ke Menu Admin                          ||");
                System.out.print("|| Pilihan Anda : ");
                Integer pilihanLanjutan = Input.inputInteger();

                switch (pilihanLanjutan){
                    case 1 :
                        restoran.tambahMenu();
                        lihatRestoran();
                        break;
                    case 2 :
                        menuAdmin();
                        break;
                    default :
                        Input.inputSalah();
                        Other.pressEnter();
                        lihatRestoran();
                        break;
                }
            }
        }
    }

    /**
     * Fungsi untuk menambah restoran yang dimiliki admin.
     * Input : namaRestoran(String), pilihanAlamat(Integer).
     */
    public static void tambahRestoran(){
        Other.clearScreen();
        System.out.println("|| ================================================== ||");
        System.out.println("||                    Tambah Restoran                 ||");
        System.out.println("|| ================================================== ||");
        System.out.print("|| Nama Restoran : ");
        String namaResto = Input.inputString();
        System.out.print("|| Lokasi Restoran : ");
        String alamatResto = Input.inputString();
        ListRestoran.tambah(new Restoran(namaResto, alamatResto));
    }

    /**
     * Fungsi untuk menghapus restoran admin.
     * Input : pilihanRestoran(Integer).
     */
    public static void hapusRestoran(){
        Other.clearScreen();
        if(ListRestoran.isEmpty()){
            System.out.println("|| ================================================== ||");
            System.out.println("||                 Tidak ada Restoran                 ||");
            System.out.println("||                    Yang Tersedia                   ||");
            System.out.println("|| ================================================== ||");
            Other.pressEnter();
        }else{
            System.out.println("|| ================================================== ||");
            System.out.println("||                    List Restoran                   ||");
            System.out.println("|| ================================================== ||");
            for (int i = 0; i < ListRestoran.size(); i++) {
                System.out.printf("|| [%d] %-46s ||\n", (i + 1), ListRestoran.get(i).getNamaResto());
            }
            System.out.println("|| [0] Kembali ke Menu Admin                          ||");
            System.out.println("|| ================================================== ||");
            System.out.print("|| Pilih Restoran Untuk Dihapus : ");
            Integer pilihanRestoran = Input.inputInteger();
            if(pilihanRestoran == 0){
                menuAdmin();
            }else if(pilihanRestoran < 0 || pilihanRestoran > ListRestoran.size()){
                System.out.println("|| ================================================== ||");
                System.out.println("||               Restoran Tidak Ditemukan             ||");
                System.out.println("|| ================================================== ||");
                Other.pressEnter();
            }
            ListRestoran.hapus(pilihanRestoran - 1);
        }
    }
}
