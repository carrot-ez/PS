package Programmers;

import java.util.Arrays;

public class 예산 {
    class Solution {
        public int solution(int[] d, int budget) {
            Arrays.sort(d);

            int answer = 0;
            for(int e : d) {
                budget -= e;
                if (budget < 0) break;
                answer += 1;
            }

            return answer;
        }
    }
}
