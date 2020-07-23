package Backjoon11375;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer> adList[];
	static int d[];
	static boolean visited[];
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String splits[] = br.readLine().split(" ");
		int N = Integer.parseInt(splits[0]); // 직원의 수
		int M = Integer.parseInt(splits[1]); // 일의 수
		
		adList = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			adList[i] = new ArrayList<Integer>();
		}
		d = new int[M+1];
		visited = new boolean[N+1];
		
		for(int i=1; i<N+1; i++) {
			splits = br.readLine().split(" ");
			int T = Integer.parseInt(splits[0]);
			for(int j=0; j<T; j++) {
				adList[i].add(Integer.parseInt(splits[j+1]));
			}
		}
		
		int count = 0;
		for(int i=1; i<N+1; i++) {
			Arrays.fill(visited, false);
			if(dfs(i)) count = count + 1;
		}
		
		System.out.println(count);
	}
	
	public static boolean dfs(int x) {
		visited[x] = true; // 처리됨. 다음에 다시 처리하지 않음.
		for(int e : adList[x]) {
			// d[e] == 0		: 원하는 일이 매칭되지 않은 상태.
			// !visited[d[e]]	: 원하는 일을 점유하고 있는 직원이 방문되지(처리되지) 않음
			// dfs(d[e])		: 원하는 일을 점유하고 있는 직원이 다른 일로 바꿔줄 수 있음
			if(d[e] == 0 || (!visited[d[e]] && dfs(d[e]))) { 
				d[e] = x;
				return true;
			}
		}
		return false;
	}
}
