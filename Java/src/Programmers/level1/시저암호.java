package Programmers.level1;

public class 시저암호 {

    public static void main(String[] args) {
        System.out.println((char) ('Z' + 1));
    }

    public String solution(String s, int n) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') continue;
            chars[i] = add(chars[i], n);
        }

        return new String(chars);
    }

    public char add(char c, int n) {

        boolean isLowerCase = Character.isLowerCase(c);

        if (isLowerCase) {
            c = (char) (c + n);
            if (c > 'z') {
                c = (char) (c - 'z' + 'a' - 1);
            }
        } else {
            c = (char) (c + n);
            if (c > 'Z') {
                c = (char) (c - 'Z' + 'A' - 1);
            }
        }
        return c;
    }
}
