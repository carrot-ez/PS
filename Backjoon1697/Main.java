package Backjoon1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 숨바꼭질
 */
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 수빈이의 위치
		int N = Integer.parseInt(st.nextToken());
		// 동생의 위치
		int K = Integer.parseInt(st.nextToken());
		
		if(N > K) {
			int temp = N;
			N = K;
			K = temp;
		}
		
		int count = 0;
		while(N != K) {
			if(N == 0) {
				N = N+1;
				count++;
				continue;
			}
			if(N*2 <= K) {
				N = N*2;
				count++;
				continue;
			}
			int half = K/2;
			if(N - half < K-N) {
				count = count + N - half + 1;
				break;
			}
			else {
				count = count + (K-N);
				break;
			}
		}
		System.out.println(count);
	}
}
