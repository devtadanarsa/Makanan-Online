import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * Fungsi menuLogin() :
     * Menerima input username(string) dan password(string) dari user melalui scanner.
     * Jika (username == admin && password == termosdingin) -> program berjalan melalui menuAdmin().
     * Selain itu -> program berjalan melalui menuCustomer().
     */
    public static void menuLogin(){
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
            Admin.menuAdmin();
        }else{

        }
    }

    public static void main(String[] args) {
        ListRestoran listRestoran = new ListRestoran();
        menuLogin();
    }
}
