package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 악덕_영주_혜유 {

    private static int[][] costArr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int numVillage = Integer.parseInt(split[0]);
        int numPath = Integer.parseInt(split[1]);

        costArr = new int[numVillage][numVillage];
        List<Integer>[] adList = new List[numVillage];
        for (int i = 0; i < adList.length; i++) {
            adList[i] = new ArrayList<>();
        }

        PriorityQueue<Edge> minPq = new PriorityQueue<>();

        while(numPath-- > 0) {
            split = br.readLine().split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            int cost = Integer.parseInt(split[2]);

            costArr[x][y] = cost;
            costArr[y][x] = cost;

            minPq.offer(new Edge(x, y, cost));
        }

        int[] solution = solution(numVillage, minPq, adList);
        System.out.println(solution[0]);
        System.out.println(solution[1]);
    }

    private static int[] solution(int numVillage, PriorityQueue<Edge> minPq, List<Integer>[] adList) {

        int[] answer = new int[2];
        answer[0] = getMinCost(numVillage, minPq, adList);
        answer[1] = getMaxRoot(numVillage, adList);
        return answer;
    }

    private static int getMinCost(int numVillage, PriorityQueue<Edge> minPq, List<Integer>[] adList) {

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

            // save graph
            adList[edge.x].add(edge.y);
            adList[edge.y].add(edge.x);
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

    private static int getMaxRoot(int numVillage, List<Integer>[] adList) {

        boolean[] visited = new boolean[numVillage];
        int maxCost = Integer.MIN_VALUE;
        int startVertex = 0;

        Queue<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        queue.offer(startVertex);

        // start bfs - find leaf - calc max
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            // if leaf
            if (adList[poll].size() == 1) {
                int y = adList[poll].get(0);
                boolean[] visitedDfs = new boolean[numVillage];
                visitedDfs[poll] = true;
                maxCost = Math.max(maxCost, calcMaxCost(poll, 0, visitedDfs, adList)); // calc max cost
            }

            for (int e : adList[poll]) {
                if (!visited[e]) {
                    visited[e] = true;
                    queue.offer(e);
                }
            }
        }

        return maxCost;
    }

    private static int calcMaxCost(int x, int cost, boolean[] visitedDfs, List<Integer>[] adList) {

        if(!visitedDfs[x] && adList[x].size() == 1) {
            return cost;
        }

        visitedDfs[x] = true;
        int max = Integer.MIN_VALUE;
        for (int e : adList[x]) {
            if (!visitedDfs[e]) {
                max = Math.max(max, calcMaxCost(e, costArr[x][e], visitedDfs, adList));
            }
        }

        return max + cost;
    }
}
