package Kakao.y2022;

import java.util.ArrayList;
import java.util.List;

public class sol5 {

    class Solution {
        List<Integer>[] adList;
        List<Integer> unVisitedNodes;
        int[] info;
        boolean[] visited;
        static final int SHEEP = 0;
        static final int WOLF = 1;
        public int solution(int[] info, int[][] edges) {

            this.info = info;
            visited = new boolean[info.length];
            unVisitedNodes = new ArrayList<>();

            // build graph
            adList = new List[info.length];
            for (int i = 0; i < adList.length; i++) {
                adList[i] = new ArrayList<>();
            }

            for (int[] edge : edges) {
                adList[edge[0]].add(edge[1]);
            }

            // back tracking with bfs
            visited[0] = true;
            int answer = maxSheep(0, 1, 0);
            return answer;

        }

        public int maxSheep(int n, int numSheep, int numWolf) {

            if (adList[n].size() == 0) {
                return numSheep;
            }

            int res = 0;

            for (int i = 0; i < info.length; i++) {
                if (visited[i]) {
                    for (Integer node : adList[i]) {

                        int sheep = numSheep;
                        int wolf = numWolf;

                        // 재방문 X
                        if (visited[node]) {
                            continue;
                        }

                        // check
                        if (info[node] == WOLF) {
                            if (numSheep - numWolf <= 1) {
                                continue;
                            }
                            wolf += 1;
                        } else {
                            sheep += 1;
                        }

                        visited[node] = true;
                        res = Math.max(res, maxSheep(node, sheep, wolf));
                        visited[node] = false;
                    }
                }
            }

            return res;
        }
    }
}
