package Backjoon2309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 일곱 난장이
 */
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int arr[] = new int[9];
		int gap = 0;
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			gap += arr[i];
		}
		gap = gap - 100;
		Arrays.sort(arr);
		
		boolean isEnd = false;
		for(int i=0; i<arr.length && !isEnd; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(gap == arr[i] + arr[j]) {
					arr[i] = -1;
					arr[j] = -1;
					isEnd = true;
					break;
				}
			}
		}
		
		for(int e : arr) {
			if(e == -1)
				continue;
			System.out.println(e);
		}
	}
}
