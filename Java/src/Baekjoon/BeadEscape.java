package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Note
 * dx, dy를 이용하여 네 방향 이동 구현
 * 4차원 배열 visited
 * 빨간구슬과 파란구슬이 동시에 빠지는 경우 생각 안했음
 */
public class BeadEscape {
    private static int rows;
    private static int cols;
    private static int[] posHall;
    private static char[][] matrix;
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    private static boolean[][][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");

        rows = Integer.parseInt(splits[0]);
        cols = Integer.parseInt(splits[1]);

        // init matrix & positions
        matrix = new char[rows][cols];
        int[] posRed = new int[2];
        int[] posBlue = new int[2];
        posHall = new int[2];
        for(int i=0; i<rows; i++) {
            String s = br.readLine();
            for(int k=0; k<cols; k++) {
                matrix[i][k] = s.charAt(k);
                if(matrix[i][k] == 'R') {
                    // red
                    posRed[0] = i;
                    posRed[1] = k;
                }
                else if(matrix[i][k] == 'B') {
                    // blue
                    posBlue[0] = i;
                    posBlue[1] = k;
                }
                else if(matrix[i][k] == 'O') {
                    // hall
                    posHall[0] = i;
                    posHall[1] = k;
                }
            }
        }

        // bfs
        visited = new boolean[10][10][10][10];
        visited[posRed[0]][posRed[1]][posBlue[0]][posBlue[1]] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(posRed, posBlue, 0));

        while(!queue.isEmpty()) {
            Pair p = queue.poll();

            // 10번 초과했는지 확인
            if(p.cnt > 10) {
                break;
            }

            // Hall에 들어왔는지 확인
            if(p.reds[0] == posHall[0] && p.reds[1] == posHall[1]) {
                System.out.println(p.cnt);
                System.exit(0);
                break;
            }

            // 4방향으로 굴리면서 방문하지 않은 곳이면 queue에 추가
            for(int i=0; i<4; i++) {
                Pair moved = move(p, dx[i], dy[i]);

                // 파란공이 구멍에 빠진 경우
                if(moved == null) {
                    continue;
                }

                if(!visited[moved.reds[0]][moved.reds[1]][moved.blues[0]][moved.blues[1]]) {
                    visited[moved.reds[0]][moved.reds[1]][moved.blues[0]][moved.blues[1]] = true;
                    queue.add(moved);
                }
            }
        }
        System.out.println("-1");

    }

    /**
     * 공을 굴린 후 결과를 리턴하는 함수
     */
    public static Pair move(Pair now, int dx, int dy) {
        Pair next = new Pair(now);

        int[] red = next.reds;
        int[] blue = next.blues;
        int redCount = 0;
        int blueCount = 0;

        // 일단 굴린다.
        while(matrix[red[0] + dx][red[1] + dy] != '#' && matrix[red[0]][red[1]] != 'O') {
            red[0] += dx;
            red[1] += dy;
            redCount += 1;
        }
        while(matrix[blue[0] + dx][blue[1] + dy] != '#' && matrix[blue[0]][blue[1]] != 'O') {
            blue[0] += dx;
            blue[1] += dy;
            blueCount += 1;
        }

        // 파란공이 구멍에 들어가면 실패
        if(blue[0] == posHall[0] && blue[1] == posHall[1]) {
            return null;
        }

        // 좌표가 같은지 확인
        if(red[0] == blue[0] && red[1] == blue[1]) {
            if(redCount > blueCount) {
                red[0] -= dx;
                red[1] -= dy;
            }
            else if(redCount < blueCount) {
                blue[0] -= dx;
                blue[1] -= dy;
            }
        }

        return next;
    }

    static class Pair {
        int[] reds;
        int[] blues;
        long cnt;

        public Pair(int[] reds, int[] blues, long cnt) {
            this.reds = reds.clone();
            this.blues = blues.clone();
            this.cnt = cnt;
        }

        public Pair(Pair p) {
            this.reds = p.reds.clone();
            this.blues = p.blues.clone();
            this.cnt = p.cnt + 1;
        }
    }
}
