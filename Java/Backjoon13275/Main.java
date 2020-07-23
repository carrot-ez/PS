package Backjoon13275;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static int A[];
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String s_rev = new StringBuilder(s).reverse().toString();
		String tmp = getLCSString(s, s_rev);
		System.out.println(tmp);
		System.out.println(getLCS(s, s_rev));
//		StringBuilder sb = new StringBuilder();
//		for(int i=0; i < s.length(); i++) {
//			sb.append('#');
//			sb.append(s.charAt(i));
//		}
//		sb.append('#');
//		s = sb.toString();
//		manachers(s);
//		int rank = -1;
//		for(int i=0; i<A.length; i++) {
//			rank = Math.max(rank, A[i]);
//		}
//		System.out.println(rank);
	}
	
	public static void manachers(String s) {
		A = new int[s.length()];
		int r = 0, p = 0;
		for(int i=0; i<s.length(); i++) {
			if(i <= r) {
				A[i] = Math.min(A[2*p - i], r - i);
				// 2*p -1 = ȸ���� ��Ī�� �Ǵ� �ε���
				// r = ȸ���� ���
				// p = ȸ���� �߾�
			}
			else
				A[i] = 0;
			
			while(i - A[i] - 1 >= 0 && i + A[i] +1 < s.length() // �ε��� ��ȿ�� �˻�
					&& s.charAt(i - A[i] - 1) == s.charAt(i + A[i] + 1)) { // �� ���� �� ������ ��
				A[i]++;
			}
			
			if(r < i + A[i] ) {
				r = i + A[i];
				p = i;
			}
			System.out.println("i :"+i+", A :"+A[i]+", p :"+p+", r :"+r);
		}// end of for
	}// end of manachers
	
	public static int getLCS(String X, String Y) {
		// �־��� ���ڿ��� ����
		int m = X.length();
		int n = Y.length();
		
		// DP���� �����ϱ� ���� �迭
		int L[][] = new int[m+1][n+1];
		
		for(int i=1; i<m+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(i == 0 && j == 0) {
					L[i][j] = 0;
				}
				else if(X.charAt(i-1) == Y.charAt(j-1))  {
					L[i][j] = L[i-1][j-1] + 1;
				}
				else {
					L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
				}
			} // end of for
		}// end of for
		return L[m][n];
	}// end of getLCS
	
	public static String getLCSString(String X, String Y) {
		// �־��� ���ڿ��� ����
		int m = X.length();
		int n = Y.length();
		
		// DP���� �����ϱ� ���� �迭
		int L[][] = new int[m+1][n+1];
		
		for(int i=1; i<m+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(i == 0 && j == 0) {
					L[i][j] = 0;
				}
				else if(X.charAt(i-1) == Y.charAt(j-1))  {
					L[i][j] = L[i-1][j-1] + 1;
				}
				else {
					L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
				}
			} // end of for
		}// end of for
		
		Stack<Integer> stack = new Stack<Integer>();
		while(m > 0 && n > 0) {
			if(L[m][n] == L[m-1][n]) {
				// ���ʰ� ����.
				m--;
			}
			else if(L[m][n] == L[m][n-1]) {
				// ���� ����.
				n--;
			}
			else if(L[m][n] -1 == L[m-1][n-1]){
				//���ʰ� ���� ��� �ٸ���.
				stack.push(m);
				System.out.println("push"+m);
				m--; n--;
			}
		}

		StringBuilder sb = new StringBuilder();
		while(!stack.empty()) {
			sb.append(X.charAt(stack.pop() - 1));
		}
		
		return sb.toString();

	}// end of getLCS
}
