package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 로또의_최고_순위와_최저_순위 {

    class Solution {

        /**
         * 비어있는 번호 = 0
         * @param lottos 산 로또 번호
         * @param win_nums 당첨 번호
         * @return [최고 순위, 최저 순위]
         */
        public int[] solution(int[] lottos, int[] win_nums) {

            List<Integer> winNumList = Arrays.stream(win_nums).boxed().collect(Collectors.toList());

            int numWin = 0;
            int numEmpty = 0;
            for (int lotto : lottos) {
                if(lotto == 0) {
                    numEmpty += 1;
                }
                if(winNumList.contains(lotto)) {
                    numWin += 1;
                }
            }

            int[] rank = new int[]{6, 6, 5, 4, 3, 2, 1};

            return new int[]{rank[numWin + numEmpty], rank[numWin]};
        }
    }
}

