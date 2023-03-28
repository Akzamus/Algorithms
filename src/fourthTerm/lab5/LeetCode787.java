package fourthTerm.lab5;

import java.util.Arrays;

public class LeetCode787 {
    public int findCheapestPrice(final int N, int[][] flights, int src, int dst, final int K) {
        int[] prices = new int[N];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        for (int i = 0; i <= K; i++) {
            int[] temp = prices.clone();
            for (int[] flight : flights) {
                int current = flight[0], next = flight[1], price = flight[2];
                if (prices[current] == Integer.MAX_VALUE) continue;
                temp[next] = Math.min(temp[next], prices[current] + price);
            }
            prices = temp;
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
