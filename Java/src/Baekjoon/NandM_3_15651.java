package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NandM_3_15651 {
    private static boolean[] visited;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        int N = Integer.parseInt(splits[0]);
        int M = Integer.parseInt(splits[1]);

        visited = new boolean[N + 1];
        arr = new int[M];

        dfs(N, M, 0);
        System.out.println(sb);
    }

    private static void dfs(int N, int M, int depth) {
        if(depth == M) {
            for(int i=0; i<depth; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<N+1; i++) {
            arr[depth] = i;
            dfs(N, M, depth + 1);
        }
    }
}
