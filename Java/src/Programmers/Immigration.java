package Programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Immigration {
    public static void main(String args[]) {
        int n = 6;
        int times[] = {7, 10};

        long result = new Immigration().new Solution().solution(n, times);
        System.out.println(result);
    }

    class Solution {
        public long solution(int n, int[] times) {
            Arrays.sort(times);
            long left = 1; // best
            long right = (long)(times[times.length -1] * n); // worst
            long mid = 0;
            long answer = Long.MAX_VALUE;

            while(left <= right) {
                mid = (left + right) / 2;

                if(isPassed(times, n, mid)) {
                    answer = answer > mid ? mid : answer;
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }

            return answer;
        }

        public boolean isPassed(int times[], int n, long mid) {
            long sum = 0;
            for(int e : times) {
                sum += mid / e;
            }
            if(sum >= n)
                return true;
            else
                return false;
        }
    }
}
