package Programmers;

import java.util.HashSet;
import java.util.Set;

public class 약수의_개수와_덧셈 {

    class Solution {

        int[] numDivisor;
        public int solution(int left, int right) {

            numDivisor = new int[right + 1];
            calcDivisor(left, right);

            int answer = 0;
            for (int i = left; i < right + 1; i++) {
                if (numDivisor[i] % 2 == 0) {
                    answer += i;
                } else {
                    answer -= i;
                }
            }

            return answer;
        }

        public void calcDivisor(int left, int right) {

            for (int i = 1; i < right + 1; i++) {
                for (int k = 1; i * k < right + 1; k++) {
                    numDivisor[i * k] += 1;
                }
            }
        }
    }
}
