package Backjoon2150;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	private static List<Integer> adList[];
	private static List<List<Integer>> SCC;
	private static boolean finished[];
	private static Stack<Integer> stack;
	private static int d[];
	private static int id = 1;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		// initialize all
		adList = new ArrayList[V+1];
		for(int i=0; i<V+1; i++) {
			adList[i] = new ArrayList<Integer>();
		}
		finished = new boolean[V+1];
		stack = new Stack<>();
		SCC = new ArrayList<>();
		d = new int[V+1];
		
		// fill the adList
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adList[x].add(y);
		}

		
		for(int i=1; i<V+1; i++) {
			if(d[i] == 0) dfs(i);
		}
		
		System.out.println(SCC.size());
		Collections.sort(SCC, new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> l1, List<Integer> l2) {
				return l1.get(0) - l2.get(0);
			}
		});
		for(List<Integer> e : SCC) {
			for(int i : e) {
				System.out.print(i+" ");
			}
			System.out.println(-1);
		}
	}
	
	public static int dfs(int x) {
		d[x] = id++;
		stack.push(x);
		int parent = d[x];
		
		for(int e : adList[x]) {
			if(d[e] == 0) { // 처음 방문
				parent = Math.min(parent, dfs(e));
			}
			else if(!finished[e]) { // 처리중인 노드
				parent = Math.min(parent, d[e]);
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
			Collections.sort(list);
			SCC.add(list);
		}
	
		return parent;
	}
}
