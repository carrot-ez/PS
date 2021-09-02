package Programmers;

import java.util.Arrays;
import java.util.List;

public class 키패드_누르기 {

    class Solution {
        public String solution(int[] numbers, String hand) {

            final String LEFT = "L";
            final String RIGHT = "R";
            StringBuilder sb = new StringBuilder();

            List<Integer> leftHands = Arrays.asList(1, 4, 7);
            List<Integer> rightHands = Arrays.asList(3, 6, 9);
            int leftPos = 9; // *
            int rightPos = 11; // #
            int[] table = new int[] {10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11};

            for (int number : numbers) {
                if(leftHands.contains(number)) {
                    sb.append(LEFT);
                    leftPos = table[number];
                } else if (rightHands.contains(number)) {
                    sb.append(RIGHT);
                    rightPos = table[number];
                } else {
                    int leftDist = calcDistance(leftPos, table[number]);
                    int rightDist = calcDistance(rightPos, table[number]);

                    if (leftDist > rightDist) {
                        sb.append(RIGHT);
                        rightPos = table[number];
                    } else if (leftDist < rightDist) {
                        sb.append(LEFT);
                        leftPos = table[number];
                    } else { // ==
                        if (hand.equals("left")) {
                            sb.append(LEFT);
                            leftPos = table[number];
                        } else {
                            sb.append(RIGHT);
                            rightPos = table[number];
                        }
                    }
                }
            }

            return sb.toString();
        }

        public int calcDistance(int start, int end) {
            int startRow = start / 3;
            int startCol = start % 3;

            int endRow = end / 3;
            int endCol = end % 3;

            int dist = Math.abs(startRow - endRow) + Math.abs(startCol - endCol);
            return dist;
        }
    }
}
