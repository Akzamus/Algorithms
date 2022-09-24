package codewars1;

public class Code3 {
    public static void main(String[] args){
        String s = "";
        if(s.length() % 2 != 0)
            s += "_";
        String[] arr = new String[s.length()/2];
        for(int i = 0, j = 0; i < arr.length; i++, j += 2)
            arr[i] = s.charAt(j) + s.charAt(j+1)+"";
    }
}
