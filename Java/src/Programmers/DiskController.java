package Programmers;

import java.util.*;

public class DiskController {
    public static void main(String args[]) {
        int jobs[][] = { {0, 3}, {1, 9}, {2, 6} };
        int result = new DiskController().solution(jobs);

        System.out.println(result);
    }

    public int solution(int[][] jobs) {
        int time = 0;
        int answer = 0;
        int count = 0;
        PriorityQueue<int[]> wait = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        wait.addAll(Arrays.asList(jobs));

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        while(count < jobs.length) {
            if(!wait.isEmpty() && wait.peek()[0] <= time) {
                pq.add(wait.poll());
                continue;
            }

            if(!pq.isEmpty()) {
                time += pq.peek()[1];
                answer += time - pq.peek()[0];
                pq.poll();
                count += 1;
            }
            else {
                time += 1;
            }
        }

        return answer / jobs.length;
    }
}
