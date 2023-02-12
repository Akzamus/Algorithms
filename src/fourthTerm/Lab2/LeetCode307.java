package fourthTerm.Lab2;

public class LeetCode307 {

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 3, 5});
        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2));
    }
}

class NumArray {

    private final TreeNode root;

    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }

    public void update(int index, int val) {
        updateHelper(root, index, val);
    }

    public int sumRange(int i, int j) {
        return sumHelper(root, i, j);
    }

    private TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) return null;
        TreeNode res = new TreeNode(start, end);

        if (start == end) {
            res.sum = nums[start];
        } else {
            int mid = start + (end - start) / 2;
            res.left = buildTree(nums, start, mid);
            res.right = buildTree(nums, mid + 1, end);
            res.sum = res.left.sum + res.right.sum;
        }

        return res;
    }

    private void updateHelper(TreeNode root, int index, int val) {
        if (root.start == root.end) {
            root.sum = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;

            if (index <= mid) updateHelper(root.left, index, val);
            else updateHelper(root.right, index, val);

            root.sum = root.left.sum + root.right.sum;
        }
    }

    private int sumHelper(TreeNode root, int start, int end) {
        if (root.start == start && root.end == end) {
            return root.sum;
        } else {
            int mid = root.start + (root.end - root.start) / 2;

            if (end <= mid)            return sumHelper(root.left, start, end);
            else if (start >= mid + 1) return sumHelper(root.right, start , end);
            else                       return sumHelper(root.left, start, mid) + sumHelper(root.right, mid + 1, end);
        }
    }
}

class TreeNode {

    public int sum;
    public int start;
    public int end;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int s, int e) {
        this.start  = s;
        this.end    = e;
    }
}

