package Backjoon15945;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		int A[] = new int[testCase];
		int min = 0;
		int max = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int index = 0;
		
		while(st.hasMoreTokens()) {
			A[index] = Integer.parseInt(st.nextToken());
			
			if(index == 0) {
				min = A[index];
				max = A[index];
			}
			
			if(A[index] < min) {
				min = Math.min(min, A[index]);
			}
			if(A[index] > max) {
				max = Math.max(max, A[index]);
			}
			
			index++;
		}
		
		// 음수와 양수가 모두 존재
		if(min < 0 && max > 0) {
			System.out.println("0");
		}
		// 모두 음수
		else if(min < 0 && max < 0) {
			if(min - max > max) {
				System.out.println(Math.abs(min-max));
			}
			else {
				System.out.println(-max);
			}
		}
		// 모두 양수
		else if(min > 0 && max > 0) {
			if(max - min < min) {
				System.out.println(max-min);
			}
			else {
				System.out.println(min);
			}
		}
		// min = 0, max = 0
		else {
			System.out.println("0");
		}
	}
}
