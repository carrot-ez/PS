package Programmers;

public class 삼진법_뒤집기 {
    class Solution {
        public int solution(int n) {

            String reversedTernaryString = getReversedTernaryString(n);
            return toDecimal(reversedTernaryString);
            /* 3줄 풀이 */
            // Stirng teraryString = Integer.toString(n, 3);
            // String reversedTernaryString = new StringBuilder(ternaryString).reverse().toString();
            // int solution = Integer.parseInt(reversedTernaryString, 3);
        }

        public String getReversedTernaryString(int n) {
            StringBuilder sb = new StringBuilder();

            while(n > 0) {
                int remainder = n % 3;
                n = n / 3;
                sb.append(remainder);
            }

            return sb.toString();
        }

        public int toDecimal(String ternaryString) {
            long ternaryNumber = Long.parseLong(ternaryString.trim());

            int multOp = 1;
            int decimalNumber = 0;

            while(ternaryNumber > 0) {
                long remainder = ternaryNumber % 10;
                decimalNumber += remainder * multOp;

                multOp *= 3;
                ternaryNumber /= 10;
            }

            return decimalNumber;
        }
    }
}