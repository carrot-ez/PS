package Backjoon11057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 오르막 수
 */
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		int dp[][] = new int[input][10];
		for(int i=0; i<10; i++) {
			dp[0][i] = 1;
		}
		
		for(int i=1; i<input; i++) {
			for(int j=0; j<10; j++) {
				for(int k=j; k<10; k++) {
					dp[i][j] += dp[i-1][k];
				}
				dp[i][j] = dp[i][j] %10007;
			}
		}
		
		int result = 0;
		for(int e : dp[input-1]) {
			result = result%10007 + e;
		}
		
		System.out.println(result);
	}

}
