package Programmers.level1;

public class 최대공약수와_최소공배수 {

    public int[] solution(int n, int m) {


        // get GCD
        int gcd = getGcd(n, m);


        // get LCM
        int lcm = (n * m) / gcd;


        int[] answer = {gcd, lcm};
        return answer;
    }

    // 유클리드 호제법
    public int getGcd(int a, int b) {
        return b == 0 ? a : getGcd(b, a % b);
    }
}
