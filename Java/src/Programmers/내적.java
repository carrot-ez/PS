package Programmers;

public class 내적 {
    class Solution {
        public int solution(int[] a, int[] b) {

            int sum = 0;

            for (int i = 0; i < a.length; i++) {
                int mult = a[i] * b[i];
                sum += mult;
            }

            return sum;
        }
    }
}
