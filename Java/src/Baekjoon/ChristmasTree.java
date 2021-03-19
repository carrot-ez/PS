package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [level][R][G][B] 의 DP배열 선언
 * 각 레벨별로 경우의 수 7가지
 * 1. 1가지 색인 경우, 3가지: 빨강, 초록, 파랑
 * 2. 2가지 색인 경우, 3가지: (빨,초), (빨,파), (초,파)
 *      level이 2로 나누어질 때
 * 3. 3가지 색인 경우, 1가지: (빨, 초, 파)
 *      level이 3으로 나누어질 때
 * 각 경우에 따라 DP배열 갱신하며 진행
 */
public class ChristmasTree {
    private static long dp[][][][] = new long[11][56][56][56]; // 한 층에 한 구슬이 들어갈 수 있는 최대 갯수 = 55개
    private static long factorial[] = new long[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] splits = br.readLine().split(" ");

        int N = Integer.parseInt(splits[0]);
        int R = Integer.parseInt(splits[1]);
        int G = Integer.parseInt(splits[2]);
        int B = Integer.parseInt(splits[3]);

        System.out.println(getCase(N, R, G, B));
    }

    public static long getCase(int level, int R, int G, int B) {
        if(R < 0 || B < 0 || G < 0) return 0;
        if(level <= 0) return 1;
        if(dp[level][R][G][B] != 0) {
            return dp[level][R][G][B];
        }

        // 1가지 색으로 채울 때
        dp[level][R][G][B] += getCase(level-1, R - level, G, B);
        dp[level][R][G][B] += getCase(level-1, R, G - level, B);
        dp[level][R][G][B] += getCase(level-1, R, G, B - level);

        // 2가지 색으로 채울 때
        if(level % 2 == 0) {
            int quotient = level / 2;
            long comb = getCombination(level,2, quotient);
            dp[level][R][G][B] += comb * getCase(level-1, R-quotient, G-quotient, B);
            dp[level][R][G][B] += comb * getCase(level-1, R-quotient, G, B-quotient);
            dp[level][R][G][B] += comb * getCase(level-1, R, G-quotient, B-quotient);
        }

        // 3가지 색으로 채울 때
        if(level % 3 == 0) {
            int quotient = level/3;
            long comb = getCombination(level, 3, quotient);
            dp[level][R][G][B] += comb * getCase(level-1, R-quotient, G-quotient, B-quotient);
        }

        return dp[level][R][G][B];
    }

    public static long getFactorial(int n) {
        if(factorial[n] != 0) return factorial[n];

        if(n == 0) return factorial[0] = 1;

        return factorial[n] = getFactorial(n-1) * n;
    }

    public static int getCombination(int n, int r, int quotation) {
        long ret = getFactorial(n);
        long div = (long) Math.pow(getFactorial(quotation), r);
        return (int)(ret / div);
    }
}
