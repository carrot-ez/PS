package Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class HighwayCamera {

    public static void main(String args[]) {
        int routes[][] = { {-20, 15}, {-14, -5}, {-18, -13}, {-5, -3} };
        int result = new HighwayCamera().solution(routes);

        System.out.println(result);
    }

    public int solution(int[][] routes) {
        int answer = 1;
        boolean visited[] = new boolean[routes.length];

        // sort by start time
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int currentCamera = routes[0][1];
        for(int i = 1; i < routes.length; i++) {
            if(currentCamera > routes[i][1]) {
                currentCamera = routes[i][1];
            }
            else if(currentCamera < routes[i][0]) {
                currentCamera = routes[i][1];
                answer += 1;
            }
        }

        return answer;
    }
}
