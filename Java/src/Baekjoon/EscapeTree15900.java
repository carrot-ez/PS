package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class EscapeTree15900 {
    private static List<Integer>[] adList;
    private static boolean[] visited;
    private static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numTrees = Integer.parseInt(br.readLine());
        adList = new List[numTrees + 1];
        visited = new boolean[numTrees + 1];

        for(int i=0; i< numTrees + 1; i++) {
            adList[i] = new ArrayList<>();
        }

        while(numTrees-- > 1 ) {
            String[] splits = br.readLine().split(" ");
            int start = Integer.parseInt(splits[0]);
            int end = Integer.parseInt(splits[1]);
            adList[start].add(end);
            adList[end].add(start);
        }

        dfs(1, 0);
        if(sum %2 == 0 ){
            System.out.println("No");
        }
        else {
            System.out.println("Yes");
        }
    }

    public static void dfs(int x, int level) {
        visited[x] = true;
        boolean isLeaf = true;
        for(int e : adList[x]) {
            if(!visited[e]) {
                dfs(e, level + 1);
                isLeaf = false;
            }
        }

        if(isLeaf) {
            sum += level;
        }
    }
}
