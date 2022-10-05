package LAB2;

public class Task2 {
    public static void main(String[] args) {
        cycle(100);
        cycle(10_000);
        cycle(100_000);
        cycle(1_000_000);
    }

    public static void cycle(int n) {
        long sum = 0;
        long start = System.currentTimeMillis();

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                sum += i + j;

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
