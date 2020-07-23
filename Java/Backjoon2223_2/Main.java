package Backjoon2223_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken()); // �־��� �ð�
		int X = Integer.parseInt(st.nextToken()); // �ð��� �ݴ� ��ȭ
		int M = Integer.parseInt(st.nextToken()); // ���� ��
	
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
