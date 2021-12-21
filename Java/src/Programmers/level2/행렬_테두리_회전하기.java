package Programmers.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 행렬_테두리_회전하기 {
    private int[][] board;
    public int[] solution(int rows, int columns, int[][] queries) {

        List<Integer> answer = new ArrayList<>();
        board = new int[rows][columns];
        initBoard(rows, columns);

        for (int[] query : queries) {
            int min = rotateBoardAndGetMin(query);
            answer.add(min);
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public void initBoard(int rows, int columns) {
        int cnt = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                board[row][col] = cnt++;
            }
        }
    }

    public int rotateBoardAndGetMin(int[] query) {
        int min = Integer.MAX_VALUE;
        int x1 = query[0] - 1;
        int y1 = query[1] - 1;
        int x2 = query[2] - 1;
        int y2 = query[3] - 1;

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(board[x1][y1]);
        for (int i = y1 + 1; i <= y2; i++) {
            queue.offer(board[x1][i]);
            board[x1][i] = queue.poll();
            min = Math.min(min, board[x1][i]);
        }
        for (int i = x1 + 1; i <= x2; i++) {
            queue.offer(board[i][y2]);
            board[i][y2] = queue.poll();
            min = Math.min(min, board[i][y2]);
        }
        for (int i = y2 - 1; i >= y1; i--) {
            queue.offer(board[x2][i]);
            board[x2][i] = queue.poll();
            min = Math.min(min, board[x2][i]);
        }
        for (int i = x2 - 1; i >= x1; i--) {
            queue.offer(board[i][y1]);
            board[i][y1] = queue.poll();
            min = Math.min(min, board[i][y1]);
        }

        return min;
    }
}
