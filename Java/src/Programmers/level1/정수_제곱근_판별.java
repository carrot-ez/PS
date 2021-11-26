package Programmers.level1;

public class 정수_제곱근_판별 {

    public long solution(long n) {

        long sqrt = (long)Math.sqrt(n) + 1;

        for (long i = 1; i < sqrt ; i++) {
            if(i * i == n) return (i + 1) * (i + 1);
        }

        return -1;
    }
}
