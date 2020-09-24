package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppleTree19539 {
    private static int[] trees;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numTree = Integer.parseInt(br.readLine());
        trees = new int[numTree];
        String[] splits = br.readLine().split(" ");

        for(int i=0; i<numTree; i++) {
            trees[i] = Integer.parseInt(splits[i]);
        }
        Arrays.sort(trees);

        int minus2Cnt = 0;
        int minus1Cnt = 0;
        for(int i=0; i<numTree; i++) {
            while(minus2Cnt > 0 && trees[i] >= 2) {
                trees[i] -= 2;
                minus2Cnt -= 1;
            }
            while(minus1Cnt > 0 && trees[i] >= 1) {
                trees[i] -= 1;
                minus1Cnt -= 1;
            }
            trees[i] = trees[i] % 3;
            switch (trees[i]) {
                case 1:
                    minus2Cnt += 1;
                    break;
                case 2:
                    minus1Cnt += 1;
                    break;
            }
        }

        if(trees[numTree-1] == 0 && minus1Cnt == 0 && minus2Cnt == 0) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }

//        for(int e : trees) {
//            System.out.println(e);
//        }
    }

    public static void otherSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numTree = Integer.parseInt(br.readLine());
        trees = new int[numTree];
        String[] splits = br.readLine().split(" ");

        int sum = 0;
        int numDivideBy2 = 0;
        for(int i=0; i<numTree; i++) {
            trees[i] = Integer.parseInt(splits[i]);
            sum += trees[i]; // GET TOTAL
            numDivideBy2 += trees[i]/2; // 2로 나눌 수 있는 최대 횟수
        }

        // sum이 3으로 나누어 떨어져야만 조건에 만족이 가능하다.
        if(sum % 3 == 0) {
            int numDivideBy1 = sum % 3;

            // 2로 나눌 수 있는 횟수가 1로 나눌 수 있는 횟수보다 크다면 항상 조건을 만족한다.
            if(numDivideBy2 >= numDivideBy1 ) {
                System.out.println("YES");
            }
            else {
                // 2로 나눌 수 있는 횟수보다 1로 나눌 수 있는 횟수가 크다면 조건을 만족하지 못한다.
                System.out.println("NO");
            }
        }
        else {
            System.out.println("NO");
        }
    }
}
