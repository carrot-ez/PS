package Programmers.level1;

import java.util.Arrays;

public class 나누어_떨어지는_숫자_배열 {

    public int[] solution(int[] arr, int divisor) {

        int[] answer = Arrays.stream(arr)
                .filter(e -> e % divisor == 0)
                .sorted()
                .toArray();

        return answer.length == 0 ? new int[]{-1} : answer;
    }
}
