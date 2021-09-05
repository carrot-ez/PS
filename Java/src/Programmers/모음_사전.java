package Programmers;

public class 모음_사전 {

    enum WORD {
        A(1), E(2), I(3), O(4), U(5);

        int val;
        WORD(int val) {
            this.val = val;
        }
    }

    public int solution(String word) {

        int answer = 0;
        int[] weight = new int[] {781, 156, 31, 6, 1};
        for (int i = 0; i < word.length(); i++) {

            switch (word.charAt(i)) {
                case 'A' :
                    answer += weight[i] * (WORD.A.val - 1) + 1;
                    break;
                case 'E':
                    answer += weight[i] * (WORD.E.val - 1) + 1;
                    break;
                case 'I':
                    answer += weight[i] * (WORD.I.val - 1) + 1;
                    break;
                case 'O':
                    answer += weight[i] * (WORD.O.val - 1) + 1;
                    break;
                case 'U':
                    answer += weight[i] * (WORD.U.val - 1) + 1;
                    break;
            }
        }

        return answer;
    }
}
