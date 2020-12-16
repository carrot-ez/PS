package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestSubSequence {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] splits = br.readLine().split(" ");
        int[] arr = new int[N];
        int[] dp = new int[N];

        for(int i=0; i < N; i++) {
            dp[i] = 1;
            arr[i] = Integer.parseInt(splits[i]);
            if(i == 0)
                continue;
            for(int k=0; k<i; k++) {
                if(arr[k] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[k] + 1);
                }
            }
        }

        int max = 0;
        for(int i=0; i<N; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

    }
}