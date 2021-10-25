package Programmers.level1;

import java.util.Arrays;
import java.util.Comparator;

public class 최소직사각형 {

    public static void main(String[] args) {

        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};

        new 최소직사각형().solution(sizes);
    }

    public int solution(int[][] sizes) {

        // get max
        for (int[] size : sizes) {
            if (size[0] < size[1]) {
                // swap
                int temp = size[0];
                size[0] = size[1];
                size[1] = temp;
            }
        }

        int maxFirst = Arrays.stream(sizes).max(Comparator.comparingInt(e -> e[0])).get()[0];
        int maxSecond = Arrays.stream(sizes).max(Comparator.comparingInt(e -> e[1])).get()[1];

        return maxFirst * maxSecond;
    }
}
