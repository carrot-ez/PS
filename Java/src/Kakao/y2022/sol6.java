package Kakao.y2022;

public class sol6 {
    class Solution {

        int[][] board;
        static final int ATTACK = 1;
        static final int RECOVERY = 2;
        public int solution(int[][] board, int[][] skill) {
            this.board = board;

            for (int[] e : skill) {
                applySkill(e);
            }

            return getPositiveBoards();
        }

        public void applySkill(int[] skill) {
            int op = 1;
            if (skill[0] == ATTACK) {
                op = -1;
            }

            int rowStart = skill[1];
            int colStart = skill[2];
            int rowEnd = skill[3];
            int colEnd = skill[4];
            op *= skill[5];

            for (int row = rowStart; row <= rowEnd; row++) {
                for (int col = colStart; col <= colEnd; col++) {
                    board[row][col] += op;
                }
            }
        }

        public int getPositiveBoards() {

            int res = 0;

            for (int i = 0; i < board.length; i++) {
                for (int k = 0; k < board[i].length; k++) {
                    if (board[i][k] > 0) {
                        res += 1;
                    }
                }
            }

            return res;
        }
    }
}
