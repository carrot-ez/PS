package Programmers.level1;

public class 이상한_문자_만들기 {
    public String solution(String s) {

        char[] chars = s.toCharArray();
        int counter = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                counter = 0;
                continue;
            }

            if (counter % 2 == 0) {
                chars[i] = Character.toUpperCase(chars[i]);
            }
            else {
                chars[i] = Character.toLowerCase(chars[i]);
            }
            counter += 1;
        }

        return new String(chars);
    }
}
