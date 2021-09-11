package Kakao.y2022;

import java.sql.Array;
import java.util.*;

public class sol4 {

    class Solution {

        Map<Integer, List<int[]>> map = new HashMap<>();
        int[] info;
        boolean[] visited;

        public int[] solution(int n, int[] info) {
            this.info = info;
            this.visited = new boolean[info.length];

            backTracking(n, 0, new int[11], 0);

            Integer max = map.keySet().stream()
                    .max(Comparator.comparingInt(Integer::intValue))
                    .get();

            List<int[]> list = map.get(max);
            if(list.size() == 1) return list.get(0);
            else {

            }

            return null;
        }

        public boolean isWin(int[] source, int[] target) {
            int scoreSource = 0;
            int scoreTarget = 0;

            for (int i = 0; i < source.length; i++) {
                if (source[i] == 0 && target[i] == 0) continue;
                if (source[i] < target[i]) {
                    scoreTarget += 10 - i;
                } else {
                    scoreSource += 10 - i;
                }
            }

            return scoreTarget > scoreSource;
        }

        public void backTracking(int remainArrows, int score, int[] answer, int start) {

            if (remainArrows == 0) {
                List<int[]> list = map.containsKey(score) ? map.get(score) : new ArrayList<int[]>();
                list.add(answer.clone());
                map.put(score, list);
                return;
            }

            for (int i = start; i < info.length; i++) {

                if(visited[i]) continue;

                int needArrow = info[i] + 1;

                if (needArrow <= remainArrows) {
                    visited[i] = true;
                    int temp = answer[i];
                    answer[i] = needArrow;
                    int calcScore = needArrow > 1 ?  2 * (10 - i) : 10 - i;
                    backTracking(remainArrows - needArrow, score + calcScore, answer, i + 1);
                    answer[i] = temp;
                    visited[i] = false;
                }
            }
        }
    }

}
