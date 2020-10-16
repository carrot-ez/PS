package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RGBDistance {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][3];

        for(int i=1; i<N+1; i++) {
            String[] splits = br.readLine().split(" ");
            int arr[] = new int[3];
            for(int k=0; k<3; k++) {
                arr[k] = Integer.parseInt(splits[k]);
            }
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[2];
        }

        System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
    }
}