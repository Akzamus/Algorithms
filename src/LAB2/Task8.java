package LAB2;

public class Task8 {

    public static boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode temp = head;

        while (temp != null) {
            temp = temp.next;
            len++;
        }

        int[] arr = new int[len];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = head.val;
            head = head.next;
        }

        for (int i = 0, j = len - 1; i < len / 2; i++, j--)
            if(arr[i] != arr[j])
                return false;

        return true;
    }
}
