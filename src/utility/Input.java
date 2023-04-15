package utility;

import java.util.Scanner;

public class Input {
    public static String inputString(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    public static Integer inputInteger(){
        String input = inputString();

        if(input.isEmpty()){
            return -1;
        }

        for(int i = 0; i < input.length(); i++){
            if(!Character.isDigit(input.charAt(i))){
                return -1;
            }
        }

        return Integer.parseInt(input);
    }

    public static void inputSalah(){
        System.out.println("|| -------------------------------------------------- ||");
        System.out.println("||               Warning : Input Salah!               ||");
        System.out.println("|| -------------------------------------------------- ||");
    }
}
