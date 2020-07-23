package Backjoon1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		
		/* input first line */
		int numVertex = Integer.parseInt(st.nextToken());
		int numEdge = Integer.parseInt(st.nextToken());
		int startVertex = Integer.parseInt(st.nextToken());

		/* array to check visits */
		boolean[] visited = new boolean[numVertex+1];
		Arrays.fill(visited, false);
		
		/* initialize adjacency List */
		List<Integer> adList[] = new ArrayList[numVertex+1];
		for(int i=0; i<numVertex+1; i++) {
			adList[i] = new ArrayList<Integer>();
		}

		/* put node to adList */
		for(int i=0; i<numEdge; i++) {
			st = new StringTokenizer(br.readLine());
			int startIndex = Integer.parseInt(st.nextToken());
			int endIndex = Integer.parseInt(st.nextToken());

			// undirected graph
			adList[startIndex].add(endIndex);
			adList[endIndex].add(startIndex);
		}
		
		/* sorting required from the problem */
		for(int i=0; i<numVertex+1; i++) {
			Collections.sort(adList[i]);
		}

		DFS(adList, visited, startVertex);
		System.out.println();
		Arrays.fill(visited, false);
		BFS(adList, visited, startVertex);
	}
	
	public static void BFS(List<Integer>[] adList, boolean[] visited, int v)
	/* adList	: adjacency List
	 * visited	: array for check
	 * v		: start vertex */
	{
		Queue<Integer> que = new LinkedList();
		que.add(v);
		visited[v] = true;
		
		while(!que.isEmpty()) {
			v = que.poll();
			System.out.print(v+" ");
			
			for(int e : adList[v]) {
				if (!visited[e]) {
					que.add(e);
					visited[e] = true;
				}
			}
		}
	}
	
	public static void DFS(List<Integer>[] adList, boolean[] visited, int v)
	/* adList	: adjacency List
	 * visited	: array for check
	 * v		: start vertex */
	{
		System.out.print(v+" ");
		visited[v] = true;
		
		for(int e : adList[v]) {
			if(!visited[e]) {
				DFS(adList, visited, e);
			}
		}
	}

}
