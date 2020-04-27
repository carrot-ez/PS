package Backjoon13164;
/*
 * 행복 유치원
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int numStudent = Integer.parseInt(st.nextToken());
		int numSet = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int heights[] = new int[numStudent];
		int i=0;
		while(st.hasMoreTokens()) {
			heights[i++] = Integer.parseInt(st.nextToken());
		}
		
		// joint = differences in heights
		int joint[] = new int[numStudent-1];
		for(int j=0; j<numStudent-1; j++) {
			joint[j] = heights[j+1] - heights[j];
		}
		Arrays.sort(joint);
		
		int sum = 0;
		// summarize joint except a maximum of numSet-1 numbers
		for(int j=0; j<joint.length-numSet+1; j++) {
			sum += joint[j];
		}
		
		System.out.println(sum);
	}
}
