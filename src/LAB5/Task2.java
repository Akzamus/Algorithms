package LAB5;

public class Task2 {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
            if (fast == 1) return true;
        } while (slow != fast);

        return false;
    }

    private int getNext(int n) {
        int res = 0;
        for (;n != 0; n /= 10)
            res += Math.pow(n % 10, 2);
        return res;
    }
}
