package Backjoon17384_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * ´ëÁøÇ¥
 */
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numTeam = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		matching(1, getSize(numTeam), numTeam, sb);
		System.out.println(sb.toString());
	}
	public static void matching(int start, int end, int num, StringBuilder sb) {
		if(start == end) {
			if(num == 1) {
				sb.append('#');
				return;
			}
			else {
				sb.append('.');
				return;
			}
		}
		int half = (end - start + 1) / 2;
		if(num > half) {
			// 1. Math.round(num/2.0), 
			// 2. num/2
			int left = num - (half/2);
			int right = num - left;
			while(left > half) {
				left--;
				right++;
			}
			matching(start, start + half - 1, left, sb);
			matching(start + half, end, right, sb);
		}
		else {
			matching(start, start + half - 1, num, sb);
			matching(start + half, end, 0, sb);
		}
	}
	
	public static int getSize(int n) {
		int num = 1;
		while(n > num) {
			num = num << 1;
		}
		return num;
	}
}
