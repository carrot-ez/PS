package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 가르침 {
    private static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        int answer = 0;

        int N = Integer.parseInt(splits[0]);
        int K = Integer.parseInt(splits[1]);

        List<String> contents = new ArrayList<>();

        while(N-- > 0) {
            contents.add(br.readLine());
        }

        System.out.println(solution(contents, K));
    }

    public static int solution(List<String> contents, int k) {

        boolean[] alphabets = new boolean[26];
        boolean[] fixed = new boolean[26];

        // a, n, t, i, c 고정
        alphabets[0] = fixed[0] = true; // a
        alphabets[2] = fixed[2] = true; // c
        alphabets[8] = fixed[8] = true; // i
        alphabets[13] = fixed[13] = true; // n
        alphabets[19] = fixed[19] = true; // t

        int selectCnt = k - 5;

        // can't make
        if (selectCnt < 0) {
            return 0;
        }

        // start back tracking
        countReadable(selectCnt, alphabets, contents);


        return pq.peek();
    }

    public static void countReadable(int cnt, boolean[] alphabets, List<String> contents) {

        if (cnt == 0) {
            // calc
            int readableCnt = 0;
            for (String content : contents) {
                char[] chars = content.toCharArray();
                boolean isRead = true;
                for (char c : chars) {
                    if (!alphabets[c - 'a']) {
                        isRead = false;
                        break;
                    }
                }

                if (isRead) {
                    readableCnt += 1;
                }
            }

            pq.offer(readableCnt);
        }
        else {
            for (int i = 0; i < 26; i++) {
                if (alphabets[i]) {
                    continue;
                }

                alphabets[i] = true;
                countReadable(cnt - 1, alphabets, contents);
                alphabets[i] = false;
            }
        }
    }
}
