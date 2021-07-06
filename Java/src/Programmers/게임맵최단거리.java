import java.util.Calendar;
import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {

    public static void main(String[] args) {
        int[][] maps = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}
        };

        int res = new 게임맵최단거리().solution(maps);
        System.out.println("res = " + res);
    }

    // maps 0:벽, 1:이동가능
    // maps[0][0] -> maps[n][m] 이동 최단거리
    public int solution(int[][] maps) {

        // vars
        final int ROW_NUM = maps.length;
        final int COL_NUM = maps[0].length;
        final int[] DX = {1, 0, -1, 0};
        final int[] DY = {0, 1, 0, -1};

        // Character
        int[][] dist = new int[ROW_NUM][COL_NUM];
        Character init = new Character(0, 0);
        dist[0][0] = 1;

        // set init value
        Queue<Character> queue = new LinkedList<>();
        queue.offer(init);

        // start bfs
        while(!queue.isEmpty()) {
            Character character = queue.poll();
            final int cx = character.x;
            final int cy = character.y;

            // calc next position
            for(int i=0; i<4; i++) {
                int nextX = cx + DX[i];
                int nextY = cy + DY[i];

                // boundary check
                if( !checkBoundary(nextX, nextY, ROW_NUM, COL_NUM, maps) )
                    continue;

                if(dist[nextX][nextY] == 0 || dist[nextX][nextY] > (dist[cx][cy] + 1)) {
                    Character nextPos = new Character(nextX, nextY);
                    dist[nextX][nextY] = dist[cx][cy] + 1;
                    queue.offer(nextPos);
                }
            }
        }

        return dist[ROW_NUM-1][COL_NUM-1] == 0 ? -1 : dist[ROW_NUM-1][COL_NUM-1];
    }

    public boolean checkBoundary(int x, int y, final int ROW_NUM, final int COL_NUM, final int[][] maps) {

        // check x
        if (x >= 0 && x < ROW_NUM) {
            // check y
            if (y >= 0 && y < COL_NUM) {
                // check wall
                if(maps[x][y] == 0) {
                    return false;
                }
                return true;
            }
        }

        return false;
    }

    private class Character {
        int x;
        int y;

        public Character(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isSamePosition(Character c) {
            return this.x == c.x && this.y == c.y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this)
                return true;
            if(!(obj instanceof Character))
                return false;

            Character c = (Character) obj;

            return c.x == this.x && c.y == this.y;
        }
    }
}
