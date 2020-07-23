package Backjoon2223_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken()); // 주어진 시간
		int X = Integer.parseInt(st.nextToken()); // 시간당 줍는 금화
		int M = Integer.parseInt(st.nextToken()); // 몬스터 수
	
		int result = 0;
		int mi = Integer.MAX_VALUE;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			
			mi = Math.min(mi, (D-1)/S);
		}
		
		if(mi < 1) {
			result = 0;
		}
		else if(mi >= T) {
			result = T*X;
		}
		else {
			result = mi * X + ( (T-mi)/2 ) * X;
		}
		
		System.out.println(result);
		
	}
}
