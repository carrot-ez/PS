package Programmers;

import java.util.Arrays;

public class SteppingStone {
    public static void main(String args[]) {
        int distance = 25;
        int rocks[] = {2, 14, 11, 21, 17};
        int  n = 2;

        int result = new SteppingStone().solution(distance, rocks, n);
        System.out.println(result);
    }

    public int solution(int distance, int[] rocks, int n) {
        // 바위 사이간 최소 거리가 x일때 몇개의 돌을 뽑아야 하는지로 접근
        Arrays.sort(rocks);
        long min = 1;
        long max = distance;

        while(min < max) {
            long mid = (min + max + 1) / 2;
            long position = 0;
            int removeCnt = 0;

            // mid가 최소 거리가 되게 하도록 돌 제거하기
            for(int i=0; i< rocks.length; i++) {
                if(rocks[i] - position < mid) {
                    removeCnt += 1;
                }
                else {
                    position = rocks[i];
                }
            }
            if(distance - position < mid) {
                removeCnt += 1;
            }

            if(removeCnt > n) {
                max = mid - 1;
            }
            else {
                min = mid;
            }
        }
        return (int)min;
    }
}
