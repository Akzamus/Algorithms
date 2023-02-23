package yandex.training3.queue;

import java.util.*;

public class DrunkardGame {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue<Integer> playerOne = new LinkedList<>();
        Queue<Integer> playerTwo = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            playerOne.add(in.nextInt());
        }

        for (int i = 0; i < 5; i++) {
            playerTwo.add(in.nextInt());
        }

        in.close();

        int round = 0;
        while (!playerOne.isEmpty() && !playerTwo.isEmpty()) {
            int card1 = playerOne.poll();
            int card2 = playerTwo.poll();
            round++;

            if (card1 == 0 && card2 == 9) {
                playerOne.add(card1);
                playerOne.add(card2);
            } else if (card2 == 0 && card1 == 9) {
                playerTwo.add(card1);
                playerTwo.add(card2);
            } else if (card1 > card2) {
                playerOne.add(card1);
                playerOne.add(card2);
            } else {
                playerTwo.add(card1);
                playerTwo.add(card2);
            }

            if (round > 1_000_000) {
                System.out.println("botva");
                return;
            }
        }

        System.out.println(
                (playerOne.isEmpty() ? "second " : "first ") + round
        );
    }
}
