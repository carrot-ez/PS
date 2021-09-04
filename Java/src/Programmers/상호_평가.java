package Programmers;

public class 상호_평가 {

    class Solution {
        public String solution(int[][] scores) {

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < scores.length; i++) {
                int sum = 0;
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                int self = scores[i][i];
                double avg = 0;
                boolean flag = false;

                for (int idx = 0; idx < scores[i].length; idx++) {
                    if (i != idx && scores[idx][i] == self) {
                        flag = true;
                    }
                    sum += scores[idx][i];
                    max = Math.max(max, scores[idx][i]);
                    min = Math.min(min, scores[idx][i]);
                }

                if (!flag && ( self == max || self == min )) {
                    avg = (sum - self) / (double)(scores[i].length - 1);
                }
                else {
                    avg = sum / (double)scores[i].length;
                }

                sb.append(getGrade(avg));
            }

            return sb.toString();
        }

        public String getGrade(double avg) {
            if (avg >= 90) return "A";
            if (avg >= 80) return "B";
            if (avg >= 70) return "C";
            if (avg >= 50) return "D";
            return "F";
        }
    }
}
