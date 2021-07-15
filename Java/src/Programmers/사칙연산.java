package Programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class 사칙연산 {

    public static void main(String[] args) {
        String[] arr = {"1", "-", "3", "+", "5", "-", "8"};

        int solution = new 사칙연산().solution(arr);
        System.out.println("solution = " + solution);
    }

    // 1 + 2 + 3
    // -> 1. 3 + 3
    // -> 2. 1 + 5
    // 쪼개어 계산
    public int solution(String arr[]) {

        // answer
        int answer = Integer.MIN_VALUE;

        // queue
        Queue<String[]> queue = new LinkedList<>();
        queue.offer(arr);

        // start bfs
        while(!queue.isEmpty()) {
            String[] exp = queue.poll();

            // 쪼갤 수 없는 식이면 계산 ex) 1 - 3
            if (exp.length == 3) {
                int res = calcExp(exp);
                answer = Math.max(answer, res);
                continue;
            }

            // 식 쪼개기
            for(int i=0; i < exp.length; i += 2) {
                // 연산 불가능
                if (i + 2 >= exp.length) {
                    break;
                }

                // calc 1(i) +(i+1) 2(i+2)
                String[] subExp = new String[3];
                subExp[0] = exp[i];
                subExp[1] = exp[i+1];
                subExp[2] = exp[i+2];
                int subResult = calcExp(subExp);

                // build resExp
                String[] resExp = new String[exp.length - 2];
                for(int k=0; k<i; k++) {
                    resExp[k] = exp[k];
                }
                resExp[i] = Integer.toString(subResult);
                for(int k=i+1; k<resExp.length; k++) {
                    resExp[k] = exp[k+2];
                }

                // add queue
                queue.offer(resExp);
            }
        }

        return answer;
    }

    public int calcExp(String[] exp) {

        int num1 = Integer.parseInt(exp[0]);
        int num2 = Integer.parseInt(exp[2]);
        String operator = exp[1];

        if (operator.equals("+")) {
            return num1 + num2;
        } else if (operator.equals("-")) {
            return num1 - num2;
        }

        throw new RuntimeException("invalid operation");
    }
}
