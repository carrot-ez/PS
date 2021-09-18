package Programmers.level1;

public class 없는_숫자_더하기 {

    class Solution {
        public int solution(int[] numbers) {

            boolean[] checked = new boolean[10];

            for(int e : numbers) {
                checked[e] = true;
            }

            int answer = 0;
            for(int i = 0; i < 10; i++ ) {
                if(checked[i] == false) {
                    answer += i;
                }
            }

            return answer;
        }
    }
}
