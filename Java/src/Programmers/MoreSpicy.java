package Programmers;

import java.util.PriorityQueue;

public class MoreSpicy {
    public static void main(String args[]) {
        int scoville[] = {1,1, 2};
        int K = 3;

        int result = new MoreSpicy().solution(scoville, K);
        System.out.println(result);

    }

    public int solution(int[] scoville, int K) {
        // init variables
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // add all element to pq
        for(int e : scoville) {
            pq.add(e);
        }

        // calc priority, loop
        while(pq.size() > 1 && pq.peek() < K) {
            int after = pq.poll() + pq.poll() * 2;
            pq.add(after);

            answer += 1;
        }

        // 1 or more elements always exists.
        if (pq.peek() < K) {
            answer = -1;
        }

        return answer;
    }

}
