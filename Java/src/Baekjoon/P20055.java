package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 컨베이어 벨트 위의 로봇
 */
public class P20055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // given
        String[] splits = br.readLine().split(" ");

        int N = Integer.parseInt(splits[0]); // 컨베이어 벨트 길이
        int K = Integer.parseInt(splits[1]); // threshold, 내구도 0인 블럭이 K개 이상이면 종료

        splits = br.readLine().split(" ");

        int A[] = new int[2 * N]; // 2N개의 벨트
        for(int i=0; i<A.length; i++) {
            A[i] = Integer.parseInt(splits[i]);
        }

        // then
        boolean isRobot[] = new boolean[N]; // 칸에 로봇이 있는지 여부를 저장하는 배열
        int countZero = 0; // 내구도가 0이 된 칸 수
        int turn = 0; // 돌아간 칸 수
        int answer = 0; // 완료한 단계 수

        // 4. 내구도가 0인 칸 수가 K개 이상이면 종료
        while(countZero < K) {
            // 1. 벨트가 한 칸 회전한다.
            turn = prev(turn, N * 2);
            rotateRobot(N, isRobot);

            // 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동
            for(int i=N - 1; i>= 0; i--) {
                // 로봇이 있다면
                if(isRobot[i]) {
                    // 마지막 칸이면 로봇을 내린다
                    if(i == N-1) {
                        isRobot[i] = false;
                        continue;
                    }

                    int robotNext = sumAndNext(i, turn, 2 * N);
                    // 다음 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상이어야 한다.
                    if(!isRobot[i + 1] && A[robotNext] > 0) {
                        isRobot[i] = false;
                        isRobot[i + 1] = true;
                        A[robotNext] -= 1;
                        if(A[robotNext] == 0) {
                            countZero += 1;
                        }
                    }
                }
            }

            // 3. 올라가는 위치에 로봇이 없다면 로봇을 하나 올린다.
            if(!isRobot[0] && A[turn] > 0) {
                isRobot[0] = true;
                A[turn] -= 1;
                if(A[turn] == 0) {
                    countZero += 1;
                }
            }

            answer += 1;
        }

        // result
        System.out.println(answer);

    }
    public static int prev(int turn, int beltSize) {
        return (turn - 1) < 0 ? beltSize - 1 : (turn - 1);
    }

    public static void rotateRobot(int beltSize, boolean[] robots) {
        for(int i = beltSize - 1; i >= 0; i--) {
            if(robots[i]) {
                if(i == beltSize - 1) {
                    robots[i] = false;
                    continue;
                }

                robots[i] = false;
                robots[i + 1] = true;
            }
        }
    }

    public static int next(int turn, int beltSize) {
        return (turn + 1) % beltSize;
    }

    public static int sumAndNext(int a, int b, int beltSize) {
        return (a + b + 1) % beltSize;
    }
}
