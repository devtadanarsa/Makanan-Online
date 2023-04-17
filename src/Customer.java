import utility.Input;
import utility.Other;

import java.util.ArrayList;

public class Customer {
    private ArrayList <Menu> listPesanan;
    private ArrayList <Integer> jumlahPesanan;
    private String namaCustomer;
    private String alamatCustomer;

    public Customer(){
        listPesanan = new ArrayList<>();
        jumlahPesanan = new ArrayList<>();
    }

    //Getter dan Setter
    private void setNamaCustomer(String namaCustomer) {this.namaCustomer = namaCustomer;}
    public String getNamaCustomer() {return namaCustomer;}
    public void setAlamatCustomer(String alamatCustomer) {this.alamatCustomer = alamatCustomer;}
    public String getAlamatCustomer() {return alamatCustomer;}

    /**
     * Fungsi untuk mendapatkan nama dan lokasi dari customer.
     * Fungsi ini hanya akan dipanggil sekali, yaitu sesaat setelah login menjadi user.
     */
    public void introCustomer(){
        Other.clearScreen();
        System.out.println("|| ================================================== ||");
        System.out.println("||                   BIODATA CUSTOMER                 ||");
        System.out.println("|| ================================================== ||");
        System.out.print("|| Nama : ");
        String namaCustomer = Input.inputString();
        setNamaCustomer(namaCustomer);
        System.out.print("|| Domisili : ");
        String alamatCustomer = Input.inputString();
        setAlamatCustomer(alamatCustomer);
        menuCustomer();
    }

    /**
     * Fungsi untuk menampilkan menu customer.
     * Fungsi ini akan melanjutkan program sesuai dengan aksi yang dipilih oleh customer.
     */
    public void menuCustomer(){
        Other.clearScreen();
        System.out.println("|| ================================================== ||");
        System.out.println("||                     MENU CUSTOMER                  ||");
        System.out.println("|| ================================================== ||");
        System.out.println("|| [1] Buat Pesanan                                   ||");
        System.out.println("|| [2] Kembali ke Login                               ||");
        System.out.println("|| [3] Keluar Program                                 ||");
        System.out.println("|| ================================================== ||");
        System.out.print("|| Pilihan Anda : ");
        Integer pilihan = Input.inputInteger();

        switch (pilihan){
            case 1 :
                buatPesanan();
                menuCustomer();
                break;
            case 2 :
                Admin.menuLogin();
                break;
            case 3 :
                System.exit(0);
                break;
            default :
                Input.inputSalah();
                Other.pressEnter();
                menuCustomer();
                break;
        }

    }

    /**
     * Fungsi untuk membuat sebuah pesanan.
     */
    public void buatPesanan(){
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
            System.out.println("|| [0] Kembali ke Menu Customer                       ||");
            System.out.println("|| ================================================== ||");
            System.out.print("|| Pilih Restoran : ");
            Integer pilihan = Input.inputInteger();

            if(pilihan == 0){
                menuCustomer();
                Other.pressEnter();
            }else if(pilihan < 0 || pilihan > ListRestoran.size()){
                System.out.println("|| ================================================== ||");
                System.out.println("||               Restoran Tidak Ditemukan             ||");
                System.out.println("|| ================================================== ||");
                Other.pressEnter();
            }else{
                Restoran restoran = ListRestoran.get(pilihan - 1);
                buatPesananLoop(restoran);
            }
        }
    }

    /**
     * Fungsi untuk menambah pesanan yang telah dibuat.
     * Fungsi ini dipanggil pada fungsi buatPesanan().
     * @param restoran
     */
    public void buatPesananLoop(Restoran restoran){
        Other.clearScreen();
        if(restoran.jumlahMenu() == 0){
            System.out.println("|| ================================================== ||");
            System.out.println("||               Tidak ada Pilihan Menu               ||");
            System.out.println("||                   Yang Tersedia                    ||");
            System.out.println("|| ================================================== ||");
            Other.pressEnter();
            buatPesanan();
        }else{
            restoran.lihatMenu();
            System.out.print("|| Pilihan Anda : ");
            Integer pilihan = Input.inputInteger();
            System.out.print("|| Jumlah : ");
            Integer inputJumlah = Input.inputInteger();

            listPesanan.add(restoran.getMenu(pilihan - 1));
            jumlahPesanan.add(inputJumlah);

            System.out.println("|| ================================================== ||");
            System.out.println("|| [1] Tambah Pesanan                                 ||");
            System.out.println("|| [2] Checkout                                       ||");
            System.out.print("|| Pilihan Anda : ");
            Integer pilihanLanjutan = Input.inputInteger();
            switch (pilihanLanjutan){
                case 1 :
                    buatPesananLoop(restoran);
                    break;
                case 2 :
                    checkoutPesanan(restoran);
                    break;

            }
        }
    }

    /**
     * Fungsi untuk melakukan checkout bagi customer.
     * Tampilan : data restoran (nama restoran, lokasi), pesanan, harga.
     * @param restoran
     */
    public void checkoutPesanan(Restoran restoran){
        Other.clearScreen();
        Integer totalHarga = 0;
        Integer ongkosKirim = jarakCustomerRestoran(this, restoran) * 370;
        for(int i = 0; i < listPesanan.size(); i++){
            totalHarga += listPesanan.get(i).getHarga() * jumlahPesanan.get(i).intValue();
        }

        System.out.println("|| ================================================== ||");
        System.out.println("||                         BILL                       ||");
        System.out.println("|| ---------------------------------------------------||");
        System.out.println("||                    Data Restoran                   ||");
        System.out.printf("|| Nama Restoran : %-34s ||\n", restoran.getNamaResto());
        System.out.printf("|| Id Restoran : 00%-34d ||\n", restoran.getIdRestoran());
        System.out.printf("|| Lokasi : %-41s ||\n", (restoran.getAlamatResto() + ", Bali"));
        System.out.println("|| ================================================== ||");
        System.out.println("||        Nama Menu          |  Qty  |     Harga      ||");
        System.out.println("|| -------------------------------------------------- ||");
        for(int i = 0; i < listPesanan.size(); i++){
            System.out.printf("|| %-25s |   %d   | Rp. %-10s ||\n", listPesanan.get(i).getNamaMenu(), jumlahPesanan.get(i).intValue(), jumlahPesanan.get(i).intValue() * listPesanan.get(i).getHarga());
        }
        System.out.printf("|| %-25s |   %d   | Rp. %-10s ||\n", "Ongkos Kirim", 1, ongkosKirim);
        System.out.println("|| -------------------------------------------------- ||");
        System.out.printf("||            Total          |      Rp. %-13s ||\n", totalHarga + ongkosKirim);
        System.out.println("|| ================================================== ||");
        System.out.println("||                      Tekan Enter                   ||");
        System.out.println("||              Untuk Menyelesaikan Pesanan           ||");
        System.out.println("|| ================================================== ||");
        Other.pressEnter();
    }

    /**
     * Fungsi untuk menentukan jarak antara customer dan restoran.
     * @param customer
     * @param restoran
     * @return
     */
    public Integer jarakCustomerRestoran(Customer customer, Restoran restoran){
        if(customer.getAlamatCustomer().equals(restoran.getAlamatResto())){
            return Other.randomNumber(0, 10);
        }else{
            Integer skalaJarakCustomer;
            Integer skalaJarakRestoran;

            switch (customer.getAlamatCustomer()){
                case "Klungkung" :
                    skalaJarakCustomer = 0;
                    break;
                case "Badung" :
                    skalaJarakCustomer = 1;
                    break;
                case "Denpasar" :
                    skalaJarakCustomer = 2;
                    break;
                case "Gianyar" :
                    skalaJarakCustomer = 3;
                    break;
                case "Jembrana" :
                    skalaJarakCustomer = 4;
                    break;
                case "Bangli" :
                    skalaJarakCustomer = 5;
                    break;
                case "Negara" :
                    skalaJarakCustomer = 6;
                    break;
                case "Karangasem" :
                    skalaJarakCustomer = 7;
                    break;
                default :
                    skalaJarakCustomer = 8;
                    break;
            }

            switch (restoran.getAlamatResto()){
                case "Klungkung" :
                    skalaJarakRestoran = 0;
                    break;
                case "Badung" :
                    skalaJarakRestoran = 1;
                    break;
                case "Denpasar" :
                    skalaJarakRestoran = 2;
                    break;
                case "Gianyar" :
                    skalaJarakRestoran = 3;
                    break;
                case "Jembrana" :
                    skalaJarakRestoran = 4;
                    break;
                case "Bangli" :
                    skalaJarakRestoran = 5;
                    break;
                case "Negara" :
                    skalaJarakRestoran = 6;
                    break;
                case "Karangasem" :
                    skalaJarakRestoran = 7;
                    break;
                default :
                    skalaJarakRestoran = 8;
                    break;
            }

            Integer perbedaanJarak = Math.abs(skalaJarakCustomer - skalaJarakRestoran);
            return (Other.randomNumber((perbedaanJarak * 10), (perbedaanJarak * 10 + 10)));
        }
    }
}
