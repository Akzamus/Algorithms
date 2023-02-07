package bitManipulation;

public class Task11 {

    // Given to string B and G. String B represents a binary code and string G represents a Gray Code.
    // You need to write a program which converts binary code to gray code and vice versa.

    public static void main(String[] args) {
        String bin = "0011";
        String grey = binToGrey(bin);
        System.out.println(greyToBin(grey).equals(bin));
    }

    private static String binToGrey(String B) {
        int b = Integer.parseInt(B, 2);
        String grey = Integer.toBinaryString(b ^ (b >> 1));
        return String.format("%1$" + B.length() + "s", grey).replace(' ', '0');
    }

    private static String greyToBin(String G) {
        int g = Integer.parseInt(G, 2);
        int res = g;

        while (g > 0) {
            g >>= 1;
            res ^= g;
        }

        String bin = Integer.toBinaryString(res);
        return String.format("%1$" + G.length() + "s", bin).replace(' ', '0');
    }
}
