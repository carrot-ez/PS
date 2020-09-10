package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// kakao code festival
public class RewardHunter {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testNum = Integer.parseInt(br.readLine());

        for(int i=0; i<testNum; i++) {
            String[] splits = br.readLine().split(" ");
            int firstRank = Integer.parseInt(splits[0]);
            int secondRank = Integer.parseInt(splits[1]);
            int sum = 0;
            sum += getFirstReward(firstRank);
            sum += getSecondReward(secondRank);

            System.out.println(sum);
        }
    }

    public static int getFirstReward(int rank) {
        int[] prize = {-1, 5000000, 3000000, 2000000, 500000, 300000, 100000};
        if(rank < 1 || rank > 100) {
            return 0;
        }
        for(int i=1; i<7; i++) {
            rank -= i;
            if(rank <= 0) {
                return prize[i];
            }
        }

        return 0;
    }

    public static int getSecondReward(int rank) {
        int prize = 5120000;
        if(rank < 1 || rank > 64) {
            return 0;
        }
        for(int i=1; i<17; i = i << 1) {
            rank -= i;
            if(rank <= 0) {
                return prize / i;
            }
        }

        return 0;
    }
}
