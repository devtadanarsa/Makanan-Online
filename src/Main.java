import java.util.Scanner;

public class Main {
    public static void loginMenu(){
        String username;
        String password;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Username : ");
        username = scanner.nextLine();
        System.out.print("Password : ");
        password = scanner.nextLine();

        if(username == "admin" && password == "termosdingin"){
            menuAdmin();
        }else{
            menuCustomer();
        }
    }

    public static void menuAdmin(){
        System.out.println("1. Lihat Restoran");
        System.out.println("2. Tambah Restoran");
        System.out.println("3. Hapus Restoran");
        System.out.println("4. Kembali ke login");

    }

    public static void menuCustomer(){
        System.out.println("1. Buat Pesanan");
        System.out.println("2. Lihat Pesanan");
        System.out.println("3. Kembali ke login");
    }

    public static void main(String[] args) {
        loginMenu();
    }
}
