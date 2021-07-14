package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 케빈베이컨의_6단계_법칙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        int numUser = Integer.parseInt(splits[0]);
        int numRelation = Integer.parseInt(splits[1]);

        int res = Integer.MAX_VALUE;
        int resUser = 0;

        List<Integer>[] adList = new List[numUser + 1];
        for (int i = 0; i < adList.length; i++) {
            adList[i] = new ArrayList<>();
        }

        for (int i = 0; i < numRelation; i++) {
            splits = br.readLine().split(" ");
            int user1 = Integer.parseInt(splits[0]);
            int user2 = Integer.parseInt(splits[1]);

            adList[user1].add(user2);
            adList[user2].add(user1);
        }

        for (int i = 1; i < numUser + 1; i++) {

            int sol = solution(i, numUser, adList);
            if (res > sol) {
                res = sol;
                resUser = i;
            }
        }

        System.out.println(resUser);
    }

    public static int solution(int userNo, int numUser, List<Integer>[] adList) {

        int answer = 0;
        int level = 0;
        boolean[] visited = new boolean[numUser + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(userNo);

        while(!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int p = queue.poll();
                answer += level;
                for(int e : adList[p]) {
                    if (!visited[e]) {
                        visited[e] = true;
                        queue.offer(e);
                    }
                }
            } // for
            level += 1;
        } // while

        return answer;
    }
}
