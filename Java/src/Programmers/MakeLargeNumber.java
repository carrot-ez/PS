package Programmers;

import java.util.Arrays;

public class MakeLargeNumber {
    public static void main(String args[]) {
        String number = "1924";
        int k = 2;
        String result = new MakeLargeNumber(). new Solution().solution(number, k);

        System.out.println(result);
    }

    class Solution {
        public String solution(String number, int k) {
            // 1. string to char array
            char charArray[] = number.toCharArray();

            // 2. search max number in range(k+1)
            StringBuilder sb = new StringBuilder();
            while(k > 0) {
                // error handling
                if(k == charArray.length) {
                    return sb.toString();
                }

                int maxIdx = 0;
                for(int i = 1; i <= k; i++) {
                    if(charArray[i] > charArray[maxIdx]) {
                        maxIdx = i;
                    }
                }

                // 3. add the max number to string builder
                sb.append(charArray[maxIdx]);

                // 4. k - maxIdx
                k -= maxIdx;

                // 5. delete char array
                charArray = Arrays.copyOfRange(charArray, maxIdx+1, charArray.length);
            }

            // 6. add remaining chars
            if(charArray.length > 0)
                sb.append(String.valueOf(charArray));

            return sb.toString();
        }
    }
}
