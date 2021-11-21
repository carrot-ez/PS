package Programmers.level1;

public class 자릿수_더하기 {
    public int solution(int n) {

        int answer = 0;

        // to String
        String numberString = Integer.toString(n);

        // add each number
        for(char c : numberString.toCharArray()) {
            answer += c - '0';
        }

        return answer;
    }
}
