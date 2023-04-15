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

}
