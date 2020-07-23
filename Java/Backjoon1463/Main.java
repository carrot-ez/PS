package Backjoon1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 1로 만들기
 */
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();
		
		int visited[] = new int[N+1];
		Arrays.fill(visited, -1);
		visited[N] = 0;
		
		Queue<Integer> que = new LinkedList<>();
		que.add(N);
		
		while(!que.isEmpty()) {
			N = que.poll();
			if(N == 1) {
				break;
			}
			
			if(N%3 == 0 && visited[N/3] == -1) {
				que.add(N/3);
				visited[N/3] = visited[N]+1;
			}
			if(N%2 == 0 && visited[N/2] == -1) {
				que.add(N/2);
				visited[N/2] = visited[N]+1;
			}
			if (N-1 >= 1 && visited[N-1] == -1) {
				que.add(N-1);
				visited[N-1] = visited[N] + 1;
			}
		}
		
		System.out.println(visited[1]);
	}
}
