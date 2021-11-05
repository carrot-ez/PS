package Programmers.level1;

public class 문자열내_p와_y의_개수 {
    boolean solution(String s) {

        int numP = 0;
        int numY = 0;
        char[] chars = s.toLowerCase().toCharArray();

        for (char c : chars) {
            if (c == 'p') numP += 1;
            if (c == 'y') numY += 1;
        }

        return numP == numY;
    }
}
