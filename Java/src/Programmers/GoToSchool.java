package Programmers;

import java.util.Arrays;

public class GoToSchool {

    public static void main(String args[]) {
        int m = 4;
        int n = 3;
        int puddles[][] = { {2, 1}};

        int result = new GoToSchool().solution(m, n, puddles);
        System.out.println(result);
    }

    public int solution(int m, int n, int[][] puddles) {

        // m * n 격자를 만든다.
        // 물이 있는 곳의 좌표를 0으로 만든다.
        // 각 테두리의 계수를 1로 놓고 대각선으로 더해 계산한다.
        // 배열 초기화시 0, 1, inf 값으로 초기화한다.
        int dp[][] = new int[n][m];
        // unvisited node is -1
        for(int arr[] : dp) {
            Arrays.fill(arr, -1);
        }
        // set edges is 1
        for(int i=0; i<dp[0].length; i++) {
            dp[0][i] = 1;
        }
        for(int i=0; i<dp.length; i++) {
            dp[i][0] = 1;
        }
        // set puddle is 0
        for(int arr[] : puddles) {
            dp[arr[1] - 1][arr[0] -1] = 0;

            // 테두리에 웅덩이가 있으면 그 이후는 모두 최단거리가 아니게 됨. 즉 0을 대입해야 한다.
            if(arr[0] -1 == 0) {
                for(int i= arr[1] - 1; i<n; i++) {
                    dp[i][0] = 0;
                }
            }
            if(arr[1] -1 == 0) {
                for(int i=arr[0] -1; i<m; i++) {
                    dp[0][i] = 0;
                }
            }
        }

        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[i].length; j++) {
                if(dp[i][j] == -1) {
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) %1000000007;
                }
            }
        }

        // for test
//        for(int arr[] : dp ) {
//            for(int e : arr) {
//                System.out.print(e+" ");
//            }
//            System.out.println();
//        }

        return dp[n-1][m-1];
    }
}
