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
        System.out.println("|| [5] Keluar dari Program                            ||");
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
            case 5 :
                System.exit(0);
                break;
        }
    }

    public static void lihatRestoran(){
        if(ListRestoran.isEmpty()){
            System.out.println("|| ================================================== ||");
            System.out.println("||                 Restoran Tidak Ditemukan           ||");
            System.out.println("|| ================================================== ||");
        }else {
            Scanner scanner = new Scanner(System.in);
            int pilihan;

            System.out.println("|| ================================================== ||");
            System.out.println("||                    List Restoran                   ||");
            System.out.println("|| ================================================== ||");
            for (int i = 0; i < ListRestoran.size(); i++) {
                System.out.printf("|| [%d] %-46s ||\n", (i + 1), ListRestoran.get(i).getNamaResto());
            }
            System.out.println("|| ================================================== ||");
            System.out.print("|| Pilih Restoran : ");
            pilihan = scanner.nextInt();
            Restoran restoran = ListRestoran.get(pilihan - 1);
            restoran.detailRestoran();

            System.out.println("|| [1] Tambah Menu                                    ||");
            System.out.println("|| [2] Kembali ke Menu Admin                          ||");
            System.out.print("|| Pilihan Anda : ");
            pilihan = scanner.nextInt();

            switch (pilihan){
                case 1 :
                    restoran.tambahMenu();
                    lihatRestoran();
                    break;
                case 2 :
                    Admin.menuAdmin();
                    break;
            }

        }
    }

    public static void tambahRestoran(){
        String namaResto;
        int pilihanAlamat;
        Scanner scanner = new Scanner(System.in);

        System.out.println("|| ================================================== ||");
        System.out.println("||                    Tambah Restoran                 ||");
        System.out.println("|| ================================================== ||");
        System.out.print("|| Nama Restoran : ");
        namaResto = scanner.nextLine();
        System.out.println("|| -------------------------------------------------- ||");
        System.out.println("||                Pilihan Alamat Restoran             ||");
        System.out.println("|| -------------------------------------------------- ||");
        System.out.println("|| [1] Denpasar              [6] Bangli               ||");
        System.out.println("|| [2] Gianyar               [7] Jembrana             ||");
        System.out.println("|| [3] Badung                [8] Negara               ||");
        System.out.println("|| [4] Klungkung             [9] Buleleng             ||");
        System.out.println("|| [5] Karangasem                                     ||");
        System.out.print("|| Pilihan Alamat Restoran : ");
        pilihanAlamat = scanner.nextInt();
        switch (pilihanAlamat){
            case 1 :
                ListRestoran.tambah(new Restoran(namaResto, "Denpasar"));
                break;
            case 2 :
                ListRestoran.tambah(new Restoran(namaResto, "Gianyar"));
                break;
            case 3 :
                ListRestoran.tambah(new Restoran(namaResto, "Badung"));
                break;
            case 4 :
                ListRestoran.tambah(new Restoran(namaResto, "Klungkung"));
                break;
            case 5 :
                ListRestoran.tambah(new Restoran(namaResto, "Karangasem"));
                break;
            case 6 :
                ListRestoran.tambah(new Restoran(namaResto, "Bangli"));
                break;
            case 7 :
                ListRestoran.tambah(new Restoran(namaResto, "Jembrana"));
                break;
            case 8 :
                ListRestoran.tambah(new Restoran(namaResto, "Negara"));
                break;
            case 9 :
                ListRestoran.tambah(new Restoran(namaResto, "Buleleng"));
                break;
        }
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
