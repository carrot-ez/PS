package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 양치기_꿍 {

    private final static char EMPTY = '.';
    private final static char FENCE = '#';
    private final static char WOLF = 'v';
    private final static char SHEEP = 'k';


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] splits = br.readLine().split(" ");
        int row = Integer.parseInt(splits[0]);
        int col = Integer.parseInt(splits[1]);

        char[][] map = new char[row][col];

        for (int i = 0; i < row; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int[] res = solution(row, col, map);
        System.out.println(res[0] + " " + res[1]);
    }

    public static int[] solution(int row, int col, char[][] map) {
        /**
         * .    : 빈공간
         * #    : 울타리
         * v    : 늑대
         * k    : 양
         *
         * if 늑대의 수 < 양의 수:    양이 늑대를 전부 잡아먹는다.
         * else:                    늑대가 양을 전부 잡아먹는다.
         */

        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();

        // 살아있는 양, 늑대의 수
        int total_sheep = 0;
        int total_wolf = 0;

        // 울타리 밖엔 양, 늑대가 없다. -> [1][1] 부터 탐색 시작
        for (int i = 1; i < row - 1; i++) {
            for (int k = 1; k < col - 1; k++) {

                if (map[i][k] == FENCE || visited[i][k]) {
                    continue;
                }

                // bfs
                int num_sheep = 0;
                int num_wolf = 0;
                queue.offer(new int[]{i, k});
                while (!queue.isEmpty()) {
                    int[] pos = queue.poll();
                    int r = pos[0];
                    int c = pos[1];

                    visited[r][c] = true;

                    // 양 or 늑대이면 카운팅
                    switch (map[r][c]) {
                        case SHEEP:
                            total_sheep += 1;
                            num_sheep += 1;
                            break;
                        case WOLF:
                            total_wolf += 1;
                            num_wolf += 1;
                            break;
                        default:
                            break;
                    }

                    // 주위의 유효한 위치를 찾아 삽입
                    // up
                    if (checkBound(r - 1, c, row, col)
                            && map[r-1][c] != FENCE
                            && !visited[r - 1][c]
                    ) {
                        queue.offer(new int[]{r - 1, c});
                        visited[r-1][c] = true;
                    }

                    // down
                    if (checkBound(r + 1, c, row, col)
                            && map[r + 1][c] != FENCE
                            && !visited[r + 1][c]
                    ) {
                        queue.offer(new int[]{r + 1, c});
                        visited[r + 1][c] = true;
                    }

                    // left
                    if (checkBound(r, c - 1, row, col)
                            && map[r][c - 1] != FENCE
                            && !visited[r][c - 1]
                    ) {
                        queue.offer(new int[]{r, c - 1});
                        visited[r][c - 1] = true;
                    }

                    // right
                    if (checkBound(r, c + 1, row, col)
                            && map[r][c + 1] != FENCE
                            && !visited[r][c + 1]
                    ) {
                        queue.offer(new int[]{r, c + 1});
                        visited[r][c + 1] = true;
                    }
                } // while

                if(num_sheep == 0 || total_wolf == 0) {
                    continue;
                }

                if(num_sheep <= num_wolf) {
                    total_sheep -= num_sheep;
                }
                else {
                    total_wolf -= num_wolf;
                }
            } // for k
        } // for i

        return new int[]{total_sheep, total_wolf};
    }

    public static boolean checkBound(int r, int c, int row, int col) {
        if(r < row && r >= 0) {
            return c < col && c >= 0;
        }

        return false;
    }
}
