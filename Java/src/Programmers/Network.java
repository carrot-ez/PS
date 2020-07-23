package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Network {
    public static void main(String args[]) {
        class Solution {
            private int d[];
            private Queue<Integer> queue;

            public int solution(int n, int[][] computers) {
                // init vars
                d = new int[n];
                queue = new LinkedList<>();

                int answer = 0;
                for(int i=0; i<n; i++) {
                    if(d[i] == 0) {
                        answer++;
                        bfs(i, computers);
                    }
                }

                return answer;
            }

            public boolean bfs(int x, int computers[][]) {
                if(d[x] == 1)
                    return false;
                d[x] = 1;

                for(int i=0; i<computers[x].length; i++) {
                    if(computers[x][i] == 1) {
                        queue.add(i);
                    }
                }

                while(!queue.isEmpty()) {
                    int num = queue.poll();
                    bfs(num, computers);
                }
                return true;
            }
        }

        int n = 3;
        int computers[][] = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int result = new Solution().solution(n, computers);
        System.out.println(result);
    }
}

