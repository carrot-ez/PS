package Backjoon11377;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	private static List<Integer> adList[];
	private static int d[];
	private static boolean isVisited[];
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String splits[] = br.readLine().split(" ");
		int N = Integer.parseInt(splits[0]); // 직원의 수
		int M = Integer.parseInt(splits[1]); // 일의 수
		int K = Integer.parseInt(splits[2]); // 일을 2개 할 수 있는 직원의 수
		
		// initialize 
		adList = new ArrayList[N+1];
		d = new int[M+1];
		isVisited = new boolean[N+1];
		for(int i=0; i<N+1; i++) {
			adList[i] = new ArrayList<Integer>();
		}
		
		// i번째 직원이 할 수 있는 일들을 추가
		for(int i=1; i<N+1; i++) {
			splits = br.readLine().split(" ");
			int numTask = Integer.parseInt(splits[0]);
			for(int j=0; j<numTask; j++) {
				adList[i].add(Integer.parseInt(splits[j+1]));
			}
		}
		
		int count = 0;
		for (int i = 1; i < N + 1; i++) {
			Arrays.fill(isVisited, false);
			if (dfs(i))
				count = count + 1;
		}
		for(int i=1; K > 0 && i< N+1; i++) {
			Arrays.fill(isVisited, false);
			if(dfs(i)) {
				count = count + 1;
				K = K-1;
			}
		}
		System.out.println(count);
		
	}
	
	public static boolean dfs(int x) {
		isVisited[x] = true;
		for(int e : adList[x]) {
			if(d[e] == 0 || (!isVisited[d[e]] && dfs(d[e]))) {
				d[e] = x;
				return true;
			}
		}
		return false;
	}
}
