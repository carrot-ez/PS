package Baekjoon;

import java.io.*;

public class DungeonMap199543 {
    private static int numRow;
    private static int numCol;
    private static char matrix[][];
    private static int visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        numRow = Integer.parseInt(splits[0]);
        numCol = Integer.parseInt(splits[1]);
        int numBlocks = Integer.parseInt(splits[2]);

        String inputs[] = new String[numBlocks];
        matrix = new char[numRow][numCol];
        visited = new int[numRow][numCol]; // -1 : 도착 못하는 경우, 1: 도착하는 경우, 0: 아직 방문하지 않은 경우

        for(int i=0; i<numBlocks; i++) {
            inputs[i] = br.readLine();
        }
        String blockSequence = br.readLine();

        // build char matrix
        for(int i=0; i<numRow; i++) {
            matrix[i] = inputs[blockSequence.indexOf(""+blockSequence.charAt(i))].toCharArray();
        }

        // 왼쪽 밑에서부터 시작
        for(int i=numRow-1; i>=0; i--) {
            for(int j=0; j<numCol; j++) {
                if(visited[i][j] == 0) {
                    // 탐색
                    searchRoot(i, j);
                }
            }
        }

        int result = 0;
        // 갯수 세기
        for(int i=0; i<numRow; i++) {
            for(int j=0; j<numCol; j++) {
                if(visited[i][j] == 1) {
                    result += 1;
                }
            }
        }

        System.out.println(result);

    }

    public static int searchRoot(int row, int col) {
        if(row < 0 || col >= numCol) {
            return -1;
        }
        if(row == 0 && col == numCol-1) {
            return visited[row][col] = 1;
        }

        if(matrix[row][col] == 'R') {
            return visited[row][col] = searchRoot(row, col+1);
        }
        else if(matrix[row][col] == 'U') {
            return visited[row][col] = searchRoot(row -1, col);
        }

        return -999;
    }
}
