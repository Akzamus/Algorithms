package fourthTerm.lab2;

public class LeetCode2424 {

}

class LUPrefix {

    private boolean[] arr;
    private int longest = 0;

    public LUPrefix(int n) {
        arr = new boolean[n];
    }

    public void upload(int video) {
        arr[video - 1] = true;
    }

    public int longest() {
        for (int i = longest; i < arr.length; i++) {
            if(arr[i]) longest++;
            else break;
        }
        return longest;
    }
}
