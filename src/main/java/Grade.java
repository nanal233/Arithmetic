import java.util.Scanner;

public class Grade {

    public static  boolean Equals(String  str1){
        boolean isRight = false;
        Scanner input  = new Scanner(System.in);
        String str = input.next();
        isRight = str.equals(str1);
        return isRight;
    }


}
