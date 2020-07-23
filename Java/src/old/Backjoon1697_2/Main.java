package Backjoon1697_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 숨바꼭질
 */
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 수빈이의 위치
		int N = Integer.parseInt(st.nextToken());
		// 동생의 위치
		int K = Integer.parseInt(st.nextToken());
		
		int maxSize = Math.max(N, K)*2;
		if(maxSize > 100000) {
			maxSize = 100000;
		}
		
		// 방문한 위치에서의 걸리는 시간 저장
		int visited[] = new int[maxSize + 1];
		Arrays.fill(visited, -1);
		
		// 시작점의 거리를 0으로 초기화
		visited[N] = 0;
		
		Queue<Integer> que = new LinkedList<>();
		que.add(N);
		
		while(!que.isEmpty()) {
			N = que.poll();
			if(N == K) {
				break;
			}
			
			/*
			 * 큐는 선입선출이므로 처음 갱신한 시간이 가장 빠른시간임
			 * 따라서 다른 조건을 검사 할 필요 없음
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
