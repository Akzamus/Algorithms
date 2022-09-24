package LAB1;

public class Task8 {

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "sipp"));
    }

    public static int strStr(String haystack, String needle) {
        char[] chars = haystack.toCharArray();
        char[] target = needle.toCharArray();
        boolean flag = false;

        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == target[0]) {
                if (i + target.length > chars.length) return -1;
                for (int j = i, k = 0; j < chars.length && k < target.length; j++, k++) {
                    flag = chars[j] == target[k];
                    if(!flag) break;
                }
                if(flag) return i;
            }
        }
        return -1;
    }
}
