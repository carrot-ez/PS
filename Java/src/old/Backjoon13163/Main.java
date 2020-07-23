package Backjoon13163;
/*
 * 닉네임에 갓 붙이기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<testCase; i++) {
			String[] strarr = br.readLine().split(" ");
			strarr[0] = "god";
			for(String s : strarr) {
				sb.append(s);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}
}
