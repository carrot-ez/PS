package Programmers;

import java.util.PriorityQueue;

public class 섬_연결하기 {

    public int solution(int n, int[][] costs) {
        int answer = 0;

        PriorityQueue<Island> pq = new PriorityQueue<>();

        // set data pq
        for (int i = 0; i < costs.length; i++) {
            int x = costs[i][0];
            int y = costs[i][1];
            int dist = costs[i][2];

            pq.offer(new Island(x, y, dist));
        }

        // for union-find
        int[] table = new int[n];
        // init table
        for (int i = 0; i < n; i++) {
            table[i] = i;
        }

        // kruskal
        while (!pq.isEmpty()) {
            Island i = pq.poll();

            // 추가했을때, 사이클이 생긴다면
            if (isCycle(i.x, i.y, table)) {
                continue;
            }

            // 연결
            union(i.x, i.y, table);
            answer += i.cost;
        }

        return answer;
    }

    public boolean isCycle(int x, int y, int[] table) {

        return find(x, table) == find(y, table);
    }

    public int find(int x, int[] table) {

        if(table[x] == x) {
            return x;
        }

        return table[x] = find(table[x], table);

    }

    public void union(int x, int y, int[] table) {

        int rootX = find(x, table);
        int rootY = find(y, table);

        if (rootX < rootY) {
            table[rootY] = rootX;
        }
        else {
            table[rootX] = rootY;
        }
    }

    private class Island implements Comparable<Island> {
        int x;
        int y;
        int cost;

        public Island(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Island obj) {
            return Integer.compare(this.cost, obj.cost);
        }
    }
}
