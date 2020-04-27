package Backjoon3977;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	private static List<Integer> adList[];
	private static Stack<Integer> stack;
	private static List<List<Integer>> SCC;
	private static boolean finished[];
	private static int d[];
	private static int group[];
	private static int inDegree[];
	private static int id;
	private static int N, M;
	private static StringTokenizer st;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			adList = new ArrayList[N];
			for(int i=0; i<N; i++) {
				adList[i] = new ArrayList<Integer>();
			}
			
			// fill adList
			while(M-- > 0) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				adList[A].add(B);
			}
			
			// initailize
			stack = new Stack<>();
			SCC = new ArrayList<>();
			finished = new boolean[N];
			group = new int[N];
			d = new int[N];
			
			// find scc
			for(int i=0; i < N; i++) {
				if(d[i] == 0) dfs(i);
			}

			inDegree = new int[SCC.size()+1];
			for(int i=0; i< N; i++) {
				for(int e : adList[i]) {
					if(group[i] != group[e]) {
						inDegree[group[e]]++;
					}
				}
			}
			
			int count = 0;
			for(int i=1; i<SCC.size() +1; i++) {
				if(inDegree[i] == 0) count++;
			}
			if(count == 1) {
				for(int i=0; i<N; i++) {
					if(inDegree[group[i]] == 0) {
						System.out.println(i);
					}
				}
			}
			else {
				System.out.println("Confused");
			}
			System.out.println();
			if(T != 0) br.readLine();
		}
	}
	public static int dfs(int x) {
		d[x] = ++id;
		stack.push(x);
		int parent = d[x];
		
		for(int e : adList[x]) {
			if(d[e] == 0) {
				parent = Math.min(parent, dfs(e));
			}
			else {
				if(!finished[e]) {
					parent = Math.min(parent, d[e]);
				}
			}
		}
		
		if(parent == d[x]) {
			List<Integer> list = new ArrayList<>();
			while(!stack.isEmpty()) {
				int t = stack.pop();
				list.add(t);
				finished[t] = true;
				group[t] = SCC.size() + 1;
				if(t == x) break;
			}
			SCC.add(list);
		}
		
		return parent;
	}
}
