package Programmers.level1;

public class 하샤드_수 {

    public boolean solution(int x) {
        int sumEach = getSumOfEachNumber(x);
        return x % sumEach == 0;
    }

    public int getSumOfEachNumber(int n) {
        int res = 0;
        char[] chars = Integer.toString(n).toCharArray();
        for (char c : chars) {
            res += c - '0';
        }

        return res;
    }
}
