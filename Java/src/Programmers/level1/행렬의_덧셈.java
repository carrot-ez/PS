package Programmers.level1;

public class 행렬의_덧셈 {

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int row = arr1.length;
        int col = arr1[0].length;

        int[][] answer = new int[row][col];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                answer[r][c] = arr1[r][c] + arr2[r][c];
            }
        }

        return answer;
    }
}
