package utility;
import java.util.Random;

public class Other {
    public static void pressEnter(){
        String input = Input.inputString();
    }

    public static Integer randomNumber(Integer lowerBound, Integer upperBound){
        Random random = new Random();
        Integer result = (random.nextInt(upperBound - lowerBound) + lowerBound);
        return result.intValue();
    }

    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
