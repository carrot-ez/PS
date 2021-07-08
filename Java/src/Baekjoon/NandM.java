package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NandM {
    // input: N, M
    // 1 ~ N 까지의 수 중 M개를 택해서 나올 수 있는 모든 조합 구하기


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] splits = br.readLine().split(" ");

        int N = Integer.parseInt(splits[0]);
        int M = Integer.parseInt(splits[1]);

        boolean[] isVisit = new boolean[N + 1]; // 1 ~ N 까지 고른 원소 저장

        printCombinations(N, M, isVisit, 0, 1);
    }

    public static void printCombinations(int N, int M, boolean[] isVisit, int count, int start) {
        if(count == M) {
            printByBooleanArr(isVisit);
            return;
        }

        for(int i = 1; i < isVisit.length; i++) {
            if(isVisit[i]) continue;

            isVisit[i] = true;
            printCombinations(N, M, isVisit, count + 1, i);
            isVisit[i] = false;
        }
    }

    public static void printByBooleanArr(boolean[] isVisit) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < isVisit.length; i++) {
            if(isVisit[i]) {
                sb.append(i+" ");
            }
        }

        System.out.println(sb.toString());
    }
}
