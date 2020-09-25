package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class YeolHyeolGangHo_11375 {

    private static List<Integer>[] empList;
    private static boolean[] visited;
    private static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // init vars
        String[] splits = br.readLine().split(" ");
        int numEmployees = Integer.parseInt(splits[0]);
        int numTasks = Integer.parseInt(splits[1]);
        d = new int[numTasks + 1];
        empList = new List[numEmployees + 1];
        for(int i=0; i<numEmployees + 1; i++) {
            empList[i] = new ArrayList<>();
        }

        // fill adlist
        for(int i=1; i<numEmployees + 1; i++) {
            splits = br.readLine().split(" ");
            int T = Integer.parseInt(splits[0]);
            for(int k=0; k<T; k++) {
                empList[i].add(Integer.parseInt(splits[k+1]));
            }
        }

        int result = 0;
        // bipartite matching
        for(int i=1; i<numEmployees + 1; i++) {
            // 매번 boolean 배열을 초기화 하는 과정이 필요하다.
            visited = new boolean[numEmployees + 1];
            if(dfs(i)) {
                result += 1;
            }
        }

        System.out.println(result);
    }

    // bipartite matching
    public static boolean dfs(int x) {
        visited[x] = true;
        for(int e : empList[x]) {
            if(d[e] == 0) {
                d[e] = x;
                return true;
            }
            else if(!visited[d[e]] && dfs(d[e])) {
                d[e] = x;
                return true;
            }
        }
        return false;
    }
}
