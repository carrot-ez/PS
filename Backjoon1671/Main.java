package Backjoon1671;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Shark {
	private int size;
	private int speed;
	private int itg;

	public Shark(int size, int speed, int itg) {
		this.size = size;
		this.speed = speed;
		this.itg = itg;
	}

	public boolean isBig(Shark s) {
		if (this.size >= s.size && this.speed >= s.speed && this.itg >= s.itg) {
			return true;
		} else
			return false;
	}
	
	public boolean isSame(Shark s) {
		if(this.size == s.size && this.speed == s.speed && this.itg == s.itg)
			return true;
		else 
			return false;
	}
	
	public boolean isSmall(Shark s) {
		if(this.size <= s.size && this.speed <= s.speed && this.itg <= s.itg) {
			return true;
		}
		else
			return false;
	}
}

public class Main {
	private static boolean isVisited[];
	private static Shark sharks[];
	private static int d[];
	private static List<Integer> adList[];

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 상어의 수

		sharks = new Shark[N];
		isVisited = new boolean[N];
		d = new int[N];
		Arrays.fill(d, -1);
		adList = new ArrayList[N];
		for(int i=0; i<N; i++) {
			adList[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			String splits[] = br.readLine().split(" ");
			int size = Integer.parseInt(splits[0]);
			int speed = Integer.parseInt(splits[1]);
			int itg = Integer.parseInt(splits[2]);
			sharks[i] = new Shark(size, speed, itg);
		}
		
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				if(sharks[i].isSame(sharks[j])) {
					adList[i].add(j);
				}
				else if(sharks[i].isBig(sharks[j])) {
					adList[i].add(j);
				}
				else if(sharks[i].isSmall(sharks[j])){
					adList[j].add(i);
				}
			}
		}

		int count = N;
		for (int j = 0; j < 2; j++) {
			for (int i = 0; i < N; i++) {
				Arrays.fill(isVisited, false);
				if (dfs(i)) count = count - 1;
			}
		}
		System.out.println(count);
	}

	public static boolean dfs(int x) {
		isVisited[x] = true;
		for(int e : adList[x]) {
			if(d[e] == -1 || (!isVisited[d[e]] && dfs(d[e]))) {
				d[e] = x;
				return true;
			}
		}
		return false;
	}
}
