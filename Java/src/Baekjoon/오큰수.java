package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 오큰수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        String[] arr = br.readLine().split(" ");
        int[] nge = new int[arr.length];
        Arrays.fill(nge, -1);

        // 1. 가장 오른쪽 끝에서 시작
        int highNge = Integer.parseInt(arr[arr.length-1]); // 현재까지 가장 큰 값
        int midNge = 0; // 가장 큰 값보다 작지만 더 왼쪽에 있는 값

        for(int i=arr.length-2; i>=0; i--) {
            int e = Integer.parseInt(arr[i]);
            if(highNge < e) {
                // 지금까지의 가장 높은 수보다 크다
                midNge = highNge;
                highNge = e;
            }
            else if(midNge < e) {
                // 중간 nge보다 크고 가장 높은 nge보다 작다.
                nge[i] = highNge;
                midNge = e;
            }
            else {
                // 작다
                nge[i] = midNge;
            }
        }

        /* print */
        StringBuilder sb = new StringBuilder();
        for (int e : nge) {
            sb.append(e).append(" ");
        }
        System.out.println(sb.toString());
    }
}
