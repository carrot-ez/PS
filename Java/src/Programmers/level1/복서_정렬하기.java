package Programmers.level1;

import java.util.Arrays;

public class 복서_정렬하기 {

    class Solution {
        public int[] solution(int[] weights, String[] head2head) {

            Boxer[] boxers = new Boxer[weights.length];

            for (int i = 0; i < weights.length; i++) {
                boxers[i] = new Boxer(i + 1, weights[i]);
            }

            for (int i = 0; i < head2head.length; i++) {

                int win = 0;
                int numMatch = 0;
                for (int k = 0; k < weights.length; k++) {
                    if (head2head[i].charAt(k) == 'N') {
                        continue;
                    }

                    numMatch += 1;
                    if (head2head[i].charAt(k) == 'W') {
                        win += 1;
                        if (weights[i] < weights[k]) {
                            boxers[i].numWinByHeavy += 1;
                        }
                    }
                }

                double winRate = numMatch == 0 ? 0.0 : (double) win / numMatch;
                boxers[i].winRate = winRate;
            }

            return Arrays.stream(boxers).sorted().mapToInt(e -> e.number).toArray();
        }
    }

    class Boxer implements Comparable<Boxer> {
        int number;
        int numWinByHeavy;
        double winRate;
        int weight;

        public Boxer(int number, int weight) {
            this.number = number;
            this.weight = weight;
            this.numWinByHeavy = 0;
            this.winRate = 0.0;
        }

        @Override
        public int compareTo(Boxer o) {
            int compareWinRate = Double.compare(o.winRate, this.winRate);
            int compareWinByHeavy = Integer.compare(o.numWinByHeavy, this.numWinByHeavy);
            int compareWeight = Integer.compare(o.weight, this.weight);
            int compareNumber = Integer.compare(this.number, o.number);

            return compareWinRate != 0
                    ? compareWinRate
                    : compareWinByHeavy != 0
                        ? compareWinByHeavy
                        : compareWeight != 0
                            ? compareWeight
                            : compareNumber;
        }
    }
}
