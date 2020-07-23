package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Depending_the_castle {
    public static void main(String args[]) {
        int N = 0; // cols
        int M = 0; // rows
        boolean rowGuard[] = null, colGuard[] = null;

        try {
            // init variables
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String splits[] = br.readLine().split(" ");
            N = Integer.parseInt(splits[0]);
            M = Integer.parseInt(splits[1]);
            colGuard = new boolean[M];
            rowGuard = new boolean[N];

            // counting Guards
            for(int i=0; i<N; i++) {
                String s = br.readLine();
                for(int j=0; j<M; j++) {
                    if(s.charAt(j) == 'X') {
                        rowGuard[i] = colGuard[j] = true;
                    }
                }
            }

            // calculate Guards
            int rowCount = 0;
            int colCount = 0;
            for(int i=0; i < rowGuard.length; i++) {
                if(rowGuard[i] == false) {
                    rowCount++;
                }
            }
            for(int i=0; i<colGuard.length; i++) {
                if(colGuard[i] == false) {
                    colCount++;
                }
            }
            System.out.println(Math.max(rowCount, colCount));

        } catch(IOException ie) {
            System.exit(-1);
        }
    }
}
