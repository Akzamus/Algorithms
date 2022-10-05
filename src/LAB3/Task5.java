package LAB3;

public class Task5 {

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
    }

    public static boolean backspaceCompare(String s, String t) {
        return getResStack(s).equals(getResStack(t));
    }

    public static String getResStack(String s) {
        String result = "";

        for (char c : s.toCharArray()) {
            if (c == '#'){
                if (result.length() > 0)
                    result = result.substring(0, result.length() - 1);
            } else {
                result += c;
            }
        }
        System.out.println(result);
        return result;
    }
}
