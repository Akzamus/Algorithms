package fourthTerm.Lab2;

import java.util.*;

public class LeetCode315 {

    public List<Integer> countSmaller(int[] nums) {
        LinkedList<Integer> result = new LinkedList<>();
        if(nums == null || nums.length == 0) return result;
        Node root = new Node(nums[nums.length - 1]);
        result.add(0);
        for(int i = nums.length - 2; i >= 0; i--){
            result.addFirst(insert(root, nums[i]));
        }
        return result;
    }

    private int insert(Node node, int val){
        if (val == node.val) {
            node.count ++;
            return node.leftCount;
        } else if (val < node.val) {
            node.leftCount++;
            if (node.left == null) {
                node.left = new Node(val);
                return 0;
            }
            return insert(node.left, val);
        } else {
            if (node.right == null) {
                node.right = new Node(val);
                return node.count + node.leftCount;
            }
            return node.count + node.leftCount + insert(node.right, val);
        }
    }
}

class Node {
    public int val;
    public int count;
    public int leftCount;
    public Node left, right;

    public Node(int val) {
        this.val = val;
        this.count = 1;
    }
}
