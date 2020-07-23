package Backjoon2223;

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
		
		int D[] = new int[M]; // �� ���� �Ÿ�
		int S[] = new int[M]; // �� ���� �̵��ӵ�
		int A[] = new int[M]; // �� ���� ���� ��ġ ������ ����
		
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
