package Programmers.level2;

public class 멀쩡한_사각형 {

    // 빠지는 영역 = w + h - GCD(w, h)
    public long solution(int w, int h) {

        // get GCD
        int max = w;
        int min = h;
        while (min != 0) {
            int tmp = max % min;
            max = min;
            min = tmp;
        }

        return (long) w * h - ( w + h - max);
    }
}
