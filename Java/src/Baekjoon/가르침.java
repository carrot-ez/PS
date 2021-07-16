package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 가르침 {
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");

        int N = Integer.parseInt(splits[0]); // 배울 수 있는 단어 수
        int K = Integer.parseInt(splits[1]); // 배울 수 있는 글자 제한

        List<String> contents = new ArrayList<>();

        while(N-- > 0) {
            String s = br.readLine();
            contents.add(s.substring(4, s.length() - 4));
        }

        System.out.println(solution(contents, K));
    }

    public static int solution(List<String> contents, int k) {

        // terminate cond
        if (k < 5) {
            return 0;
        } else if (k == 26) {
            return contents.size();
        }

        boolean[] alphabets = new boolean[26];

        // a, n, t, i, c 고정
        alphabets[0] = true; // a
        alphabets[2] = true; // c
        alphabets[8] = true; // i
        alphabets[13] = true; // n
        alphabets[19] = true; // t

        // start back tracking
        countReadable(0, k - 5, alphabets, contents);


        return max;
    }

    public static void countReadable(int idx, int cnt, boolean[] alphabets, List<String> contents) {

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

            max = Math.max(max, readableCnt);
        }
        else {
            for (int i = idx; i < 26; i++) {
                if (alphabets[i]) {
                    continue;
                }

                alphabets[i] = true;
                countReadable(i + 1, cnt - 1, alphabets, contents);
                alphabets[i] = false;
            }
        }
    }
}
