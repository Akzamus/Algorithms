package LAB1;

public class Task3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord(" 12345   "));
    }

    public static int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int start = chars.length - 1;
        boolean flag = chars[start] == ' ';
        int count = 0;

        for(int i = start; i >= 0; i--) {
            if(flag) {
                if(chars[i] != ' ') {
                    flag = false;
                    count++;
                }
            } else {
                if(chars[i] == ' ')
                    return count;
                count++;
            }
        }

        if(count == 0) return -1;
        else           return count;
    }
}
