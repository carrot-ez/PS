package Programmers.level1;

import java.io.*;

public class 직사각형_별찍기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] splits = br.readLine().split(" ");
        int numCol = Integer.parseInt(splits[0]);
        int numRow = Integer.parseInt(splits[1]);

        for (int row = 0; row < numRow; row++) {
            for (int col = 0; col < numCol; col++) {
                bw.write("*");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
