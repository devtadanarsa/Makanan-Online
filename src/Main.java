import utility.Input;

public class Main {
    /**
     * Fungsi menuLogin() :
     * Menerima input username(string) dan password(string) dari user melalui scanner.
     * Jika (username == admin && password == termosdingin) -> program berjalan melalui menuAdmin().
     * Selain itu -> program berjalan melalui introCustomer().
     */
    public static void menuLogin(){
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
            customer.introCustomer(customer);
        }
    }

    public static void main(String[] args) {
        ListRestoran listRestoran = new ListRestoran();
        menuLogin();
    }
}
