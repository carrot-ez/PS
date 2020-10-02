package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HandoutFlyers19542 {
    private static List<Integer>[] adList;
    public static boolean[] visited;
    private static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        int numNodes = Integer.parseInt(splits[0]);
        int startNode = Integer.parseInt(splits[1]);
        int strength = Integer.parseInt(splits[2]);

        // init vars
        adList = new List[numNodes + 1];
        visited = new boolean[numNodes + 1];
        count = new int[numNodes + 1];

        for(int i=0; i<numNodes + 1; i++) {
            adList[i] = new ArrayList<>();
        }

        for(int i=1; i<numNodes; i++) {
            splits = br.readLine().split(" ");
            int start = Integer.parseInt(splits[0]);
            int end = Integer.parseInt(splits[1]);
            adList[start].add(end);
            adList[end].add(start);
        }

        computeCount(startNode);
        System.out.println(getDistance(startNode, strength));
    }
    // dfs
    // 자식 노드의 최대 길이가 얼마인지 구하는 함수
    public static int computeCount(int x) {
        visited[x] = true;
        boolean isLeaf = true;
        int max = 0;
        for(int e : adList[x]) {
            if(!visited[e]) {
                visited[e] = true;
                max = Math.max(max, computeCount(e) + 1);
                isLeaf = false;
            }
        }
        if(isLeaf) {
            return count[x] = 0;
        }

        return count[x] = max;
    }

    // get distance using bfs
    // 자식노드의 최대 길이가 strength 이상인 노드만 방문하며 거리를 구하는 함수
    public static int getDistance(int x, int strength) {
        int result = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        Arrays.fill(visited, false);

        while(!queue.isEmpty()) {
            int n = queue.poll();
            visited[n] = true;
            for(int e : adList[n]) {
                if(!visited[e] && count[e] >= strength) {
                    result += 1;
                    visited[e] = true;
                    queue.add(e);
                }
            }
        }

        return result * 2; // 첫 노드를 세지 않으므로
    }
}
