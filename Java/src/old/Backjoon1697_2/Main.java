package Backjoon1697_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * ���ٲ���
 */
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// �������� ��ġ
		int N = Integer.parseInt(st.nextToken());
		// ������ ��ġ
		int K = Integer.parseInt(st.nextToken());
		
		int maxSize = Math.max(N, K)*2;
		if(maxSize > 100000) {
			maxSize = 100000;
		}
		
		// �湮�� ��ġ������ �ɸ��� �ð� ����
		int visited[] = new int[maxSize + 1];
		Arrays.fill(visited, -1);
		
		// �������� �Ÿ��� 0���� �ʱ�ȭ
		visited[N] = 0;
		
		Queue<Integer> que = new LinkedList<>();
		que.add(N);
		
		while(!que.isEmpty()) {
			N = que.poll();
			if(N == K) {
				break;
			}
			
			/*
			 * ť�� ���Լ����̹Ƿ� ó�� ������ �ð��� ���� �����ð���
			 * ���� �ٸ� ������ �˻� �� �ʿ� ����
			 */
			if(N+1 <= maxSize && visited[N+1] == -1) {
				que.add(N+1);
				visited[N+1] = visited[N]+1;
			}
			if(N-1 >= 0 && visited[N-1] == -1) {
				que.add(N-1);
				visited[N-1] = visited[N]+1;
			}
			if(N*2 <= maxSize && visited[N*2] == -1) {
				que.add(N*2);
				visited[N*2] = visited[N]+1;
			}
		}
		System.out.println(visited[K]);
	}
}
