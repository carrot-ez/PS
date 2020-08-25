package Programmers;

import java.util.Arrays;

public class HIndex {
    public static void main(String args[]) {
        int citations[] = {3, 0, 6, 1, 5};

        int result = new HIndex().solution(citations);
        System.out.println(result);
    }

    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for(int i = 0; i< citations.length; i++) {
            // 답이 될 수 있는 가장 큰 수는 citations.length 이다.
            // i번째 원소에서 답이될 수 있는 가장 큰 수는 citations.length - i 이다.
            // 따라서 0 ~ citations.length - i 사이의 수 중 조건을 만족하는 가장 큰 수를 찾는다.
            // i번째 원소의 값이 citations.length - i 보다 크다면, H-Index = citations.length - i 이다.
            int tmp = Math.min(citations[i], citations.length - i);
            answer = Math.max(answer, tmp);
        }

        return answer;
    }
}
