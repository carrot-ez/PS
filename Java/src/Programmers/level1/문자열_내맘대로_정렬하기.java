package Programmers.level1;

import java.util.*;

public class 문자열_내맘대로_정렬하기 {

    public String[] solution(String[] strings, int n) {

        return Arrays.stream(strings)
                .sorted()
                .sorted(Comparator.comparing(e -> e.charAt(n)))
                .toArray(String[]::new);
    }
}
