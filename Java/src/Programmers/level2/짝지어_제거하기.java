package Programmers.level2;

import java.util.Stack;

public class 짝지어_제거하기 {

    public int solution(String s)
    {
        if (s.length() % 2 != 0) {
            return 0;
        }

        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(chars[i]);
                continue;
            }

            if (stack.peek() == chars[i]) {
                stack.pop();
            } else {
                stack.push(chars[i]);
            }
        }

        return stack.size() == 0 ? 1 : 0;
    }
}
