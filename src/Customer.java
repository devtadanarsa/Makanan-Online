import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
    private ArrayList <Makanan> listPesanan;
    private ArrayList <Integer> jumlahPesanan;

    public Customer(){
        listPesanan = new ArrayList<>();
        jumlahPesanan = new ArrayList<>();
    }

    private Makanan getPesanan(int index){
        return listPesanan.get(index);
    }

    private Integer getJumlahPesanan(int index){
        return jumlahPesanan.get(index);
    }

    public void menuCustomer(Customer customer){
        int pilihan;
        Scanner scanner = new Scanner(System.in);
        System.out.println("|| ================================================== ||");
        System.out.println("||                     Menu Customer                  ||");
        System.out.println("|| ================================================== ||");
        System.out.println("|| [1] Buat Pesanan                                   ||");
        System.out.println("|| [2] Kembali ke Login                               ||");
        System.out.println("|| [3] Keluar Program                                 ||");
        System.out.println("|| ================================================== ||");
        System.out.print("|| Pilihan Anda : ");
        pilihan = scanner.nextInt();

        switch (pilihan){
            case 1 :
                buatPesanan(customer);
                menuCustomer(customer);
                break;
            case 2 :
                Main.menuLogin();
                break;
            case 3 :
                System.exit(0);
                break;
        }

    }

    public void buatPesananLoop(Customer customer, Restoran restoran){
        int pilihan;
        int inputJumlah;
        Scanner scanner = new Scanner(System.in);

        restoran.lihatMenu();
        System.out.print("|| Pilihan Anda : ");
        pilihan = scanner.nextInt();
        System.out.print("|| Jumlah : ");
        inputJumlah = scanner.nextInt();

        listPesanan.add(restoran.getMenu(pilihan - 1));
        jumlahPesanan.add(inputJumlah);

        System.out.println("|| ================================================== ||");
        System.out.println("|| [1] Tambah Pesanan                                 ||");
        System.out.println("|| [2] Checkout                                       ||");
        System.out.print("|| Pilihan Anda : ");
        pilihan = scanner.nextInt();
        switch (pilihan){
            case 1 :
                buatPesananLoop(customer, restoran);
                break;
            case 2 :
                checkoutPesanan(customer, restoran);
                break;

        }
    }

    public void checkoutPesanan(Customer customer, Restoran restoran){
        Integer totalHarga = 0;
        for(int i = 0; i < listPesanan.size(); i++){
            totalHarga += listPesanan.get(i).getHarga() * jumlahPesanan.get(i).intValue();
        }

        System.out.println("|| ================================================== ||");
        System.out.println("||                         BILL                       ||");
        System.out.println("|| ---------------------------------------------------||");
        System.out.println("||                    Data Restoran                   ||");
        System.out.printf("|| Nama Restoran : %-34s ||\n", restoran.getNamaResto());
        System.out.printf("|| Lokasi : %-41s ||\n", (restoran.getAlamatResto() + ", Bali"));
        System.out.println("|| ================================================== ||");
        System.out.println("||        Nama Menu          |  Qty  |     Harga      ||");
        System.out.println("|| -------------------------------------------------- ||");
        for(int i = 0; i < listPesanan.size(); i++){
            System.out.printf("|| %-25s |   %d   | Rp. %-10s ||\n", listPesanan.get(i).getNamaMakanan(), jumlahPesanan.get(i).intValue(), jumlahPesanan.get(i).intValue() * listPesanan.get(i).getHarga());
        }
        System.out.println("|| -------------------------------------------------- ||");
        System.out.printf("||            Total          |      Rp. %-11s ||\n", totalHarga.intValue());
        System.out.println("|| ================================================== ||");
        System.out.println("||                      Tekan Enter                   ||");
        System.out.println("||              Untuk Menyelesaikan Pesanan           ||");
        System.out.println("|| ================================================== ||");
    }

    public void buatPesanan(Customer customer){
        int pilihan;

        Scanner scanner = new Scanner(System.in);
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
        buatPesananLoop(customer, restoran);

    }
}
