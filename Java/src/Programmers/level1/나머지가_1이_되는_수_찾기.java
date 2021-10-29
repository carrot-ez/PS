package Programmers.level1;

public class 나머지가_1이_되는_수_찾기 {

    public int solution(int n) {

        // x를 나누어서 나머지가 1이되는 가장 작은 수 찾기
        for (int i = 2; i < n; i++) {
            if (n % i == 1) {
                return i;
            }
        }

        // 항상 답은 존재
        return -1;
    }
}
