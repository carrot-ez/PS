package Backjoon2223;

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
		
		int D[] = new int[M]; // 각 몬스터 거리
		int S[] = new int[M]; // 각 몬스터 이동속도
		int A[] = new int[M]; // 각 몬스터 원래 위치 저장을 위함
		
		int result = 0;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			A[i] = D[i] = Integer.parseInt(st.nextToken());
			S[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean flag = false;
		
		for(int i=0; i<T; i++) {
			for(int j=0; j<M; j++) {
				D[j] = D[j] - S[j];
				if(D[j] <= 0) {
					flag = true;
				}
			}
			if(!flag) {
				result = result + X;
			}
			else {
				for(int j=0; j<M; j++) {
					D[j] = D[j] + 2*S[j];
					if(D[j] > A[j]) {
						D[j] = A[j];
					}
				}
			}
			flag = false;
		}
		
		System.out.println(result);
	}
}
