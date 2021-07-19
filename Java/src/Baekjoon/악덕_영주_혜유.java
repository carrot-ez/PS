package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 악덕_영주_혜유 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int numVillage = Integer.parseInt(split[0]);
        int numPath = Integer.parseInt(split[1]);

        PriorityQueue<Edge> minPq = new PriorityQueue<>();
        PriorityQueue<Edge> maxPq = new PriorityQueue<>(Comparator.reverseOrder());

        while(numPath-- > 0) {
            split = br.readLine().split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            int cost = Integer.parseInt(split[2]);

            minPq.offer(new Edge(x, y, cost));
            maxPq.offer(new Edge(x, y, cost));
        }

        int[] solution = solution(numVillage, minPq, maxPq);
        System.out.println(solution[0]);
        System.out.println(solution[1]);
    }

    private static int[] solution(int numVillage, PriorityQueue<Edge> minPq, PriorityQueue<Edge> maxPq) {

        int[] answer = new int[2];
        answer[0] = getMaxCost(numVillage, maxPq);
        answer[1] = getMinCost(numVillage, minPq);

        System.out.println("answer[0] = " + answer[0]);
        System.out.println("answer[1] = " + answer[1]);
        return answer;
    }

    private static int getMinCost(int numVillage, PriorityQueue<Edge> minPq) {

        int totalCost = 0;
        int[] table = new int[numVillage];
        for(int i=0; i<table.length; i++) {
            table[i] = i;
        }

        while (!minPq.isEmpty()) {
            Edge edge = minPq.poll();

            // check cycle
            if (isCycle(edge.x, edge.y, table)) {
                continue;
            }

            // union
            union(edge.x, edge.y, table);
            totalCost += edge.cost;
        }

        return totalCost;
    }

    private static int getMaxCost(int numVillage, PriorityQueue<Edge> maxPq) {

        int totalCost = 0;
        int[] table = new int[numVillage];
        for(int i=0; i<table.length; i++) {
            table[i] = i;
        }

        while (!maxPq.isEmpty()) {
            Edge edge = maxPq.poll();

            // check cycle
            if (isCycle(edge.x, edge.y, table)) {
                continue;
            }

            // union
            union(edge.x, edge.y, table);
            totalCost += edge.cost;
        }

        return totalCost;
    }

    private static boolean isCycle(int x, int y, int[] table) {

        return find(x, table) == find(y, table);
    }

    private static int find(int x, int[] table) {

        // 자신이 부모이면
        if (x == table[x]) {
            return x;
        }

        return table[x] = find(table[x], table);
    }

    private static void union(int x, int y, int[] table) {

        int rootX = find(x, table);
        int rootY = find(y, table);

        if (rootX < rootY) {
            table[rootY] = rootX;
        } else {
            table[rootX] = rootY;
        }
    }

    private static class Edge implements Comparable<Edge> {
        int x;
        int y;
        int cost;

        public Edge(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
