package LAB3;

import java.util.ArrayList;

public class Task4 {

    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
    }

    public static int calPoints(String[] operations) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (String operation : operations) {
            switch (operation) {
                case "C" -> arr.remove(arr.size() - 1);
                case "D" -> arr.add(arr.get(arr.size() - 1) * 2);
                case "+" -> arr.add(arr.get(arr.size() - 1) + arr.get(arr.size() - 2));
                default -> arr.add(Integer.valueOf(operation));
            }
        }

        int sum = 0;
        for (int num : arr)
            sum += num;
        return sum;
    }
}
