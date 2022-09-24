package codewars1;

public class Code5 {
    public static void main(String[] args) {
        String str = "isIsogram";
        boolean result = true;
        for(int i = 0; i < str.length(); i++){
            String capitalLetter = String.valueOf(str.charAt(i)).toUpperCase();
            String smallLetter = String.valueOf(str.charAt(i)).toLowerCase();
            if(str.indexOf(capitalLetter) != str.lastIndexOf(capitalLetter) ||
               str.indexOf(smallLetter)!= str.lastIndexOf(smallLetter) ||
               str.contains(capitalLetter) && str.contains(smallLetter))
            {
                result = false;
                break;
            }
        }
        System.out.println(result);
    }
}
