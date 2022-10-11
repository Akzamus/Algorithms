package LAB4;

public class Task4 {

    public int maxProduct(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++)
            for (int j = 0; j < nums.length; j++)
                if(j != i)
                    max = Math.max((nums[i]-1)*(nums[j]-1), max);
        return max;
    }
}
