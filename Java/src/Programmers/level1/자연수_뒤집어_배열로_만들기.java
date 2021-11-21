package Programmers.level1;

public class 자연수_뒤집어_배열로_만들기 {
    public int[] solution(long n) {

        String numberString = Long.toString(n);
        int len = numberString.length();

        char[] chars = numberString.toCharArray();
        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {
            answer[i] = chars[len - i - 1] - '0';
        }

        return answer;
    }
}
