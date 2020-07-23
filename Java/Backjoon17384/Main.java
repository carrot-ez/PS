package Backjoon17384;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 대진표
 * 20,000 이상에서 터짐
 */
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numTeam = Integer.parseInt(br.readLine());
		
		String dp[] = new String[numTeam + 1];
		dp[1] = "#";
		
		for(int i=2; i<numTeam+1; i++) {
			StringBuilder sb = new StringBuilder();
			int size = getSize(i);
			
			sb.append(dp[(int)Math.round(i/2.0)]);
			for(int j=dp[(int)Math.round(i/2.0)].length(); j<size/2; j++) {
				sb.append('.');
			}
			
			sb.append(dp[i/2]);
			for(int j=size/2 + dp[i/2].length(); j<size; j++) {
				sb.append('.');
			}
			dp[i] = sb.toString();
		}
		
		System.out.println(dp[numTeam]);
	}
	
	public static int getSize(int n) {
		int num = 1;
		while(n > num) {
			num = num << 1;
		}
		return num;
	}
}
