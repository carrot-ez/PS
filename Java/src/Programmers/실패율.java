package Programmers;

import java.util.*;

public class 실패율 {

    class Solution {

        /**
         *
         * @param N 전체 스테이지의 개수
         * @param stages 사용자의 현재 멈춰있는 스테이지의 번호호
         * @return 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
         */
        public int[] solution(int N, int[] stages) {

            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 1; i < N + 2; i++) {
                map.put(i, 0);
            }

            for (int stage : stages) {
                Integer cnt = map.get(stage);
                map.replace(stage, cnt + 1);
            }

            int numPlayer = stages.length;
            List<Stage> list = new ArrayList<>();
            for (int i = 1; i < N + 1; i++) {
                int now = map.get(i);
                double failRate = now == 0 ? 0 : now / (double) numPlayer;
                list.add(new Stage(i, failRate));

                numPlayer -= now;
            }

            int[] answer = list.stream()
                    .sorted(Comparator
                            .comparing(Stage::getFailRate).reversed()
                            .thenComparing(Stage::getStageNum))
                    .mapToInt(Stage::getStageNum)
                    .toArray();

            return answer;
        }

        class Stage {
            int stageNum;
            double failRate;

            public Stage(int stageNum, double failRate) {
                this.stageNum = stageNum;
                this.failRate = failRate;
            }

            public int getStageNum() {
                return stageNum;
            }

            public void setStageNum(int stageNum) {
                this.stageNum = stageNum;
            }

            public double getFailRate() {
                return failRate;
            }

            public void setFailRate(double failRate) {
                this.failRate = failRate;
            }
        }
    }
}
