package Programmers.level1;

import java.util.Arrays;

public class 제일_작은_수_제거하기 {

    public int[] solution(int[] arr) {

        // get min
        int min = Arrays.stream(arr)
                .min()
                .getAsInt();

        int[] result = Arrays.stream(arr)
                .filter(e -> e != min)
                .toArray();

        return result.length != 0 ? result : new int[] {-1};
    }
}
