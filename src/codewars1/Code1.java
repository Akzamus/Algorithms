package codewars1;

import java.util.Scanner;

public class Code1 {

    public static void main(String[] args){
        try {
            Scanner in = new Scanner(System.in);
            String phrase = in.nextLine();
            StringBuilder result = new StringBuilder();
            for (String word : phrase.split(" ")){
                result.append(word.substring(0,1).toUpperCase()).append(word.substring(1)).append(" ");
            }
            System.out.println(result);
        }catch (Exception ignored){}
    }
}
