package Programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Rank {
    public static void main(String args[]) {
        int n = 5;
        int results[][] = { {4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5} };
        int result = new Rank().solution(n, results);

        System.out.println(result);
    }

    public int solution(int n, int[][] results) {
        // 1. 이기는 노드를 가리키는 directed graph,지는 노드를 가리키는 directed graph 세팅
        // 2. 각 노드에서 이기는 노드의 수, 지는 노드의 수를 bfs를 이용하여 구한다.
        // 3. 이기는 노드 수 + 지는 노드 수 = n-1(자기 자신 제외) 이면 순위가 확정된 노드이다.
        List<Integer>[] winList = new List[n + 1];
        List<Integer>[] loseList = new List[n + 1];
        for(int i=0; i< n + 1; i++) {
            winList[i] = new ArrayList<>();
            loseList[i] = new ArrayList<>();
        }

        for(int i=0; i< results.length; i++) {
            winList[results[i][0]].add(results[i][1]);
            loseList[results[i][1]].add(results[i][0]);
        }

        int answer = 0;
        for(int i=1; i< n+1; i++) {
            int winCount = count(winList, i);
            int loseCount = count(loseList, i);
//            System.out.println("win count = "+winCount+", lose count = "+loseCount);
            if(winCount+loseCount == n-1) {
                answer += 1;
            }
        }

        return answer;
    }

    public int count(List<Integer>[] list, int x) {
        int count = 0;
        boolean isVisited[] = new boolean[list.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);

        while(!queue.isEmpty()) {
            int n = queue.poll();
            isVisited[n] = true;
            for(int e : list[n]) {
                if(!isVisited[e]) {
                    isVisited[e] = true;
                    queue.add(e);
                    count += 1;
                }
            }
        }

        return count;
    }
}
