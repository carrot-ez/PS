package Backjoon2188;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static List<Integer> adList[];
	private static int d[];
	private static boolean fin[];
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 소의 수
		int M = Integer.parseInt(st.nextToken()); // 축사의 수
		
		/* initialize */
		fin = new boolean[M+1];
		d = new int[M+1];
		adList = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			adList[i] = new ArrayList<>();
		}
		
		for(int i =1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());	
			for(int j=0; j<S; j++) {
				adList[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		int count = 0;
		for(int i=1; i<N+1; i++) {
			Arrays.fill(fin, false);
			if(dfs(i)) count = count + 1;
		}
		System.out.println(count);
	}
	
	public static boolean dfs(int x) {
		for(int e : adList[x]) {
			if(fin[e]) continue;
			fin[e] = true;
			if(d[e] == 0 || dfs(d[e])) {
				d[e] = x;
				return true;
			}
		}
		return false;
	}
}
