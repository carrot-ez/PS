package Backjoon2606_UnionFind;
import java.io.BufferedReader;
/*
 * 바이러스
 */
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int root[];
	private static int rank[];
	private static int nodeCount[];
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numComputer = Integer.parseInt(br.readLine());
		int numComPair = Integer.parseInt(br.readLine());
		
		root = new int[numComputer+1];
		rank = new int[numComputer+1]; // default = fill 0
		nodeCount = new int[numComputer+1];
		
		for(int i=0; i<numComputer+1; i++) {
			root[i] = i;
			rank[i] = 0;
			nodeCount[i] = 1;
		}
		
		StringTokenizer st;
		for(int i=0; i<numComPair; i++) {
			st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			
			union_by_rank(c1, c2);
		}
		
		System.out.println(nodeCount[find_PathCompression(1)] - 1); // except 1
	}
	
	
	/* find method optimization, Path Compression */
	public static int find_PathCompression(int x) {
		if(x == root[x]) {
			return x;
		}
		else {
			return root[x] = find_PathCompression(root[x]);
		}
	}
	
	/* union method optimization, Union by rank */
	public static void union_by_rank(int a, int b) {
		int x = find_PathCompression(a);
		int y = find_PathCompression(b);
		
		// same root, same set
		if(x == y) {
			return;
		}
		
		// higher rank become a root
		if(rank[x] < rank[y]) {
			root[x] = y;
			nodeCount[y] = nodeCount[y] + nodeCount[x];
			nodeCount[x] = 1;
		}
		else {
			root[y] = x;
			nodeCount[x] = nodeCount[x] + nodeCount[y];
			nodeCount[y] = 1;
			if(rank[x] == rank[y]) {
				rank[x]++;
			}
		}
	}
}
