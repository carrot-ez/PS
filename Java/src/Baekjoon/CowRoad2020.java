package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CowRoad2020 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String splits[] = br.readLine().split(" ");
        int N = Integer.parseInt(splits[0]); // 위쪽 진영 소
        int M = Integer.parseInt(splits[1]); // 아랫쪽 진영 소
        int L = Integer.parseInt(splits[2]); // 진영 사이 거리
        int sqrtL = L * L;

        // 위쪽 진영 소 x좌표
        int aboveCows[] = new int[N];
        splits = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            aboveCows[i] = Integer.parseInt(splits[i]);
        }

        // 아랫 진영 소 x좌표
        int belowCows[] = new int[M];
        splits = br.readLine().split(" ");
        for(int i=0; i<M; i++) {
            belowCows[i] = Integer.parseInt(splits[i]);
        }


    }
}
