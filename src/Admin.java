import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    private ArrayList <Restoran> listResto;

    public Admin(){
        listResto = new ArrayList<>();
    }

    public void lihatRestoran(){
        System.out.println("|| ================================================== ||");
        System.out.println("||                    List Restoran                   ||");
        System.out.println("|| ================================================== ||");
        for(int i = 0; i < listResto.size(); i++){
            System.out.printf("|| [%d] %s ||", (i + 1), listResto.get(i).getNamaResto());
        }
    }

    public void tambahRestoran(){
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
        listResto.add(new Restoran(namaResto, alamatResto));
    }
}
