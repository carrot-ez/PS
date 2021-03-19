package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NandM_2_15650 {
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        int N = Integer.parseInt(splits[0]);
        int M = Integer.parseInt(splits[1]);

        visited = new boolean[N + 1];
        printCombination(1, N, M);
    }

    private static void printCombination(int start, int N, int M) {
        if(M == 0) {
            // print
            for(int i=1; i<N + 1; i++) {
                if(visited[i])
                    System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
        for(int i=start; i< N + 1; i++) {
            visited[i] = true;
            printCombination(i+1, N, M-1);
            visited[i] = false;
        }
    }
}
