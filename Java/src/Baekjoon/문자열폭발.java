package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 문자열폭발 {
    public static void main(String[] args) throws IOException {

        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] content = br.readLine().toCharArray();
        char[] key = br.readLine().toCharArray();

        // vars
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> cache = new Stack<>();

        // calc
        int chkIdx = key.length - 1;
        for(int i=0; i<content.length; i++) {
            stack.push(i);

            if (content[i] == key[chkIdx]
                    && stack.size() >= key.length ) {
                for (int k = 0; k < key.length; k++) {
                    Integer e = stack.pop();
                    cache.push(e);

                    if (content[e] != key[chkIdx]) {
                        break;
                    }

                    chkIdx -= 1;
                }

                // match key
                if(chkIdx < 0) {
                    cache.clear();
                }
                else {
                    while (!cache.isEmpty()) {
                        stack.push(cache.pop());
                    }
                }

                chkIdx = key.length - 1;
            }
        }

        if (stack.isEmpty()) {
            System.out.println("FRULA");
        }
        else {
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
               sb.append(content[stack.pop()]);
            }
            String result = sb.reverse().toString();
            System.out.println(result);
        }
    }
}
