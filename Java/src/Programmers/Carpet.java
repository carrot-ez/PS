package Programmers;

public class Carpet {

    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        int[] answer = new int[2];

        for(int i=3; i<sum; i++) {
            for(int j=i; j<sum; j++) {
                if(i*j == sum) {
                    if(checkBrown(brown, i, j)) {
                        answer[0] = j;
                        answer[1] = i;
                        return answer;
                    }
                }
            }
        }

        return answer;
    }

    public boolean checkBrown(int brown, int i, int j) {
        if(brown == (i+j-2)*2) {
            return true;
        }
        else {
            return false;
        }
    }
}
