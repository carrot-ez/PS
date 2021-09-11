package Kakao.y2022;

public class sol2 {

    public static void main(String[] args) {
        int solution = new Solution().solution(1000000, 2);
        System.out.println("solution = " + solution);
    }

    static class Solution {
        public int solution(int n, int k) {

            int answer = 0;

            // get prime numbers
            boolean[] primeNumbers = new boolean[n];

            String knaryString = Integer.toString(n, k);
            String[] splits = knaryString.split("0");
            for (String s : splits) {
                // check s is prime number
                if (!s.equals("") && checkPrime(s)) {
                    answer += 1;
                }
            }

            return answer;
        }

        private boolean checkPrime(String numberString) {

            long number = Long.parseLong(numberString);
            if (number == 1) return false;

            long sqrtNumber = (long) Math.sqrt(number);

            for (long i = 2; i <= sqrtNumber; i++) {
                if (number % i == 0) {
                    return false;
                }
            }

            return true;
        }
    }
}
