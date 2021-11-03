package Programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class 같은_숫자는_싫어 {

    public int[] solution(int []arr) {

        List<Integer> list = new ArrayList<>();

        list.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) {
                continue;
            }
            list.add(arr[i]);
        }

        return list.stream()
                .mapToInt(e -> e)
                .toArray();
    }
}
