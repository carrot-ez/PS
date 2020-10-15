package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] dp0 = new int[n+1];
            int[] dp1 = new int[n+1];

            for(int i=0; i<n+1; i++) {
                if(i == 0)
                    dp0[i] = 1;
                else if(i == 1)
                    dp1[i] = 1;
                else {
                    dp0[i] = dp0[i - 1] + dp0[i - 2];
                    dp1[i] = dp1[i - 1] + dp1[i - 2];
                }
            }

            System.out.println(dp0[n]+" "+dp1[n]);
        }
    }
}
