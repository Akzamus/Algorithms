package LAB3;

public class Task10 {

    public static void main(String[] args) {
        System.out.println(timeRequiredToBuy(new int[] {2, 3, 2}, 2));
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int seconds = 0;

        for (int i = 0; tickets[k] != 0; i++) {
            if (i == tickets.length) {
                i = 0;
            }
            if (tickets[i] != 0) {
                seconds++;
                tickets[i]--;
            }
        }
        return seconds;
    }
}
