package Baekjoon.backjoon17143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 상어는 크기, 속도 가짐

    // 1초에 한번
    // 1. 낚시왕이 한 칸 이동
    // 2. 낚시왕이 위치한 열에 있는 가장 가까운 상어를 잡는다
    // 3. 상어 이동

    // 이동하려는 칸이 경계를 넘는 경우 반대 방향으로 이동
    // 한 칸에 여러마리 상어가 있는 경우 가장 큰 상어가 모두를 잡아먹는다.

    // Direction
    // 1: 위
    // 2: 아래
    // 3: 오른쪽
    // 4: 왼쪽
    static final int[] dcol = {0, 0, 0, -1, 1}; // change col
    static final int[] drow = {0, -1, 1, 0, 0}; // change row
    static final int[] dDir = {0, 2, 1, 4, 3}; // change direction

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] splits; // 입력을 위한 변수

        // given
        splits = br.readLine().split(" ");
        int row = Integer.parseInt(splits[0]);
        int col = Integer.parseInt(splits[1]);
        int numShark = Integer.parseInt(splits[2]);

        int[][] map = new int[row + 1][col + 1];
        Shark[] sharks = new Shark[numShark + 1];
        sharks[0] = new Shark(-1, -1, -1, -1, 0);

        for (int i = 0; i < numShark; i++) {
            splits = br.readLine().split(" ");

            int sharkRow = Integer.parseInt(splits[0]);
            int sharkCol = Integer.parseInt(splits[1]);
            int sharkSpeed = Integer.parseInt(splits[2]);
            int sharkDirection = Integer.parseInt(splits[3]);
            int sharkWeight = Integer.parseInt(splits[4]);

            map[sharkRow][sharkCol] = i + 1;
            sharks[i + 1] = new Shark(sharkRow, sharkCol, sharkSpeed, sharkDirection, sharkWeight);
        }

        // then
        int ans = 0;
        for (int i = 1; i < col + 1; i++) {
            // 1. 사람 한 칸 이동

            // 2. 열에서(i) 가장 가까운 상어 사냥
            for (int k = 1; k < row + 1; k++) {
                if (map[k][i] != 0) {
                    // 해당 열에서 가장 가까운 상어 찾음
                    // 사냥 go
                    int shark = map[k][i];
                    ans += sharks[shark].weight;
                    map[k][i] = 0;
                    sharks[shark] = null;
                    break;
                }
            }

            // 3. 상어 이동
            for (int k = 1; k < numShark + 1; k++) {
                if (sharks[k] != null) {
                    int sRow = sharks[k].row;
                    int sCol = sharks[k].col;
                    int sDir = sharks[k].direction;
                    int sSpeed = sharks[k].speed;
                    int sWeight = sharks[k].weight;

                    map[sRow][sCol] = 0;

                    sRow = sRow + (sSpeed * drow[sDir]);
                    sCol = sCol + (sSpeed * dcol[sDir]);
                    while ((sRow < row + 1 && sRow > 0) || (sCol < col + 1 && sCol > 0)) {
                        int rowGap = getGap(sRow, row);
                        int colGap = getGap(sCol, col);

                        sharks[k].direction = dDir[sharks[k].direction];
                        sRow = sRow + (2 * rowGap * drow[sharks[k].direction]);
                        sCol = sCol + (2 * colGap * dcol[sharks[k].direction]);
                    }

                    int otherShark = map[sRow][sCol]; // 있을 수도 있고, 없을 수도 있다.
                    int otherWeight = sharks[otherShark].weight;
                    if (otherWeight < sWeight) {
                        map[sRow][sCol] = k;
                    }
                }
            }

            System.out.println(ans);
        }

    }

    static int getGap(int curr, int boundary) {
        if(curr > boundary) {
            return curr - boundary;
        }
        if(curr < 1) {
            return 1 - curr;
        }
        return 0;
    }

    private static class Shark {
        int row;
        int col;
        int speed;
        int direction;
        int weight;

        public Shark(int row, int col, int speed, int direction, int weight) {
            this.row = row;
            this.col = col;
            this.speed = speed;
            this.direction = direction;
            this.weight = weight;
        }
    }
}
