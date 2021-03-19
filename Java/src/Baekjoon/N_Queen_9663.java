package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_Queen_9663 {
    private static int[] arr;
    private static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int N = Integer.parseInt(br.readLine());
         arr = new int[N];

         dfs(N, 0);
        System.out.println(ans);
    }

    private static void dfs(int N, int depth) {
        if(depth == N) {
            // 경우의 수 +1
            ans += 1;
            return;
        }

        if(depth == 0) {
            // depth == 0
            for(int i=0; i<N; i++) {
                arr[depth] = i;
                dfs(N, depth + 1);
            }
        }
        else {
            for(int i=0; i<N; i++) {
                if(possibleQueen(i, N, depth)) {
                    arr[depth] = i;
                    dfs(N, depth + 1);
                }
            }
        }
    }

    private static boolean possibleQueen(int col, int N, int depth) {
        for (int i = 0; i < depth; i++) {
            if (col == arr[i]) return false;
            if (arr[i] - (depth - i) >= 0 && col == arr[i] - (depth - i)) {
                return false;
            }
            if (arr[i] + (depth - i) < N && col == arr[i] + (depth - i)) {
                return false;
            }
        }
        return true;
    }
}
