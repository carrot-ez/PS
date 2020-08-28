package Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class ConnectIsland {

    public static void main(String args[]) {
        int n = 6;
        int costs[][] = { {0, 1, 1}, {2, 3, 2}, {4, 5, 2}, {2, 4, 3}, {1, 5, 4}, {0, 5, 3} };

        int result = new ConnectIsland().solution(n, costs);
        System.out.println(result);
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;

        int root[] = new int[n];
        for(int i=0; i<n; i++) {
            root[i] = i;
        }

        // sort by cost of vertex
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        for(int cost[] : costs) {
            if(find(root, cost[0]) == find(root, cost[1])) {
                continue;
            }
            else {
                union(root, cost[0], cost[1]);
                answer += cost[2];
            }
        }

        return answer;
    }

    public int find(int root[], int x) {
        if(root[x] == x) {
            return x;
        }
        else {
            return root[x] = find(root, root[x]);
        }
    }

    public void union(int root[], int x, int y) {
        x = find(root, x);
        y = find(root, y);

        if(x < y) root[y] = x;
        else root[x] = y;
    }
}
