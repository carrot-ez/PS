package Backjoon11060;
/*
 * 점프 점프
 * DP
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		
		int dp[] = new int[testCase + 1];
		Arrays.fill(dp, -1);
		dp[1] = 0; // starting point

		boolean visited[] = new boolean[testCase + 1];
//		Arrays.fill(visited, false); /* default */
		visited[1] = true; // if length == 1, starting point == destination

		String input[] = br.readLine().split(" ");

		for (int i = 1; i < testCase + 1; i++) {
			int jump = Integer.parseInt(input[i - 1]); // number of jumpable block

			/* inaccessible block */
			if (dp[i] == -1) {
				break;
			}

			/* minimum number of jumping = Min(dp[i+j], dp[i] +1) */
			for (int j = 1; (j <= jump) && (i + j < testCase + 1); j++) {
				if (!visited[i + j]) {
					dp[i + j] = dp[i] + 1;
					visited[i + j] = true;
				}
			}
		}

		System.out.println(dp[testCase]);
	}
}
