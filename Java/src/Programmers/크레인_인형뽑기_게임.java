package Programmers;

import java.util.Stack;

public class 크레인_인형뽑기_게임 {

    class Solution {

        Stack<Integer> stack = new Stack<>();

        public int solution(int[][] board, int[] moves) {

            int answer = 0;

            for (int move : moves) {
                int pick = pick(board, move);
                if(pick == -1) {
                    continue;
                }

                int score = putIntoBasket(pick);
                answer += score;
            }

            return answer;
        }

        /**
         * 지정된 위치의 인형을 뽑는 함수
         *
         * @return 뽑은 인형
         */
        public int pick(int[][] board, int pos) {

            pos -= 1; // index 보정
            int pick = -1;

            for (int i = 0; i < board.length; i++) {
                if (board[i][pos] == 0)
                    continue;

                pick = board[i][pos];
                board[i][pos] = 0;
                break;
            }

            return pick;
        }

        /**
         * item을 바구니에 넣는 함수
         *
         * @return 사라진 인형 갯수
         */
        public int putIntoBasket(int item) {

            int numBomItems = 0;

            if (!stack.isEmpty()) {
                Integer prevItem = stack.peek();
                if (item == prevItem) {
                    stack.pop();
                    numBomItems = 2;
                } else {
                    stack.push(item);
                }
            } else {
                stack.push(item);
            }

            return numBomItems;
        }
    }
}
