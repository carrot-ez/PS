package Backjoon16674;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		boolean flag = false;
		int check[] = new int[4];
		/*
		 * check[0] = 0
		 * check[1] = 1
		 * check[2] = 2
		 * check[3] = 8
		 */
		
		while(!flag && num > 0) {
			int n = num % 10;
			num = num/10;
			switch(n) {
			case 0:
				check[0]++;
				break;
			case 1:
				check[1]++;
				break;
			case 2:
				check[2]++;
				break;
			case 8:
				check[3]++;
				break;
			default :
				flag = true;
				break;
			}
		}
		
		if(flag) {
			System.out.println("0");
		}
		else if(check[0] == check[1] && check[1] == check[2] && check[2] == check[3]) {
			System.out.println("8");
		}
		else if(check[0] * check[1] * check[2] * check[3] > 0) {
			System.out.println("2");
		}
		else {
			System.out.println("1");
		}
	}
}
