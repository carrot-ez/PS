package Programmers.level1;

public class 소수_찾기 {

    public int solution(int n) {

        boolean[] isPrime = new boolean[n + 1];
        isPrime[1] = true;

        // get primes
        for (int i = 2; i < Math.sqrt(n) + 1; i++) {
            for (int k = 2; i * k < n + 1; k++) {
                isPrime[i * k] = true;
            }
        }

        // counting
        int cnt = 0;
        for (int i = 1; i < n + 1; i++) {
            if (isPrime[i] == false) cnt += 1;
        }

        return cnt;
    }
}
