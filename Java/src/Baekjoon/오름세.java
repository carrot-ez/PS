package Baekjoon;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class 오름세 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            int n = sc.nextInt();
            int[] stocks = new int[n];
            for(int i=0; i<n; i++) {
                stocks[i] = sc.nextInt();
            }

            System.out.println(solution(stocks));
        }
    }

    public static int solution(int[] stocks) {
        int[] dp = new int[stocks.length + 1];
        Arrays.fill(dp, -1);

        // init val
        dp[0] = stocks[0];

        for (int i = 1; i < stocks.length; i++) {

            // binary search
            int target = stocks[i];
            int left = stocks[i] > stocks[i- 1] ? dp[i - 1] : 0;
            int right = i;
            while (left < right) {
                int mid = (left + right) / 2;

                if (dp[mid] == -1) {
                    right = mid;
                    continue;
                }

                if (target <= dp[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            dp[right] = target;
        }

        long count = Arrays.stream(dp).filter(e -> e != -1).count();

        return (int) count;
    }
}
