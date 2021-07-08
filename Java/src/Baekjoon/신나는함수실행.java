package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 신나는함수실행 {

    static int[][][] dp = new int[51][51][51];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String[] splits = br.readLine().split(" ");
            int a = Integer.parseInt(splits[0]);
            int b = Integer.parseInt(splits[1]);
            int c = Integer.parseInt(splits[2]);

            if(a == -1 && b == -1 && c == -1) break;

            int result = w(a, b, c);
            System.out.println("w("+a+", "+b+", "+c+") = "+result);
        }
    }

    public static int w(int a, int b, int c) {
        if(a <= 0 || b <= 0 || c <= 0)
            return 1;

        else if(a > 20 || b > 20 || c > 20) {
            return dp[20][20][20] == 0
                    ? dp[20][20][20] = w(20, 20, 20)
                    : dp[20][20][20];
        }

        else if(a < b && b < c) {
            return dp[a][b][c] == 0
                    ? dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
                    : dp[a][b][c];
        }

        else {
            return dp[a][b][c] == 0
                    ? dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
                    : dp[a][b][c];
        }
    }
}
