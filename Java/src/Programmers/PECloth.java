package Programmers;

import java.util.Arrays;

public class PECloth {
    public static void main(String args[]) {
        int n = 5;
        int lost[] = {2, 3, 4};
        int reserve[] = {3};

        int result = new PECloth().new Solution().solution(n, lost, reserve);
        System.out.println(result);
    }

    class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = n - lost.length;
            boolean isLost[] = new boolean[n+2];
            boolean isReserve[] = new boolean[n+1];

            for(int e : lost) {
                isLost[e] = true;
            }

            // 순차적 비교를 위한 sort
            Arrays.sort(reserve);

            // 여분을 가지고 있는 학생이 잃어버린 경우 먼저 계산 해줘야 한다.
            for(int e : reserve) {
                if(isLost[e]) {
                    isLost[e] = false;
                    isReserve[e] = true;
                    answer += 1;
                }
            }

            // 여분을 가지고 있는 학생 앞뒤로 잃어버린 학생이 있을 시 빌려준다.
            for(int e : reserve) {
                if(isReserve[e]) continue;
                if(isLost[e-1]) {
                    isLost[e-1] = false;
                    answer += 1;
                }
                else if(isLost[e+1]) {
                    isLost[e+1] = false;
                    answer += 1;
                }
            }

            return answer;
        }
    }
}
