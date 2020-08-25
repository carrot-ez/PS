package Programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DualPriorityQueue {
    public static void main(String args[]) {
        String operations[] = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        int result[] = new DualPriorityQueue().solution(operations);

        for(int e: result) {
            System.out.println(e);
        }
    }

    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();

        for(String e : operations) {
            String splits[] = e.split(" ");
            if(splits[0].equals("I")) {
                // insert number
                maxQueue.add(Integer.parseInt(splits[1]));
                minQueue.add(Integer.parseInt(splits[1]));
            }
            else if(splits[0].equals("D")) {
                if(splits[1].equals("1") && !maxQueue.isEmpty()) {
                    // delete max
                    minQueue.remove(maxQueue.poll());
                }
                else if(splits[1].equals("-1") && !minQueue.isEmpty()) {
                    // delete min
                    maxQueue.remove(minQueue.poll());
                }
            }
        }

        int[] answer = new int[2];
        if(!maxQueue.isEmpty() && !minQueue.isEmpty()) {
            answer[0] = maxQueue.poll();
            answer[1] = minQueue.poll();
        }

        return answer;
    }
}
