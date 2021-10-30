package etc;

public class ReverseString {

    public static void main(String[] args) {
        String s = "abcefg";
        System.out.println("reverseString(s) = " + reverseString(s));
    }

    public static String reverseString(String s) {

        if (s.length() == 1) {
            return s;
        }

        int len = s.length();
        int mid = (len + 1) / 2;

        return reverseString(s.substring(mid, len)) + reverseString(s.substring(0, mid));
    }
}
