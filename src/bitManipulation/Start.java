package bitManipulation;

public class Start {

    public static void main(String[] args) {
        int x = 3, y = 6;
        //             x      = 0011
        //             y      = 0110
        // AND         x & y  = 0010 => 2
        // OR          x | y  = 0111 => 7
        // XOR         x ^ y  = 0101 => 5
        // left shift  x << 1 = 0110 => 6
        // right shift x >> 1 = 0001 => 1
        System.out.println("x = " + x + ", y = " + y);
        System.out.println("AND x &  y: " + (x & y));
        System.out.println("OR  x |  y: " + (x | y));
        System.out.println("XOR x ^  y: " + (x ^ y));
        System.out.println("LS  x << 1: " + (x << 1));
        System.out.println("RS  x >> 1: " + (x >> 1));
    }
}


