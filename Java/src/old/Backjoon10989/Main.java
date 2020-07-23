package Backjoon10989;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static final int MAX_NUMBER = 10001;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine());
		
		int count[] = new int[MAX_NUMBER];
		Arrays.fill(count, 0);
		
		for(int i=0; i<testCase; i++) {
			int num = Integer.parseInt(br.readLine());
			count[num]++;
		}

		for(int i=0; i<count.length; i++) {
			if(count[i] != 0) {
				for(int j=0; j<count[i]; j++) {
//					bw.write(i+"\n");
					sb.append(i+"\n");
				}
			}
		}
		System.out.print(sb.toString());
//		bw.close();
		br.close();
	}
}
