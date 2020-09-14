package Line;

import java.util.*;

public class No2 {
    public static void main(String args[]) {

    }

    public int[] solution(int[] ball, int[] order) {
        List<Integer> resultList = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for(int e : ball) {
            deque.add(e);
        }
        List<Integer> orderList = new ArrayList<>();
        for(int e : order) {
            orderList.add(e);
        }

        while(!deque.isEmpty() ) {
            int prev = deque.peekFirst();
            int rear = deque.peekLast();

            Iterator<Integer> iter = orderList.iterator();
            while(iter.hasNext()) {
                int o = iter.next();
                if(o == prev) {
                    resultList.add(deque.pollFirst());
                    iter.remove();
                    break;
                }
                else if(o == rear) {
                    resultList.add(deque.pollLast());
                    iter.remove();
                    break;
                }
            }
        }
        int[] answer = {};
        return resultList.stream().mapToInt(i -> i).toArray();
    }
}
