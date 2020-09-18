package Line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class No1 {
    public static void main(String args[]) {
        int[][] boxes = {{1, 2}, {2, 1}, {3, 3}, {4, 5}, {5, 6}, {7, 8}};
        int result = new No1().solution(boxes);

        System.out.println("result = "+result);
    }
    public int solution(int[][] boxes) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int arr[] : boxes) {
            for(int e : arr) {
                list.add(e);
            }
        }
        Collections.sort(list);
        Iterator<Integer> iter = list.iterator();
        int x = -1, y = -1;
        while(iter.hasNext()) {
            if(x == -1) {
                x = iter.next();
                continue;
            }
            if(y == -1) {
                y = iter.next();
                continue;
            }
            if(x == y) {
                x = -1;
                y = -1;
            }
            else if(x > y) {
                y = -1;
                answer += 1;
            }
            else if(x < y) {
                x = -1;
                answer += 1;
            }
        }
        if(x == y) {
            x = -1;
            y = -1;
        }

        if(x != -1 ){
            answer += 1;
        }
        if( y != -1) {
            answer += 1;
        }

        return answer/2;
    }
}
