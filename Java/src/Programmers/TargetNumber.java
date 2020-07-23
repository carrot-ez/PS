package Programmers;

import java.util.Stack;

public class TargetNumber {
    public static void main(String args[]) {
        int numbers[] = {1, 1, 1, 1, 1};
        int target = 3;

        int result = new Solution().solution(numbers, target);
        System.out.println(result);
    }
}

class Solution {
    private Stack<Integer> stack;
    private int count = 0;
    public int solution(int[] numbers, int target) {
        // init var
        stack = new Stack<>();
        stack.add(0);

        dfs(0, numbers, target);

        return count;
    }

    public void dfs(int x, int[] numbers, int target) {
        // termination condition
        if(x == numbers.length) {
            if(stack.pop() == target)
                count += 1;
            return;
        }

        while(!stack.isEmpty()) {
            int num = stack.pop();
            stack.add(num + numbers[x]);
            dfs(x + 1, numbers, target);

            stack.add(num - numbers[x]);
            dfs(x + 1, numbers, target);
        }
    }
}
