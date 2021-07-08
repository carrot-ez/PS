package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 토마토 {
    // 보관 후 하루가 지나면 익은 토마토 주변의 안익은 토마토가 익는다.
    // 인접하다의 기준 -> 앞 뒤 상 하 좌 우
    // 토마토가 모두 익는 최소일 구하기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");

        int M = Integer.parseInt(splits[0]); // 상자 가로
        int N = Integer.parseInt(splits[1]); // 상자 세로
        int H = Integer.parseInt(splits[2]); // 상자 높이

        int[][][] tomatos = new int[M + 2][N + 2][H + 2];

        // padding
        for (int[][] tomato : tomatos) {
            for (int[] ints : tomato) {
                Arrays.fill(ints, -1);
            }
        }

        // given
        for (int i = 1; i < H + 1; i++) {
            for (int k = 1; k < N + 1; k++) {
                splits = br.readLine().split(" ");
                for (int m = 1; m < M + 1; m++) {
                    tomatos[m][k][i] = Integer.parseInt(splits[m - 1]);
                }
            }
        }

        /* print input */
//        for(int i=1; i<H+1; i++) {
//            for(int k=1; k<N+1; k++) {
//                for(int m=1; m<M+1; m++) {
//                    System.out.print(tomatos[m][k][i]+ " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }

        int[][][] next = tomatos.clone(); // 깊은 복사
        int times = 0; // 며칠 걸렸는지

        while (true) {
            int applyNum = 0; // 영향 받은 토마토 수
            for (int i = 1; i < H + 1; i++) { // z
                for (int k = 1; k < N + 1; k++) { // y
                    for (int m = 1; m < M + 1; m++) { // x
                        if (tomatos[m][k][i] == -1) continue; // 토마토 없으면 넘어가자
                        if (tomatos[m][k][i] == 1) {
                            // 익은 토마토면

                            if (tomatos[m + 1][k][i] == 0) {
                                next[m + 1][k][i] = 1;
                                applyNum += 1;
                            }

                            if (tomatos[m - 1][k][i] == 0) {
                                next[m - 1][k][i] = 1;
                                applyNum += 1;
                            }

                            if (tomatos[m][k + 1][i] == 0) {
                                next[m][k + 1][i] = 1;
                                applyNum += 1;
                            }

                            if (tomatos[m][k - 1][i] == 0) {
                                next[m][k - 1][i] = 1;
                                applyNum += 1;
                            }

                            if (tomatos[m][k][i + 1] == 0) {
                                next[m][k][i + 1] = 1;
                                applyNum += 1;
                            }

                            if (tomatos[m][k][i - 1] == 0) {
                                next[m][k][i - 1] = 1;
                                applyNum += 1;
                            }

                        }
                    }
                }
            }

            // 더이상 상태가 전진되지 않음
            if (applyNum == 0) {
                break;
            }

            times += 1; // 하루가 지났습니다.
            tomatos = next.clone(); // 서로 상태 맞춰주고
        }

        // 비교
        for (int i = 1; i < H + 1; i++) {
            for (int k = 1; k < N + 1; k++) {
                for (int m = 1; m < M + 1; m++) {
                    if (tomatos[m][k][i] == 0) {
                        System.out.println("-1");
                        return;
                    }
                }
            }
        }

        System.out.println(times);
    }
}
