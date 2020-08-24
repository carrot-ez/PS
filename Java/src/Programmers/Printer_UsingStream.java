package Programmers;

import java.util.LinkedList;

public class Printer_UsingStream {
    public static void main(String args[]) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;

        int result = new Printer_UsingStream().solution(priorities, location);

        System.out.println(result);
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        LinkedList<Integer> queue = new LinkedList<>();

        for(int e : priorities) {
            queue.add(e);
        }

        while(!queue.isEmpty()) {
            int x = queue.poll();

            // if there is any item in queue larger than x
            if( queue.stream().anyMatch(v -> v > x) ) {
                queue.add(x);
            }
            else {
                answer += 1;
                if(location == 0) {
                    return answer;
                }
            }

            // adjust location
            if(location > 0) {
                location -= 1;
            }
            else {
                location = queue.size() - 1;
            }
        }

        return answer;
    }
}
