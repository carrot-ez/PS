package Programmers.level1;

public class 약수의_합 {
    public int solution(int n) {

        int answer = n;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) answer += i;
        }

        return answer;
    }
}
