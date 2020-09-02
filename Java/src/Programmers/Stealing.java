package Programmers;

public class Stealing {
    public int solution(int[] money) {
        int dp1[] = new int[money.length-1];
        int dp2[] = new int[money.length];

        // 0부터 시작하는 경우
        dp1[0] = money[0];
        dp1[1] = money[0];
        for(int i=2; i<dp1.length; i++) {
            dp1[i] = Math.max(dp1[i-2] + money[i], dp1[i-1]);
        }

        // 0부터 시작하지 않는 경우
        dp2[1] = money[1];
        for(int i=2; i<dp2.length; i++) {
            dp2[i] = Math.max(dp2[i-2] + money[i], dp2[i-1]);
        }

        return Math.max(dp1[dp1.length-1], dp2[dp2.length-1]);
    }
}
