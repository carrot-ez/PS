package Backjoon2606;
import java.io.BufferedReader;
/*
 * 바이러스
 */
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numComputer = Integer.parseInt(br.readLine());
		int numComPair = Integer.parseInt(br.readLine());
		
		boolean visited[] = new boolean[numComputer+1];
//		Arrays.fill(visited, false); /* default */
		
		List<Integer>[] adList = new ArrayList[numComputer+1];
		for(int i=0; i<numComputer+1; i++) {
			adList[i] = new ArrayList<Integer>();
		}
		
		StringTokenizer st;
		for(int i=0; i<numComPair; i++) {
			st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			adList[c1].add(c2);
			adList[c2].add(c1);
		}
		
		System.out.println(BFS(adList, visited) - 1); // 1번을 통해 전염된 컴퓨터의 수 이므로 1을 제외
	}
	
	public static int BFS(List<Integer>[] adList, boolean[] visited) { // start = 1
		int count = 0; // total visited vertex
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(1); // start Vertex
		while(!que.isEmpty()) {
			int index = que.poll();
			visited[index] = true;
			count++;
			for(int e : adList[index]) {
				if(!visited[e]) {
					que.add(e);
					visited[e] = true;
				}
			}
		}
		return count;
	}

}
