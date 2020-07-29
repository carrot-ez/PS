package Programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TheFurthestNode {
    public static void main(String args[]) {
        int n = 6;
        int edge[][] = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        int result = new TheFurthestNode().new Solution().solution(n, edge);
        System.out.println(result);
    }

    class Solution {
        private List<Integer> adList[];
        private Queue<Integer> queue;
        int d[];

        public int solution(int n, int[][] edge) {
            adList = new List[n+1];
            queue = new LinkedList<>();
            d = new int[n+1];

            for(int i=0; i<n+1; i++) {
                adList[i] = new ArrayList<>();
            }

            for(int arr[] : edge) {
                adList[arr[0]].add(arr[1]);
                adList[arr[1]].add(arr[0]);
            }

            int answer = 0;
            int max = bfs(1);
            for(int i=1; i<n+1; i++) {
                if(d[i] == max) {
                    answer += 1;
                }
            }

            return answer;
        }

        public int bfs(int x) {
            queue.add(x);
            d[x] = 1;
            int max = 1;

            while(!queue.isEmpty()) {
                int n = queue.poll();
                for(int e : adList[n]) {
                    if(d[e] == 0) {
                        queue.add(e);
                        d[e] = d[n] + 1;
                        max = Math.max(max, d[e]);
                    }
                }
            }

            return max;
        }
    }
}
