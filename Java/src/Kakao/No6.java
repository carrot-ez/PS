public class No6 {
    public static void main(String args[]) {
        int[][] board = {{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}};
        int r = 1;
        int c = 0;

        int result = new No6().solution(board, r, c);
    }

    public int solution(int[][] board, int r, int c) {
        // 종료조건을 위한 카운트
        int catchCount = 0;
        int maxCount = 0;
        for(int arr[] : board) {
            for(int e : arr) {
                Math.max(maxCount, e);
            }
        }

        // 맨하탄 거리
        int[][] manhattan = new int[4][4];

        // 모두 잡을때까지
        while(catchCount < maxCount) {
//            int idx = checkRow(board, r);
//            if(idx < 0 )
//                idx = checkCol(board, c);
        }

        int answer = 0;
        return answer;
    }

    public void getManhattanD(int[][] board, int[][] manhattan, int r, int c) {

    }
}
