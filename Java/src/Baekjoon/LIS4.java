package Baekjoon;

/* https://www.acmicpc.net/problem/14002 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LIS4 {

    public static void main(String[] args) throws IOException  {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] splits = br.readLine().split(" ");

        int[] arr = new int[N];
        int[] dp = new int[N];
        int[] trace = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(splits[i]);
        }

        for(int i=0; i<N; i++) {
            trace[i] = -1;
            dp[i] = 1;
            for(int k=0; k<i; k++) {
                if(arr[i] > arr[k] && dp[i] < dp[k] + 1) {
                    dp[i] = dp[k] + 1;
                    trace[i] = k;
                }
            }
        }

        int max = 0;
        for(int i=1; i<N; i++) {
            if(dp[max] < dp[i]) {
                max = i;
            }
        }

        System.out.println(dp[max]);
        Stack<Integer> stack =  new Stack<>();
        while(max != -1) {
            stack.push(arr[max]);
            max = trace[max];
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }


    }
}
