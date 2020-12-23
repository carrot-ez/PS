package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class NandM_1_15649 {
    private static boolean[] visited;
    private static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        int N = Integer.parseInt(splits[0]);
        int M = Integer.parseInt(splits[1]);

        visited = new boolean[N + 1];
        stack = new Stack<>();

        printCombination(N, M);
    }

    /**
     * Backtracking을 이용한 조합 출력
     * @param N 1~N 까지의 자연수
     * @param M M개의 조합
     */
    private static void printCombination(int N, int M) {
        if(M == 0) {
            for(int e: stack) {
                System.out.print(e+" ");
            }
            System.out.println();
            return;
        }
        for(int i=1; i < N+1; i++) {
            if(!visited[i]) {
                visited[i] = true;
                stack.add(i);
                printCombination(N, M-1);
                stack.pop();
                visited[i] = false;
            }
        }
    }

}
