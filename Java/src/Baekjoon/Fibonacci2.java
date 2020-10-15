package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci2 {
    private static long[] dp;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new long[n+1];
        for(int i=1; i<n + 1; i++) {
            if(i<=2)
                dp[i] = 1;
            else
                dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[n]);
    }
}
