package Backjoon4196;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static List<Integer> adList[];
	private static Stack<Integer> stack;
	private static int d[];
	private static boolean finished[];
	private static int id;
	private static List<List<Integer>> SCC;
	private static int group[];
	private static int inDegree[];
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		while(testCase-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 도미노의 개수
			M = Integer.parseInt(st.nextToken()); // 관계의 개수
			
			// initialize
			adList = new ArrayList[N+1];
			for(int i=0; i<N+1; i++) {
				adList[i] = new ArrayList<Integer>();
			}
			stack = new Stack<Integer>();
			d = new int[N+1];
			finished = new boolean[N+1];
			id = 0;
			SCC = new ArrayList<List<Integer>>();
			group = new int[N+1];
			
			// fill adList
			while(M-- >0) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				adList[x].add(y);
			}
			
			// find scc
			for(int i=1; i<= N; i++) {
				if(d[i] == 0) dfs(i);
			}
			
			inDegree = new int[SCC.size()+1];
			
			int count = 1;
			for(List<Integer> list : SCC) {
				for(int e:list) {
					group[e] = count;
				}
				count++;
			}
			
			// 진입 차수 구하기
			boolean cd[][] = new boolean[SCC.size()+1][SCC.size()+1]; // check duplicate
			for(int i=1; i<N+1; i++) {
				for(int e : adList[i]) {
					if(group[i] != group[e] && !cd[group[i]][group[e]]) {
						inDegree[group[e]]++;
						cd[group[i]][group[e]] = true;
					}
				}
			}
			
			int result = 0;
			for(int i=1; i<SCC.size() + 1 ; i++) {
				if(inDegree[i] == 0) result++; // 진입차수가 0인 scc 갯수
			}
			
			System.out.println(result);
		}
	}
	
	public static int dfs(int x) {
		d[x] = ++id;
		stack.push(x);
		
		int parent = d[x];
		for(int e : adList[x]) {
			if(d[e] == 0) { // 방문한 적 없는 노드
				parent = Math.min(parent, dfs(e));
			}
			else { // 방문한 노드
				if(!finished[e]) { // 처리되지 않은 노드
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
				if(t == x) break;
			}
			SCC.add(list);
		}
		
		return parent;
	}
}
