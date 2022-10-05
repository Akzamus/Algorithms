package LAB3;

import java.util.ArrayList;
import java.util.List;

public class Task9 {

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] arrOfNumbersOfPeopleWhoFoundSecretOnParticularDay = new long[n + 1];
        long mod = (long)1e9 + 7;
        long numberOfPeopleSharingSecret = 0;
        long result = 0;

        arrOfNumbersOfPeopleWhoFoundSecretOnParticularDay[1] = 1;

        for (int i = 2; i <= n; i++) {
            long numberOfNewPeopleSharingSecret = arrOfNumbersOfPeopleWhoFoundSecretOnParticularDay[Math.max(i - delay, 0)];
            long numberOfPeopleForgettingSecret = arrOfNumbersOfPeopleWhoFoundSecretOnParticularDay[Math.max(i - forget, 0)];
            numberOfPeopleSharingSecret += (numberOfNewPeopleSharingSecret  - numberOfPeopleForgettingSecret + mod) % mod;
            arrOfNumbersOfPeopleWhoFoundSecretOnParticularDay[i] = numberOfPeopleSharingSecret;
        }

        for (int i = n - forget + 1; i <= n; i++) {
            result = (result + arrOfNumbersOfPeopleWhoFoundSecretOnParticularDay[i]) % mod;
        }
        return (int)result;
    }
}
