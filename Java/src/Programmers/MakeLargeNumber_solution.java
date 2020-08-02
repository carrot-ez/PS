package Programmers;

import java.util.Stack;

public class MakeLargeNumber_solution {
    public static void main(String args[]) {
        String number = "1924";
        int k = 3;
        String result = new MakeLargeNumber_solution(). new Solution().solution(number, k);

        System.out.println(result);
    }

    class Solution {
        public String solution(String number, int k) {
            Stack<Character> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();

            for(int i=0; i<number.length(); i++) {
                char c = number.charAt(i);
                // 이전 k개 까지 현재값보다 작은 것 pop
                while(!stack.isEmpty() && stack.peek() < c && k > 0) {
                    stack.pop();
                    k -= 1;
                }
                stack.push(c);
            }

            // cut excess chars
            while(k > 0) {
                stack.pop();
                k -= 1;
            }

            // fill the sb.
            while(!stack.isEmpty()) {
                sb.append(stack.pop());
            }

            return sb.reverse().toString();
        }
    }
}
