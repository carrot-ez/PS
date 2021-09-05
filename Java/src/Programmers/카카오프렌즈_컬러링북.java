package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈_컬러링북 {

    /**
     * [1, 1, 1, 0],
     * [1, 2, 2, 0],
     * [1, 0, 0, 1],
     * [0, 0, 0, 1],
     * [0, 0, 0, 3],
     * [0, 0, 0, 3]
     */

    private int[] dRow = new int[]{1, -1, 0, 0};
    private int[] dCol = new int[]{0, 0, 1, -1};
    private int numRow;
    private int numCol;
    public int[] solution(int m, int n, int[][] picture) {

        int[][] clonedPicture = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                clonedPicture[i][j] = picture[i][j];
            }
        }

        numRow = m;
        numCol = n;
        int[] answer = new int[2];

        for (int row = 0; row < clonedPicture.length; row++) {
            for (int col = 0; col < clonedPicture[row].length; col++) {
                if(clonedPicture[row][col] > 0) {
                    int maxSizeOfOneArea = getNumOfArea(clonedPicture, row, col);
                    answer[0] += 1;
                    answer[1] = Math.max(answer[1], maxSizeOfOneArea);
                }
            }
        }

        return answer;
    }

    private int getNumOfArea(int[][] picture, int row, int col) {

        int area = 0;
        int val = picture[row][col];
        picture[row][col] = 0; // visited
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            area += 1;

            for (int i = 0; i < dRow.length; i++) {
                int nextRow = pos[0] + dRow[i];
                int nextCol = pos[1] + dCol[i];
                if(!boundaryCheck(nextRow, nextCol)) continue;

                if (picture[nextRow][nextCol] == val) {
                    queue.offer(new int[]{nextRow, nextCol});
                    picture[nextRow][nextCol] = 0;
                }
            }
        }

        return area;
    }

    private boolean boundaryCheck(int nextRow, int nextCol) {

        if (nextRow < 0 || nextRow >= numRow) {
            return false;
        }

        if (nextCol < 0 || nextCol >= numCol) {
            return false;
        }

        return true;
    }
}
