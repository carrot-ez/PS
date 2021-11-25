package Programmers.level1;

import java.util.Arrays;
import java.util.Comparator;

public class 정수_내림차순으로_배치하기 {

    public long solution(long n) {

        char[] chars = Long.toString(n).toCharArray();
        Arrays.sort(chars);

        return Long.parseLong(new StringBuilder(new String(chars)).reverse().toString());
    }
}
