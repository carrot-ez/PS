package Programmers;

public class 소수_만들기 {

    class Solution {

        boolean[] primeNumbers;
        int[] nums;
        public int solution(int[] nums) {
            this.nums = nums;
            int maxNum = nums.length * 1000 + 1;
            primeNumbers = new boolean[maxNum];
            calcPrimeNumbers(primeNumbers);

            boolean[] visited = new boolean[nums.length];

            int answer = backTracking(0, visited, 0, 0);
            return answer;
        }

        private int backTracking(int start, boolean[] visited, int sum, int count) {

            if (count == 3) {
                if(!primeNumbers[sum]) return 1;
                else return 0;
            }

            int answer = 0;

            for (int i = start; i < visited.length; i++) {
                if(visited[i]) continue;

                visited[i] = true;
                int returns = backTracking(i + 1, visited, sum + nums[i], count + 1);
                answer += returns;
                visited[i] = false;
            }

            return answer;
        }

        private void calcPrimeNumbers(boolean[] primeNumbers) {

            int sqrtLength = (int) Math.sqrt(primeNumbers.length);

            for (int i = 2; i < sqrtLength; i++) {
                for (int k = 2; i * k < primeNumbers.length; k++) {
                    primeNumbers[i * k] = true;
                }
            }

        }

    }
}
