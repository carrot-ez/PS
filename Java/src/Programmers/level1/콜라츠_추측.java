package Programmers.level1;

public class 콜라츠_추측 {

    public int solution(long num) {

        int cnt = 0;
        while (num != 1) {
            num = getCollatz(num);
            cnt += 1;

            if (cnt >= 500) return -1;
        }

        return cnt;
    }

    public long getCollatz(long num) {
        if (num % 2 == 0) {
            return num / 2;
        } else {
            return num * 3 + 1;
        }
    }
}
