package yandex.training3.warmup;

import java.util.Scanner;

public class ControlWork {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        final int N = in.nextInt();
        final int K = in.nextInt();
        int row = in.nextInt();
        int col = in.nextInt();

        in.close();

        int seat = (row - 1) * 2 + (col - 1);
        int deskNumber = seat / 2 + 1;

        int decSeat = seat - K;
        int incSeat = seat + K;

        int decDeskNumber = (decSeat / 2 + 1);
        int incDeskNumber = (incSeat / 2 + 1);

        String resultInc = incDeskNumber + " " + (incSeat % 2 == 0 ? 1 : 2);
        String resultDec = decDeskNumber + " " + (decSeat % 2 == 0 ? 1 : 2);

        if (decSeat < 0 && incSeat >= N) {
            System.out.println(-1);
            System.exit(0);
        }

        if (decSeat < 0 && incSeat < N) {
            System.out.println(resultInc);
            System.exit(0);
        }

        if (decSeat >= 0 && incSeat >= N) {
            System.out.println(resultDec);
            System.exit(0);
        }

        if (Math.abs(deskNumber - incDeskNumber) > Math.abs(deskNumber - decDeskNumber)) {
            System.out.println(resultDec);
        } else {
            System.out.println(resultInc);
        }
    }
}
